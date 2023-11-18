package com.visualflow.webapp.repository;

import com.visualflow.webapp.model.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User,Integer> {
}
