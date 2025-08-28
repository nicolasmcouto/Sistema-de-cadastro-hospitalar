package Estudo.Domain.DTOs;

import java.util.List;

public record PacienteResponseDTO(Long id, String nome, List<ContatosDeEmergenciaDTO> contatosDeEmergenciaDTOList) {
}
