package com.example.springbootactivemqproducer.config;

import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.broker.region.policy.PolicyEntry;
import org.apache.activemq.broker.region.policy.PolicyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import java.util.ArrayList;
import java.util.List;

@EnableJms
@Configuration
public class ActiveMQConfiguration {
    public static final String SINHVIEN_QUEUE = "sinhvien_queue";
    @Bean
    public MessageConverter messageConverter(){
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }

    @Bean
    public BrokerService broker() throws Exception {
        BrokerService brokerService = new BrokerService();
       // brokerService.addConnector("tcp://localhost:61616");
        brokerService.setPersistent(false);
       // brokerService.setDestinationPolicy(policyMap());
        return brokerService;
    }

//    @Bean
//    public PolicyMap policyMap(){
//        PolicyMap destinationPoliciy = new PolicyMap();
//        List<PolicyEntry> entries = new ArrayList<PolicyEntry>();
//        PolicyEntry queueEntry = new PolicyEntry();
//        queueEntry.setQueue(">");
//        queueEntry.setStrictOrderDispatch(false);
//        entries.add(queueEntry);
//        destinationPoliciy.setPolicyEntries(entries);
//        return destinationPoliciy;
//    }
}
