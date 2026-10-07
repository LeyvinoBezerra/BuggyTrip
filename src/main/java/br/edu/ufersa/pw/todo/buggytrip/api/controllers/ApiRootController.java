package br.edu.ufersa.pw.todo.buggytrip.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ApiRootController {
    @GetMapping("/")
    public Map<String, String> index() {
        return Map.of(
                "name", "BuggyTrip API",
                "docs", "/swagger-ui.html",
                "openapi", "/v3/api-docs"
        );
    }
}
