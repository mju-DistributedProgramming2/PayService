package com.omnm.pay.Service;

import com.omnm.pay.Entity.Contract;
import com.omnm.pay.Entity.customerInfo.CustomerInfo;
import com.omnm.pay.enumeration.contract.ContractStatus;
import com.omnm.pay.exception.EmptyListException;
import com.omnm.pay.exception.NoDataException;
import com.omnm.pay.exception.TimeDelayException;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public interface ContractServiceIF  extends Remote {
    ArrayList<Contract> getContractList(ContractStatus status) throws EmptyListException, RemoteException, TimeDelayException;

    ArrayList<Contract> getContractList(String customerId) throws RemoteException, EmptyListException, TimeDelayException;

    ArrayList<Contract> getContractList(String customerId, ContractStatus status) throws RemoteException, EmptyListException, TimeDelayException;

    Contract getContract(int contractId) throws RemoteException, NoDataException;

    int applyInsurance(Contract contract, CustomerInfo customerInfo) throws RemoteException;

    boolean conclude(int id) throws NoDataException, RemoteException;

    boolean examineUnderwrite(int contractId, ContractStatus status) throws RemoteException;

    ArrayList<Contract> getUnpaidContractList(String customerId) throws RemoteException, EmptyListException, TimeDelayException;

    boolean setPaymentDeadline(int id, LocalDateTime deadline) throws RemoteException;
}
