# Assignment1
Assignment 1: Java Backend 

Springboot application for showing Team and player one to many relationship.

### Purpose of this application
This is an example of showing one to many relationship.

### Key features:
    - Easy to use
    - Using Restful services for http requests
    - capable to handle multiple request simultaneously 
    - Using MySQl database


### Requirements
  - Java version 11
  - SpringToolSuite4
  - MySQl 2.8

# Get started

  ## Installation
  
  Open project in STS and run as Springboot app.
  
![image](https://user-images.githubusercontent.com/66743138/153647332-426d3a70-9f8f-42e4-b2a5-7d71fbf78d85.png)


  ## pom.xml file for dependencies
  
  
          <?xml version="1.0" encoding="UTF-8"?>
          <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
          <modelVersion>4.0.0</modelVersion>
          <parent>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-starter-parent</artifactId>
          <version>2.6.3</version>
          <relativePath/> <!-- lookup parent from repository -->
          </parent>
          <groupId>com.football</groupId>
          <artifactId>Football</artifactId>
          <version>0.0.1-SNAPSHOT</version>
          <name>Football</name>
          <description>Demo project for Football team management</description>
          <properties>
          <java.version>11</java.version>
          </properties>
          <dependencies>
          <dependency>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-starter-data-jpa</artifactId>
          </dependency>
          <dependency>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-starter-web</artifactId>
          </dependency>

          <dependency>
          <groupId>mysql</groupId>
          <artifactId>mysql-connector-java</artifactId>
          <scope>runtime</scope>
          </dependency>
          <dependency>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-starter-test</artifactId>
          <scope>test</scope>
          </dependency>

          <!-- https://mvnrepository.com/artifact/org.apache.tomcat/tomcat-jasper -->
          <dependency>
          <groupId>org.apache.tomcat</groupId>
          <artifactId>tomcat-jasper</artifactId>
          <version>9.0.56</version>
          </dependency>

          <dependency>
          <groupId>org.apache.tomcat.embed</groupId>
          <artifactId>tomcat-embed-jasper</artifactId>

          </dependency>
          </dependencies>

          <build>
          <plugins>
          <plugin>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-maven-plugin</artifactId>
          </plugin>
          </plugins>
          </build>

          </project>



  ## application.properties file
  
  Here we do all configuration of project. This is most important file for project. It is responsible to connect project with database.
      
      
          spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
          spring.datasource.url = jdbc:mysql://localhost:3306/football
          spring.datasource.username = root
          spring.datasource.password = Lokesh@123
          spring.jpa.show-sql = true
          spring.jpa.hibernate.ddl-auto = update
          spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5Dialect

          logging.level.hibernate.SQL=DEBUG
          logging.level.hibernate.type=TRACE

    


  ## Rest endpoints for Team
  
  - /addTeam
  - /update/team/{id}
  - /delete/team/{id}
  - /teams



  #### /addTeam 
  
  if app get /addTeam post request then Team data added to database. If all fields is match then only record will save into database. 
  
  
          @PostMapping("/addTeam")
	        public Team addTeam(@RequestBody Team team) {
		
		        return service.saveTeam(team);
	        }
  User send post request with Team object then data save to the database and response send to the user.
  
  
  Example of post request using Postman :
  
![addTeam](https://user-images.githubusercontent.com/66743138/153661533-23246447-0938-4ccf-8987-424f2820d239.jpg)





  #### /update/team/{id}
  if user request a put request with team id /update/team/{id} for updating team data then their respective data will be updated. If all fields is match then only record will save into the database. 
  
  
	   @PutMapping("/team/update/{id}")
	   public Team updateTeam(@PathVariable int id, @RequestBody Team team) {
	      	return service.updateTeam(id, team);
	   }
  User send put request with team id, if team id exist in database then team data will be updated otherwise exception occurs.
  
  Example of put request :
  
  
![Update_Team](https://user-images.githubusercontent.com/66743138/153661592-75a6ef83-542a-409c-b6d6-6aa5c8c44a82.jpg)







  #### /team/{id}
  if user send a get request with team id for getting specific team data then their respective data will be send to the user. 
  
	   @GetMapping("/team/{id}")
	   public Team updateTeam(@PathVariable int id, @RequestBody Team team) {
	      	return service.updateTeam(id, team);
	   }
     
  User send get request with team id, if team id exist in database then specific team data will be send otherwise exception occurs.
  
  Example of put request :
  
  
![findById_Team](https://user-images.githubusercontent.com/66743138/153661640-f3338f47-bdb8-465e-af40-95cf40d5b9bc.jpg)






   #### /delete/team/{id}
  if user request a delete request with team id /delete/team/{id} for deleting team data then their respective data will be deleted. If team id get matched then only record will be deleted from the database.
  
  
      @DeleteMapping("/team/delete/{id}")
	    public String deleteTeam(@PathVariable int id) {
	    	return service.deleteTeamById(id);
	    }
      
  User send delete request with team id, if team id exist then team will be deleted from the database.
  
  
  Example of delete request :
  
  
  
![Team_Delete](https://user-images.githubusercontent.com/66743138/153661685-a684318b-abc9-4622-a328-1c69936c905b.jpg)






   #### /teams
  if user request a simple get request /teams for getting team data then their respective data will be displayed.
  
  
        @GetMapping("/teams")
	      public List<Team> showTeams(){
		      return service.getTeams();
	       }
         
  If user send get request then all team data will be send to user as response in the form of list.
  
  
  Example of get request :
  
  
![All_Teams](https://user-images.githubusercontent.com/66743138/153661727-b6cceca9-20ea-4b47-892e-05a5399fabda.jpg)







 ## Rest endpoints for Player
  - /addPlayer
  - /update/player/{id}
  - /delete/player/{id}
  - /players



  #### /addPlayer
  if user request a /addPlayer post request then Player data added to database. If all fields is match then only record will save into the database. 
  
  
        @PostMapping("/addPlayer")
	      public Player addPlayer(@RequestBody Player player) {
	      	return service.savePlayer(player);
	      }
        
   User send post request with Player object then data save to the database and response send to the user.
  
  Example of post request using Postman :
  
  
![Add_Player](https://user-images.githubusercontent.com/66743138/153661748-dce9b0b5-f67c-4a4c-9afd-fe89259f4911.jpg)






  #### /player/{id}
  if user send a get request with player id for getting specific player data then their respective data will be send to the user. 
  
  
	   @GetMapping("/player/{id}")
	   public Player findPlayerById(@PathVariable long id) {
		    return service.findPlayerById(id);
	    }
      
  User send get request with player id, if player id exist in database then specific player data will be send otherwise exception occurs.
  
  Example of put request :
  
  
![FindById_Player](https://user-images.githubusercontent.com/66743138/153661801-5e23c31f-c96d-45ac-bfc2-72ac0368cea0.jpg)


  
  
  


  #### /update/player/{id}
  if user request a put request with player id /update/player/{id} for updating player data then their respective data will be updated. If all fields is match then only record will save into the database. 
  
  
        @PutMapping("/player/update/{id}")
	      public Player updatePlayer(@PathVariable long id, @RequestBody Player player) {
	      	return service.updatePlayer(id, player);
	      }
        
  User send put request with player id, if player id exist in database then player data will be updated otherwise exception occurs.
  
  Example of put request :
  
  
![Update_Player](https://user-images.githubusercontent.com/66743138/153661836-00554299-571a-4cdf-a3c8-be8909b30aa8.jpg)






   #### /delete/player/{id}
  if user request a delete request with player id /delete/player/{id} for deleting player data then their respective data will be deleted. If player id get matched then only  record will be deleted from the database. 
  
  
        @DeleteMapping("/player/delete/{id}")
	      public String deletePlayer(@PathVariable int id) {
		        return service.deletePlayerById(id);
	      }
        
  User send delete request with player id, if player id exist then player will be deleted from the database.
  
  
  Example of delete request :
  
  
  
![Player_Delete](https://user-images.githubusercontent.com/66743138/153661866-9c2e6126-dc13-4fc0-aa81-2b3bbb8641da.jpg)






   #### /players
  if user send a simple get request /players for getting player data then their respective data will be displayed.
  
  
          @GetMapping("/players")
	        public List<Player> showPlayers(){
	        	return service.getPlayers();
	         }
           
  
  If user send get request then all player data will be send to user as response in the form of list.
  
  Example of get request :
  
  
![All_Players](https://user-images.githubusercontent.com/66743138/153662005-f05be670-23c8-45fa-93d7-ea9c07f9ae63.jpg)








# Database 



![Database](https://user-images.githubusercontent.com/66743138/153662033-72cb3c5b-97a1-4c63-8288-aae9ea31bb8f.jpg)




