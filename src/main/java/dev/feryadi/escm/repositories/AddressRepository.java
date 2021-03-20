package dev.feryadi.escm.repositories;

import dev.feryadi.escm.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
