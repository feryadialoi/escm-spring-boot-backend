package dev.feryadi.escm.repositories;

import dev.feryadi.escm.entities.ProductQuota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProductQuotaRepository extends JpaRepository<ProductQuota, Long> {
    @Query(value = "SELECT pq FROM product_quotas pq WHERE pq.product_id = :productId", nativeQuery = true)
    ProductQuota findProductQuotaByProductIdNative(@Param("productId") Long productId);
}
