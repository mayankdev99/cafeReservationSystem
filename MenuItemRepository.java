package cafe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cafe.entity.MenuItem;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
}

