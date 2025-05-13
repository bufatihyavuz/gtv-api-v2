package org.gtvapi.repository;

import org.gtvapi.dto.projection.UserProjection;
import org.gtvapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<UserProjection> findByUsername(String username);

    boolean existsByUsername(String username);

}

