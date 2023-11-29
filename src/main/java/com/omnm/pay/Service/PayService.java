package com.omnm.pay.Service;

import com.omnm.pay.DAO.PayDao;
import com.omnm.pay.Entity.Contract;
import com.omnm.pay.Entity.Pay;
import com.omnm.pay.enumeration.contract.PaymentCycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Service
public class PayService implements PayServiceIF {
    @Autowired
    PayDao payDao;
    @Override
    public ResponseEntity<Integer> postPay(Contract contract, Pay pay) throws RemoteException{
        int cycle= PaymentCycle.getCycle(contract.getPayCycle());
        Timestamp deadline= contract.getPaymentDeadline();
        LocalDateTime newDeadline = deadline.toLocalDateTime();
        newDeadline = newDeadline.plus(cycle, ChronoUnit.MONTHS);
        boolean isSuccess = setPaymentDeadline(contract.getId(), newDeadline);
        if(!isSuccess) return new ResponseEntity<>(0,new HttpHeaders(), HttpStatus.valueOf(500));
        return new ResponseEntity<>(this.payDao.createPay(pay),new HttpHeaders(), HttpStatus.valueOf(200));
    }

    private boolean setPaymentDeadline(int id, LocalDateTime newDeadline) {
//        PatchRestTemplate template = new PatchRestTemplate();
//        URI uri = UriComponentsBuilder
//                .fromUriString(Constants.BASE_URL)
//                .path(Constants.CONTRACT_SERVICE_GET_CONTRACT_URL + "status")
//                .encode()
//                .build()
//                .toUri();
//
//        SetStatusRequest setStatusRequest = new SetStatusRequest();
//        setStatusRequest.setAccidentId(accidentId);
//        setStatusRequest.setStatus(status);
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//
//        HttpEntity requestEntity = new HttpEntity(setStatusRequest, headers);
//        System.out.println(requestEntity.getBody());
//
//        ResponseEntity<SetStatusResponse> result = template.exchange(uri, HttpMethod.PATCH, requestEntity, SetStatusResponse.class);
//
//        System.out.println("Status Code: " + result.getStatusCode());
//        System.out.println("Response Body: " + result.getBody());

        return true;
    }
}
