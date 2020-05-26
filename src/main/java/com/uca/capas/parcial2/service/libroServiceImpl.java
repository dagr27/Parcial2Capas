package com.uca.capas.parcial2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.parcial2.dao.libroDAO;
import com.uca.capas.parcial2.domain.libro;

@Service
public class libroServiceImpl implements libroService {
	@Autowired
	private libroDAO libroDao;
	
	@Override
	public List<libro> findAll() throws DataAccessException {
		return libroDao.findAll();
	}

	@Override
	public void insert(libro libro) throws DataAccessException {
		libroDao.insert(libro);
		
	}

}
