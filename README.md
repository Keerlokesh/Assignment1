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
  
        ![addTeam](https://user-images.githubusercontent.com/66743138/153648567-75fdbf26-4119-4880-804a-b0d32669908e.jpg)




  #### /update/team/{id}
  if user request a put request with team id /update/team/{id} for updating team data then their respective data will be updated. If all fields is match then only record will save into the database. 
  
  
	   @PutMapping("/team/update/{id}")
	   public Team updateTeam(@PathVariable int id, @RequestBody Team team) {
	      	return service.updateTeam(id, team);
	   }
  User send put request with team id, if team id exist in database then team data will be updated otherwise exception occurs.
  
  Example of put request :
  
  
          ![Update_Team](https://user-images.githubusercontent.com/66743138/153660060-bae8cc46-b57e-4c84-bd56-b6b8e9a63ac5.jpg)






  #### /team/{id}
  if user send a get request with team id for getting specific team data then their respective data will be send to the user. 
  
	   @GetMapping("/team/{id}")
	   public Team updateTeam(@PathVariable int id, @RequestBody Team team) {
	      	return service.updateTeam(id, team);
	   }
     
  User send get request with team id, if team id exist in database then specific team data will be send otherwise exception occurs.
  
  Example of put request :
  
  
        ![findById_Team](https://user-images.githubusercontent.com/66743138/153657604-29d5e3bb-9156-4afc-8eae-5f5f062e7300.jpg)





   #### /delete/team/{id}
  if user request a delete request with team id /delete/team/{id} for deleting team data then their respective data will be deleted. If team id get matched then only record will be deleted from the database.
  
  
      @DeleteMapping("/team/delete/{id}")
	    public String deleteTeam(@PathVariable int id) {
	    	return service.deleteTeamById(id);
	    }
      
  User send delete request with team id, if team id exist then team will be deleted from the database.
  
  
  Example of delete request :
  
  
  
      ![Team_Delete](https://user-images.githubusercontent.com/66743138/153649422-357db433-4521-48e5-991a-37fdc5867cc1.jpg)


   #### /teams
  if user request a simple get request /teams for getting team data then their respective data will be displayed.
  
  
        @GetMapping("/teams")
	      public List<Team> showTeams(){
		      return service.getTeams();
	       }
         
  If user send get request then all team data will be send to user as response in the form of list.
  
  
  Example of get request :
  
  
      ![All_Teams](https://user-images.githubusercontent.com/66743138/153649963-b0b58918-ef95-4b05-b973-1d7c5f3c626e.jpg)






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
  
  
        ![Add_Player](https://user-images.githubusercontent.com/66743138/153650703-59668796-9ab0-4d72-87d2-01ecb4e9c4b4.jpg)





  #### /player/{id}
  if user send a get request with player id for getting specific player data then their respective data will be send to the user. 
  
  
	   @GetMapping("/player/{id}")
	   public Player findPlayerById(@PathVariable long id) {
		    return service.findPlayerById(id);
	    }
      
  User send get request with player id, if player id exist in database then specific player data will be send otherwise exception occurs.
  
  Example of put request :
  
  
          ![FindById_Player](https://user-images.githubusercontent.com/66743138/153657875-91b7a0cd-792f-4cab-9ff6-592815735f27.jpg)

  
  
  


  #### /update/player/{id}
  if user request a put request with player id /update/player/{id} for updating player data then their respective data will be updated. If all fields is match then only record will save into the database. 
  
  
        @PutMapping("/player/update/{id}")
	      public Player updatePlayer(@PathVariable long id, @RequestBody Player player) {
	      	return service.updatePlayer(id, player);
	      }
        
  User send put request with player id, if player id exist in database then player data will be updated otherwise exception occurs.
  
  Example of put request :
  
  
        ![Update_Player](https://user-images.githubusercontent.com/66743138/153650846-2c36b38a-eb40-49e4-9228-f97a916b36b4.jpg)





   #### /delete/player/{id}
  if user request a delete request with player id /delete/player/{id} for deleting player data then their respective data will be deleted. If player id get matched then only  record will be deleted from the database. 
  
  
        @DeleteMapping("/player/delete/{id}")
	      public String deletePlayer(@PathVariable int id) {
		        return service.deletePlayerById(id);
	      }
        
  User send delete request with player id, if player id exist then player will be deleted from the database.
  
  
  Example of delete request :
  
  
  
      ![Player_Delete](https://user-images.githubusercontent.com/66743138/153651308-474c14e2-967d-4fd8-bdfd-f192ce62ce98.jpg)





   #### /players
  if user send a simple get request /players for getting player data then their respective data will be displayed.
  
  
          @GetMapping("/players")
	        public List<Player> showPlayers(){
	        	return service.getPlayers();
	         }
           
  
  If user send get request then all player data will be send to user as response in the form of list.
  
  Example of get request :
  
  
      ![All_Teams](https://user-images.githubusercontent.com/66743138/153651610-6ef9858b-c5f6-4b93-9f08-4452e5aace38.jpg)







# Database 



     ![Database](https://user-images.githubusercontent.com/66743138/153661239-c1385bf1-75e5-470a-841e-a0403adf112d.jpg)



