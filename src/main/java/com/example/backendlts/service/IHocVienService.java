package com.example.backendlts.service;

import com.example.backendlts.entity.HocVien;
import org.springframework.data.domain.Page;

public interface IHocVienService {
    public String ThemHocVien(HocVien hocVien);
    public String SuaHocVien(HocVien hocVien);
    public String XoaHocVien(int id);
    public Page<HocVien> DanhSachHocVien(int soTrang);
    public Page<HocVien> HocVienTheoTen(String tenHV, int soTrang);
    public Page<HocVien> HocVienTheoMail(String mail, int soTrang);
}
