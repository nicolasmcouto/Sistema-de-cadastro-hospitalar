package Estudo.Domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ContatosDeEmergencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String name;

    @NotNull
   private double contato;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private PacienteEntity paciente;

    public ContatosDeEmergencia(String name, PacienteEntity paciente , double contato) {
        this.name = name;
        this.paciente = paciente;
        this.contato = contato;
    }


    public void setId(long id) {this.id = id;}
    public void setPaciente(PacienteEntity paciente) {this.paciente = paciente;}
    public void setContato(double contato) {this.contato = contato;}
    public void setName(String name) {this.name = name;}
    public String getName() {return name;}
    public double getContato() {return contato;}
    public PacienteEntity getPaciente() {return paciente;}
    public long getId() {return id;}
}
