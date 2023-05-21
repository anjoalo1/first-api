package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="books")
public class Book {
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String autor;
	private boolean enlinea;
	private Double precio;
	private int paginas;
	


	
	
	

	public Book(Long id, String nombre, String autor, boolean enlinea, Double precio, int paginas) {
		this.id = id;
		this.nombre = nombre;
		this.autor = autor;
		this.enlinea = enlinea;
		this.precio = precio;
		this.paginas = paginas;
	}



	public int getPaginas() {
		return paginas;
	}



	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}



	public Book() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public boolean isEnlinea() {
		return enlinea;
	}

	public void setEnlinea(boolean enlinea) {
		this.enlinea = enlinea;
	}
	
	
	

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}



	@Override
	public String toString() {
		return "Book [id=" + id + ", nombre=" + nombre + ", autor=" + autor + ", enlinea=" + enlinea + ", precio="
				+ precio + ", paginas=" + paginas + "]";
	}

	


	
	
	
	
	
	

}
