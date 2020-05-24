package com.uca.capas.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.dao.ContribuyenteDAO;
import com.uca.capas.domain.Contribuyente;

@Service
public class ContribuyenteServiceImpl implements ContribuyenteService{
	
	@Autowired
	ContribuyenteDAO contribuyenteDAO;
	
	@Autowired
	ImportanciaService importanciaService;

	@Override
	@Transactional
	public void insert(Contribuyente contribuyente) throws DataAccessException {
		/*
		//Fecha
		Date date = new Date();  
	    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
	    String f_fecha_ingreso = formatter.format(date);
		contribuyente.setF_fecha_ingreso(f_fecha_ingreso);
		*/
		//Asignar la importancia
		//Al atributo importancia (c_importancia) se le pasa un entero obtenido por metodo findOne de ImportanciaService
		contribuyente.setImportancia(importanciaService.findOne(contribuyente.getC_importancia()));
		contribuyenteDAO.insert(contribuyente);
	}

	@Override
	public List<Contribuyente> findAll() throws DataAccessException {
		return contribuyenteDAO.findAll();
	}

}
