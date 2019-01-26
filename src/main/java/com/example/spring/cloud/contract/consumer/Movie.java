package com.example.spring.cloud.contract.consumer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Movie {
    private String id;
    private String name;
    private String genre;
    private String year;
}