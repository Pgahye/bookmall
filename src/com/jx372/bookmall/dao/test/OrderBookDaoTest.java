package com.jx372.bookmall.dao.test;

import java.util.List;

import com.jx372.bookmall.dao.BookDao;
import com.jx372.bookmall.dao.OrderBookDao;
import com.jx372.bookmall.vo.BookVo;

public class OrderBookDaoTest {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//insertTest();
		selectTest();
		//selectTest(1,1); //주문번호 책 
		//deleteTest(2);	
		//updateTest();
		
	}
	
	
	public static void insertTest(){
		
		BookVo BookVo=new BookVo();
		BookVo.setOrder_id(1);
		BookVo.setBook_id(4);
		BookVo.setNum(2);
	
	
		
		new OrderBookDao().insert(BookVo);
		
	}
	
public static void selectTest(){
		
		List<BookVo> list=new  OrderBookDao().getList();
		
		System.out.println("주문 도서 리스트");
		System.out.println();
		
		for( BookVo vo  : list ) { 
			
			System.out.println(vo.getBook_id()+", "+vo.getBook_name()+", "+vo.getNum());
			
			
		}
		
	}
	public static void selectTest(int no, int no2){
		
		BookVo vo=new  OrderBookDao().get(no, no2);
		
	
			
		System.out.println(vo.getOrder_id()+", "+vo.getBook_id()+", "+vo.getBook_name()+", "+vo.getNum());
		
			
			
		
		
	}
	public static void deleteTest(int no, int no2){
		
		new  OrderBookDao().delete( no,no2 ); 
		
		
	}
	public static void updateTest(){
		
		BookVo BookVo=new BookVo();
		
		
		
		BookVo.setOrder_id(1);
		BookVo.setBook_id(4);
		BookVo.setNum(3);
		
		
		new  OrderBookDao().update(BookVo);
		
	}
	
	
	
	
	
	

}
