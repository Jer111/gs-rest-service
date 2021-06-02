package com.example.restservice;


import org.springframework.data.repository.CrudRepository;
import java.util.List;  

public interface UserRepository extends CrudRepository<User, Long>{
	List<User> findByGroupName( final String name );
}