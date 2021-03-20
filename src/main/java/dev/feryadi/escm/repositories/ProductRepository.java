package dev.feryadi.escm.repositories;

import dev.feryadi.escm.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
