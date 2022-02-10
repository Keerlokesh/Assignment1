package com.football.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Player")
public class Player {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;   // id for unique identity of each player
	
	@Column(name = "name")
	private String name;    // name for storing name of team
	
	@Column(name = "age")
	private int age;      // age for storing age of player
	
	@Column(name = "created_at")
	private String created_at;   // created_at variable for storing player creation date 
	
	@Column(name = "updated_at")
	private String updated_at;  // updated_at variable for storing player update date

	@Column(name = "team_id")
	private long team_id;     // team id for storing team id of player
	
	
	/* non-parameterized constructor */
	public Player() {
		
	}
	
	/* parameterized constructor */
	public Player(String name, int age, String created_at, String updated_at,long team_id) {
		super();
		this.name = name;
		this.age = age;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.team_id = team_id;
	}
	
	
	/* Getters and Setters methods */
	
	public long getTeam_id() {
		return team_id;
	}

	public void setTeam_id(long team_id) {
		this.team_id = team_id;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
	
	
	
	
	
}
