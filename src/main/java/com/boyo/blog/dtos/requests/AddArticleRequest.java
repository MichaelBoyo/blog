package com.boyo.blog.dtos.requests;

import lombok.Data;

@Data
public class AddArticleRequest {
    private String username;
    private String blogName;
    private String title;
    private String body;
}

