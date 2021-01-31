/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xchandqq.ft.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.xchandqq.ft.models.Transaction;

/**
 *
 * @author Christian
 */
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>{
    List<Transaction> findByUserId(long userId);
    List<Transaction> findByAccountToIdOrAccountFromId(long accountToId, long accountFromId);
}
