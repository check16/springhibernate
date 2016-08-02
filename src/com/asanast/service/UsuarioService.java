package com.asanast.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.asanast.dao.UsuarioDao;
import com.asanast.pojo.Usuario;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioDao usuarioDao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public void save(Usuario usuario) {
		usuario.setFechaCreacion(new Timestamp(new Date().getTime()));
		String claveUsr = usuario.getClave();
		usuario.setClave(passwordEncoder.encode(claveUsr));
		usuarioDao.save(usuario);
	}

	public List<Usuario> findAll() {
		return usuarioDao.findAll();
	}

}
