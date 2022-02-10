package com.football.app;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication

public class FootballApplication  {

	public static void main(String[] args) {
		SpringApplication.run(FootballApplication.class, args);
	}

//	@Autowired
//	private TeamRepository teamRepository;
//	
//	@Override
//	public void run(String... args) throws Exception {
//		
//		Team t = new Team("Kobra","Bhopal", "01/01/2019", "01/01/2020");
//		
//		Player p1 = new Player("Sonu",20,"20/01/2021", "20/01/2021");
//		Player p2 = new Player("Aman",21,"01/06/2021", "01/06/2021");
//		Player p3 = new Player("Harsh",18,"02/08/2020", "01/06/2021");
//		
//		t.getPlayers().add(p1);
//		t.getPlayers().add(p2);
//		t.getPlayers().add(p3);
//		
//		this.teamRepository.save(t);
//		
//		
//	}
}
