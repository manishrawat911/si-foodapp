package com.example.userservice.dto;

import lombok.NonNull;
import lombok.Value;

@Value
public class AddUserRequest {
    public final @NonNull String userName;
    public final @NonNull Long userId;
}
