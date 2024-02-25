package com.example.backendlts.service;

import com.example.backendlts.entity.LoaiBaiViet;
import com.example.backendlts.repository.LoaiBaiVietRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoaiBaiVietService implements ILoaiBaiVietService{
    @Autowired
    LoaiBaiVietRepository loaiBaiVietRepository;
    @Override
    public String ThemLoaiBaiViet(LoaiBaiViet loaiBaiViet) {
        String res = "";
        loaiBaiVietRepository.save(loaiBaiViet);
        res += "them thanh cong";
        return res;
    }

    @Override
    public String SuaLoaiBaiViet(LoaiBaiViet loaiBaiViet) {
        String res = "";
        LoaiBaiViet lbv = loaiBaiVietRepository.findById(loaiBaiViet.getId()).get();
        if (lbv == null){
            res += "loai bai viet khong ton tai";
            return res;
        }
        loaiBaiVietRepository.save(lbv);
        res += "sua thanh cong";
        return res;
    }

    @Override
    public String XoaLoaiBaiViet(int id) {
        String str = "";
        Optional<LoaiBaiViet> loaiBaiViet = loaiBaiVietRepository.findById(id);
        if (loaiBaiViet.isEmpty()){
            str += "loai bai viet khong ton tai";
            return str;
        }
        loaiBaiVietRepository.delete(loaiBaiViet.get());
        str += "xoa thanh cong";
        return str;
    }

    @Override
    public Page<LoaiBaiViet> DanhSachLoaiBaiViet(int soTrang) {
        Pageable pageable = PageRequest.of(soTrang, 10);
        return loaiBaiVietRepository.findAll(pageable);
    }
}
