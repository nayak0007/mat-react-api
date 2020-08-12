package com.matreact.matreact.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.matreact.matreact.model.ERole;
import com.matreact.matreact.model.Role;

public interface RoleRepository extends MongoRepository<Role, String> {
	Optional<Role> findByName(ERole name);
}
