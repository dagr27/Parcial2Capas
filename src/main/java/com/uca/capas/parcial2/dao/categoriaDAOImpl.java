package com.uca.capas.parcial2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.parcial2.domain.categoria;

@Repository
public class categoriaDAOImpl implements categoriaDAO {
	@PersistenceContext(unitName="capas")
	private EntityManager entityManager;

	@Override
	public List<categoria> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * FROM public.cat_categoria");
		Query query = entityManager.createNativeQuery(sb.toString(), categoria.class);
		List<categoria> resultset= query.getResultList();
		return resultset;
	}

	@Override
	@Transactional
	public void insert(categoria cat) throws DataAccessException {
		entityManager.persist(cat);
		
	}
}
