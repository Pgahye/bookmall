package com.jx372.bookmall.dao.test;

import java.util.List;

import com.jx372.bookmall.dao.BookDao;
import com.jx372.bookmall.vo.BookVo;

public class BookDaoTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//insertTest();
		selectTest();
		//selectTest(2);
		//deleteTest(2);	
		//updateTest();
		
	}
	
	
	public static void insertTest(){
		
		BookVo BookVo=new BookVo();
		BookVo.setBook_name("아큐정전");
		BookVo.setPrice(10000);
		BookVo.setCa_id(1);
	
	
		
		new BookDao().insert(BookVo);
		
	}
	
public static void selectTest(){
		
		List<BookVo> list=new BookDao().getList();
		
		System.out.println("상품 리스트");
		System.out.println();
		
		for( BookVo vo  : list ) { 
			
			System.out.println(vo.getBook_id()+", "+vo.getBook_name()+", "+vo.getCa_name()+", "+vo.getPrice());
			
			
		}
		System.out.println("=========================================================================");
	}
	public static void selectTest(int no){
		
		BookVo vo=new BookDao().get(no);
		
	
			
		System.out.println(vo.getBook_id()+", "+vo.getBook_name()+", "+vo.getCa_name()+", "+vo.getPrice());
		
			
			
		
		
	}
	public static void deleteTest(int no){
		
		new BookDao().delete( no ); 
		
		
	}
	public static void updateTest(){
		
		BookVo BookVo=new BookVo();
		
		BookVo.setBook_id(4);
		
		BookVo.setBook_name("아큐정전1");
		BookVo.setPrice(100001);
		BookVo.setCa_id(1);
		
		
		
		new BookDao().update(BookVo);
		
	}
}
