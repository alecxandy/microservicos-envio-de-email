package com.alexandregsouza.api.email.models;

import com.alexandregsouza.api.email.enuns.StatusEmail;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "tb_email")
public class EmailModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ownerRef;//id do usuario que vai ser enviado
    private String emailFrom;//Onde?
    private String emailTo;//Pra onde?
    private String subject;//titulo
    @Column(columnDefinition = "TEXT")//campo de texto recebe mais caracters no banco
    private String text;//corpo
    private LocalDateTime localDateTime;
    @Enumerated
    private StatusEmail statusEmail;
}
