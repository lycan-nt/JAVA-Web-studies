package com.digitalinnovationone.restfull.controller;

import com.digitalinnovationone.restfull.controller.request.SoldadoEditRequest;
import com.digitalinnovationone.restfull.dto.Soldado;
import com.digitalinnovationone.restfull.service.SoldadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/soldado")
public class SoldadoController {

    private SoldadoService soldadoService;

    public SoldadoController(SoldadoService soldadoService) {
        this.soldadoService = soldadoService;
    }

    @GetMapping("")
    public ResponseEntity<List<Soldado>> buscarSoldados() {
        List<Soldado> soldadoList = soldadoService.buscarSoldados();
        return ResponseEntity.status(HttpStatus.OK).body(soldadoList);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Soldado> buscarSoldado(@PathVariable() String cpf) {
        Soldado soldado = soldadoService.buscarSoldado(cpf);
        return ResponseEntity.status(HttpStatus.OK).body(soldado);
    }

    @PostMapping("")
    public ResponseEntity criarSoldado(@RequestBody Soldado soldado) {
        soldadoService.criarSoldado(soldado);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{cpf}")
    public ResponseEntity editarSoldado(@PathVariable() String cpf,
                                        @RequestBody SoldadoEditRequest soldadoEditRequest) {
        soldadoService.editarSoldado(cpf, soldadoEditRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity deletarSoldado(@PathVariable String cpf) {
        soldadoService.deletarSoldado(cpf);
        return ResponseEntity.ok().build();
    }

}
