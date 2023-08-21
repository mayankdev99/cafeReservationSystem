package cafe.repository;

import org.springframework.data.repository.CrudRepository;

import cafe.entity.Admin;

public interface AdminRepo extends CrudRepository<Admin, Integer>{

}
