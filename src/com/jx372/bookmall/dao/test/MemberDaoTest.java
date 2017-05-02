package com.jx372.bookmall.dao.test;

import java.util.List;


import com.jx372.bookmall.dao.MemberDao;
import com.jx372.bookmall.vo.BookVo;

public class MemberDaoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//insertTest();
		//selectTest();
		//selectTest(3L);
		//deleteTest(2);	
		//updateTest();
		
	}
	
	
	public static void insertTest(){
		
		BookVo BookVo=new BookVo();
		BookVo.setMem_name("안대혁");
		BookVo.setPhone_num("010-4761-6934");
		BookVo.setEmail("kickscar@gmail.com");
		BookVo.setPwd("1234");
	
		
		new MemberDao().insert(BookVo);
		
	}
	
public static void selectTest(){
		
		List<BookVo> list=new MemberDao().getList();
		
		System.out.println("회원정보");
		System.out.println();
		
		for( BookVo vo  : list ) { 
			
			System.out.println(vo.getMem_id()+", "+vo.getMem_name()+", "+vo.getPhone_num()+", "+vo.getEmail()+", "+vo.getPwd());
			
			
		}
		
		System.out.println("=========================================================================");
		
	}
	public static void selectTest(int no){
		
		BookVo vo=new  MemberDao().get(no);
		
	
			
		System.out.println(vo.getMem_id()+", "+vo.getMem_name()+", "+vo.getPhone_num()+", "+vo.getEmail()+", "+vo.getPwd());
		
			
			
		
		
	}
	public static void deleteTest(int no){
		
		new MemberDao().delete( no ); 
		
		
	}
	public static void updateTest(){
		
		BookVo BookVo=new BookVo();
		
		BookVo.setMem_id(1);
		
		BookVo.setMem_name("안대혁1");
		BookVo.setPhone_num("010-4761-69341");
		BookVo.setEmail("kickscar@gmail.com1");
		BookVo.setPwd("12341");
		
		new MemberDao().update(BookVo);
		
	}
}
