/**
 * 
 */
/**
 * @author An An Nguyen
 *
 */
package com.example.heroes.dal;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.heroes.model.UserModel;

public interface UserDao extends CrudRepository<UserModel, Integer> {
	
	@Query("FROM UserModel u WHERE u.id = :id")
	public UserModel getBy(@Param("id") int id);
	
	@Query("FROM UserModel a WHERE a.userName = :userName AND a.password = :password")
	public UserModel getByPassword(@Param("userName") String userName, @Param("password") String password);

	@Query("FROM UserModel a WHERE a.email = :email")
	public UserModel getBy(@Param("email") String email);

	@Query("FROM UserModel a WHERE (a.userName = :userName OR a.email = :email)")
	public UserModel getBy(@Param("userName") String userName, @Param("email") String email);
	
}