package com.asanast.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asanast.dao.AdminDao;
import com.asanast.dao.DireccionDao;
import com.asanast.pojo.Admin;
import com.asanast.pojo.Direccion;

@Service
public class DireccionService {

	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private DireccionDao direccionDao;

	public void save(Admin admin, Direccion direccion) {
		direccion.setAdmin(admin);
		direccionDao.save(direccion);
		
	}

	public List<Direccion> findAll(int idAd) {
		Admin admin = adminDao.findById(idAd);
		return direccionDao.findAll(admin);
	}

	public Direccion findById(int idDir) {
		Direccion direccion = direccionDao.findById(idDir);
		return direccion;
	}

	public void saveOrUpdate(Admin admin, Direccion direccion) {
		if (direccion.getIdDireccion() == 0) {
			direccion.setAdmin(admin);
			direccionDao.save(direccion);
		} else {
			direccion.setAdmin(admin);
			direccionDao.update(direccion);
		}
	}
	
	public void delete(int idDireccion) {
		Direccion direccion = direccionDao.findById(idDireccion);
		direccionDao.delete(direccion);
	}

}
