package com.example.backendlts.repository;

import com.example.backendlts.entity.LoaiBaiViet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoaiBaiVietRepository extends JpaRepository<LoaiBaiViet, Integer> {
}
