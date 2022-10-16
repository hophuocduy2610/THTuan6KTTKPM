package com.example.springbootactivemqproducer.listener;

import com.example.springbootactivemqproducer.config.ActiveMQConfiguration;
import com.example.springbootactivemqproducer.model.SinhVien;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerSinhVien {
    private static final Logger log = LoggerFactory.getLogger(ConsumerSinhVien.class);

    @JmsListener(destination = ActiveMQConfiguration.SINHVIEN_QUEUE)
    public void receiveCustomer(SinhVien sinhVien) {
        log.info("Received Customer message: " + sinhVien.toString());
    }
}
