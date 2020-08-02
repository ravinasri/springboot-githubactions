package com.sample.springbootgithubactions.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.sample.springbootgithubactions.model.Library;
import com.sample.springbootgithubactions.repository.LibraryRepository;
	

	@CrossOrigin(origins = "*")
	@RestController
	@RequestMapping("/api")
	public class LibraryController {
	
	  @Autowired
	  LibraryRepository libraryRepository;

	  @GetMapping("/getAll")
	  public List<Library> getAllUsers() {
	 
	  return libraryRepository.findAll();
	  }
	  
	 

	  @GetMapping("/getUser/{id}")
	  public ResponseEntity<Library> getUsersById(@PathVariable("id") Long id) {
	   Optional<Library> Data = libraryRepository.findById(id);

	   if (Data.isPresent()) {
	     return new ResponseEntity<>(Data.get(), HttpStatus.OK);
	   } else {
	     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	   }
	 }
	  
	  @PostMapping("/login")
	  public ResponseEntity<Library> createUser(@RequestBody Library library) {
	    try {
	    	Library _library = libraryRepository.save(new Library(library.getLibrary_card_number(), library.getPassword()));
	      return new ResponseEntity<>(_library, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
	    }
	  }
	  
	  @PutMapping("/library/{id}")
	  public ResponseEntity<Library> updateUser(@PathVariable("id") Long id, @RequestBody Library library) {
	    Optional<Library> updateData = libraryRepository.findById(id);

	    if (updateData.isPresent()) {
	    	Library _library = updateData.get();
	    	_library.setLibrary_card_number(library.getLibrary_card_number());
	    	_library.setPassword(library.getPassword());
	    	
	      return new ResponseEntity<>(libraryRepository.save(_library), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	  
	  @DeleteMapping("/user/{id}")
	  public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") Long id) {
	    try {
	    	libraryRepository.deleteById(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	    }
	  }

	  @DeleteMapping("/users")
	  public ResponseEntity<HttpStatus> deleteAllUsers() {
	    try {
	      libraryRepository.deleteAll();
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	    }
	  }
	}



