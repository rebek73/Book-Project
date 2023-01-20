package com.book.demo.bookproject.serviceImpl;

import com.book.demo.bookproject.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("P1")
@Primary
public class PaymentServiceImpl implements PaymentService {

    private static Logger logger = LoggerFactory.getLogger(PaymentService.class);

    @Override
    public void printPayment() {
        logger.info("In PaymentServiceImpl");
    }
}
