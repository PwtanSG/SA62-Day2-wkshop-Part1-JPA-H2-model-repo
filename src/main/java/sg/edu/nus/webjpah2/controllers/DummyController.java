package sg.edu.nus.webjpah2.controllers;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.nus.webjpah2.model.Category;
import sg.edu.nus.webjpah2.model.User;
import sg.edu.nus.webjpah2.repo.CategoryRepository;
import sg.edu.nus.webjpah2.repo.UserRepository;

@RestController
public class DummyController {
	
	@Autowired
	UserRepository uRepo;
	@Autowired
	CategoryRepository cRepo;
	
	@GetMapping("/test")
	public String getMethodName(@RequestParam String param) {
//		/test?param=Done
		Category c1 = new Category("Kitchen knive", "Simple home knife");
		cRepo.save(c1);
		LocalDate dob =  LocalDate.of(2022, 1, 1);
		LocalDateTime createdDate = LocalDateTime.now();
		User u1 = new User("Ah beng", "password", "ahbeng@email.com", "AH", "Beng", dob, createdDate);
		uRepo.save(u1);
		User u2 = new User("Ah Seng", "password12345", "ahSeng@email.com", "AH", "Seng", dob, createdDate);
		uRepo.save(u2);
		System.out.println(param);
		return new String(param);
	}

	@GetMapping("/test1")
	public String test() {
		Category c1 = new Category("Kitchen knive", "Simple home knife");
		cRepo.save(c1);
//		LocalDate dob =  LocalDate.of(2022, 1, 1);
//		LocalDate createdDate = LocalDate.now();
//		User u1 = new User("Ah beng", "password", "ahbeng@email.com", "AH", "Beng", dob, createdDate);
//		uRepo.save(u1);
		User u2 = new User("Ah Seng", "password12345", "ahSeng@email.com", "AH", "Seng", LocalDate.of(2022, 1, 1),  LocalDateTime.now());
		uRepo.save(u2);
		return "testing completed";
	}
}
