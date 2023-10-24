package com.example.imageapi.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(indexes = {
        @Index(name = "name_index", columnList = "name"),
        @Index(name = "author_index", columnList = "author"),
        @Index(name = "created_date_index", columnList = "createdDate"),
        @Index(name = "modified_date_index", columnList = "modifiedDate")
})
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    @Column(columnDefinition = "text")
    private String description;

    @NotBlank
    private String author;

    @URL
    @NotBlank
    private String imageUrl;

    @Min(0)
    private double width;

    @Min(0)
    private double height;

    @NotEmpty
    @ElementCollection(targetClass=String.class)
    private List<String> tags;

    @CreationTimestamp
    private LocalDateTime createdDate;

    @UpdateTimestamp
    private LocalDateTime modifiedDate;
}