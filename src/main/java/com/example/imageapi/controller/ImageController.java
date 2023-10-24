package com.example.imageapi.controller;

import com.example.imageapi.entity.Image;
import com.example.imageapi.service.ImageService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/image")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping
    public ResponseEntity<Image> create(@Valid @RequestBody Image image) {
        return new ResponseEntity<>(imageService.create(image), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Image> get(@PathVariable Long id) {
        return ResponseEntity.ok(imageService.getById(id));
    }


    @GetMapping
    public ResponseEntity<Page<Image>> getImages(Pageable pageable, @RequestParam(value = "filter", required = false) String filter) {
        return ResponseEntity.ok(imageService.getImages(pageable, filter));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Image> update(@PathVariable Long id, @RequestBody Image image) {
        return ResponseEntity.ok(imageService.update(id, image));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        imageService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
