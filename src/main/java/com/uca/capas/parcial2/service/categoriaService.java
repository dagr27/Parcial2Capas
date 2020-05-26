package com.uca.capas.parcial2.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.parcial2.domain.categoria;

public interface categoriaService {
	public List<categoria> findAll() throws DataAccessException;
	
	public void insert(categoria cat) throws DataAccessException;
}
