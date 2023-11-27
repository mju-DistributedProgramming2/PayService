package com.omnm.pay.Service;


import com.omnm.pay.Entity.Contract;
import com.omnm.pay.Entity.Pay;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PayServiceIF  extends Remote {
    void setContractService(ContractServiceIF contractService) throws RemoteException;

    int pay(Contract contract, Pay pay) throws RemoteException;
}
