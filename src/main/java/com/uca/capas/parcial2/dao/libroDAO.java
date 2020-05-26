package com.uca.capas.parcial2.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.parcial2.domain.libro;

public interface libroDAO {
	public List<libro> findAll() throws DataAccessException;
	
	public void insert(libro libro) throws DataAccessException;
}
