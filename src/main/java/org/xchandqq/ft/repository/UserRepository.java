/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xchandqq.ft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.xchandqq.ft.models.User;

/**
 *
 * @author Christian
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    
}
