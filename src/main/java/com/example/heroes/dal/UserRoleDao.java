package com.example.heroes.dal;

import org.springframework.data.repository.CrudRepository;

import com.example.heroes.model.UserRole;

public interface UserRoleDao extends CrudRepository<UserRole, Integer> {

}