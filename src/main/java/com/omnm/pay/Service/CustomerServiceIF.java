package com.omnm.pay.Service;


import com.omnm.pay.Entity.Customer;
import com.omnm.pay.Entity.customerInfo.CustomerInfo;
import com.omnm.pay.exception.DataDuplicationException;
import com.omnm.pay.exception.EmptyListException;
import com.omnm.pay.exception.NoDataException;
import com.omnm.pay.exception.TimeDelayException;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface CustomerServiceIF  extends Remote {
    boolean registerCustomer(Customer customer) throws RemoteException, DataDuplicationException;

    Customer loginCustomer(String id, String password) throws RemoteException, NoDataException;

    Customer getCustomer(String selectedCustomerId) throws RemoteException, NoDataException;

    ArrayList<Customer> getCustomerList() throws RemoteException, EmptyListException, TimeDelayException;

    CustomerInfo getInfo(int infoId) throws RemoteException, NoDataException;

    int makeInfo(CustomerInfo customerInfo) throws RemoteException;
}
