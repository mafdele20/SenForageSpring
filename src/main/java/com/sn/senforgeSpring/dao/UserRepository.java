package com.sn.senforgeSpring.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sn.senforgeSpring.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
