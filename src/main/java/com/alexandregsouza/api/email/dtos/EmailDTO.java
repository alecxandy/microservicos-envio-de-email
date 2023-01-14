package com.alexandregsouza.api.email.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EmailDTO {

    @NotBlank
    private String ownerRef;//id do usuario que vai ser enviado
    @NotBlank
    @Email
    private String emailFrom;//Onde?
    @NotBlank
    @Email
    private String emailTo;//Pra onde?
    @NotBlank
    private String subject;//titulo
    private String text;//corpo

}
