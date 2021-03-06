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

import com.example.heroes.dto.HeroDto;
import com.example.heroes.model.HeroModel;
import java.util.List;

public interface HeroDao extends CrudRepository<HeroModel, Integer> {

	@Query(nativeQuery = true, value = "SELECT get_total_hero()")
	public int getTotalHero();
	
	@Query(nativeQuery = true, value = "SELECT * FROM get_heros()")
	public List<Object[]> getHerosFunc();
	
	@Query("FROM HeroModel h WHERE h.id = :id")
	public HeroModel getBy(@Param("id") int id);
	
	@Query("FROM HeroModel")
	public List<HeroModel> getHeroes();
	
	@Query("FROM HeroModel h WHERE h.name like %:name%")
	public List<HeroModel> searchBy(@Param("name") String name);
	
}