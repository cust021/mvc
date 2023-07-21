package com.mvc;

public class Constructor { // 생성자
	int num ;
	public Constructor() {
		System.out.println(num);
	}

	public Constructor(int num) {
		this.num= num;
		System.out.println(num);
	}

	

	void test() {
		System.out.println("나 이미 머리 속에 있어서 생성자에서 호출됨!");
	}
}

class Execute {
	public static void main(String[] args) { // 생성자는 데이터 타입 x
		Constructor c = new Constructor(100);
		System.out.println(c.num);
		

	}
}