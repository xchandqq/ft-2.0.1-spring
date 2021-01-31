/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xchandqq.ft.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.xchandqq.ft.models.Account;

/**
 *
 * @author Christian
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{
    List<Account> findByUserId(long userId);
    Optional<Account> findByIdAndUserId(long accountId, long userId);
}
