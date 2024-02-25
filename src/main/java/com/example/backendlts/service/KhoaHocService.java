package com.example.backendlts.service;

import com.example.backendlts.entity.KhoaHoc;
import com.example.backendlts.entity.LoaiKhoaHoc;
import com.example.backendlts.repository.KhoaHocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class KhoaHocService implements IKhoaHocService{
    @Autowired
    KhoaHocRepository khoaHocRepository;
    @Override
    public String ThemKhoaHoc(KhoaHoc khoaHoc) {
        String res = "";
        KhoaHoc KHmoi = khoaHocRepository.save(khoaHoc);
        res += "them thanh cong khoa hoc: "+ KHmoi.getTenKhoaHoc();
        return res;
    }

    @Override
    public String SuaKhoaHoc(KhoaHoc khoaHoc) {
        String res = "";
        KhoaHoc KHcu = khoaHocRepository.findById(khoaHoc.getId()).get();
        if (KHcu == null){
            res += "khong tim thay khoa hoc";
            return res;
        }
        KHcu.setGioiThieu(khoaHoc.getGioiThieu());
        KHcu.setHinhAnh(khoaHoc.getHinhAnh());
        KHcu.setHocPhi(khoaHoc.getHocPhi());
        KHcu.setNoiDung(khoaHoc.getNoiDung());
        KHcu.setSoHocVien(khoaHoc.getSoHocVien());
        KHcu.setSoLuongMon(khoaHoc.getSoLuongMon());
        KHcu.setTenKhoaHoc(khoaHoc.getTenKhoaHoc());
        KHcu.setThoiGianHoc(khoaHoc.getThoiGianHoc());
        KHcu.setLoaiKhoaHocID(khoaHoc.getLoaiKhoaHocID());
        khoaHocRepository.save(KHcu);
        res += "sua thanh cong khoa hoc: id = "+KHcu.getId();
        return res;
    }

    @Override
    public String XoaKhoaHoc(int id) {
        String res = "";
        Optional<KhoaHoc> khoaHocCu = khoaHocRepository.findById(id);
        if (khoaHocCu.isEmpty()){
            res += "khong tim thay khoa hoc";
            return res;
        }
        khoaHocRepository.delete(khoaHocCu.get());
        res += "xoa thanh cong khoa hoc";
        return res;
    }

    @Override
    public Page<KhoaHoc> HienThiDanhSachKhoaHoc(int soTrang) {
        Sort sort = Sort.by(Sort.Direction.DESC,"hocPhi");
        Pageable page = PageRequest.of(soTrang,10,sort);
        return khoaHocRepository.findAll(page);
    }

    @Override
    public Page<KhoaHoc> TimKiemKhoaHoc(String tenKH, int soTrang) {
        List<KhoaHoc> ltsKH = new ArrayList<>();
        for (KhoaHoc khoaHoc : khoaHocRepository.findAll()){
            if (khoaHoc.getTenKhoaHoc().toLowerCase().contains(tenKH.toLowerCase())){
                ltsKH.add(khoaHoc);
            }
        }
        // Tính chỉ số bắt đầu của trang
        int start = soTrang * 10;
        // Tính chỉ số cuối của trang
        int end = Math.min((start + 10), ltsKH.size());
        if (start > end){
            return Page.empty();
        }

        // Tạo một trang mới từ danh sách đã sắp xếp và phân trang
        Pageable page = PageRequest.of(soTrang, 10, Sort.by(Sort.Direction.DESC, "hocPhi"));
        Page<KhoaHoc> resultPage = new PageImpl<>(ltsKH.subList(start, end), page, ltsKH.size());
        return resultPage;
    }
}
