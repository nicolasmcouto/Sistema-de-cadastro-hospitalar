package Estudo.Domain.DTOs;

import Estudo.Domain.ContatosDeEmergencia;

import java.util.List;

public record PacienteCadastroDTO (String name, List<ContatosDeEmergencia> contatosDeEmergencias){
}
