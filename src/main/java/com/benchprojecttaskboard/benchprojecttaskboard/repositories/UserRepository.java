package com.benchprojecttaskboard.benchprojecttaskboard.repositories;

import com.benchprojecttaskboard.benchprojecttaskboard.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
