package com.example.backendlts.controller;

import com.example.backendlts.entity.LoaiKhoaHoc;
import com.example.backendlts.entity.TinhTrangHoc;
import com.example.backendlts.service.TinhTrangHocService;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;

@RestController
public class TinhTrangHocController {
    @Autowired
    TinhTrangHocService tinhTrangHocService;
    @PostMapping("tinhtranghoc/them")
    public String ThemTinhTrang(@RequestBody String tinhTrangHoc){
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                return LocalDate.parse(json.getAsJsonPrimitive().getAsString());
            }
        }).create();
        TinhTrangHoc tth = gson.fromJson(tinhTrangHoc, TinhTrangHoc.class);
        return tinhTrangHocService.ThemTinhTrangHoc(tth);
    }
    @PutMapping("tinhtranghoc/sua")
    public String SuaTinhTrang(@RequestBody String tinhTrangHoc) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                return LocalDate.parse(json.getAsJsonPrimitive().getAsString());
            }
        }).create();
        TinhTrangHoc tth = gson.fromJson(tinhTrangHoc, TinhTrangHoc.class);
        return tinhTrangHocService.SuaTinhTrangHoc(tth);
    }
    @DeleteMapping("tinhtranghoc/xoa")
    public String XoaTinhTrang(@RequestParam int id){
        return tinhTrangHocService.XoaTinhTrangHoc(id);
    }
    @GetMapping("tinhtranghoc/danhsach")
    public List<TinhTrangHoc> DanhSach(){
        return tinhTrangHocService.DanhSachTinhTrangHoc();
    }
}
