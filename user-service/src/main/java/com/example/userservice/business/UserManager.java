package com.example.userservice.business;

import com.example.userservice.business.entities.User;
import com.example.userservice.dto.AddUserRequest;
import com.example.userservice.dto.DeleteUserRequest;
import com.example.userservice.ports.UserManagement;
import com.example.userservice.ports.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManager implements UserManagement {
    private final UserRepository userRepository;
    @Autowired
    public UserManager(UserRepository userRepository){
        this.userRepository= userRepository;
    }
    @Override
    public User getUser(Long request){
        User user = userRepository.findByUserId(request);
        if (!user.getUserName().isEmpty()){
            return userRepository.findByUserId(request);
        }
        return null;
    }
    @Override
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @Override
    public User addUser(AddUserRequest addUserRequest)
    {
        User user = new User(addUserRequest.getUserName());
        User added = userRepository.save(user);
        return added;
    }
    @Override
    public void removeUser(DeleteUserRequest deleteUserRequest)
    {
        User user = userRepository.findByUserId(deleteUserRequest.getUserId());
        userRepository.delete(user);

    }

}
