package com.example.imageapi;

import com.example.imageapi.controller.ImageController;
import com.example.imageapi.exception.CustomExceptionHandler;
import com.example.imageapi.exception.ResourceNotFoundException;
import com.example.imageapi.entity.Image;
import com.example.imageapi.service.ImageService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class ImageControllerTest {

	@InjectMocks
	private ImageController imageController;

	@Mock
	private ImageService imageService;

	private Image image;

	private MockMvc mockMvc;

	@BeforeEach
	void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(imageController)
				.setControllerAdvice(new CustomExceptionHandler())
				.build();

		image = new Image();
		image.setName("test");
		image.setDescription("desc");
		image.setAuthor("author");
		image.setImageUrl("http://test.com");
		image.setWidth(20.0);
		image.setHeight(30.0);
		image.setTags(Arrays.asList("testTag1", "testTag2"));
	}

	@Test
	void shouldCreateImageSuccessfully() throws Exception {
		when(imageService.create(any(Image.class))).thenReturn(image);
		mockMvc.perform(post("/api/image")
						.contentType(MediaType.APPLICATION_JSON)
						.content(new ObjectMapper().writeValueAsString(image)))
				.andExpect(status().isCreated());
	}

	@Test
	void shouldUpdateImageSuccessfully() throws Exception {
		when(imageService.update(anyLong(), any(Image.class))).thenReturn(image);
		mockMvc.perform(put("/api/image/1")
						.contentType(MediaType.APPLICATION_JSON)
						.content(new ObjectMapper().writeValueAsString(image)))
				.andExpect(status().isOk());
	}

	@Test
	void shouldReturnImageSuccessfully() throws Exception {
		when(imageService.getById(anyLong())).thenReturn(image);
		mockMvc.perform(get("/api/image/1")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	void shouldDeleteImageSuccessfully() throws Exception {
		mockMvc.perform(delete("/api/image/1")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNoContent());
	}

	@Test
	void shouldReturnNotFoundForInvalidImage() throws Exception {
		when(imageService.getById(anyLong())).thenThrow(new ResourceNotFoundException("Resource not found"));
		mockMvc.perform(get("/api/image/1")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound());
	}
}