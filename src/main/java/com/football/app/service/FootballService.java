package com.football.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.football.app.entity.Player;
import com.football.app.entity.Team;
import com.football.app.repository.PlayerRepository;
import com.football.app.repository.TeamRepository;

@Service
public class FootballService {
	
	@Autowired
	private TeamRepository teamRepository;
	
	@Autowired
	private PlayerRepository playerRepository;
	
	/* saveTeam method for adding new team into database */
	public Team saveTeam(Team team) {
		return teamRepository.save(team);
	}
	
	/* method to get record of existing Team by their id */
	public Team findTeamById(long id) {
		return teamRepository.getById(id);
	}
	
	/* method to update existing Team record */
	public Team updateTeam(long id, Team team) {
		/* finding team record and storing into Team class object t  */
		Team t = teamRepository.getById(id);
		/* updating details */
		team.setTid(id);
		t.setName(team.getName());
		t.setLocation(team.getLocation());
		t.setCreated_at(team.getCreated_at());
		t.setUpdated_at(team.getUpdated_at());

		return teamRepository.save(t);
	}
	
	/* method to delete Team using their id */
	public String deleteTeamById(long id) {
		teamRepository.deleteById(id);
		return "Team deleted || "+id;
	}
	
	/* method to show all teams */
	public List<Team> getTeams() {
		return teamRepository.findAll();
	}
	
	
	/* savePlayer method for adding new Player into player table */
	public Player savePlayer(Player player) {
		return playerRepository.save(player);
	}
	
	/* method to get record of existing player by their id */
	public Player findPlayerById(long id) {
		return playerRepository.getById(id);
	}
	
	/* method to update existing player record */
	public Player updatePlayer(long id,Player player) {
		/* setting id ( new Player object id is auto generated and always new id create that's why setting old id ) */
		player.setId(id);
		
		/* storing player record into Player class object */
		Player p = playerRepository.getById(id);
		
		/* updating details */
		p.setName(player.getName());
		p.setAge(player.getAge());
		p.setCreated_at(player.getCreated_at());
		p.setUpdated_at(player.getUpdated_at());
		p.setTeam_id(player.getTeam_id());
		
		return playerRepository.save(p);
	}
	
	/* method to delete existing Player using their id */
	public String deletePlayerById(long id) {
		playerRepository.deleteById(id);
		return "Player deleted || "+id;
	}
	
	/* method to show all players */
	public List<Player> getPlayers() {
		return playerRepository.findAll();
	}
	
}


