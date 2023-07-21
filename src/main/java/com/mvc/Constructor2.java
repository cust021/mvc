package com.mvc;

class Test{
	public String name;
	
	public Test(String name) {
		this.name = name;
	}
	
	public void printName() {
		System.out.println("아빠 : " + name);
	}
}
public class Constructor2 extends Test{
	
	public Constructor2(String name1) {      
		super(name1);							//super
	}
	
	public void printName() {
		super.printName();
		System.out.println("아들 : " + name); //상속 받아 기존에 있던 printName 위에 올라감
	}
}

class Excute{
	public static void main(String[] args) {
		Constructor2 cotr2 = new Constructor2("안녕");	
		cotr2.printName();
	}
}