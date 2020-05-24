package com.uca.capas.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Contribuyente;

public interface ContribuyenteDAO {
	
	public void insert(Contribuyente contribuyente) throws DataAccessException;
	
	public List<Contribuyente> findAll() throws DataAccessException;

}
