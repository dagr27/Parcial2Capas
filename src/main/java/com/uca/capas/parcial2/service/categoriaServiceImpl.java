package com.uca.capas.parcial2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.parcial2.dao.categoriaDAO;
import com.uca.capas.parcial2.domain.categoria;

@Service
public class categoriaServiceImpl implements categoriaService{
	@Autowired
	private categoriaDAO categoriaDao;
	
	@Override
	public List<categoria> findAll() throws DataAccessException {
		return categoriaDao.findAll();
	}

	@Override
	public void insert(categoria cat) throws DataAccessException {
		categoriaDao.insert(cat);
		
	}

}
