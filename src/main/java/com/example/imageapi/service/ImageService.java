package com.example.imageapi.service;

import com.example.imageapi.entity.Image;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.IOException;

public interface ImageService {

    Image create(Image image);

    Image update(Long id, Image image);

    Image getById(Long id);

    Page<Image> getImages(Pageable pageable, String filter);

    void delete(Long id);
}
