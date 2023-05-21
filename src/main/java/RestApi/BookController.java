package RestApi;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Book;
import com.example.demo.RepositoryBook;
@CrossOrigin(origins= {"*"}, maxAge = 4800, allowCredentials = "false" )
@RestController
//@RequestMapping("/b2")
public class BookController {
	
	
	
	private RepositoryBook respositoryBook;
	private Book book;
	
	//constructores
	
	public BookController(RepositoryBook respositoryBook) {
		
		this.respositoryBook = respositoryBook;
		
	}
	
	@GetMapping("/uno")
	public String home() {
		return "home.html";
	}
	
	@Test
	@GetMapping("/api/hola")
	public String devolverpagina() {
		return "hola";
	}
	
	//getter and setters
	
	//crud sobre la entidad Book
	
	
	//Buscar todos los libros (lista de libros)
	@GetMapping("/api/books")
	public  List<Book> findAll() {
		//recuperar y devolver los libros de base de datos
		int countBooks = (int) respositoryBook.count();
		if(countBooks<=0) {
			
			 return respositoryBook.findAll();
		}else {
			
			return respositoryBook.findAll();
		}
	}
	
	//buscar un solo libro
	@GetMapping("/api/books/{id}")
	public ResponseEntity<Book> findOneById(@PathVariable Long id) {
	
		Optional<Book> bookOpt = respositoryBook.findById(id);
		System.out.println(bookOpt);
		
		if(bookOpt.isPresent()==true) {
			return ResponseEntity.ok(bookOpt.get());
		}
		else {
			System.out.println(ResponseEntity.notFound().build());
			return ResponseEntity.notFound().build();
			
		}
		
	}
	
	
	//enviar un libro con @PostMapping
	@PostMapping("/api/books")
	public Book create(@RequestBody Book book /*@RequestHeader HttpHeaders headers*/) {
		return respositoryBook.save(book);
		
	}
		
	/*Modificar un libro ya existente*/
	@PutMapping("/api/books")
	public ResponseEntity<Book> update(@RequestBody Book book) {
		if(book.getId()==null) {//si no tiene el id, es un libro nuevo
			System.out.println("El libro es una creacion nueva");
			return ResponseEntity.badRequest().build();
			
			
		}
		if(!respositoryBook.existsById(book.getId())==true) {
			System.out.println("Intentas actualizar un libro que no existe");
			return ResponseEntity.notFound().build();
		}
		
		
		Book result= respositoryBook.save(book);
		return ResponseEntity.ok(result);
	
	}
	
	/**/
	@DeleteMapping("/api/books/{id}")
	public ResponseEntity<Book> delete(@PathVariable Long id){
		if(!respositoryBook.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		respositoryBook.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/api/books")
	public ResponseEntity<Book> deleteAll(){
		respositoryBook.deleteAll();
		return ResponseEntity.noContent().build();	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
