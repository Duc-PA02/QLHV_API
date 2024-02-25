package com.example.backendlts.controller;

import com.example.backendlts.entity.BaiViet;
import com.example.backendlts.service.BaiVietService;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.time.LocalDate;

@RestController
public class BaiVietController {
    @Autowired
    BaiVietService baiVietService;
    @PostMapping("baiviet/them")
    public String ThemBaiViet(@RequestBody String baiViet){
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                return LocalDate.parse(json.getAsJsonPrimitive().getAsString());
            }
        }).create();
        BaiViet bv = gson.fromJson(baiViet, BaiViet.class);
        return baiVietService.ThemBaiViet(bv);
    }
    @PutMapping("baiviet/sua")
    public String SuaBaiViet(@RequestBody String baiViet){
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                return LocalDate.parse(json.getAsJsonPrimitive().getAsString());
            }
        }).create();
        BaiViet bv = gson.fromJson(baiViet, BaiViet.class);
        return baiVietService.SuaBaiViet(bv);
    }
    @DeleteMapping("baiviet/xoa")
    public String XoaBaiViet(@RequestParam int id){
        return baiVietService.XoaBaiViet(id);
    }
    @GetMapping("baiviet/danhsach")
    public Page<BaiViet> DanhSachBaiViet(@RequestParam int soTrang){
        return baiVietService.DanhSachBaiViet(soTrang);
    }
    @GetMapping("baiviet/danhsach/tenbaiviet")
    public Page<BaiViet> TimBaiVietTheoTen(@RequestParam String tenBV,@RequestParam int soTrang){
        return baiVietService.TimBaiVietTheoTen(tenBV, soTrang);
    }
}
