package com.book.demo.bookproject.controller;

import com.book.demo.bookproject.config.CustomConfig;
import com.book.demo.bookproject.model.Demo;
import com.book.demo.bookproject.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class DemoController {

    @Autowired
    PaymentService paymentService;

    @Autowired
    CustomConfig customConfig;
    private static final Logger logger = LoggerFactory.getLogger(DemoController.class);

    @GetMapping("/demo")
    public Demo getDemo(){
        Demo demo = new Demo();
        logger.info("Demo Object is; {}", demo);
        paymentService.printPayment();
        return demo;
    }

    @PostMapping("/demo")
    public Demo saveDemo(){
        Demo demo = new Demo();
        logger.info("Demo Object is: {}",demo);
        paymentService.printPayment();
        return demo;
    }


    @GetMapping("/requestParam")
    public void requestParamMethod(@RequestParam String name){
        logger.info("Request Param received with: {}",name);
    }

    @GetMapping("/pathVariable/{id}/bookISBN/{bookISBN}")
    public void requestParamMethod(@PathVariable int id, @PathVariable String bookISBN){
        logger.info("Path Variable received with: {} Book's ISBN received {}", id, bookISBN );
    }

    @GetMapping("/requestBody/")
    public Demo requestParamMethod(@RequestBody Demo demoObj){
        logger.info("Request Body received with: {}",demoObj.getBookTitle());
        return demoObj;
    }

    @GetMapping("/getTemplate")
    public void getTemplate(){
        logger.info("In DemoController: {}", customConfig.getTemplate());
    }

}
