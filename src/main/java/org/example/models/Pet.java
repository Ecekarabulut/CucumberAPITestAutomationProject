package org.example.models;

import lombok.Data;
import java.util.List;

@Data
public class Pet {
    private Long id;
    private Category category;
    private String name;
    private List<String> photoUrls;
    private List<Tag> tags;
    private String status;
} 