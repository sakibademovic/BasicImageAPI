grammar Filter;

/*
 * Parser Rules
 */

parse
    :   query EOF
    ;

query
    :   nestedQuery
    ;

nestedQuery
    :   nestedQuery OROPERATOR nestedQuery
    |   nestedQuery ANDOPERATOR nestedQuery
    |   LPAREN nestedQuery RPAREN
    |   condition
    ;

condition
    :   property OPERATOR operand
    ;

property
    :   'tag' | 'author' | 'name'
    ;

operand
    :   STRING
    ;

/*
 * Lexer Rules
 */
ANDOPERATOR
    :   'and'
    ;

OROPERATOR
    :   'or'
    ;

OPERATOR
    :   'eq' | 'ne' | 'contains'
    ;

STRING
    :   '\'' ( ~ '\'' )* '\''
    ;

LPAREN           : '(';
RPAREN           : ')';

WS  :   [ \r\n\t]+ -> skip ;