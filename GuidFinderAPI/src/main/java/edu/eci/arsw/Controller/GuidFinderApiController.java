package edu.eci.arsw.Controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.management.relation.RelationNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import edu.eci.arsw.Model.UiRequest;
import edu.eci.arsw.Persistence.PersistenceException;
import edu.eci.arsw.Services.GuidFinderServices;


@RestController
@RequestMapping(value = "/uuid")
public class GuidFinderApiController {
	@Autowired
	GuidFinderServices gServices;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getAll() throws RelationNotFoundException {
		try {
			// obtener datos que se enviarán a través del API
			return new ResponseEntity<>(gServices.getAll(), HttpStatus.ACCEPTED);
		} catch (Exception ex) {
			Logger.getLogger(GuidFinderApiController.class.getName()).log(Level.SEVERE, null, ex);
			return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping
	public ResponseEntity<?> consult(@RequestBody UiRequest uuid) throws PersistenceException {
		try {
			return new ResponseEntity<>(gServices.consult(uuid), HttpStatus.CREATED);

		} catch (ExceptionInInitializerError ex) {
			
			return new ResponseEntity<>("No se encontró el recurso solicitado", HttpStatus.NOT_FOUND);
		}
	}

}
