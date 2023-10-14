package com.expenseSharingApp.expenseSharingApp.controllers;

import com.expenseSharingApp.expenseSharingApp.dtos.PaymentDTO;
import com.expenseSharingApp.expenseSharingApp.entities.Payment;
import com.expenseSharingApp.expenseSharingApp.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public ResponseEntity<Payment> pay (@RequestBody PaymentDTO pay) {
        return new ResponseEntity<>(paymentService.pay(pay), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Payment>> listPayments (@RequestParam String idUser) {
        return new ResponseEntity<>(paymentService.listPayments(idUser), HttpStatus.OK);
    }
}
