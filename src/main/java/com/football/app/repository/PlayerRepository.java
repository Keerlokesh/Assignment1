package com.football.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.football.app.entity.Player;

public interface PlayerRepository extends JpaRepository<Player,Long>{

}
