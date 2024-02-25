package com.example.backendlts.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
@Entity
@Table(name = "loaibaiviet")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoaiBaiViet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "tenloai")
    private String tenLoai;
    @OneToMany(mappedBy = "loaiBaiVietID")
    @JsonIgnoreProperties
    private Set<ChuDe> chuDes;
}
