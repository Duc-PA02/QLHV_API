package com.example.backendlts.service;

import com.example.backendlts.entity.TinhTrangHoc;

import java.util.List;

public interface ITinhTrangHocService {
    public String ThemTinhTrangHoc(TinhTrangHoc tinhTrangHoc);
    public String SuaTinhTrangHoc(TinhTrangHoc tinhTrangHoc);
    public String XoaTinhTrangHoc(int id);
    public List<TinhTrangHoc> DanhSachTinhTrangHoc();
}
