package com.gestion.empleados.controlador;

import java.awt.Color;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.empleados.excepciones.ResourceNotFoundException;
import com.gestion.empleados.modelo.Persona;
import com.gestion.empleados.modelo.Test;
import com.gestion.empleados.reporte.Reporte;
import com.gestion.empleados.repositorio.PacienteRepository;
import com.gestion.empleados.repositorio.PersonaRepositorio;
import com.gestion.empleados.repositorio.TestsRepositorio;
import com.gestion.empleados.servicio.PersonaServicio;
import com.gestion.empleados.servicio.UserService;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@RestController
@RequestMapping("/api/v1/")
//@CrossOrigin(origins = "http://localhost:4200")

@CrossOrigin(origins = "https://comfy-cocada-808077.netlify.app")
@Service
public class PersonaControlador {

	@Autowired
	private PersonaRepositorio repositorio;
	private PersonaServicio personaServicio;
	private PacienteRepository personarepositorio;

	// este metodo sirve para listar todas las personas
	// @GetMapping("/personas")
	// public List<Persona> listarTodosLosEmpleados() {
	// return repositorio.findAll();
	// }

	// este metodo es para validar el login

	// este metodo sirve para guardar la persona

	@PostMapping("/personas")
	public Persona guardarPersona(@RequestBody Persona persona) {
		return repositorio.save(persona);
	}

	// este metodo sirve para buscar una persona
	@GetMapping("/personas/{id}")
	@PreAuthorize("hasAnyRole('Administrador', 'Paciente', 'Psicologo')")

	public ResponseEntity<Persona> obtenerPersonaPorId(@PathVariable Long id) {
		Persona persona = repositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No existe la persona con el ID : " + id));
		return ResponseEntity.ok(persona);
	}

	// este metodo sirve para actualizar Persona
	@PutMapping("/personas/{id}")
	@PreAuthorize("hasAnyRole('Administrador', 'Paciente', 'Psicologo')")

	public ResponseEntity<Persona> actualizarPersona(@PathVariable Long id, @RequestBody Persona detallesPersona) {
		Persona persona = repositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No existe la persona con el ID : " + id));

		persona.setName(detallesPersona.getName());
		persona.setUsername(detallesPersona.getUsername());
		persona.setEmail(detallesPersona.getEmail());
		persona.setPassword(detallesPersona.getPassword());
		persona.setTipousuario(detallesPersona.getTipousuario());

		Persona personaActualizada = repositorio.save(persona);
		return ResponseEntity.ok(personaActualizada);
	}

	// este metodo sirve para eliminar una persona
	@DeleteMapping("/personas/{id}")
	@PreAuthorize("hasAnyRole('Administrador', 'Psicologo')")
	public ResponseEntity<Map<String, Boolean>> eliminarPersona(@PathVariable Long id) {
		Persona persona = repositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No existe la persona con el ID : " + id));

		repositorio.delete(persona);
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminar", Boolean.TRUE);
		return ResponseEntity.ok(respuesta);
	}

	// este metodo sirve para buscar por Tipo de usuario
	// @GetMapping("/personas/{tipousuario}")
	// public ResponseEntity<Persona> obtenerPersonaPorTipoUser(@PathVariable String
	// tipousuario) {
	// Persona persona = repositorio.findByTipousuario(tipousuario)
	// .orElseThrow(() -> new ResourceNotFoundException("No existe la persona con el
	// ID : " + tipousuario));
	// return ResponseEntity.ok(persona);
	// }

	////

	// @GetMapping("/personas")
	// public List<Persona> listarTodosLosPacientes(Model model) {
	// return repositorio.findByTipousuario("Paciente");
	// }

	@GetMapping("/personas")
	@PreAuthorize("hasAnyRole('Administrador', 'Psicologo')")
	public List<Persona> getPaciente() {
		return repositorio.findByTipousuario("Paciente");
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('Administrador')")
	public List<Persona> getAdmin() {
		return repositorio.findByTipousuario("Administrador");
	}

	@GetMapping("/psicologo")
	@PreAuthorize("hasRole('Administrador')")

	public List<Persona> getPsicologo() {
		return repositorio.findByTipousuario("Psicologo");
	}
	

	@GetMapping("/exportarPDF")

	public void exportarListadoDeEmpleadosEnPDF(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/pdf");

		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String fechaActual = dateFormatter.format(new Date());

		String cabecera = "Content-Disposition";
		String valor = "attachment; filename=Pacientes_" + fechaActual + ".pdf";

		response.setHeader(cabecera, valor);

		List<Persona> pacientes = repositorio.findByTipousuario("Paciente");

		Reporte exporter = new Reporte(pacientes);
		exporter.exportar(response);
	}

	@GetMapping("/exportarpsicologoPDF")
	public void exportarListadoDePsicologoEnPDF(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/pdf");

		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String fechaActual = dateFormatter.format(new Date());

		String cabecera = "Content-Disposition";
		String valor = "attachment; filename=Psicologos_" + fechaActual + ".pdf";

		response.setHeader(cabecera, valor);

		List<Persona> psicologo = repositorio.findByTipousuario("Psicologo");

		Reporte exporter = new Reporte(psicologo);
		exporter.exportarpsicologo(response);
	}

	@GetMapping("/exportaradminPDF")

	public void exportarListadoDeAdminEnPDF(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/pdf");

		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String fechaActual = dateFormatter.format(new Date());

		String cabecera = "Content-Disposition";
		String valor = "attachment; filename=Administradores_" + fechaActual + ".pdf";

		response.setHeader(cabecera, valor);

		List<Persona> psicologo = repositorio.findByTipousuario("Administrador");

		Reporte exporter = new Reporte(psicologo);
		exporter.exportadmin(response);
	}

	@GetMapping("/contadortotaluser")
	public ResponseEntity<Long> countpersonas() {
		Long countpersonas = repositorio.count();
		return ResponseEntity.ok(countpersonas);
	}

	@GetMapping("/contadortotalpaciente")
	@PreAuthorize("hasAnyRole('Administrador', 'Psicologo')")
	public int totalpaciente() {
		List<Persona> users = repositorio.findByTipousuario("Paciente");
		int numRows = users.size();
		return numRows;
	}

	@GetMapping("/contadortotalpsicolo")
	@PreAuthorize("hasRole('Administrador')")
	public int totalpsicologo() {
		List<Persona> users = repositorio.findByTipousuario("Psicologo");
		int numRows = users.size();
		return numRows;
	}

	@GetMapping("/contadortotaladmin")
	@PreAuthorize("hasRole('Administrador')")
	public int totaladmin() {
		List<Persona> users = repositorio.findByTipousuario("Administrador");
		int numRows = users.size();
		return numRows;
	}

	@Autowired
	private UserService userService;

	@PostMapping({ "/registerNewUser" })
	public Persona registerNewUser(@RequestBody Persona user) {
		return userService.registerNewUser(user);
	}

	// ROLES

	@GetMapping({ "/forAdmin" })
	@PreAuthorize("hasRole('Administrador')")

	public String forAdmin() {
		return "Esta URL solo es accesible para el administrador";
	}

	@GetMapping("/forPaciente")
	@PreAuthorize("hasRole('Paciente')")
	public String forPaciente() {
		return "Esta URL solo es accesible para el paciente";
	}
	
	@GetMapping("/forPsicologo")
    @PreAuthorize("hasRole('Psicologo')")

	public String forPsicologo() {
		return "Esta URL solo es accesible para el psicologo";
	}
	

}
