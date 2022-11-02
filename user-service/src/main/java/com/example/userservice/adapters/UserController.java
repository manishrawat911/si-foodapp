package com.example.userservice.adapters;

import com.example.userservice.business.entities.User;
import com.example.userservice.dto.AddUserRequest;
import com.example.userservice.dto.DeleteUserRequest;
import com.example.userservice.ports.UserManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1", produces = "application/json")

public class UserController {
    private static final String ENDPOINT="/user/";
    private final UserManagement userManager;
    @Autowired
    public UserController(UserManagement userManager)
    {
        this.userManager = userManager;
    }
    @GetMapping(ENDPOINT)
    public List<User> findAll() {
        return userManager.getUsers();
    }
    @GetMapping(ENDPOINT+"/{id}")
    public User getUser(@PathVariable Long userId)
    {
        return userManager.getUser(userId);
    }

    @PostMapping(ENDPOINT)
    public User add(@RequestBody AddUserRequest addUserRequest)
    {
        return userManager.addUser(addUserRequest);
    }

    @DeleteMapping(ENDPOINT+"/{id}")
    public void delete(@RequestBody DeleteUserRequest deleteUserRequest, @PathVariable Long id)
    {
        if (!deleteUserRequest.getUserId().equals(id))
        {
            throw new IllegalArgumentException("Wrong Identity Number");
        }
        userManager.removeUser(deleteUserRequest);
    }


}
