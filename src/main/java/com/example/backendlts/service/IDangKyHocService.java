package com.example.backendlts.service;

import com.example.backendlts.entity.DangKyHoc;
import org.springframework.data.domain.Page;

public interface IDangKyHocService {
    public String ThemDangKy(DangKyHoc dangKyHoc);
    public String SuaDangKy(DangKyHoc dangKyHoc);
    public String XoaDangKy(int id);
    public Page<DangKyHoc> DanhSachDangKy(int soTrang);
}
