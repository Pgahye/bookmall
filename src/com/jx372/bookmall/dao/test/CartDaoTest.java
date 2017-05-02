package com.jx372.bookmall.dao.test;

import java.util.List;

import com.jx372.bookmall.dao.CartDao;
import com.jx372.bookmall.vo.BookVo;

public class CartDaoTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//insertTest();
		selectTest();
		//selectTest(1,1); //맴버- 책 순
		//deleteTest(2);	
		//updateTest();
		
	}
	
	
	public static void insertTest(){
		
		BookVo BookVo=new BookVo();
		BookVo.setMem_id(1);
		BookVo.setBook_id(2);
		BookVo.setNum(2);
	
	
		
		new CartDao().insert(BookVo);
		
	}
	
public static void selectTest(){
		
		List<BookVo> list=new CartDao().getList();
		
		
		System.out.println("카트 리스트");
		System.out.println();
		
		
		for( BookVo vo  : list ) { 
			
			System.out.println(vo.getMem_id()+", "+vo.getMem_name()+", "+vo.getBook_name()+", "+vo.getNum()+", "+vo.getSum());
			
			
		}
		System.out.println("=========================================================================");
		
	}
	public static void selectTest(int no, int no2){
		
		BookVo vo=new CartDao().get(no, no2);
		
	
			
		System.out.println(vo.getMem_id()+", "+vo.getMem_name()+", "+vo.getBook_name()+", "+vo.getNum()+", "+vo.getSum());
		
			
			
		
		
	}
	public static void deleteTest(int no, int no2){
		
		new CartDao().delete( no,no2 ); 
		
		
	}
	public static void updateTest(){
		
		BookVo BookVo=new BookVo();
		
		
		
		BookVo.setMem_id(1);
		BookVo.setBook_id(2);
		BookVo.setNum(2);
		
		
		new CartDao().update(BookVo);
		
	}
}
