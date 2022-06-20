package com.turntalien.rest.repo;

import com.turntalien.rest.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {

}
