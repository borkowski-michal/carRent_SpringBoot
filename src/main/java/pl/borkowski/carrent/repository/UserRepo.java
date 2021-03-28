package pl.borkowski.carrent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.borkowski.carrent.model.User;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    User findByEmail(String email);
    User findByFirstName(String userName);

}
