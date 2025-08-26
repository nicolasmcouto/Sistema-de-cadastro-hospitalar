package Estudo.Service;

import Estudo.Domain.ContatosDeEmergencia;
import Estudo.Domain.DTOs.PacienteCadastroDTO;
import Estudo.Domain.PacienteEntity;
import Estudo.Domain.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class PacientService {

    @Autowired
    PacienteRepository repository;

    public void cadastroDePaciente(PacienteCadastroDTO dto){
        PacienteEntity paciente = new PacienteEntity(dto.name(),  dto.contatosDeEmergencias());

            repository.save(paciente);
    }
}
