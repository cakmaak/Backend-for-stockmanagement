package com.Stokmanagement.Stokmanagementapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Stokmanagement.Stokmanagementapi.Entity.Stok;

@Repository
public interface StokRepository extends JpaRepository<Stok, Long> {

}
