package com.gestion.empleados.controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.empleados.excepciones.ResourceNotFoundException;
import com.gestion.empleados.modelo.Test;
import com.gestion.empleados.repositorio.TestsRepositorio;

@RestController
@RequestMapping("/api/v3/")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://comfy-cocada-808077.netlify.app")

public class TestControlador {
	@Autowired
	private TestsRepositorio testrepo;

	// este metodo sirve para listar todas los tests
	@GetMapping("/tests")
	@PreAuthorize("hasRole('Paciente')")
	public List<Test> listarTodosLosTests() {
		return testrepo.findAll();
	}

	// este metodo sirve para guardar los test
	@PostMapping("/tests")
	@PreAuthorize("hasRole('Paciente')")
	public Test guardarTest(@RequestBody Test test) {
		return testrepo.save(test);
	}

	// este metodo sirve para buscar un test
	@GetMapping("/tests/{id}")
	@PreAuthorize("hasRole('Paciente')")

	public ResponseEntity<Test> obtenerTestsPorId(@PathVariable Long id) {
		Test test = testrepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No existe la persona con el ID : " + id));
		return ResponseEntity.ok(test);
	}

	// este metodo sirve para actualizar un test
	@PutMapping("/tests/{id}")
	@PreAuthorize("hasRole('Paciente')")

	public ResponseEntity<Test> actualizarTest(@PathVariable Long id, @RequestBody Test detallesTest) {
		Test test = testrepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No existe la persona con el ID : " + id));

		test.setPregunta1(detallesTest.getPregunta1());
		test.setOpcion1(detallesTest.getOpcion1());
		test.setUsuario(detallesTest.getUsuario());
		test.setTipotest(detallesTest.getTipotest());

		Test testActualizada = testrepo.save(test);
		return ResponseEntity.ok(testActualizada);
	}

	// este metodo sirve para eliminar un test
	@DeleteMapping("/tests/{id}")
	@PreAuthorize("hasRole('Paciente')")

	public ResponseEntity<Map<String, Boolean>> eliminarTest(@PathVariable Long id) {
		Test test = testrepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No existe la persona con el ID : " + id));

		testrepo.delete(test);
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminar", Boolean.TRUE);
		return ResponseEntity.ok(respuesta);
	}
}