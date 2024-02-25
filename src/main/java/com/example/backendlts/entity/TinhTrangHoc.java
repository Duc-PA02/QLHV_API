package com.example.backendlts.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
@Entity
@Table(name = "tinhtranghoc")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TinhTrangHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "tentinhtrang")
    private String tenTinhTrang;
    @OneToMany(mappedBy = "tinhTrangHocID")
    @JsonIgnoreProperties
    private Set<DangKyHoc> dangKyHocs;
}
