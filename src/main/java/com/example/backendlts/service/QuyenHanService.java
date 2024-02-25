package com.example.backendlts.service;

import com.example.backendlts.entity.QuyenHan;
import com.example.backendlts.repository.QuyenHanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuyenHanService implements IQuyenHanService{
    @Autowired
    QuyenHanRepository quyenHanRepository;
    @Override
    public String ThemQuyenHan(QuyenHan quyenHan) {
        String res = "";
        quyenHanRepository.save(quyenHan);
        res += "them thanh cong";
        return res;
    }

    @Override
    public String SuaQuyenHan(QuyenHan quyenHan) {
        String res = "";
        Optional<QuyenHan> qh = quyenHanRepository.findById(quyenHan.getId());
        if (qh.isEmpty()){
            res += "quyen han khong ton tai";
            return res;
        }
        QuyenHan qH = qh.get();
        qH.setTenQuyenHan(quyenHan.getTenQuyenHan());
        quyenHanRepository.save(qH);
        res += "sua thanh cong";
        return res;
    }

    @Override
    public String XoaQuyenHan(int id) {
        String res = "";
        Optional<QuyenHan> qh = quyenHanRepository.findById(id);
        if (qh.isEmpty()){
            res += "quyen han khong ton tai";
            return res;
        }
        quyenHanRepository.delete(qh.get());
        res += "xoa thanh cong";
        return res;
    }

    @Override
    public Page<QuyenHan> DanhSachQuyenHan(int soTrang) {
        Pageable pageable = PageRequest.of(soTrang, 10);
        return quyenHanRepository.findAll(pageable);
    }
}
