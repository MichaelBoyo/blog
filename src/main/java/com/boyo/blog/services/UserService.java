package com.boyo.blog.services;

import com.boyo.blog.data.models.User;
import com.boyo.blog.dtos.requests.RegisterUserRequest;
import com.boyo.blog.dtos.requests.UpdateUserRequest;
import com.boyo.blog.dtos.responses.RegisterUserResponse;

public interface UserService {
    RegisterUserResponse saveUser(RegisterUserRequest registerUserRequest);
    RegisterUserResponse updateUser(UpdateUserRequest updateUserRequest);
    RegisterUserResponse deleteUser(Integer id);
    User getUSer(Integer id);

    void reSave(User user);

    User getUserByUsername(String username);
}
