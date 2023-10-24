package com.example.imageapi.support;

import com.example.imageapi.Constants;
import com.example.imageapi.antlar.FilterBaseVisitor;
import com.example.imageapi.antlar.FilterParser;
import com.example.imageapi.entity.Image;
import com.example.imageapi.exception.FilterMalformedException;
import org.springframework.data.jpa.domain.Specification;


public class FilterExpressionVisitor extends FilterBaseVisitor<Specification<Image>> {

    @Override
    public Specification<Image> visitCondition(FilterParser.ConditionContext ctx) {

        String property = ctx.property().getText();
        String operator = ctx.OPERATOR().getText();
        String operand = ctx.operand().getText();
        String value = operand.replace("'", "");

        return (root, query, cb) -> {
            switch (operator) {
                case Constants.EQ:
                    if (property.equals(Constants.TAG_PROPERTY)) {
                        return cb.isMember(value, root.get("tags"));
                    }
                    return cb.equal(root.get(property), value);
                case Constants.NE:
                    if (property.equals(Constants.TAG_PROPERTY)) {
                        return cb.isNotMember(value, root.get("tags"));
                    }
                    return cb.notEqual(root.get(property), value);
                case Constants.CONTAINS:
                    if (property.equals(Constants.TAG_PROPERTY)) {
                        throw new FilterMalformedException();
                    }
                    return cb.like(root.get(property), value);
                default:
                    throw new FilterMalformedException();
            }
        };
    }

    @Override
    public Specification<Image> visitNestedQuery(FilterParser.NestedQueryContext ctx) {
        if (ctx.ANDOPERATOR() != null) {
            return ctx.nestedQuery(0).accept(this).and(ctx.nestedQuery(1).accept(this));
        } else if (ctx.OROPERATOR() != null) {
            return ctx.nestedQuery(0).accept(this).or(ctx.nestedQuery(1).accept(this));
        } else if (ctx.condition() != null) {
            return ctx.condition().accept(this);
        } else if (ctx.LPAREN() != null) {
            return ctx.nestedQuery(0).accept(this);
        } else {
            throw new FilterMalformedException();
        }
    }
}
