package com.stockManagement.stockManagement.repositories;

import com.stockManagement.stockManagement.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
