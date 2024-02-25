package com.example.backendlts.controller;

import com.example.backendlts.entity.LoaiBaiViet;
import com.example.backendlts.service.LoaiBaiVietService;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.time.LocalDate;

@RestController
public class LoaiBaiVietController {
    @Autowired
    LoaiBaiVietService loaiBaiVietService;
    @PostMapping("loaibaiviet/them")
    public String ThemLBV(@RequestBody String loaiBaiViet){
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                return LocalDate.parse(json.getAsJsonPrimitive().getAsString());
            }
        }).create();
        LoaiBaiViet lbv = gson.fromJson(loaiBaiViet, LoaiBaiViet.class);
        return loaiBaiVietService.ThemLoaiBaiViet(lbv);
    }
    @PutMapping("loaibaiviet/sua")
    public String SuaLBV(@RequestBody String loaiBaiViet){
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                return LocalDate.parse(json.getAsJsonPrimitive().getAsString());
            }
        }).create();
        LoaiBaiViet lbv = gson.fromJson(loaiBaiViet, LoaiBaiViet.class);
        return loaiBaiVietService.SuaLoaiBaiViet(lbv);
    }
    @DeleteMapping("loaibaiviet/xoa")
    public String XoaLBV(@RequestParam int id){
        return loaiBaiVietService.XoaLoaiBaiViet(id);
    }
    @GetMapping("loaibaiviet/danhsach")
    public Page<LoaiBaiViet> DanhSachLBV(@RequestParam int soTrang){
        return loaiBaiVietService.DanhSachLoaiBaiViet(soTrang);
    }
}
