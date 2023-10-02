package com.leovegas.playersapp.repositories;

import com.leovegas.playersapp.entities.Player;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<Player, Long> {
    boolean existsByUsername(String username);
}
