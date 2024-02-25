package com.example.backendlts.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Entity
@Table(name = "dangkyhoc")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DangKyHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "ngaydangky")
    private LocalDate ngayDangKy;
    @Column(name = "ngaybatdau")
    private LocalDate ngayBatDau;
    @Column(name = "ngayketthuc")
    private LocalDate ngayKetThuc;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idhocvien",foreignKey = @ForeignKey(name = "fk_dangkyhoc_hocvien"))
    @JsonIgnore
    private HocVien hocVienID;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idtaikhoan",foreignKey = @ForeignKey(name = "fk_dangkyhoc_taikhoan"))
    @JsonIgnore
    private TaiKhoan taiKhoanID;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idtinhtranghoc",foreignKey = @ForeignKey(name = "fk_dangkyhoc_tinhtranghoc"))
    @JsonIgnore
    private TinhTrangHoc tinhTrangHocID;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idkhoahoc",foreignKey = @ForeignKey(name = "fk_dangkyhoc_khoahoc"))
    @JsonIgnore
    private KhoaHoc khoaHocID;
}
