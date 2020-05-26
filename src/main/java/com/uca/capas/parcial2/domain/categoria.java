package com.uca.capas.parcial2.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;


@Entity
@Table(schema="public", name="cat_categoria")
public class categoria {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="c_categoria")
	private Integer c_categoria;
	
	@Column(name="s_categoria")
	@Size(max=50, message="No debe de tener mas de 50 caracteres")
	private String s_categoria;
	
	@OneToMany(mappedBy="categoria", fetch=FetchType.EAGER)
	private List<libro> libros;

	public categoria() {
	
	}

	public Integer getC_categoria() {
		return c_categoria;
	}

	public void setC_categoria(Integer c_categoria) {
		this.c_categoria = c_categoria;
	}

	public String getS_categoria() {
		return s_categoria;
	}

	public void setS_categoria(String s_categoria) {
		this.s_categoria = s_categoria;
	}

	public List<libro> getLibros() {
		return libros;
	}

	public void setLibros(List<libro> libros) {
		this.libros = libros;
	}
	
	
}
