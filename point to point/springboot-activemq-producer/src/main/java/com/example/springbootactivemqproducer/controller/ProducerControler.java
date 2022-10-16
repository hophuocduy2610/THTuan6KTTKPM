package com.example.springbootactivemqproducer.controller;

import com.example.springbootactivemqproducer.service.ProducerSinhVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProducerControler {
    @Autowired
    private ProducerSinhVienService producerSinhVienService;

    @RequestMapping(path = "/sendsinhvien/{masv}/{tensv}/{lop}", method = RequestMethod.POST)
    public void produceCustomer(@PathVariable("masv") String maSV, @PathVariable("tensv") String tenSV, @PathVariable("lop") String lop){
           producerSinhVienService.sendSinhVien(maSV, tenSV, lop);
    }
}
