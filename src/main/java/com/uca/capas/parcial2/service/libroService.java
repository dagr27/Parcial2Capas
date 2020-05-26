package com.uca.capas.parcial2.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.parcial2.domain.libro;

public interface libroService {
	public List<libro> findAll() throws DataAccessException;
	
	public void insert(libro libro) throws DataAccessException;
}
