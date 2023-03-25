package com.owl.report.controller;

import com.owl.report.dto.ClientDto;
import com.owl.report.model.Client;
import com.owl.report.service.ClientService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@RestController
@RequestMapping("/api/v1/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping
    public ResponseEntity<ClientDto> saveClient(@RequestBody ClientDto clientDto) {
        this.clientService.save(clientDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(clientDto);
    }

    @GetMapping
    public ResponseEntity<List<Client>> getClients() {
        return ResponseEntity.ok(this.clientService.getClient());
    }

    @GetMapping("/report")
    public ResponseEntity<byte[]> getReport(HttpServletResponse response) throws Exception {
        return ResponseEntity.ok(this.clientService.exportPDF());
    }
}
