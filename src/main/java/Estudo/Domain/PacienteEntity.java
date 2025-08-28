package Estudo.Domain;

import Estudo.Domain.DTOs.ContatosDeEmergenciaDTO;
import jakarta.persistence.*;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Table(name = "pacientes")
@Entity(name = "Paciente")
@Getter
@EqualsAndHashCode(of = "id")
public class PacienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ContatosDeEmergencia>contato;


    public PacienteEntity(String name, List<ContatosDeEmergencia> contato) {
        this.nome = name;
        this.contato = contato;
    }

    public PacienteEntity() {

    }


    public Long getId() {return id;}
    public String getNome() {return nome;}
    public List<ContatosDeEmergencia> getContato() {return contato;}
    public void setId(Long id) {this.id = id;}
    public void setContato(List<ContatosDeEmergencia> contato) {this.contato = contato;}
    public void setNome(String nome) {this.nome = nome;}
}
