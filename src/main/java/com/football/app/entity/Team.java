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

@Entity
@Table(name = "Team")
public class Team {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "location")
	private String location;
	
	@Column(name = "created_at")
	private String created_at;
	
	@Column(name = "updated_at")
	private String updated_at;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "team_id", referencedColumnName = "id")
	List<Player> players = new ArrayList<>();

	
	public Team() {
		
	}
	
	
	
	public Team(String name, String location, String created_at, String updated_at) {
		super();
		this.name = name;
		this.location = location;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}

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
