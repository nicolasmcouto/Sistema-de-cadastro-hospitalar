package Estudo.Domain.DTOs;

import java.util.List;

public record PacienteAtualizacaoDTO(String nome, List<ContatosDeEmergenciaDTO> contatosDeEmergencia) {
}
