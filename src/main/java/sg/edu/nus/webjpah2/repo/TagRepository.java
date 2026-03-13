package sg.edu.nus.webjpah2.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.edu.nus.webjpah2.model.Tag;

public interface TagRepository extends JpaRepository<Tag, Long> {

}
