package br.edu.ufersa.pw.todo.buggytrip.api.controllers;
/*import com.buggytrip.model.Usuario;
import com.buggytrip.service.UsuarioService;
import org.springframework.web.bind.annotation.*;
*/

import org.springframework.web.bind.annotation.*;

import java.util.List;

public class UsuarioController {
    @RestController
    @RequestMapping("/usuarios")
    public class UsuarioController {
        private final UsuarioService service;

        public UsuarioController(UsuarioService service) {
            this.service = service;
        }

        @GetMapping
        public List<Usuario> listar() {
            return service.listar();
        }

        @PostMapping
        public Usuario salvar(@RequestBody Usuario usuario) {
            return service.salvar(usuario);
        }
    }
}
