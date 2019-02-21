package curso.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import curso.modelo.entidades.GrupoOperaciones;
import curso.modelo.entidades.Operacion;
import curso.modelo.negocio.GestorOperaciones;

@RestController
public class ControladorOperaciones {
	
	@Autowired
	private GestorOperaciones gestorOperaciones;
	
	// http://localhost:8080/operaciones
	@PostMapping(path="operaciones",
				 consumes= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
				 produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Operacion> insertar(@RequestBody Operacion operacion) {
		try {
			gestorOperaciones.insertarOperacion(operacion);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(operacion, HttpStatus.BAD_REQUEST);
		}
	}
	
	// http://localhost:8080/operaciones?tipoOperacion=suma
	@GetMapping(path="operaciones",
				produces={MediaType.APPLICATION_JSON_VALUE, 
						MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<GrupoOperaciones> listar(
			@RequestParam(name="tipoOperacion", required=false) String tipoOperacion) 
	{			
		GrupoOperaciones operaciones = new GrupoOperaciones();
		if(tipoOperacion != null) {
			operaciones.setListaOperaciones(gestorOperaciones.getListaOperacionesPorTipo(tipoOperacion));
		} else {
			operaciones.setListaOperaciones(gestorOperaciones.getListaOperaciones());
		}
		return new ResponseEntity<>(operaciones, HttpStatus.OK);
	}

	@PutMapping(path="operaciones/{id}")
	public ResponseEntity<Operacion> modificar(
			@RequestBody Operacion operacion,
			@PathVariable Integer id) 
	{
		try {
			operacion.setId(id);
			gestorOperaciones.modificarOperacion(operacion);
			return new ResponseEntity<>(operacion, HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(operacion, HttpStatus.BAD_REQUEST);
		}
	}
	
	// http://localhost:8080/operaciones?id=1
	@DeleteMapping(path="operaciones")
	public ResponseEntity<Operacion> eliminar(@RequestParam(name="id", required=true) Integer id) {
		Operacion operacion = new Operacion();
		operacion.setId(id);
		gestorOperaciones.eliminarOperacion(operacion);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
}
