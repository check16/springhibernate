package com.asanast.pojo;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.asanast.pojo.valid.PersistenceGroup;
import com.asanast.pojo.valid.SpringFormGroup;
import com.asanast.util.Constantes;

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsr;

	@NotEmpty(message=Constantes.NOT_EMPTY, groups={PersistenceGroup.class, SpringFormGroup.class})
	private String usuario;

	@NotEmpty(message=Constantes.NOT_EMPTY, groups={PersistenceGroup.class, SpringFormGroup.class})
	@Size(min=3, max=15, message=Constantes.SIZE, groups={SpringFormGroup.class})
	private String clave;

	@NotEmpty(message=Constantes.NOT_EMPTY, groups={PersistenceGroup.class, SpringFormGroup.class})
	private String permiso;

	private Timestamp fechaCreacion;

	public int getIdUsr() {
		return idUsr;
	}

	public void setIdUsr(int idUsr) {
		this.idUsr = idUsr;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getPermiso() {
		return permiso;
	}

	public void setPermiso(String permiso) {
		this.permiso = permiso;
	}

	public Timestamp getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	@Override
	public String toString() {
		return "Usuario [idUsr=" + idUsr + ", usuario=" + usuario + ", clave=" + clave + ", permiso=" + permiso
				+ ", fechaCreacion=" + fechaCreacion + "]";
	}

}
