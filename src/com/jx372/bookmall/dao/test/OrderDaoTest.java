package com.jx372.bookmall.dao.test;

import java.util.List;

import com.jx372.bookmall.dao.OrderDao;
import com.jx372.bookmall.vo.BookVo;

public class OrderDaoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//insertTest();
		selectTest();
		//selectTest(1);
		//deleteTest(1);	
		//updateTest();
		
	}
	
	
	public static void insertTest(){
		
		BookVo BookVo=new BookVo();
		BookVo.setMem_id(1);
		BookVo.setPrice(53000);
		BookVo.setAddress("서울시 은평구 진관동 구파발 레미안APT");

	
	
		
		new OrderDao().insert(BookVo);
		
	}
	
public static void selectTest(){
		
		List<BookVo> list=new OrderDao().getList();
		
		System.out.println("주문 리스트");
		System.out.println();
		
		for( BookVo vo  : list ) { 
			
			System.out.println(vo.getOrder_id()+", "+vo.getMem_name()+"/"+vo.getEmail()+", "+vo.getPrice()+", "+vo.getAddress());
			
			
		}
		System.out.println("=========================================================================");
		
	}
	public static void selectTest(int no){
		
		BookVo vo=new OrderDao().get(no);
		
	
			
		System.out.println(vo.getOrder_id()+", "+vo.getMem_name()+"/"+vo.getEmail()+", "+vo.getPrice()+", "+vo.getAddress());
		
			
			
		
		
	}
	public static void deleteTest(int no){
		
		new OrderDao().delete( no ); 
		
		
	}
	public static void updateTest(){
		
		BookVo BookVo=new BookVo();
		
		BookVo.setOrder_id(1);
		BookVo.setMem_id(1);
		BookVo.setPrice(63000);
		BookVo.setAddress("서울시 은평구 진관동 구파발 레미안APT 100동 ");

		
		
		
		new OrderDao().update(BookVo);
		
	}

}
