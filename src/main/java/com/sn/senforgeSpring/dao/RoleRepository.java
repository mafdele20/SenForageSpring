package com.sn.senforgeSpring.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sn.senforgeSpring.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
