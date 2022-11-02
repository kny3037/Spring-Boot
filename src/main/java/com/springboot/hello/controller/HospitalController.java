package com.springboot.hello.controller;


import com.springboot.hello.dao.HospitalDao;
import com.springboot.hello.domian.Hospital;
import com.springboot.hello.parser.ReadLineContext;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/hospital")
public class HospitalController {
    private final HospitalDao hospitalDao;
    private final ReadLineContext<Hospital> hospitalReadLineContext;

    public HospitalController(HospitalDao hospitalDao, ReadLineContext<Hospital> hospitalReadLineContext) {
        this.hospitalDao = hospitalDao;
        this.hospitalReadLineContext = hospitalReadLineContext;
    }

    @PostMapping("/insert")
    public String add() throws IOException {
        List<Hospital> hospitalList = hospitalReadLineContext.readByLine("fulldata_01_01_02_P_의원.csv");
        for (Hospital hospital : hospitalList){
            hospitalDao.add(hospital);
        }
        return "정상적으로 insert 되었습니다. ";
    }

    @DeleteMapping("/deleteAll")
    public void delete(){
        hospitalDao.deleteAll();
    }





}
