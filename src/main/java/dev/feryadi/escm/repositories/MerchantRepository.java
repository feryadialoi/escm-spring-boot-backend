package dev.feryadi.escm.repositories;

import dev.feryadi.escm.entities.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MerchantRepository extends JpaRepository<Merchant, Long> {
}
