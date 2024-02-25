package com.example.backendlts.controller;

import com.example.backendlts.entity.HocVien;
import com.example.backendlts.entity.KhoaHoc;
import com.example.backendlts.service.HocVienService;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.time.LocalDate;

@RestController
public class HocVienController {
    @Autowired
    HocVienService hocVienService;
    @PostMapping("hocvien/them")
    public String ThemHocVien(@RequestBody String hocVien){
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                return LocalDate.parse(json.getAsJsonPrimitive().getAsString());
            }
        }).create();
        HocVien hv = gson.fromJson(hocVien, HocVien.class);
        return hocVienService.ThemHocVien(hv);
    }
    @PutMapping("hocvien/sua")
    public String SuaHocVien(@RequestBody String hocVien){
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                return LocalDate.parse(json.getAsJsonPrimitive().getAsString());
            }
        }).create();
        HocVien hv = gson.fromJson(hocVien, HocVien.class);
        return hocVienService.SuaHocVien(hv);
    }
    @DeleteMapping("hocvien/xoa")
    public String XoaHocVien(@RequestParam int id){
        return hocVienService.XoaHocVien(id);
    }
    @GetMapping("hocvien/danhsach")
    public Page<HocVien> DanhSachHocVien(@RequestParam int soTrang){
        return hocVienService.DanhSachHocVien(soTrang);
    }
    @GetMapping("hocvien/danhsach/tenhocvien")
    public Page<HocVien> TimHocVienTheoTen(@RequestParam String tenHV,@RequestParam int soTrang){
        return hocVienService.HocVienTheoTen(tenHV, soTrang);
    }
    @GetMapping("hocvien/danhsach/mail")
    public Page<HocVien> TimHocVienTheoMail(@RequestParam String mail,@RequestParam int soTrang){
        return hocVienService.HocVienTheoMail(mail, soTrang);
    }
}
