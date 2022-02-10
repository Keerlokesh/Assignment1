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


/* Controller for http requests */
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
	
	
	/* Endpoints */
	
	
	/* team request */
	/* addTeam post request for adding New Team into database */
	@PostMapping("/addTeam")
	public Team addTeam(@RequestBody Team team) {
		
		return service.saveTeam(team);
	}
	
	/*get request for finding team details by their id */
	@GetMapping("/team/{id}")
	public Team findTeamById(@PathVariable int id) {
		return service.findTeamById(id);
	}
	
	/* put request for updating team details */
	@PutMapping("/team/update/{id}")
	public Team updateTeam(@PathVariable int id, @RequestBody Team team) {
		return service.updateTeam(id, team);
	}
	
	/* Delete request for deleting team details  */
	@DeleteMapping("/team/delete/{id}")
	public String deleteTeam(@PathVariable int id) {
		return service.deleteTeamById(id);
	}
	
	
	
	/* player request */
	/* addPlayer post request for adding New Player into database */
	@PostMapping("/addPlayer")
	public Player addPlayer(@RequestBody Player player) {
		return service.savePlayer(player);
	}
	
	/*get request for finding team details by their id */
	@GetMapping("/player/{id}")
	public Player findPlayerById(@PathVariable int id) {
		return service.findPlayerById(id);
	}
	
	/* put request for updating player details */
	@PutMapping("/player/update/{id}")
	public Player updatePlayer(@PathVariable long id, @RequestBody Player player) {
		return service.updatePlayer(id, player);
	}
	
	/* Delete request for deleting player details  */
	@DeleteMapping("/player/delete/{id}")
	public String deletePlayer(@PathVariable int id) {
		return service.deletePlayerById(id);
	}
	
	/* Get request for showing all players */
	@GetMapping("/players")
	public List<Player> showPlayers(){
		return service.getPlayers();
	}
	
	
	/* Get request for showing all teams */
	@GetMapping("/teams")
	public List<Team> showTeams(){
		return service.getTeams();
	}
}



