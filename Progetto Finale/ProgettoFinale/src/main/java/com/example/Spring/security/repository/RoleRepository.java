package com.example.Spring.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Spring.security.entity.ERole;
import com.example.Spring.security.entity.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    
	Optional<Role> findByRoleName(ERole roleName);

}
