package com.leovegas.playersapp.mappers;

import com.leovegas.playersapp.dtos.PlayerDTO;
import com.leovegas.playersapp.entities.Player;
import org.springframework.stereotype.Component;


@Component
public class PlayerMapper {
    public PlayerDTO entityToDTO(Player player) {
        return PlayerDTO.builder()
                .id(player.getId())
                .firstName(player.getFirstName())
                .lastName(player.getLastName())
                .username(player.getUsername())
                .email(player.getEmail())
                .accountBalance(player.getAccountBalance())
                .build();
    };

    public Player dtoToEntity(PlayerDTO playerDTO) {
        return Player.builder()
                .id(playerDTO.getId())
                .firstName(playerDTO.getFirstName())
                .lastName(playerDTO.getLastName())
                .username(playerDTO.getUsername())
                .email(playerDTO.getEmail())
                .accountBalance(playerDTO.getAccountBalance())
                .build();
    };
}
