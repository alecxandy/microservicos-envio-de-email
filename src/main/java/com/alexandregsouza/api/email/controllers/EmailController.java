package com.alexandregsouza.api.email.controllers;

import com.alexandregsouza.api.email.dtos.EmailDTO;
import com.alexandregsouza.api.email.models.EmailModel;
import com.alexandregsouza.api.email.services.EmailService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/sending-email")
    public ResponseEntity<EmailModel> sendiEmail(@RequestBody @Valid EmailDTO emailDTO) {
        EmailModel emailModel = new EmailModel();
        BeanUtils.copyProperties(emailDTO, emailModel);
        emailService.sendingnEmail(emailModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(emailModel);
    }

    @GetMapping("/")
    public ResponseEntity<List<EmailModel>> listAll() {
        return ResponseEntity.status(HttpStatus.OK).body(emailService.findAll());
    }


}
