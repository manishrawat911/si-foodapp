package com.example.walletservice.ports;

import com.example.walletservice.business.entites.Wallet;
import com.example.walletservice.dto.CreateWalletRequest;
import com.example.walletservice.dto.CreateWalletResponse;
import com.example.walletservice.dto.CreditUserWalletCommand;
import com.example.walletservice.dto.DebitUserWalletCommand;

import java.util.List;

public interface WalletManagement {

    CreateWalletResponse createWalletForUser(CreateWalletRequest req);

//    boolean debitWalletForUser(Long id, Float value);
    boolean debitWalletForUser(DebitUserWalletCommand command);

//    boolean creditWalletForUser(Long id, Float value);
    boolean creditWalletForUser(CreditUserWalletCommand command);

    Wallet getUserWallet(Long id);

    List<Wallet> getAllWallets();

}
