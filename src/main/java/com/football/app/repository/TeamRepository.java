package com.football.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.football.app.entity.Team;

public interface TeamRepository extends JpaRepository<Team,Long> {

}
