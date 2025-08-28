package Estudo.Domain.Repository;

import Estudo.Domain.PacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface PacienteRepository extends JpaRepository <PacienteEntity, Long> {

    List<PacienteEntity> findByNomeStartingWithIgnoreCasa(String nome);


}
