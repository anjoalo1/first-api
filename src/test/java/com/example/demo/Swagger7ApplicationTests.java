package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Swagger7ApplicationTests {

	@Test
	void contextLoads() {
		Book book = new Book(null, "uno", "dos", false, 100.0, 300);
		Swagger7ApplicationTests calculartor = new Swagger7ApplicationTests();
		Double price =calculartor.calculatorPrice(book);
		System.out.println(price);
		assertTrue(price>0);
		assertEquals(102.99, price);
	}
	
	public Double calculatorPrice(Book book) {
		
		Double price = book.getPrecio();
		if(book.getPaginas() > 300) {
			price +=5;
		}
		//envio + costo de envio
		price += 2.99;
		return price;
	
		
	}
	
	
	
	
	
	
	
	
	
	

}
