package com.example.backendlts.service;

import com.example.backendlts.entity.ChuDe;
import org.springframework.data.domain.Page;

public interface IChuDeService {
    public String ThemChuDe(ChuDe chuDe);
    public String SuaChuDe(ChuDe chuDe);
    public String XoaChuDe(int id);
    public Page<ChuDe> DanhSachChuDe(int soTrang);
}
