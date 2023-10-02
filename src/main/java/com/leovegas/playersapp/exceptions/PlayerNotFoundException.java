package com.leovegas.playersapp.exceptions;

public class PlayerNotFoundException extends RuntimeException {

    public PlayerNotFoundException(Long playerId) {
        super(String.format("Player with id %s not found.", playerId));
    }

}
