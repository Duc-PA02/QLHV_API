package com.example.backendlts.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;
@Entity
@Table(name = "khoahoc")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KhoaHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "tenkhoahoc")
    private String tenKhoaHoc;
    @Column(name = "thoigianhoc")
    private int thoiGianHoc;
    @Column(name = "gioithieu")
    private String gioiThieu;
    @Column(name = "noidung")
    private String noiDung;
    @Column(name = "hocphi")
    private double hocPhi;
    @Column(name = "sohocvien")
    private int soHocVien;
    @Column(name = "soluongmon")
    private int soLuongMon;
    @Column(name = "hinhanh")
    private String hinhAnh;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idloaikhoahoc",foreignKey = @ForeignKey(name = "fk_khoahoc_loaikhoahoc"))
    @JsonIgnore
    private LoaiKhoaHoc loaiKhoaHocID;
    @OneToMany(mappedBy = "khoaHocID")
    @JsonIgnoreProperties
    private Set<DangKyHoc> dangKyHocs;
}
