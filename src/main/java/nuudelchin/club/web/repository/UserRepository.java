package nuudelchin.club.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nuudelchin.club.web.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    Boolean existsByUsername(String username);

    UserEntity findByUsername(String username);
}
