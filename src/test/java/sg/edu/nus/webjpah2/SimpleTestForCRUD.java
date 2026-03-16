package sg.edu.nus.webjpah2;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jpa.test.autoconfigure.TestEntityManager;
import static org.assertj.core.api.Assertions.*;

import sg.edu.nus.webjpah2.model.User;
import sg.edu.nus.webjpah2.repo.UserRepository;

@DataJpaTest
public class SimpleTestForCRUD {

	@Autowired
	UserRepository userRepo;

	@Autowired
	private TestEntityManager em;

	@BeforeEach
	public void setUp() {
		// Create and persist test data
		User u2 = new User("Ah Beng", "12345678", "ahBeng@email.com", "AH", "Beng", LocalDate.of(2022, 1, 1),
				LocalDate.now());
		User saveUser = userRepo.save(u2);
		em.persist(saveUser);
		em.flush();
	}

//		@Test
//		@DisplayName("Test user create");
//		void saveUser() {
//			User u2 = new User("Ah Seng", "password12345", "ahSeng@email.com", "AH", "Seng", LocalDate.of(2022, 1, 1),  LocalDate.now());
//			User saveUser = userRepo.save(u2);
//			em.persistAndFlush(saveUser);
//			(saveUser.getId()).i
//			AssertThat(saveUser.getId())
//		}

//	@Test
//	@DisplayName("Test user create")
//	void saveUser() {
//		User u2 = new User("Ah Seng", "password12345", "ahSeng@email.com", "AH", "Seng", LocalDate.of(2022, 1, 1),
//				LocalDate.now());
//		User saveUser = userRepo.save(u2);
//		em.persistAndFlush(saveUser);
//		System.out.println(saveUser.getId());
//		System.out.println(saveUser.getEmail());
//		assertThat(saveUser.getId()).isNotNull().isPositive();
//	}

	@Test
	@DisplayName("Test User Creation")
	void findUserByUserName() {
		Optional<User> list = userRepo.findUsersByUsername("Ah Beng");
		System.out.println(list.isPresent());
		System.out.println(list);
		assertThat(list.isPresent());
	}

	@Test
	@DisplayName("Test User Creation")
	void findUser() {
		List<User> list = userRepo.findAll();
		assertThat(list.size() > 0);
	}
}
