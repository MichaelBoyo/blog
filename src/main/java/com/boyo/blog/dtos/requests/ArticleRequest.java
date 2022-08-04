package com.boyo.blog.dtos.requests;

import lombok.Data;

@Data
public class ArticleRequest {
    private String title;
    private String body;
}
