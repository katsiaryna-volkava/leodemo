package com.leovegas.playersapp.services;

import com.leovegas.playersapp.dtos.PlayerDTO;
import com.leovegas.playersapp.entities.Player;
import com.leovegas.playersapp.exceptions.PlayerNotFoundException;
import com.leovegas.playersapp.mappers.PlayerMapper;
import com.leovegas.playersapp.repositories.PlayerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;
    private final PlayerMapper playerMapper;

    @Override
    public PlayerDTO savePlayer(PlayerDTO playerDTO) {
        Player player = playerMapper.dtoToEntity(playerDTO);
        Player savedPlayer = playerRepository.save(player);

        return playerMapper.entityToDTO(savedPlayer);
    }

    @Override
    public PlayerDTO updatePlayer(Long id, PlayerDTO playerDTO) {
        var playerOptional = playerRepository.findById(id);
        if (playerOptional.isPresent()) {
            Player existingPlayer = playerOptional.get();

            existingPlayer.setEmail(playerDTO.getEmail());
            existingPlayer.setFirstName(playerDTO.getFirstName());
            existingPlayer.setLastName(playerDTO.getLastName());
            existingPlayer.setAccountBalance(playerDTO.getAccountBalance());
            existingPlayer.setUsername(playerDTO.getUsername());

            return playerMapper.entityToDTO(existingPlayer);
        }
        throw new PlayerNotFoundException(id);
    }

    @Override
    public void deletePlayer(Long id) {
        var playerOptional = playerRepository.findById(id);
        if (playerOptional.isPresent()) {
            playerRepository.deleteById(id);

            return;
        }
        throw new PlayerNotFoundException(id);
    }

    @Override
    public PlayerDTO getPlayerById(Long id) {
        Player player = playerRepository
                .findById(id)
                .orElseThrow(
                        () -> new PlayerNotFoundException(id)
                );

        return playerMapper.entityToDTO(player);
    }

    @Override
    public List<PlayerDTO> getAllPlayers() {
        List<Player> players = (List<Player>) playerRepository.findAll();

        return players.stream()
                .map(playerMapper::entityToDTO)
                .collect(Collectors.toList());
    }
}
