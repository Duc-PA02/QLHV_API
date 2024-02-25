package com.example.backendlts.service;

import com.example.backendlts.entity.KhoaHoc;
import org.springframework.data.domain.Page;

public interface IKhoaHocService {
    public String ThemKhoaHoc(KhoaHoc khoaHoc);
    public String SuaKhoaHoc(KhoaHoc khoaHoc);
    public String XoaKhoaHoc(int id);
    public Page<KhoaHoc> HienThiDanhSachKhoaHoc(int soTrang);
    public Page<KhoaHoc> TimKiemKhoaHoc(String tenKH, int soTrang);
}
