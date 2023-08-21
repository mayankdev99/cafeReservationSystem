package cafe.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import cafe.entity.User;

public interface UserRepo extends CrudRepository<User, Integer>{
	  Optional<User> findByEmailidAndMobileno(String emailid, String mobileno);
	}

