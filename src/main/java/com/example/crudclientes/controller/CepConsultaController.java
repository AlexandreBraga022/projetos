package com.example.crudclientes.controller;

import com.example.crudclientes.model.Endereco;
import com.example.crudclientes.service.CepService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/cep")
public class CepConsultaController {

    private final CepService cepService;

    public CepConsultaController(CepService cepService) {
        this.cepService = cepService;
    }


    @GetMapping("/{cep}")
    public Endereco consultarCep(@PathVariable String cep) {

        return cepService.buscarEnderecoPorCep(cep);
    }
}