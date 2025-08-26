package Estudo.Service;


import Estudo.Domain.ContatosDeEmergencia;
import Estudo.Domain.DTOs.ContatosDeEmergenciaDTO;
import Estudo.Domain.DTOs.PacienteCadastroDTO;
import Estudo.Domain.PacienteEntity;
import Estudo.Domain.Repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacientService {

    @Autowired
    PacienteRepository repository;

    public void cadastroDePaciente(PacienteCadastroDTO dto){
        PacienteEntity paciente = new PacienteEntity();
        paciente.setNome(dto.nome());
        List<ContatosDeEmergencia> contatos = dto.contatosDeEmergencia().stream()
                .map(c -> new ContatosDeEmergencia(c.getName(), paciente, c.getContato()))
                .toList();
        paciente.setContato(contatos);

        repository.save(paciente);
    }
}
