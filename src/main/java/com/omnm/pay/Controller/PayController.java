package com.omnm.pay.Controller;

import com.omnm.pay.DTO.PayRequest;
import com.omnm.pay.DTO.PayResponse;
import com.omnm.pay.Service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.rmi.RemoteException;

@RestController
public class PayController {
    @Autowired
    PayService payService;
    @PostMapping("/pay")
    public PayResponse pay(@RequestBody PayRequest payRequest) throws RemoteException {
        int payId = payService.pay(payRequest.getContract(),payRequest.getPay());
        PayResponse payResponse = new PayResponse();
        payResponse.setPayId(payId);
        return payResponse;
    }
}
