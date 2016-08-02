package com.asanast.dao;

import java.util.List;

import com.asanast.pojo.Admin;
import com.asanast.pojo.Direccion;

public interface DireccionDao {
	
	public void save(Direccion direccion);
	public List<Direccion> findAll(Admin admin);
	public Direccion findById(int idDireccion);
	public void update(Direccion direccion);
	public void delete(Direccion direccion);

}
