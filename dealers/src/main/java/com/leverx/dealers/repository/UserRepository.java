package com.leverx.dealers.repository;

import com.leverx.dealers.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {


    Optional<User> findUserByFirstName(String firstName);
}
