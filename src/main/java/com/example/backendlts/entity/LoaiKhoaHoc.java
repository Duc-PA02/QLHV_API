package com.example.backendlts.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
@Entity
@Table(name = "loaikhoahoc")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoaiKhoaHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "tenloai")
    private String tenLoai;
    @OneToMany(mappedBy = "loaiKhoaHocID")
    @JsonIgnoreProperties
    private Set<KhoaHoc> khoaHocs;
}
