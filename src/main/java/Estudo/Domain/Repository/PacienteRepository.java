package Estudo.Domain.Repository;

import Estudo.Domain.PacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository <PacienteEntity, Long> {
}
