package cafe.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import cafe.entity.ContactUs;

public interface ContactRepository extends JpaRepository<ContactUs,Long>{
}