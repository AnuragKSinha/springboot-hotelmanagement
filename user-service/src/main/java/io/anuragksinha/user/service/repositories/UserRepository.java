package io.anuragksinha.user.service.repositories;

import io.anuragksinha.user.service.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}
