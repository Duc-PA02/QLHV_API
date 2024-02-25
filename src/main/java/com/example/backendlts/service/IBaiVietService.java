package com.example.backendlts.service;

import com.example.backendlts.entity.BaiViet;
import org.springframework.data.domain.Page;

public interface IBaiVietService {
    public String ThemBaiViet(BaiViet baiViet);
    public String SuaBaiViet(BaiViet baiViet);
    public String XoaBaiViet(int id);
    public Page<BaiViet> DanhSachBaiViet(int soTrang);
    public Page<BaiViet> TimBaiVietTheoTen(String tenBV, int soTrang);
}
