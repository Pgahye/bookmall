package com.jx372.bookmall.dao.test;

import java.util.List;

import com.jx372.bookmall.dao.CategoryDao;
import com.jx372.bookmall.vo.BookVo;



public class CategoryDaoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//insertTest();
		selectTest();
		//selectTest(3L);
		//deleteTest(2);	
		//updateTest();
		
	}
	
	
	public static void insertTest(){
		
		BookVo BookVo=new BookVo();
		BookVo.setCa_name("만화");
	
		
		new CategoryDao().insert(BookVo);
		
	}
	
public static void selectTest(){
	
		
		List<BookVo> list=new CategoryDao().getList();
		
		
		System.out.println("카테고리 리스트");
		System.out.println();
		
		for( BookVo vo  : list ) { 
			
			System.out.println(vo.getCa_id()+" "+vo.getCa_name());
			
			
		}
		
		System.out.println("=========================================================================");
		
	}
	public static void selectTest(int no){
		
		BookVo list=new  CategoryDao().get(no);
		
	
			
			System.out.println(list.getCa_id()+ " "+ list.getCa_name());
			
			
		
		
	}
	public static void deleteTest(int no){
		
		new CategoryDao().delete( no ); 
		
		
	}
	public static void updateTest(){
		
		BookVo BookVo=new BookVo();
		BookVo.setCa_id(6);
		BookVo.setCa_name("코믹만화");

		
		new CategoryDao().update(BookVo);
		
	}

}
