package com.example.imageapi.service.impl;

import com.example.imageapi.antlar.FilterLexer;
import com.example.imageapi.antlar.FilterParser;
import com.example.imageapi.exception.FilterMalformedException;
import com.example.imageapi.exception.ResourceNotFoundException;
import com.example.imageapi.entity.Image;
import com.example.imageapi.repository.ImageRepository;
import com.example.imageapi.service.ImageService;
import com.example.imageapi.support.FilterExpressionVisitor;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private  ImageRepository imageRepository;

    @Override
    public Image create(Image image) {
        return imageRepository.save(image);
    }

    @Override
    public Image update(Long id, Image image) {
        // Get existing image
        Image existingImage = getById(id);
        // Update fields
        if(image.getName() != null && !image.getName().isEmpty())
            existingImage.setName(image.getName());
        if(image.getDescription() != null && !image.getDescription().isEmpty())
            existingImage.setDescription(image.getDescription());
        if(image.getAuthor() != null && !image.getAuthor().isEmpty())
            existingImage.setAuthor(image.getAuthor());
        if(image.getWidth() >= 0)
            existingImage.setWidth(image.getWidth());
        if(image.getHeight() >= 0)
            existingImage.setHeight(image.getHeight());
        if(image.getTags() != null && !image.getTags().isEmpty())
            existingImage.setTags(image.getTags());
        // Save
        return imageRepository.save(existingImage);
    }

    @Override
    public Image getById(Long id) {
        return imageRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Override
    public Page<Image> getImages(Pageable pageable, String filter) {

        if(filter == null || filter.isEmpty()){
            return imageRepository.findAll(pageable);
        }

        Specification<Image> spec;

        try{
            // Tokenize and parse the query string
            FilterLexer lexer = new FilterLexer(CharStreams.fromString(filter));
            FilterParser parser = new FilterParser(new CommonTokenStream(lexer));
            // Build the JPA specification
            FilterExpressionVisitor visitor = new FilterExpressionVisitor();
            spec = parser.query().accept(visitor);
        } catch (Exception e){
            throw new FilterMalformedException();
        }

        // Query the database
        return imageRepository.findAll(spec, pageable);
    }

    @Override
    public void delete(Long id) {
        if(!imageRepository.existsById(id)){
            throw new ResourceNotFoundException(id);
        }
        imageRepository.deleteById(id);
    }
}
