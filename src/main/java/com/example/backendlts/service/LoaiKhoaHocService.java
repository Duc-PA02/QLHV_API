package com.example.backendlts.service;

import com.example.backendlts.entity.KhoaHoc;
import com.example.backendlts.entity.LoaiKhoaHoc;
import com.example.backendlts.repository.KhoaHocRepository;
import com.example.backendlts.repository.LoaiKhoaHocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoaiKhoaHocService implements ILoaiKhoaHocService{
    @Autowired
    LoaiKhoaHocRepository loaiKhoaHocRepository;
    @Autowired
    KhoaHocRepository khoaHocRepository;
    @Override
    public String ThemLoaiKhoaHoc(LoaiKhoaHoc loaiKhoaHoc) {
        String res = "";
        LoaiKhoaHoc loaiKH = loaiKhoaHocRepository.save(loaiKhoaHoc);
        res += "them thanh cong loai khoa hoc: "+ loaiKH.getTenLoai();
        return res;
    }

    @Override
    public String SuaLoaiKhoaHoc(LoaiKhoaHoc loaiKhoaHoc) {
        String res = "";
        LoaiKhoaHoc loaiKH = loaiKhoaHocRepository.findById(loaiKhoaHoc.getId()).get();
        if (loaiKH == null){
            res += "khong tim thay loai khoa hoc";
            return res;
        }
        loaiKH.setTenLoai(loaiKhoaHoc.getTenLoai());
        loaiKhoaHocRepository.save(loaiKH);
        res += "sua thanh cong loai khoa hoc: id = "+loaiKH.getId();
        return res;
    }

    @Override
    public String XoaLoaiKhoaHoc(int id) {
        String res = "";
        Optional<LoaiKhoaHoc> loaiKhoaHoc = loaiKhoaHocRepository.findById(id);
        if (loaiKhoaHoc.isEmpty()){
            res += "khong tim thay loai khoa hoc";
            return res;
        }
        for (KhoaHoc kh : khoaHocRepository.findAll()){
            if (kh.getLoaiKhoaHocID().getId()==id){
                khoaHocRepository.delete(kh);
            }
        }
        loaiKhoaHocRepository.delete(loaiKhoaHoc.get());
        res += "xoa thanh cong loai khoa hoc";
        return res;
    }
}
