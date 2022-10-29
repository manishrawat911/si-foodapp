package com.example.userservice.dto;

import com.example.userservice.business.entities.User;
import lombok.NonNull;
import lombok.Value;

@Value
public class DeleteUserRequest {
    @NonNull Long userId;
    //@NonNull User userId;

}
