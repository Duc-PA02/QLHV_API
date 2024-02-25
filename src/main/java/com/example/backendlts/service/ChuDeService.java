package com.example.backendlts.service;

import com.example.backendlts.entity.ChuDe;
import com.example.backendlts.repository.ChuDeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChuDeService implements IChuDeService{
    @Autowired
    ChuDeRepository chuDeRepository;
    @Override
    public String ThemChuDe(ChuDe chuDe) {
        String str = "";
        chuDeRepository.save(chuDe);
        str += "them thanh cong";
        return str;
    }

    @Override
    public String SuaChuDe(ChuDe chuDe) {
        String str = "";
        ChuDe cd = chuDeRepository.findById(chuDe.getId()).get();
        if (cd == null){
            str += "chu de khong ton tai";
            return str;
        }
        chuDeRepository.save(chuDe);
        str += "sua thanh cong";
        return str;
    }

    @Override
    public String XoaChuDe(int id) {
        String str = "";
        Optional<ChuDe> chuDe = chuDeRepository.findById(id);
        if (chuDe.isEmpty()){
            str += "chu de khong ton tai";
            return str;
        }
        chuDeRepository.delete(chuDe.get());
        str += "xoa thanh cong";
        return str;
    }

    @Override
    public Page<ChuDe> DanhSachChuDe(int soTrang) {
        Pageable pageable = PageRequest.of(soTrang, 10);
        return chuDeRepository.findAll(pageable);
    }
}
