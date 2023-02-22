package com.de.brightslearning.football.demo;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlayerRepository extends CrudRepository<Player, Long> {

    public List<Player> findByFirstNameIs(String firstName);

    public List<Player> findByLastNameIs(String lastName);
}
