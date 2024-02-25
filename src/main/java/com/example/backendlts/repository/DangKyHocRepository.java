package com.example.backendlts.repository;

import com.example.backendlts.entity.DangKyHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DangKyHocRepository extends JpaRepository<DangKyHoc, Integer> {
}
