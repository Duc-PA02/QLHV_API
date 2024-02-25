package com.example.backendlts.service;

import com.example.backendlts.entity.BaiViet;
import com.example.backendlts.repository.BaiVietRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BaiVietService implements IBaiVietService{
    @Autowired
    BaiVietRepository baiVietRepository;
    @Override
    public String ThemBaiViet(BaiViet baiViet) {
        String res = "";
        baiViet.setThoiGianTao(LocalDate.now());
        baiVietRepository.save(baiViet);
        res += "them thanh cong";
        return res;
    }

    @Override
    public String SuaBaiViet(BaiViet baiViet) {
        String res = "";
        BaiViet bv = baiVietRepository.findById(baiViet.getId()).get();
        if (bv == null){
            res += "bai viet khong ton tai";
            return res;
        }
        bv.setThoiGianTao(LocalDate.now());
        baiVietRepository.save(bv);
        res += "sua thanh cong";
        return res;
    }

    @Override
    public String XoaBaiViet(int id) {
        String res = "";
        Optional<BaiViet> baiViet = baiVietRepository.findById(id);
        if (baiViet.isEmpty()){
            res += "bai viet khong ton tai";
            return res;
        }
        baiVietRepository.delete(baiViet.get());
        res += "xoa thanh cong";
        return res;
    }

    @Override
    public Page<BaiViet> DanhSachBaiViet(int soTrang) {
        Pageable pageable = PageRequest.of(soTrang, 10);
        return baiVietRepository.findAll(pageable);
    }

    @Override
    public Page<BaiViet> TimBaiVietTheoTen(String tenBV, int soTrang) {
        List<BaiViet> listBV = new ArrayList<>();
        for (BaiViet bv : baiVietRepository.findAll()){
            if (bv.getTenBaiViet().toLowerCase().contains(tenBV.toLowerCase())){
                listBV.add(bv);
            }
        }
        int start = soTrang*10;
        int end = Math.min((start + 10), listBV.size());
        if (start > end){
            return Page.empty();
        }
        Pageable pageable = PageRequest.of(soTrang, 10);
        Page<BaiViet> page = new PageImpl<>(listBV.subList(start,end), pageable, listBV.size());
        return page;
    }
}
