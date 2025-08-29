package Estudo;

import Estudo.Domain.ContatosDeEmergencia;
import Estudo.Domain.PacienteEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CadastroDePacienteApplicationTests {

	@Test
	void TestandoRequisicaoDeCadastroDePaciente() {


			ContatosDeEmergencia contato1 = new ContatosDeEmergencia("Gabriel", null, 123456789);
			ContatosDeEmergencia contato2 = new ContatosDeEmergencia("Maria", null, 987654321);

			List<ContatosDeEmergencia> contatos = List.of(contato1, contato2);


			PacienteEntity paciente = new PacienteEntity("João", contatos);


			contatos.forEach(c -> c.setPaciente(paciente));

			assert paciente.getNome().equals("João");
			assert paciente.getContato().size() == 2;
			assert paciente.getContato().get(0).getPaciente() == paciente;
		}

	}



