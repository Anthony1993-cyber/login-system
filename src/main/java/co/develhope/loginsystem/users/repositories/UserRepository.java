package co.develhope.loginsystem.users.repositories;

import co.develhope.loginsystem.users.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    User findByActivationCode(String activationCode);
}
