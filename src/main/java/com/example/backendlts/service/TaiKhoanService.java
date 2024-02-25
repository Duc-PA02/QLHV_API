package com.example.backendlts.service;

import com.example.backendlts.entity.TaiKhoan;
import com.example.backendlts.repository.TaiKhoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class TaiKhoanService implements ITaiKhoanService{
    @Autowired
    TaiKhoanRepository taiKhoanRepository;
    @Override
    public String ThemTaiKhoan(TaiKhoan taiKhoan) {
        String res = "";
        for (TaiKhoan tk : taiKhoanRepository.findAll()){
            if (tk.getTaiKhoan().toLowerCase().compareTo(taiKhoan.getTaiKhoan()) == 0 && tk.getId()!=taiKhoan.getId()){
                res += "ten tai khoan da ton tai";
                return res;
            }
        }
        String pattern = "^(?=.*\\d)(?=.*[!@#$%^&*()_+{}\\[\\]:;<>,.?~\\\\-]).*$";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(taiKhoan.getMatKhau());
        if (!matcher.matches()){
            res += "mat khau khong hop le";
            return res;
        }
        taiKhoanRepository.save(taiKhoan);
        res += "them tai khoan thanh cong";
        return res;
    }

    @Override
    public String SuaTaiKhoan(TaiKhoan taiKhoan) {
        String res = "";
        TaiKhoan tkn = taiKhoanRepository.findById(taiKhoan.getId()).get();
        if (tkn == null){
            res += "tai khoan khong ton tai";
            return res;
        }
        for (TaiKhoan tk : taiKhoanRepository.findAll()){
            if (tk.getTaiKhoan().toLowerCase().compareTo(taiKhoan.getTaiKhoan()) == 0 && tk.getId()!=taiKhoan.getId()){
                res += "ten tai khoan da ton tai";
                return res;
            }
        }
        String pattern = "^(?=.*\\d)(?=.*[!@#$%^&*()_+{}\\[\\]:;<>,.?~\\\\-]).*$";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(taiKhoan.getMatKhau());
        if (!matcher.matches()){
            res += "mat khau khong hop le";
            return res;
        }
        taiKhoanRepository.save(tkn);
        res += "sua tai khoan thanh cong";
        return res;
    }

    @Override
    public String XoaTaiKhoan(int id) {
        String res = "";
        Optional<TaiKhoan> taiKhoan = taiKhoanRepository.findById(id);
        if (taiKhoan.isEmpty()){
            res += "tai khoan khong ton tai";
            return res;
        }
        taiKhoanRepository.delete(taiKhoan.get());
        res += "xoa thanh cong";
        return res;
    }

    @Override
    public Page<TaiKhoan> DanhSachTaiKhoan(int soTrang) {
        Pageable pageable = PageRequest.of(soTrang, 10);
        return taiKhoanRepository.findAll(pageable);
    }

    @Override
    public Page<TaiKhoan> TimTaiKhoanTheoTen(String tenTK, int soTrang) {
        List<TaiKhoan> ltsTK = new ArrayList<>();
        for (TaiKhoan taiKhoan : taiKhoanRepository.findAll()){
            if (taiKhoan.getTaiKhoan().toLowerCase().contains(tenTK.toLowerCase())){
                ltsTK.add(taiKhoan);
            }
        }

        int start = soTrang * 10;
        int end = Math.min((start + 10), ltsTK.size());
        if (start > end){
            return Page.empty();
        }

        Pageable page = PageRequest.of(soTrang, 10);
        Page<TaiKhoan> resultPage = new PageImpl<>(ltsTK.subList(start, end), page, ltsTK.size());
        return resultPage;
    }
}
