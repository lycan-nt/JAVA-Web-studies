package com.owl.producer.controller;

import com.owl.producer.service.MensagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MensagemController {

    @Autowired
    private MensagemService mensagemService;

    @PostMapping
    public ResponseEntity<String> enviarMensagem(@RequestBody String mensagem) {
        this.mensagemService.sendMessage(mensagem);
        return ResponseEntity.ok().body("Mensagem enviada com sucesso: " + mensagem);
    }

}
