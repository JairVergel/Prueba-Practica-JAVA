package com.springboot2.pruebajairvergeljpacruudapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot2.pruebajairvergeljpacruudapp.exception.ResourceNotFoundException;
import com.springboot2.pruebajairvergeljpacruudapp.model.Usuario;
import com.springboot2.pruebajairvergeljpacruudapp.repository.UsuarioRepository;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping("/{procesado}")
	public ResponseEntity<List<Usuario>> buscarUsuarios(@PathVariable(value = "procesado") int procesado)
			throws ResourceNotFoundException {
		List<Usuario> usuarios = null;
		
			usuarios = usuarioRepository.findByProcesado(procesado);
		if(usuarios.isEmpty())
			throw new ResourceNotFoundException("No existen usuarios" + (procesado ==0 ?"No Procesados":"Procesados"));

		return ResponseEntity.ok().body(usuarios);
	}

	@PostMapping("/insertar")
	public Usuario createUsuario(@Valid @RequestBody Usuario Usuario) {
		return usuarioRepository.save(Usuario);
	}

	@PutMapping("/procesar")
	public void procesarUsuario(
		@Valid @RequestBody List<Usuario> usuarioProcesar) throws ResourceNotFoundException {
		for(Usuario us:usuarioProcesar){
			us.setProcesado(1);
			usuarioRepository.save(us);
		}

	}

	
}
