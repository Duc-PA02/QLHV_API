package com.example.backendlts.controller;

import com.example.backendlts.entity.ChuDe;
import com.example.backendlts.service.ChuDeService;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.time.LocalDate;

@RestController
public class ChuDeController {
    @Autowired
    ChuDeService chuDeService;
    @PostMapping("chude/them")
    public String ThemChuDe(@RequestBody String chuDe){
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                return LocalDate.parse(json.getAsJsonPrimitive().getAsString());
            }
        }).create();
        ChuDe cd = gson.fromJson(chuDe, ChuDe.class);
        return chuDeService.ThemChuDe(cd);
    }
    @PutMapping("chude/sua")
    public String SuaChuDe(@RequestBody String chuDe){
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                return LocalDate.parse(json.getAsJsonPrimitive().getAsString());
            }
        }).create();
        ChuDe cd = gson.fromJson(chuDe, ChuDe.class);
        return chuDeService.SuaChuDe(cd);
    }
    @DeleteMapping("chude/xoa")
    public String XoaChuDe(@RequestParam int id){
        return chuDeService.XoaChuDe(id);
    }
    @GetMapping("chude/danhsach")
    public Page<ChuDe> DanhSachChuDe(@RequestParam int soTrang){
        return chuDeService.DanhSachChuDe(soTrang);
    }
}
