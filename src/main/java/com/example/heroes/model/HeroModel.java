package com.example.heroes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "hero", schema = "public")
public class HeroModel {
	// region -- Fields --
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hero_id_seq_generator")
	@SequenceGenerator(name = "hero_id_seq_generator", sequenceName = "public.hero_id_seq", allocationSize = 1)
	@Column(columnDefinition = "SERIAL")
	private Integer id;
	
	@Column(columnDefinition = "varchar(64)", name = "name")
	private String name;
	
	// end

	// region -- Get set --

	// end

	// region -- Methods --

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HeroModel() {

	}

	// end
	
	
	
}
