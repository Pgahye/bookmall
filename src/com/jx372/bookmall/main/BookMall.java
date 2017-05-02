package com.jx372.bookmall.main;

import com.jx372.bookmall.dao.test.BookDaoTest;
import com.jx372.bookmall.dao.test.CartDaoTest;
import com.jx372.bookmall.dao.test.CategoryDaoTest;
import com.jx372.bookmall.dao.test.MemberDaoTest;
import com.jx372.bookmall.dao.test.OrderBookDaoTest;
import com.jx372.bookmall.dao.test.OrderDaoTest;

public class BookMall {

	public static void main(String[] args) {

		MemberDaoTest.selectTest();

		CategoryDaoTest.selectTest();

		BookDaoTest.selectTest();

		CartDaoTest.selectTest();

		OrderDaoTest.selectTest();

		OrderBookDaoTest.selectTest();
	}

}
