package com.omnm.pay.DAO;


import com.omnm.pay.Entity.Pay;
import com.omnm.pay.Repository.PayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
@Repository
public class PayDao {
    @Autowired
    PayRepository payRepository;

    public PayDao()  {
        super();
    }
    public boolean create(Pay pay) {
        if(payRepository.save(pay)==null) return false;
//        String query ="insert into pay values ("+
//                pay.getId()+", "+
//                pay.getContractId()+", "+
//                "'"+pay.getCardNumber()+"'"+");";
        return true;
    }
    public ArrayList<Pay> retrieve() {
//        ArrayList<Pay> payList = new ArrayList<>();
//        String query = "select * from pay;";
//        resultSet=this.retrieve(query);
//        try {
//            while(resultSet.next()) {
//                Pay pay = new Pay(resultSet.getInt(2), resultSet.getString(3));
//                pay.setId(resultSet.getInt(1));
//                payList.add(pay);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return new ArrayList<>();
//        }
        ArrayList<Pay> accidentList = new ArrayList<>(payRepository.findAll());
        return accidentList;
    }
    public int add(Pay pay) {
        ArrayList<Pay> PayList = retrieve();
        if(PayList.size()==0)pay.setId(1);
        else {pay.setId(PayList.get(PayList.size()-1).getId()+1);}
        if(create(pay)) return pay.getId();
        else {return 0;}
    }
	public Pay findById(int payId) {
		for(Pay pay:retrieve()) {
			if(pay.getId()==payId)
				return pay;
		}
		return null;
	}
}
