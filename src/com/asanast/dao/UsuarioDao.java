package com.asanast.dao;

import java.util.List;

import com.asanast.pojo.Usuario;

public interface UsuarioDao {
	
	public Usuario findByUsername(String username);

	public void save(Usuario usuario);

	public List<Usuario> findAll();

}
