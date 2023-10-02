package com.leovegas.playersapp.dtos;

import com.leovegas.playersapp.annotations.UniqueUsername;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;



@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDTO {

    private Long id;

    @UniqueUsername
    @NotBlank(message = "First name can not be empty")
    @Size(max = 10, message = "Max username length is 10 symbols!")
    private String username;

    @NotBlank(message = "First name can not be empty")
    private String firstName;

    @NotBlank(message = "Last name can not be empty")
    private String lastName;

    @NotBlank(message = "Email field can not be empty")
    @Email(message = "Please provide a valid email address")
    private String email;

    private Double accountBalance;
}
