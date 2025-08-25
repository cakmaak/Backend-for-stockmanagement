package com.Stokmanagement.Stokmanagementapi.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Stokmanagement.Stokmanagementapi.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	 Optional<User> findByEmail(String email);
	 Optional<User> findByEmailIgnoreCase(String email);
	

}
