package Estudo.Domain.Repository;

import Estudo.Domain.ContatosDeEmergencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoDeEmergenciaRepository extends JpaRepository<ContatosDeEmergencia, Long> {
}
