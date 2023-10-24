package com.example.imageapi;

import com.example.imageapi.exception.ResourceNotFoundException;
import com.example.imageapi.entity.Image;
import com.example.imageapi.repository.ImageRepository;
import com.example.imageapi.service.impl.ImageServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ImageServiceImplTest {

    @InjectMocks
    private ImageServiceImpl imageService;

    @Mock
    private ImageRepository imageRepository;

    private Image image;

    @BeforeEach
    public void setup() {
        image = new Image();
        image.setName("test");
        image.setDescription("desc");
        image.setAuthor("author");
        image.setImageUrl("http://test.com");
        image.setWidth(20.0);
        image.setHeight(30.0);
        List<String> tags = Arrays.asList("testTag1", "testTag2");
    }

    @Test
    public void shouldSaveImageSuccessfully() {
        when(imageRepository.save(image)).thenReturn(image);
        Image savedImage = imageService.create(image);
        assertThat(savedImage.getName(), is("test"));
    }

    @Test
    public void shouldUpdateImageSuccessfully() {
        when(imageRepository.findById(1L)).thenReturn(Optional.of(image));
        when(imageRepository.save(image)).thenReturn(image);
        Image updatedImage = imageService.update(1L, image);
        assertThat(updatedImage.getName(), is("test"));
    }

    @Test
    public void shouldGetImageByIdSuccessfully() {
        when(imageRepository.findById(1L)).thenReturn(Optional.of(image));
        Image foundImage = imageService.getById(1L);
        assertThat(foundImage.getName(), is("test"));
    }

    @Test
    public void shouldDeleteImageSuccessfully() {
        when(imageRepository.existsById(1L)).thenReturn(true);
        assertDoesNotThrow(() -> imageService.delete(1L));
    }

    @Test
    public void shouldThrowExceptionWhenImageNotFound() {
        when(imageRepository.findById(anyLong())).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> imageService.getById(1L));
    }

    @Test
    public void shouldThrowExceptionWhenImageToDeleteNotFound() {
        when(imageRepository.existsById(1L)).thenReturn(false);
        assertThrows(ResourceNotFoundException.class, () -> imageService.delete(1L));
    }
}