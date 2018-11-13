package com.example.heroes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "heroes", schema = "pulic")
public class SampleTable {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sample_table_id_seq_generator")
	@SequenceGenerator(name = "sample_table_id_seq_generator", sequenceName = "public.sample_table_id_seq", allocationSize = 1)
	@Column(columnDefinition = "SERIAL")
	private Integer id;
	
	@Column(columnDefinition = "text", name = "first_name")
	private String firstName;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(columnDefinition = "text", name = "last_name")
	private String lastName;
}
