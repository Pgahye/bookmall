package com.jx372.bookmall.vo;

public class BookVo {
	
	
	private int book_id;
	private String book_name;
	private int price;
	private int ca_id;
	private String ca_name;
	
	private int mem_id;
	private int num;
	
	private String mem_name;
	private String phone_num;
	private String email;
	
	private int order_id;
	private String address;
	private int sum;
	
	
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCa_id() {
		return ca_id;
	}
	public void setCa_id(int ca_id) {
		this.ca_id = ca_id;
	}
	public String getCa_name() {
		return ca_name;
	}
	public void setCa_name(String ca_name) {
		this.ca_name = ca_name;
	}
	public int getMem_id() {
		return mem_id;
	}
	public void setMem_id(int mem_id) {
		this.mem_id = mem_id;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getPhone_num() {
		return phone_num;
	}
	public void setPhone_num(String phone_num) {
		this.phone_num = phone_num;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	private String pwd;


	@Override
	public String toString() {
		return "BookVo [book_id=" + book_id + ", book_name=" + book_name + ", price=" + price + ", ca_id=" + ca_id
				+ ", ca_name=" + ca_name + ", mem_id=" + mem_id + ", num=" + num + ", mem_name=" + mem_name
				+ ", phone_num=" + phone_num + ", email=" + email + ", order_id=" + order_id + ", address=" + address
				+ ", pwd=" + pwd + "]";
	}
	
	

	
	

	
	
	
	

}
