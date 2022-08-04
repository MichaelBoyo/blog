package com.boyo.blog.dtos.requests;

import lombok.Data;

@Data
public class CommentRequest {
    private Integer articleId;
    private String comment;
}
