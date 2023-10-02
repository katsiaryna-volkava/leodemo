package com.leovegas.playersapp.services;

import com.leovegas.playersapp.dtos.PlayerDTO;

import java.util.List;

public interface PlayerService {

    PlayerDTO savePlayer(PlayerDTO playerDTO);

    PlayerDTO updatePlayer(Long id, PlayerDTO playerDTO);

    void deletePlayer(Long id);

    PlayerDTO getPlayerById(Long id);

    List<PlayerDTO> getAllPlayers();
}
