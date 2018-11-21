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

import com.example.heroes.model.Users;

public interface UserDao extends CrudRepository<Users, Integer> {
	
	@Query("FROM Users a WHERE a.id = :id")
	public Users getBy(@Param("id") int id);

//	@Query("FROM Users a WHERE a.userName = :userName AND a.status = 'ACT' AND a.isDeleted = FALSE")
	@Query("FROM Users a WHERE a.userName = :userName")
	public Users getBy(@Param("userName") String userName);

	@Query("FROM Users a WHERE (a.userName = :userName OR a.email = :email)")
	public Users getBy(@Param("userName") String userName, @Param("email") String email);

	@Query("FROM Users a WHERE a.passReminderToken = :token AND a.status = 'ACT' AND a.isDeleted = FALSE")
	public Users getByToken(@Param("token") String token);

	@Query("FROM Users a WHERE a.activeCode = :code AND a.status = 'ACT' AND a.isDeleted = FALSE")
	public Users getByActiveCode(@Param("code") String code);
	
}