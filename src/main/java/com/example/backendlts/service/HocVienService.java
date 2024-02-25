package com.example.backendlts.service;

import com.example.backendlts.entity.HocVien;
import com.example.backendlts.repository.HocVienRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HocVienService implements IHocVienService {
    @Autowired
    HocVienRepository hocVienRepository;
    @Override
    public String ThemHocVien(HocVien hocVien) {
        String res = "";
        hocVien.setHoTen(StringUtils.capitalize(hocVien.getHoTen()));
        hocVien.setEmail(hocVien.getEmail());
        for (HocVien hv : hocVienRepository.findAll()){
            if (hv.getEmail().toLowerCase().compareTo(hocVien.getEmail().toLowerCase())==0){
                res += "email da ton tai";
                return res;
            }
        }
        for (HocVien hv : hocVienRepository.findAll()){
            if (hv.getSdt().toLowerCase().compareTo(hocVien.getSdt().toLowerCase())==0){
                res += "so dien thoai da ton tai";
                return res;
            }
        }
        HocVien HVmoi = hocVienRepository.save(hocVien);
        res += "them thanh cong hoc vien: "+ HVmoi.getHoTen();
        return res;
    }

    @Override
    public String SuaHocVien(HocVien hocVien) {
        String res = "";
        HocVien hvCu = hocVienRepository.findById(hocVien.getId()).get();
        if (hvCu == null){
            res += "hoc vien khong ton tai";
            return res;
        }
        for (HocVien hv : hocVienRepository.findAll()){
            if (hv.getEmail().toLowerCase().compareTo(hocVien.getEmail().toLowerCase())==0 && hv.getId()!=hocVien.getId()){
                res += "email da ton tai";
                return res;
            }
        }
        for (HocVien hv : hocVienRepository.findAll()){
            if (hv.getSdt().toLowerCase().compareTo(hocVien.getSdt().toLowerCase())==0 && hv.getId()!=hocVien.getId()){
                res += "so dien thoai da ton tai";
                return res;
            }
        }
        hvCu.setEmail(hocVien.getEmail());
        hvCu.setHinhAnh(hocVien.getHinhAnh());
        hvCu.setHoTen(StringUtils.capitalize(hocVien.getHoTen()));
        hvCu.setNgaySinh(hocVien.getNgaySinh());
        hvCu.setPhuongXa(hocVien.getPhuongXa());
        hvCu.setQuanHuyen(hocVien.getQuanHuyen());
        hvCu.setSoNha(hocVien.getSoNha());
        hvCu.setSdt(hocVien.getSdt());
        hvCu.setTinhThanh(hocVien.getTinhThanh());
        hocVienRepository.save(hvCu);
        res += "sua thanh cong hoc vien: " + hvCu.getHoTen();
        return res;
    }

    @Override
    public String XoaHocVien(int id) {
        String res = "";
        Optional<HocVien> hocVien = hocVienRepository.findById(id);
        if (hocVien.isEmpty()){
            res += "hoc vien khong ton tai";
            return res;
        }
        hocVienRepository.delete(hocVien.get());
        res += "da xoa hoc vien";
        return res;
    }

    @Override
    public Page<HocVien> DanhSachHocVien(int soTrang) {
        Pageable pageable = PageRequest.of(soTrang, 10);
        return hocVienRepository.findAll(pageable);
    }

    @Override
    public Page<HocVien> HocVienTheoTen(String tenHV, int soTrang) {
        List<HocVien> ltsHV = new ArrayList<>();
        for (HocVien hocVien : hocVienRepository.findAll()){
            if (hocVien.getHoTen().toLowerCase().contains(tenHV.toLowerCase())){
                ltsHV.add(hocVien);
            }
        }

        int start = soTrang * 10;
        int end = Math.min((start + 10), ltsHV.size());
        if (start > end){
            return Page.empty();
        }

        Pageable page = PageRequest.of(soTrang, 10);
        Page<HocVien> resultPage = new PageImpl<>(ltsHV.subList(start, end), page, ltsHV.size());
        return resultPage;
    }

    @Override
    public Page<HocVien> HocVienTheoMail(String mail, int soTrang) {
        List<HocVien> ltsHV = new ArrayList<>();
        for (HocVien hocVien : hocVienRepository.findAll()){
            if (hocVien.getEmail().toLowerCase().contains(mail.toLowerCase())){
                ltsHV.add(hocVien);
            }
        }

        int start = soTrang * 10;
        int end = Math.min((start + 10), ltsHV.size());
        if (start > end){
            return Page.empty();
        }

        Pageable page = PageRequest.of(soTrang, 10);
        Page<HocVien> resultPage = new PageImpl<>(ltsHV.subList(start, end), page, ltsHV.size());
        return resultPage;
    }
}
