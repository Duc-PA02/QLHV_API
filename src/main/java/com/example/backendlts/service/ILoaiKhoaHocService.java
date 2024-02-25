package com.example.backendlts.service;

import com.example.backendlts.entity.LoaiKhoaHoc;

public interface ILoaiKhoaHocService {
    public String ThemLoaiKhoaHoc(LoaiKhoaHoc loaiKhoaHoc);
    public String SuaLoaiKhoaHoc(LoaiKhoaHoc loaiKhoaHoc);
    public String XoaLoaiKhoaHoc(int id);
}
