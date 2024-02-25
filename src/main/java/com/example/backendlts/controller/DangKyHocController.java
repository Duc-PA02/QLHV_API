package com.example.backendlts.controller;

import com.example.backendlts.entity.DangKyHoc;
import com.example.backendlts.service.DangKyHocService;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.time.LocalDate;

@RestController
public class DangKyHocController {
    @Autowired
    DangKyHocService dangKyHocService;
    @PostMapping("dangkyhoc/them")
    public String ThemDangKy(@RequestBody String input){
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                return LocalDate.parse(json.getAsJsonPrimitive().getAsString());
            }
        }).create();
        DangKyHoc dkh = gson.fromJson(input, DangKyHoc.class);
        return dangKyHocService.ThemDangKy(dkh);
    }
    @PutMapping("dangkyhoc/sua")
    public String SuaDangKy(@RequestBody String input){
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                return LocalDate.parse(json.getAsJsonPrimitive().getAsString());
            }
        }).create();
        DangKyHoc dkh = gson.fromJson(input, DangKyHoc.class);
        return dangKyHocService.SuaDangKy(dkh);
    }
    @DeleteMapping("dangkyhoc/xoa")
    public String XoaDangKy(@RequestParam int id){
        return dangKyHocService.XoaDangKy(id);
    }
    @GetMapping("dangkyhoc/danhsach")
    public Page<DangKyHoc> DanhSachDangKy(@RequestParam int soTrang){
        return dangKyHocService.DanhSachDangKy(soTrang);
    }
}
