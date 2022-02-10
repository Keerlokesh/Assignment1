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
	
	public Team saveTeam(Team team) {
		return teamRepository.save(team);
	}
	
	public Team findTeamById(long id) {
		return teamRepository.getById(id);
	}
	
	public Team updateTeam(long id, Team team) {
		
		Team t = teamRepository.getById(id);
		team.setTid(id);
		t.setName(team.getName());
		t.setLocation(team.getLocation());
		t.setCreated_at(team.getCreated_at());
		t.setUpdated_at(team.getUpdated_at());
		
		return teamRepository.save(t);
	}
	
	public String deleteTeamById(long id) {
		teamRepository.deleteById(id);
		return "Team deleted || "+id;
	}
	
	public List<Team> getTeams() {
		return teamRepository.findAll();
	}
	
	public Player savePlayer(Player player) {
		return playerRepository.save(player);
	}
	
	public Player findPlayerById(long id) {
		return playerRepository.getById(id);
	}
	
	public Player updatePlayer(long id,Player player) {
		System.out.println("id "+id+ "\n");
		player.setId(id);
		
		Player p = playerRepository.getById(id);
		p.setName(player.getName());
		p.setAge(player.getAge());
		p.setCreated_at(player.getCreated_at());
		p.setUpdated_at(player.getUpdated_at());
		p.setTeam_id(player.getTeam_id());
		
		return playerRepository.save(p);
	}
	
	public String deletePlayerById(long id) {
		playerRepository.deleteById(id);
		return "Player deleted || "+id;
	}
	
	public List<Player> getPlayers() {
		return playerRepository.findAll();
	}
	
}


