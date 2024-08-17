package DAO;

import java.util.Date;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Department obj = new Department(1,"Teste");
		Seller sell = new Seller(21,"Bob","bob",new Date(),3000.0,obj);
		
		System.out.println(sell);
	}

}
