package br.edu.ufersa.pw.todo.buggytrip.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/testes")
public class TodoController {
    @GetMapping()
        public String testar(){
        return "Primeiro endpoint criado!!";
    }
    }

