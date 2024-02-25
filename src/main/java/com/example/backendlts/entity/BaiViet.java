package com.example.backendlts.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Entity
@Table(name = "baiviet")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaiViet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "tenbaiviet")
    private String tenBaiViet;
    @Column(name = "thoigiantao")
    private LocalDate thoiGianTao;
    @Column(name = "tentacgia")
    private String tenTacGia;
    @Column(name = "noidung")
    private String noiDung;
    @Column(name = "noidungngan")
    private String noiDungNgan;
    @Column(name = "hinhanh")
    private String hinhAnh;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idchude",foreignKey = @ForeignKey(name = "fk_baiviet_chude"))
    @JsonIgnore
    private ChuDe chuDeID;
    @ManyToOne
    @JoinColumn(name = "idtaikhoan",foreignKey = @ForeignKey(name = "fk_baiviet_taikhoan"))
    @JsonIgnore
    private TaiKhoan taiKhoanID;
}
