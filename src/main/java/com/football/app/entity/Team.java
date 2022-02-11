package com.football.app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Team")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})
public class Team {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;     // id for unique identity of each team
	
	@Column(name = "name")
	private String name;    // name for storing name of team
	
	@Column(name = "location")
	private String location;     // location variable for storing location of team
	
	@Column(name = "created_at")
	private String created_at;  // created_at variable for storing team creation date 
	
	@Column(name = "updated_at")
	private String updated_at;  // updated_at variable for storing team update date
	
	/* joining Team table with Player table using one to many relationship */
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "team_id", referencedColumnName = "id")
	List<Player> players = new ArrayList<>();

	/* non-parameterized constructor */
	public Team() {
		
	}
	
	
	/* parameterized constructor */
	public Team(String name, String location, String created_at, String updated_at) {
		super();
		this.name = name;
		this.location = location;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}

	/* Getters and Setters methods */
	
	public long getTid() {
		return id;
	}

	public void setTid(long tid) {
		this.id = tid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
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

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	
	
	
}
