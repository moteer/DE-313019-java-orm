package com.de.brightslearning.football.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    @Autowired
    private ClubRepository clubRepository;

    @GetMapping("/")
    public @ResponseBody Iterable<Club> getAllFootballClubs() {
        Club club = new Club();
        club.setName("SV Weißichnich");
        club.setStadiumName("Heidegrass");
        clubRepository.save(club);

        return clubRepository.findAll();
    }
}
