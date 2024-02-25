package com.example.backendlts.service;

import com.example.backendlts.entity.DangKyHoc;
import com.example.backendlts.entity.KhoaHoc;
import com.example.backendlts.entity.TinhTrangHoc;
import com.example.backendlts.repository.DangKyHocRepository;
import com.example.backendlts.repository.KhoaHocRepository;
import com.example.backendlts.repository.TinhTrangHocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class DangKyHocService implements IDangKyHocService{
    @Autowired
    DangKyHocRepository dangKyHocRepository;
    @Autowired
    KhoaHocRepository khoaHocRepository;
    @Autowired
    TinhTrangHocRepository tinhTrangHocRepository;
    @Override
    public String ThemDangKy(DangKyHoc dangKyHoc) {
        String res = "";
        dangKyHoc.setNgayDangKy(LocalDate.now());
        TinhTrangHoc tinhTrangHoc = tinhTrangHocRepository.findById(dangKyHoc.getTinhTrangHocID().getId()).get();
        KhoaHoc khoaHoc = khoaHocRepository.findById(dangKyHoc.getKhoaHocID().getId()).get();
        if (tinhTrangHoc.getId()==2){
            LocalDate ngayBatDau = LocalDate.now();
            dangKyHoc.setNgayBatDau(ngayBatDau);
            LocalDate ngayKetThuc = ngayBatDau.plusDays(khoaHoc.getThoiGianHoc());
            dangKyHoc.setNgayKetThuc(ngayKetThuc);
            dangKyHocRepository.save(dangKyHoc);
            res += "thêm đăng ký đang học chính thành công";
            return res;
        }else {
            LocalDate ngayHienTai = LocalDate.now();
            dangKyHoc.setNgayKetThuc(dangKyHoc.getNgayBatDau().plusDays(khoaHoc.getThoiGianHoc()));
            if (dangKyHoc.getNgayKetThuc().isAfter(ngayHienTai)){
                res += "thời gian kết thúc phải < thời gian hiện tại";
                return res;
            }
            dangKyHocRepository.save(dangKyHoc);
            res += "them thanh cong";
        }
        return res;
    }

    @Override
    public String SuaDangKy(DangKyHoc dangKyHoc) {
        String res = "";
        DangKyHoc dkMoi = dangKyHocRepository.findById(dangKyHoc.getId()).get();
        dkMoi.setNgayDangKy(LocalDate.now());
        TinhTrangHoc tinhTrangHoc = tinhTrangHocRepository.findById(dangKyHoc.getTinhTrangHocID().getId()).get();
        KhoaHoc khoaHoc = khoaHocRepository.findById(dangKyHoc.getKhoaHocID().getId()).get();
        if (tinhTrangHoc.getId()==2){
            LocalDate ngayBatDau = LocalDate.now();
            dkMoi.setNgayBatDau(ngayBatDau);
            LocalDate ngayKetThuc = ngayBatDau.plusDays(khoaHoc.getThoiGianHoc());
            dkMoi.setNgayKetThuc(ngayKetThuc);
            dangKyHocRepository.save(dkMoi);
            res += "sửa đăng ký đang học chính thành công";
            return res;
        }else {
            LocalDate ngayHienTai = LocalDate.now();
            dkMoi.setNgayKetThuc(dkMoi.getNgayBatDau().plusDays(khoaHoc.getThoiGianHoc()));
            if (dangKyHoc.getNgayKetThuc().isAfter(ngayHienTai)){
                res += "thời gian kết thúc phải < thời gian hiện tại";
                return res;
            }
            dangKyHocRepository.save(dkMoi);
            res += "sửa thanh cong";
        }
        return res;
    }

    @Override
    public String XoaDangKy(int id) {
        String res = "";
        Optional<DangKyHoc> dangKyHoc = dangKyHocRepository.findById(id);
        if (dangKyHoc.isEmpty()){
            res += "error";
            return res;
        }
        dangKyHocRepository.delete(dangKyHoc.get());
        res += "xoa thanh cong";
        return res;
    }

    @Override
    public Page<DangKyHoc> DanhSachDangKy(int soTrang) {
        Pageable pageable = PageRequest.of(soTrang, 10);
        return dangKyHocRepository.findAll(pageable);
    }
}
