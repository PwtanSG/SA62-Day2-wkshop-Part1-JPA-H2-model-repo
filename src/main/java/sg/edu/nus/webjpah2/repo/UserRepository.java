package sg.edu.nus.webjpah2.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.edu.nus.webjpah2.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
