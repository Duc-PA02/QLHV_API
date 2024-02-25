package com.example.backendlts.controller;

import com.example.backendlts.entity.KhoaHoc;
import com.example.backendlts.service.KhoaHocService;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.time.LocalDate;

@RestController
public class KhoaHocController {
    @Autowired
    KhoaHocService khoaHocService;
    @PostMapping("khoahoc/them")
    public String ThemKhoaHoc(@RequestBody String khoaHoc){
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                return LocalDate.parse(json.getAsJsonPrimitive().getAsString());
            }
        }).create();
        KhoaHoc kh = gson.fromJson(khoaHoc, KhoaHoc.class);
        return khoaHocService.ThemKhoaHoc(kh);
    }
    @PutMapping("khoahoc/sua")
    public String SuaKhoaHoc(@RequestBody String khoaHoc){
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                return LocalDate.parse(json.getAsJsonPrimitive().getAsString());
            }
        }).create();
        KhoaHoc kh = gson.fromJson(khoaHoc, KhoaHoc.class);
        return khoaHocService.SuaKhoaHoc(kh);
    }
    @DeleteMapping("khoahoc/xoa")
    public String XoaKhoaHoc(@RequestParam int id){
        return khoaHocService.XoaKhoaHoc(id);
    }
    @GetMapping("khoahoc/danhsach")
    public Page<KhoaHoc> DanhSachKhoaHoc(@RequestParam int soTrang){
        return khoaHocService.HienThiDanhSachKhoaHoc(soTrang);
    }
    @GetMapping("khoahoc/danhsach/tenkhoahoc")
    public Page<KhoaHoc> TimKiemTheoTen(@RequestParam String tenKH,@RequestParam int soTrang){
        return khoaHocService.TimKiemKhoaHoc(tenKH, soTrang);
    }
}
