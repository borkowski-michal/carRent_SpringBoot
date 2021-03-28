package pl.borkowski.carrent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.borkowski.carrent.model.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role,Long> {
    Role findByRole(String role);
}
