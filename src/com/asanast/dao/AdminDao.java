package com.asanast.dao;

import java.util.List;

import com.asanast.pojo.Admin;


public interface AdminDao {
	
	public void save(Admin admin);
	public List<Admin> findAll();
	public Admin findById(int id);
	public List<Admin> findByNombre(String nombre);
	public void update(Admin admin);
	public void delete(Admin admin);	

}
