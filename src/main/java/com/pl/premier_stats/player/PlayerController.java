package com.pl.premier_stats.player;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/player")
public class PlayerController {
    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public List<Player> getPlayers(
            @RequestParam(required = false) String club,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String position) {
        if (club != null && position != null) {
            return playerService.getPlayersByClubAndPosition(club, position);
        } else if (name != null){
            return playerService.getPlayersByName(name);
        } else if(position != null) {
            return playerService.getPlayersByPosition(position);
        } else {
            return playerService.getPlayers();
        }
    }
    @PostMapping
    public ResponseEntity<Player> addPlayer(@RequestBody Player player){
        Player createdPlayer = playerService.addPlayer(player);
        return new ResponseEntity<>(createdPlayer, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Player>  updatePLayer(@RequestBody Player player) {
        Player resultPlayer = playerService.updatePlayer(player);
        if(resultPlayer != null){
            return new ResponseEntity<>(resultPlayer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{playerName}")
    public ResponseEntity<String> deletePlayer(@PathVariable String playerName) {
       playerService.deletePlayer(playerName);
        return new ResponseEntity<>( "Player deleted successfully", HttpStatus.OK );
    }
}


