package com.boyo.blog.services.implementations;

import com.boyo.blog.data.enums.Role;
import com.boyo.blog.data.models.User;
import com.boyo.blog.data.repositories.UserRepository;
import com.boyo.blog.dtos.requests.RegisterUserRequest;
import com.boyo.blog.dtos.requests.UpdateUserRequest;
import com.boyo.blog.dtos.responses.RegisterUserResponse;
import com.boyo.blog.exceptions.UserAlreadyExistException;
import com.boyo.blog.exceptions.UserNotFoundException;
import com.boyo.blog.services.UserService;
import com.boyo.blog.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public RegisterUserResponse saveUser(RegisterUserRequest registerUserRequest) {
        if(userRepository.findAll().stream().anyMatch(
                (user -> user.getUsername().equals(registerUserRequest.getUsername())))){
            throw new UserAlreadyExistException("email "+registerUserRequest.getUsername()+" already exist");
        }

        User user = new User();
        user.setPassword(passwordEncoder.encode(registerUserRequest.getPassword()));
        Mapper.mapRequestToUSer(registerUserRequest,user);
        user.addRole(Role.USER);
        var savedUSer = userRepository.save(user);
        return new RegisterUserResponse(savedUSer.getUsername()+ " registered successfully");
    }

    @Override
    public RegisterUserResponse updateUser(UpdateUserRequest request) {
        var user = getUSer(request.getId());
        if(request.getPassword()!=null&& !Objects.equals(request.getPassword(), "")){
            user.setPassword(passwordEncoder.encode(request.getPassword()));
        }
        Mapper.MapUpdateRequestToUser(request,user);
        userRepository.save(user);
        return new RegisterUserResponse("updated successfully");
    }

    @Override
    public RegisterUserResponse deleteUser(Integer id) {
        return new RegisterUserResponse("deleted successfully");
    }

    @Override
    public User getUSer(Integer id) {
        return userRepository.findById(id).orElseThrow(
                ()-> new UserNotFoundException("user with id-> "+id+" not found"));
    }

    @Override
    public void reSave(User user) {
        userRepository.save(user);
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findUserByUsername(username).orElseThrow(
                ()-> new UserNotFoundException("user with username -> "+username+" not found"));
    }
}
