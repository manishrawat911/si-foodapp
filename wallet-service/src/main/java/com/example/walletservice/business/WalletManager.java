package com.example.walletservice.business;

import com.example.walletservice.business.entites.Wallet;
import com.example.walletservice.dto.CreateWalletRequest;
import com.example.walletservice.dto.CreateWalletResponse;
import com.example.walletservice.dto.CreditUserWalletCommand;
import com.example.walletservice.dto.DebitUserWalletCommand;
import com.example.walletservice.ports.WalletManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalletManager implements WalletManagement {
    WalletRepository repository;

    @Autowired
    public WalletManager(WalletRepository repository) {
        this.repository = repository;
    }

    @Override
    public CreateWalletResponse createWalletForUser(CreateWalletRequest req) {
        if(exists(req.userId)){
//            throw new Exception("Wallet exist for user");
//            verify if wallet for user not exist
//            if it exists throw an exception
//            if not then continue
        }

        Wallet newWallet = new Wallet();
        newWallet.setUserId(req.userId);
//        newWallet.mmdPoints = 0.0f;
        Wallet saved = repository.save(newWallet);

        return  CreateWalletResponse.builder()
                .message("Created")
                .walletId(repository.searchByUserId(req.userId).getUserId()).build();
    }

//    @Override
//    public boolean debitWalletForUser(Long id, Float value) {
////        Wallet userWallet = getUserWallet();
//        return false;
//    }


    @Override
    public boolean debitWalletForUser(DebitUserWalletCommand command) {
        Wallet userWallet = getUserWallet(command.id);
        if(userWallet.getMmdPoints()> command.amount){
            repository.updateMddPontsForUser(userWallet.getMmdPoints() - command.amount, userWallet.getUserId() );
            return true;
        }
        return false;
    }

    boolean exists(Long userId){
        if(repository.searchByUserId(userId)!= null){
            return false;
        }
        return true;
    }

    @Override
//    public boolean creditWalletForUser(Long id, Float value) {
    public boolean creditWalletForUser(CreditUserWalletCommand command) {
//        Wallet userWallet = repository.searchByUserId(command.id);
        Wallet userWallet = getUserWallet(command.id);
        repository.updateMddPontsForUser(userWallet.getMmdPoints() + command.value, userWallet.getUserId());
        return true;
    }

    @Override
    public Wallet getUserWallet(Long id) {
        return repository.searchWalletByUserId(id);
    }

    @Override
    public List<Wallet> getAllWallets() {
        return repository.findAll();
    }
}
