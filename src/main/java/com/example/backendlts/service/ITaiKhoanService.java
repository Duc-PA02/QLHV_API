package com.example.backendlts.service;

import com.example.backendlts.entity.TaiKhoan;
import org.springframework.data.domain.Page;

public interface ITaiKhoanService {
    public String ThemTaiKhoan(TaiKhoan taiKhoan);
    public String SuaTaiKhoan(TaiKhoan taiKhoan);
    public String XoaTaiKhoan(int id);
    public Page<TaiKhoan> DanhSachTaiKhoan(int soTrang);
    public Page<TaiKhoan> TimTaiKhoanTheoTen(String tenTK, int soTrang);
}
