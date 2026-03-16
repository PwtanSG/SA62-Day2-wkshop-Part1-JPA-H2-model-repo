package sg.edu.nus.webjpah2.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.edu.nus.webjpah2.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

//	Optional<User> findUserByUsername(String name);
//	Optional<User> findUserByUsernameAndPassword(String username, String password);
	Optional<User> findUsersByUsername(String username);

	Optional<User> findUsersByUsernameAndPassword(String username, String passwrd);

	Optional<User> findByEmail(String email);

	boolean existsByUsername(String username);

	boolean existsByEmail(String email);

//	@Query("from User u where User.id = ?1")
//	Optional<User> myOwnQuery(Long id);

}
