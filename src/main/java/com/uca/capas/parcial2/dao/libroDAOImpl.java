package com.uca.capas.parcial2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.parcial2.domain.libro;

@Repository
public class libroDAOImpl implements libroDAO {
	@PersistenceContext(unitName="capas")
	private EntityManager entityManager;
	
	@Override
	public List<libro> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * FROM public.cat_libro");
		Query query = entityManager.createNativeQuery(sb.toString(), libro.class);
		List<libro> resultset= query.getResultList();
		return resultset;
	}

	@Override
	@Transactional
	public void insert(libro libro) throws DataAccessException {
		entityManager.persist(libro);
		
	}

}
