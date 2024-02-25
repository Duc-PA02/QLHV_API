package com.example.backendlts.controller;

import com.example.backendlts.entity.TaiKhoan;
import com.example.backendlts.service.TaiKhoanService;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.time.LocalDate;

@RestController
public class TaiKhoanController {
    @Autowired
    TaiKhoanService taiKhoanService;
    @PostMapping("taikhoan/them")
    public String ThemTaiKhoan(@RequestBody String taiKhoan){
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                return LocalDate.parse(json.getAsJsonPrimitive().getAsString());
            }
        }).create();
        TaiKhoan tk = gson.fromJson(taiKhoan, TaiKhoan.class);
        return taiKhoanService.ThemTaiKhoan(tk);
    }
    @PutMapping("taikhoan/sua")
    public String SuaTaiKhoan(@RequestBody String taiKhoan){
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                return LocalDate.parse(json.getAsJsonPrimitive().getAsString());
            }
        }).create();
        TaiKhoan tk = gson.fromJson(taiKhoan, TaiKhoan.class);
        return taiKhoanService.SuaTaiKhoan(tk);
    }
    @DeleteMapping("taikhoan/xoa")
    public String XoaTaiKhoan(@RequestParam int id){
        return taiKhoanService.XoaTaiKhoan(id);
    }
    @GetMapping("taikhoan/danhsach")
    public Page<TaiKhoan> DanhSachTaiKhoan(@RequestParam int soTrang){
        return taiKhoanService.DanhSachTaiKhoan(soTrang);
    }
    @GetMapping("taikhoan/danhsach/tentaikhoan")
    public Page<TaiKhoan> TimTaiKhoanTheoTen(@RequestParam String tenTK,@RequestParam int soTrang){
        return taiKhoanService.TimTaiKhoanTheoTen(tenTK, soTrang);
    }
}
