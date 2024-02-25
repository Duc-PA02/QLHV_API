package com.example.backendlts.controller;

import com.example.backendlts.entity.QuyenHan;
import com.example.backendlts.service.QuyenHanService;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.time.LocalDate;

@RestController
public class QuyenHanController {
    @Autowired
    QuyenHanService quyenHanService;
    @PostMapping("quyenhan/them")
    public String ThemQuyenHan(@RequestBody String quyenHan){
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                return LocalDate.parse(json.getAsJsonPrimitive().getAsString());
            }
        }).create();
        QuyenHan qh = gson.fromJson(quyenHan,QuyenHan.class);
        return quyenHanService.ThemQuyenHan(qh);
    }
    @PutMapping("quyenhan/sua")
    public String SuaQuyenHan(@RequestBody String quyenHan){
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                return LocalDate.parse(json.getAsJsonPrimitive().getAsString());
            }
        }).create();
        QuyenHan qh = gson.fromJson(quyenHan,QuyenHan.class);
        return quyenHanService.SuaQuyenHan(qh);
    }
    @DeleteMapping("quyenhan/xoa")
    public String XoaQuyenHan(@RequestParam int id){
        return quyenHanService.XoaQuyenHan(id);
    }
    @GetMapping("quyenhan/danhsach")
    public Page<QuyenHan> DanhSachQuyenHan(@RequestParam int soTrang){
        return quyenHanService.DanhSachQuyenHan(soTrang);
    }
}
