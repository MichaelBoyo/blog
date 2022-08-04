package com.boyo.blog.dtos.requests;

import lombok.Data;

@Data
public class UpdateUserRequest {
    private Integer id;
    private String username;
    private String password;
}
