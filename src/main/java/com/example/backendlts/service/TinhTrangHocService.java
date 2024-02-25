package com.example.backendlts.service;

import com.example.backendlts.entity.TinhTrangHoc;
import com.example.backendlts.repository.TinhTrangHocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TinhTrangHocService implements ITinhTrangHocService{
    @Autowired
    TinhTrangHocRepository tinhTrangHocRepository;

    @Override
    public String ThemTinhTrangHoc(TinhTrangHoc tinhTrangHoc) {
        String res = "";
        tinhTrangHocRepository.save(tinhTrangHoc);
        res += "them thanh cong";
        return res;
    }

    @Override
    public String SuaTinhTrangHoc(TinhTrangHoc tinhTrangHoc) {
        String res = "";
        TinhTrangHoc tth = tinhTrangHocRepository.findById(tinhTrangHoc.getId()).get();
        if (tth == null){
            res += "tinh trang hoc khong ton tai";
            return res;
        }
        tth.setTenTinhTrang(tinhTrangHoc.getTenTinhTrang());
        tinhTrangHocRepository.save(tth);
        res += "sua thanh cong";
        return res;
    }

    @Override
    public String XoaTinhTrangHoc(int id) {
        String res = "";
        Optional<TinhTrangHoc> tth = tinhTrangHocRepository.findById(id);
        if (tth.isEmpty()){
            res += "tinh trang hoc khong ton tai";
            return res;
        }
        tinhTrangHocRepository.delete(tth.get());
        res += "xoa thanh cong";
        return res;
    }

    @Override
    public List<TinhTrangHoc> DanhSachTinhTrangHoc() {
        return tinhTrangHocRepository.findAll();
    }
}
