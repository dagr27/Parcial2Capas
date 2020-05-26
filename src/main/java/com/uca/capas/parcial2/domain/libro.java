package com.uca.capas.parcial2.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(schema="public", name="cat_libro")
public class libro {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="c_libro")
	private Integer c_libro;
	
	@Column(name="s_titulo")
	@NotEmpty(message="No puede estar vacio")
	@Size(max=500, message="No puede tener mas de 500 caracteres")
	private String s_titulo;
	
	@Column(name="s_autor")
	@NotEmpty(message="No puede estar vacio")
	@Size(max=150, message="No puede tener mas de 150 caracteres")
	private String s_autor;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="c_categoria")
	private categoria categoria;
	
	@Column(name="f_ingreso")
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date f_ingreso;
	
	@Column(name="b_estado")
	private Boolean b_estado;
	
	@Column(name="s_isbn")
	@NotEmpty(message="No puede estar vacio")
	@Size(max=10, message="No puede tener mas de 10 caracteres")
	private String s_isbn;

	
	
	public libro() {
		
	}

	public Integer getC_libro() {
		return c_libro;
	}

	public void setC_libro(Integer c_libro) {
		this.c_libro = c_libro;
	}

	public String getS_titulo() {
		return s_titulo;
	}

	public void setS_titulo(String s_titulo) {
		this.s_titulo = s_titulo;
	}

	public String getS_autor() {
		return s_autor;
	}

	public void setS_autor(String s_autor) {
		this.s_autor = s_autor;
	}

	

	public categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(categoria categoria) {
		this.categoria = categoria;
	}

	public Date getF_ingreso() {
		return f_ingreso;
	}

	public void setF_ingreso(Date f_ingreso) {
		this.f_ingreso = f_ingreso;
	}

	public Boolean getB_estado() {
		return b_estado;
	}

	public void setB_estado(Boolean b_estado) {
		this.b_estado = b_estado;
	}

	public String getS_isbn() {
		return s_isbn;
	}

	public void setS_isbn(String s_isbn) {
		this.s_isbn = s_isbn;
	}
	
	
	
	
}
