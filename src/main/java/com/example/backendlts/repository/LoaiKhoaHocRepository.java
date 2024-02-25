package com.example.backendlts.repository;

import com.example.backendlts.entity.LoaiKhoaHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoaiKhoaHocRepository extends JpaRepository<LoaiKhoaHoc, Integer> {
}
