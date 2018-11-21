package com.example.heroes.dal;

import org.springframework.data.repository.CrudRepository;

import com.example.heroes.model.RoleFunction;

public interface RoleFunctionDao extends CrudRepository<RoleFunction, Integer> {

}