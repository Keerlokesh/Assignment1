package com.football.app.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.football.app.entity.Player;
import com.football.app.entity.Team;
import com.football.app.service.FootballService;


@RestController
public class HomeController {
	
	@Autowired
	private FootballService service;
	
	@RequestMapping("/")
	public String home() {

		
		return "home.jsp";
	}
	
	@RequestMapping("/team")
	public String team() {

		
		return "team.jsp";
	}
	
	@RequestMapping("/player")
	public String player() {

		
		return "player.jsp";
	}
	
	
	/* team */
	
	@PostMapping("/addTeam")
	public Team addTeam(@RequestBody Team team) {
		
		return service.saveTeam(team);
	}
	
	@PostMapping("/team/{id}")
	public Team findTeamById(@PathVariable int id) {
		return service.findTeamById(id);
	}
	
	@PutMapping("/team/update/{id}")
	public Team updateTeam(@PathVariable int id, @RequestBody Team team) {
		return service.updateTeam(id, team);
	}
	
	@DeleteMapping("/team/delete/{id}")
	public String deleteTeam(@PathVariable int id) {
		return service.deleteTeamById(id);
	}
	
	
	
	/* player */
	@PostMapping("/addPlayer")
	public Player addPlayer(@RequestBody Player player) {
		return service.savePlayer(player);
	}
	
	@GetMapping("/player/{id}")
	public Player findPlayerById(@PathVariable int id) {
		return service.findPlayerById(id);
	}
	
	@PutMapping("/player/update/{id}")
	public Player updatePlayer(@PathVariable long id, @RequestBody Player player) {
		return service.updatePlayer(id, player);
	}
	
	@DeleteMapping("/player/delete/{id}")
	public String deletePlayer(@PathVariable int id) {
		return service.deletePlayerById(id);
	}
	
	
	
	@GetMapping("/teams")
	public List<Team> showTeams(){
		return service.getTeams();
	}
}



