package com.uca.capas.parcial2.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.parcial2.domain.categoria;



public interface categoriaDAO {
	
	public List<categoria> findAll() throws DataAccessException;
	
	public void insert(categoria cat) throws DataAccessException;
}
