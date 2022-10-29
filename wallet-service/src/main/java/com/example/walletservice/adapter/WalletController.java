package com.example.walletservice.adapter;

import com.example.walletservice.business.entites.Wallet;
import com.example.walletservice.dto.CreateWalletRequest;
import com.example.walletservice.dto.CreateWalletResponse;
import com.example.walletservice.dto.CreditUserWalletCommand;
import com.example.walletservice.dto.DebitUserWalletCommand;
import com.example.walletservice.ports.WalletManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//import javax.ws.rs.*;

@RestController
@RequestMapping(value = "/rewards", produces = "application/json")
public class WalletController {

    WalletManagement walletManager;

    @Autowired
    public WalletController(WalletManagement walletManager) {
        this.walletManager = walletManager;
    }

    private static final String WALLET_ENDPOINT = "/wallet";
    @GetMapping(WALLET_ENDPOINT)
    public List<Wallet> wallets(){
        return walletManager.getAllWallets();
    }

    @PostMapping(WALLET_ENDPOINT)
    public CreateWalletResponse wallets(@RequestBody CreateWalletRequest req){
        return walletManager.createWalletForUser(req);
    }

    @PostMapping(WALLET_ENDPOINT+"/credit")
    public boolean creditUserWallet(@RequestBody CreditUserWalletCommand req){
        return walletManager.creditWalletForUser(req);
    }

    @PostMapping(WALLET_ENDPOINT+"/debit")
    public boolean creditUserWallet(@RequestBody DebitUserWalletCommand req){
        return walletManager.debitWalletForUser(req);
    }
}