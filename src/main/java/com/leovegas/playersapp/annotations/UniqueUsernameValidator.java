package com.leovegas.playersapp.annotations;

import com.leovegas.playersapp.repositories.PlayerRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;


public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {
    private final PlayerRepository playerRepository;

    @Autowired
    public UniqueUsernameValidator(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public void initialize(UniqueUsername constraintAnnotation) {
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        if (username == null) {
            return true;
        }

        return !playerRepository.existsByUsername(username);
    }
}
