package Estudo.Service;


import Estudo.Domain.ContatosDeEmergencia;
import Estudo.Domain.DTOs.ContatosDeEmergenciaDTO;
import Estudo.Domain.DTOs.PacienteCadastroDTO;
import Estudo.Domain.DTOs.PacienteResponseDTO;
import Estudo.Domain.PacienteEntity;
import Estudo.Domain.Repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;



@Service
public class PacientService {

    @Autowired
    PacienteRepository repository;

    public PacienteResponseDTO cadastroDePaciente(PacienteCadastroDTO dto){
        PacienteEntity paciente = new PacienteEntity();
        paciente.setNome(dto.nome());
        List<ContatosDeEmergencia> contatos = dto.contatosDeEmergencia().stream()
                .map(c -> new ContatosDeEmergencia(c.nome(), paciente, c.contato()))
                .toList();
        paciente.setContato(contatos);

        var salvo = repository.save(paciente);

        return new PacienteResponseDTO(salvo.getId(), salvo.getNome(), salvo.getContato().stream()
                .map(c -> new ContatosDeEmergenciaDTO(c.getName(), c.getContato()))
                .toList());
    }
    public PacienteResponseDTO buscaPorNome(String nome){
        return repository.findByNomeStartingWithIgnoreCasa(nome)
                .stream().map(p -> new PacienteResponseDTO(
                        p.getId(),
                        p.getNome(),
                        p.getContato().stream().map((contatosDeEmergencia -> new ContatosDeEmergenciaDTO(contatosDeEmergencia.getName(), contatosDeEmergencia.getContato())))
                        .toList()
                )).toList();

    }

}
