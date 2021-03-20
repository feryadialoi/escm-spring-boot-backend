package dev.feryadi.escm.repositories;

import dev.feryadi.escm.entities.SaleOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleOrderRepository extends JpaRepository<SaleOrder, Long> {
}
