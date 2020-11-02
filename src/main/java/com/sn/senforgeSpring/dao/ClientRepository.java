package com.sn.senforgeSpring.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sn.senforgeSpring.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
