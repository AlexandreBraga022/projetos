package com.example.crudclientes.service;

import com.example.crudclientes.model.Endereco;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CepService {

    private final String BASE_URL = "https://viacep.com.br/ws/";
    private final RestTemplate restTemplate = new RestTemplate();

    public Endereco buscarEnderecoPorCep(String cep) {

        String cepLimpo = cep.replaceAll("[^0-9]", "");

        String url = BASE_URL + cepLimpo + "/json/";

        return restTemplate.getForObject(url, Endereco.class);
    }
}