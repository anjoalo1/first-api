package com.example.demo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;








@ComponentScan({"RestApi", "openApi"})
@SpringBootApplication
public class Swagger7Application {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(Swagger7Application.class, args);
		RepositoryBook mybook = context.getBean(RepositoryBook.class);
		Book nuevo = new Book(null, "nuevo", "author", true, 26.0, 200);
		Book nuevo1 = new Book(null, "dos", "dos", true, 15.0, 630);
		Book nuevo2 = new Book(null, "tres", "tres", true, 12.0, 588);
		Book nuevo3 = new Book(null, "cuatro", "cuatro", true, 18.0, 177);
		mybook.save(nuevo);
		mybook.save(nuevo1);
		mybook.save(nuevo2);
		mybook.save(nuevo3);
		System.out.println(mybook.findAll());
		System.out.println(mybook.count());
	}
	
	//err
	
	

	

}





