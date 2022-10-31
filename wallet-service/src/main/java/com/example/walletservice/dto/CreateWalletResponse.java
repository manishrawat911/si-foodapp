package com.example.walletservice.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value @Builder(access = AccessLevel.PUBLIC)
//@Getter @Setter
public class CreateWalletResponse {
    @NonNull String message;
    @NonNull Long walletId;
}
