package com.leovegas.playersapp.controllers;

import com.leovegas.playersapp.dtos.PlayerDTO;
import com.leovegas.playersapp.services.PlayerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/players")
public class PlayersController {

    private final PlayerService playerService;

    @GetMapping("/")
    public List<PlayerDTO> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerDTO> getPlayerById(@PathVariable Long id) {
        PlayerDTO player = playerService.getPlayerById(id);

        return new ResponseEntity<>(player, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<PlayerDTO> createPlayer(@Valid @RequestBody PlayerDTO playerDTO) {
        PlayerDTO savedPlayer = playerService.savePlayer(playerDTO);

        return new ResponseEntity<>(savedPlayer, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlayerDTO> updatePlayer(
            @PathVariable Long id,
            @RequestBody PlayerDTO playerDTO
    ) {
        var updatedPlayer = playerService.updatePlayer(id, playerDTO);

        return new ResponseEntity<>(updatedPlayer, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable Long id) {
        playerService.deletePlayer(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
