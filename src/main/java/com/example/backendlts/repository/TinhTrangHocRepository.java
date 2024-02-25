package com.example.backendlts.repository;

import com.example.backendlts.entity.TinhTrangHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TinhTrangHocRepository extends JpaRepository<TinhTrangHoc, Integer> {
}
