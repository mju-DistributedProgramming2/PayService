package com.omnm.pay.Controller;

import com.omnm.pay.DTO.PayRequest;
import com.omnm.pay.Service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.rmi.RemoteException;

@RestController
public class PayController {
    @Autowired
    PayService payService;
    @PostMapping("/pay")
    public ResponseEntity<Integer> postPay(@RequestBody PayRequest payRequest) throws RemoteException {
        return payService.postPay(payRequest.getContract(),payRequest.getPay());
    }
}
