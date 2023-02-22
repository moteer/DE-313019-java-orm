package com.de.brightslearning.football.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;

import static java.util.Arrays.asList;

@Controller
public class MyController {

    @Autowired
    private ClubRepository clubRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping("/")
    public @ResponseBody Iterable<Club> getAllFootballClubs() {
        Club club = new Club();
        club.setName("SV Weißichnich 2");
        club.setStadiumName("Heidegrass 3");

        Player player = new Player();
        player.setFirstName("Hans");
        player.setLastName("Dieter");

        Player player2 = new Player();
        player2.setFirstName("Franz");
        player2.setLastName("Dieter");
        playerRepository.save(player);
        playerRepository.save(player2);

        club.setPlayers(asList(player, player2));

        clubRepository.save(club);


        System.out.println(playerRepository.findAll());

        System.out.println(playerRepository.findByFirstNameIs("Franz"));
        System.out.println(playerRepository.findByLastNameIs("Dieter"));

        return clubRepository.findAll();
    }
}
