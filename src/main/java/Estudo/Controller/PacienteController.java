package Estudo.Controller;

import Estudo.Domain.DTOs.ContatosDeEmergenciaDTO;
import Estudo.Domain.DTOs.PacienteCadastroDTO;
import Estudo.Domain.DTOs.PacienteResponseDTO;
import Estudo.Domain.PacienteEntity;
import Estudo.Service.PacientService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    @Autowired
    private PacientService service;

    @PostMapping("cadastro")
    @Transactional
    public ResponseEntity<PacienteResponseDTO> CadastroDePaciente(@RequestBody PacienteCadastroDTO dados) {
       var response = service.cadastroDePaciente(dados);
        return ResponseEntity.ok(response);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<PacienteEntity> AtualizacaoDeCadastro(){

    }

    @GetMapping
    @Transactional
    public ResponseEntity<PacienteEntity> ListagemDePacientes(){

    }

    @DeleteMapping
    public ResponseEntity<PacienteEntity> excluir(){

    }



}
