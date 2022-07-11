package com.user.registration.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.registration.entities.UserEntity;

public interface UserEntityRepository extends JpaRepository<UserEntity, Integer> {
	void findByCustomerId(Integer userId);
}
