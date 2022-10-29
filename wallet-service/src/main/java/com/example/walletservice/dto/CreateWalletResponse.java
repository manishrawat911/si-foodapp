package com.example.walletservice.dto;

import lombok.*;

@Value @Builder(access = AccessLevel.PUBLIC)
//@Getter @Setter
public class CreateWalletResponse {
    @NonNull String message;
    @NonNull Long walletId;
}
