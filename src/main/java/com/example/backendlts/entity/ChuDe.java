package com.example.backendlts.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
@Entity
@Table(name = "chude")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChuDe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "tenchude")
    private String tenChuDe;
    @Column(name = "noidung")
    private String noiDung;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idloaibaiviet",foreignKey = @ForeignKey(name = "fk_chude_loaibaiviet"))
    @JsonIgnore
    private LoaiBaiViet loaiBaiVietID;
    @OneToMany(mappedBy = "chuDeID")
    @JsonIgnoreProperties
    private Set<BaiViet> baiViets;
}
