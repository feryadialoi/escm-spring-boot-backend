package dev.feryadi.escm.repositories;

import dev.feryadi.escm.entities.SaleOrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleOrderDetailRepository extends JpaRepository<SaleOrderDetail, Long> {
}
