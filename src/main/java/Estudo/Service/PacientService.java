package Estudo.Service;


import Estudo.Domain.ContatosDeEmergencia;
import Estudo.Domain.DTOs.ContatosDeEmergenciaDTO;
import Estudo.Domain.DTOs.PacienteAtualizacaoDTO;
import Estudo.Domain.DTOs.PacienteCadastroDTO;
import Estudo.Domain.DTOs.PacienteResponseDTO;
import Estudo.Domain.PacienteEntity;
import Estudo.Domain.Repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.unmodifiableList;


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
    public List<PacienteResponseDTO> buscaPorNome(String nome){
        return repository.findByNomeStartingWithIgnoreCase(nome)
                .stream().map(p -> new PacienteResponseDTO(
                        p.getId(),
                        p.getNome(),
                        p.getContato().stream().map((contatosDeEmergencia -> new ContatosDeEmergenciaDTO(contatosDeEmergencia.getName(), contatosDeEmergencia.getContato())))
                        .toList()
                )).toList();
    }
    public PacienteResponseDTO atualizacaoDeCadastro(Long id, PacienteAtualizacaoDTO dto) {

        var paciente = repository.getReferenceById(id);

        if (dto.nome() != null) {
            paciente.setNome(dto.nome());

        }
        if (dto.contatosDeEmergencia() != null) {

            var contatosAtuais = paciente.getContato();
            var contatosNovos = new ArrayList<>(dto.contatosDeEmergencia()
                    .stream()
                    .map(c -> new ContatosDeEmergencia(c.nome(), paciente, c.contato()))
                    .toList());

            contatosAtuais.clear();

            paciente.setContato(contatosNovos);

        }
        var salvo = repository.save(paciente);

        return new PacienteResponseDTO(salvo.getId(), salvo.getNome(), salvo.getContato().stream().map(c -> new ContatosDeEmergenciaDTO(c.getName(), c.getContato())).toList());


    }

}
