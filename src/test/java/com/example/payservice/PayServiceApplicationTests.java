package com.example.payservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.omnm.pay.Controller.PayController;
import com.omnm.pay.DTO.PostPayRequest;
import com.omnm.pay.Entity.Contract;
import com.omnm.pay.Entity.Pay;
import com.omnm.pay.PayServiceApplication;
import com.omnm.pay.Service.PayService;
import com.omnm.pay.enumeration.contract.ContractStatus;
import com.omnm.pay.enumeration.contract.ContractTerm;
import com.omnm.pay.enumeration.contract.PaymentCycle;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import reactor.retry.Repeat;

import java.rmi.RemoteException;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static org.mockito.Mockito.*;


@SpringBootTest(classes = PayServiceApplication.class)
@AutoConfigureMockMvc
class PayServiceApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PayService payService;

    @InjectMocks
    private PayController payController;

    @Test
    public void testPostPay() throws Exception {
        Contract contract = new Contract(1,1,"1","1", ContractTerm.OneYear,3000, PaymentCycle.AMonth,10000, ContractStatus.Apply);
        contract.setId(1);
        Pay pay = new Pay(1,"123");
        when(payService.postPay(contract, pay)).thenReturn(ResponseEntity.ok(200));

        // Creating a PostPayRequest
        PostPayRequest postPayRequest = new PostPayRequest();
        postPayRequest.setContract(contract);
        postPayRequest.setPay(pay);

        // Performing the POST request
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/pay")
                        .content(new ObjectMapper().writeValueAsString(postPayRequest))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        String responseContent = result.getResponse().getContentAsString();

        Mockito.verify(payService, times(1)).postPay(any(Contract.class), any(Pay.class));


    }


}