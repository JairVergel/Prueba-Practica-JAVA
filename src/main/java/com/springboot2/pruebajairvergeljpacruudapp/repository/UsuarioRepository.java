package com.springboot2.pruebajairvergeljpacruudapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot2.pruebajairvergeljpacruudapp.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	List<Usuario> findByProcesado(int procesado);
}
