package Estudo.Controller;

import Estudo.Domain.DTOs.PacienteCadastroDTO;
import Estudo.Domain.PacienteEntity;
import Estudo.Service.PacientService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    @Autowired
    private PacientService service;

    @PostMapping("cadastro")
    @Transactional
    public ResponseEntity<PacienteEntity> CadastroDePaciente(@RequestBody PacienteCadastroDTO dados) {
        var paciente = new PacienteEntity(dados.name(),dados.contatosDeEmergencias());
        service.cadastroDePaciente(dados);
        return ResponseEntity.ok(paciente);
    }



}
