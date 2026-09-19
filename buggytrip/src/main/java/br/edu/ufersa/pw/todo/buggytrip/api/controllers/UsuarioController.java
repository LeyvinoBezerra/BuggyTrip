package br.edu.ufersa.pw.todo.buggytrip.api.controllers;

import br.edu.ufersa.pw.todo.buggytrip.api.dtos.PerfilPutResponse;
import br.edu.ufersa.pw.todo.buggytrip.api.dtos.UsuarioDTO;
import br.edu.ufersa.pw.todo.buggytrip.domain.entities.Usuario;
import br.edu.ufersa.pw.todo.buggytrip.domain.mapper.PerfilMapper;
import br.edu.ufersa.pw.todo.buggytrip.domain.service.UsuarioService;
import br.edu.ufersa.pw.todo.buggytrip.api.dtos.UsuarioPatch;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(UsuarioController.API_V1_USUARIOS)
@AllArgsConstructor
@Log4j2
public class UsuarioController {

    public static final String API_V1_USUARIOS = "/api/v1/usuarios";
    private static final String SALVAR = "salvar";
    private static final String ATUALIZAR = "atualizar";
    private static final String EXCLUIR = "excluir";
    private static final String BUSCAR_POR_ID = "buscarPorId";
    private static final String LISTAR_TODOS = "listarTodos";

    private final UsuarioService usuarioService;
    private final UsuarioMapper usuarioMapper;

    @PostMapping(SALVAR)
    public ResponseEntity<UsuarioPostResponse> salvar(@RequestBody @Valid UsuarioPostRequest usuario) {
        log.info("Salvando usuário {}", usuario);

        var usuarioToSave = usuarioMapper.toUsuario(usuario);
        var usuarioSaved = usuarioService.salvar(usuarioToSave);
        var response = usuarioMapper.toUsuarioPostResponse(usuarioSaved);

        log.info("Usuário salvo com sucesso: {}", usuarioSaved);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping(ATUALIZAR)
    public ResponseEntity<UsuarioPutResponse> atualizar(@RequestBody @Valid UsuarioPutRequest usuario) {
        log.info("Atualizando usuário {}", usuario);

        var usuarioToUpdate = usuarioMapper.toUsuario(usuario);
        var usuarioUpdated = usuarioService.atualizar(usuarioToUpdate);
        var response = usuarioMapper.toUsuarioPutResponse(usuarioUpdated);

        log.info("Usuário atualizado com sucesso: {}", usuarioUpdated);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping(EXCLUIR)
    public ResponseEntity<Void> excluir(Long id) {
        log.info("Excluindo usuário {}", id);

        usuarioService.excluir(id);
        log.info("Usuário excluído com sucesso: {}", id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping(BUSCAR_POR_ID)
    public ResponseEntity<UsuarioGetResponse> findById(Long id) {
        log.info("Buscando usuário {}", id);

        var usuario = usuarioService.findById(id);
        var usuarioGetResponse = usuarioMapper.toUsuarioGetResponse(usuario);

        return ResponseEntity.ok(usuarioGetResponse);
    }

    @GetMapping(LISTAR_TODOS)
    public ResponseEntity<List<UsuarioGetResponse>> listarTodos() {
        log.info("Listando usuários");

        var usuarios = usuarioService.listarTodos();
        var response = usuarioMapper.toUsuarioGetResponseList(usuarios);

        log.info("Usuários listados com sucesso: {}", usuarios.size());
        return ResponseEntity.ok(response);
    }
}
