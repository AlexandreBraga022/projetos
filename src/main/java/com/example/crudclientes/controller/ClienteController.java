package com.example.crudclientes.controller;

import com.example.crudclientes.model.Cliente;
import com.example.crudclientes.service.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/clientes")
public class ClienteController {


    private final ClienteService clienteService;


    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }


    @GetMapping
    public String listarClientes(Model model) {
        model.addAttribute("clientes", clienteService.listarTodos());
        return "clientes/lista";
    }


    @GetMapping("/novo")
    public String exibirFormCadastro(Cliente cliente) {
        return "clientes/form-cliente";
    }


    @PostMapping("/salvar")
    public String salvarCliente(@Valid Cliente cliente, BindingResult result, RedirectAttributes attributes) {

        if (result.hasErrors()) {
            return "clientes/form-cliente";
        }


        clienteService.salvar(cliente);

        attributes.addFlashAttribute("mensagem", "Cliente salvo com sucesso!");
        return "redirect:/clientes";
    }


    @GetMapping("/editar/{id}")
    public String exibirFormEdicao(@PathVariable("id") Long id, Model model) {


        Cliente cliente = clienteService.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("ID de Cliente inválido:" + id));

        model.addAttribute("cliente", cliente);

        return "clientes/form-cliente";
    }


    @PostMapping("/atualizar/{id}")
    public String atualizarCliente(@PathVariable("id") Long id, @Valid Cliente cliente, BindingResult result, RedirectAttributes attributes) {

        if (result.hasErrors()) {

            cliente.setId(id);
            return "clientes/form-cliente";
        }


        clienteService.salvar(cliente);

        attributes.addFlashAttribute("mensagem", "Cliente atualizado com sucesso!");
        return "redirect:/clientes";
    }


    @GetMapping("/excluir/{id}")
    public String excluirCliente(@PathVariable("id") Long id, RedirectAttributes attributes) {


        clienteService.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("ID de Cliente inválido:" + id));


        clienteService.excluir(id);

        attributes.addFlashAttribute("mensagem", "Cliente excluído com sucesso!");
        return "redirect:/clientes";
    }
}