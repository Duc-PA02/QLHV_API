package com.example.backendlts.service;

import com.example.backendlts.entity.QuyenHan;
import org.springframework.data.domain.Page;

public interface IQuyenHanService {
    public String ThemQuyenHan(QuyenHan quyenHan);
    public String SuaQuyenHan(QuyenHan quyenHan);
    public String XoaQuyenHan(int id);
    public Page<QuyenHan> DanhSachQuyenHan(int soTrang);
}
