package Estudo.Controller;


import Estudo.Domain.DTOs.PacienteAtualizacaoDTO;
import Estudo.Domain.DTOs.PacienteCadastroDTO;
import Estudo.Domain.DTOs.PacienteResponseDTO;
import Estudo.Domain.Repository.PacienteRepository;
import Estudo.Service.PacientService;
import jakarta.transaction.Transactional;
import org.aspectj.apache.bcel.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    @Autowired
    private PacientService service;

    @Autowired
    private PacienteRepository repository;

    @PostMapping("cadastro")
    @Transactional
    public ResponseEntity<PacienteResponseDTO> CadastroDePaciente(@RequestBody PacienteCadastroDTO dados) {
       var response = service.cadastroDePaciente(dados);
        return ResponseEntity.ok(response);
    }


    @GetMapping("listagem")
    public ResponseEntity<List<PacienteResponseDTO>>ListagemDePacientes(@RequestParam String nome){

        var pacientes =  service.buscaPorNome(nome);
        return ResponseEntity.ok(pacientes);
    }
    @PutMapping("{id}")
    @Transactional
    public  ResponseEntity<PacienteResponseDTO>AtualizacaoDeCadastro(@PathVariable Long id, @RequestBody PacienteAtualizacaoDTO dto){
        var response = service.atualizacaoDeCadastro(id, dto);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity DeletarUsuario(@PathVariable Long id){
        repository.deleteAllById(Collections.singleton(id));
        return ResponseEntity.noContent().build();

    }



}
