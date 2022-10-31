package com.example.userservice.ports;

import com.example.userservice.business.entities.User;
import com.example.userservice.dto.AddUserRequest;
import com.example.userservice.dto.DeleteUserRequest;

import java.util.List;

public interface IUserService {
    User getUser(Long request);
    List<User> getUsers();
    User addUser(AddUserRequest addUserRequest);
    void removeUser(DeleteUserRequest deleteUserRequest);
}
