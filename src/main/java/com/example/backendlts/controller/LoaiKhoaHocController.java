package com.example.backendlts.controller;

import com.example.backendlts.entity.LoaiKhoaHoc;
import com.example.backendlts.service.LoaiKhoaHocService;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.time.LocalDate;

@RestController
public class LoaiKhoaHocController {
    @Autowired
    LoaiKhoaHocService loaiKhoaHocService;
    @PostMapping("loaikhoahoc/them")
    public String ThemLoaiKH(@RequestBody String loaiKhoaHoc){
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                return LocalDate.parse(json.getAsJsonPrimitive().getAsString());
            }
        }).create();
        LoaiKhoaHoc loaiKH = gson.fromJson(loaiKhoaHoc, LoaiKhoaHoc.class);
        return loaiKhoaHocService.ThemLoaiKhoaHoc(loaiKH);
    }
    @PutMapping("loaikhoahoc/sua")
    public String SuaLoaiKH(@RequestBody String loaiKhoaHoc){
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                return LocalDate.parse(json.getAsJsonPrimitive().getAsString());
            }
        }).create();
        LoaiKhoaHoc loaiKH = gson.fromJson(loaiKhoaHoc, LoaiKhoaHoc.class);
        return loaiKhoaHocService.SuaLoaiKhoaHoc(loaiKH);
    }
    @DeleteMapping("loaikhoahoc/xoa")
    public String XoaLoaiKH(@RequestParam int id){
        return loaiKhoaHocService.XoaLoaiKhoaHoc(id);
    }
}
