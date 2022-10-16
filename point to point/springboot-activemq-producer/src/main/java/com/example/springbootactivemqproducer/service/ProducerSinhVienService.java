package com.example.springbootactivemqproducer.service;

import com.example.springbootactivemqproducer.config.ActiveMQConfiguration;
import com.example.springbootactivemqproducer.model.SinhVien;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerSinhVienService {
    private static Logger log = LoggerFactory.getLogger(ProducerSinhVienService.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendSinhVien(String maSV, String tenSV, String lop){
        SinhVien sinhVien = new SinhVien(maSV, tenSV, lop);
        log.info("Sending customer message" + sinhVien.toString() + " to queue " + ActiveMQConfiguration.SINHVIEN_QUEUE);
        jmsTemplate.convertAndSend(ActiveMQConfiguration.SINHVIEN_QUEUE, sinhVien);
    }
}
