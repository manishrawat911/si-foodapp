package com.example.walletservice.business;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface WalletRepository extends JpaRepository<Wallet, Long> {

    Wallet searchWalletByUserId(Long id);

    Wallet searchByUserId(Long id);

//    @Transactional
//    @Modifying
//    @Query("update Wallet w set w.mmdPoints = ?1 where w.mmdPoints = ?2")
//    int updateMddForUser(Float mmdPoints, @NonNull Float mmdPoints1);

    @Transactional
    @Modifying
    @Query("update Wallet w set w.mmdPoints = ?1 where w.userId = ?2")
    int updateMddPontsForUser(Float mmdPoints, Long userId);



    List<Wallet> findAll();

//    boolean upda

}
