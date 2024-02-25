package com.example.backendlts.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
@Entity
@Table(name = "quyenhan")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuyenHan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "tenquyenhan")
    private String tenQuyenHan;
    @OneToMany(mappedBy = "quyenHanID")
    @JsonIgnoreProperties
    private Set<TaiKhoan> taiKhoans;
}
