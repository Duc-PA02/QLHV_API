package com.example.backendlts.service;

import com.example.backendlts.entity.LoaiBaiViet;
import org.springframework.data.domain.Page;

public interface ILoaiBaiVietService {
    public String ThemLoaiBaiViet(LoaiBaiViet loaiBaiViet);
    public String SuaLoaiBaiViet(LoaiBaiViet loaiBaiViet);
    public String XoaLoaiBaiViet(int id);
    public Page<LoaiBaiViet> DanhSachLoaiBaiViet(int soTrang);
}
