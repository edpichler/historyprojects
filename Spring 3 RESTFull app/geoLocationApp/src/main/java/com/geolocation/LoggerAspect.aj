package com.geolocation;

import javax.swing.JFrame;

import org.hsqldb.util.DatabaseManagerSwing;

public aspect LoggerAspect {

//	//criando um field 
//	private String Address.novoField = "this is a new field";  
//	
//	public String Address.getNovoField(){
//		return this.novoField;
//	}
//	
//	pointcut tracedCall():
//       call(String *.novoMetodo());
//	
//	pointcut traceTudo():
//        call(String Address.*());
//	
//	
//
//	//colocando lógica nos pointcuts
//	before(): tracedCall() {
//		System.out.println("Entering: " + thisJoinPoint);
//	}
//	
//	//colocando lógica nos pointcuts
//	after() : traceTudo() {
//		System.out.println("Passou por: " + thisJoinPoint);
//	}
//
//	public static void main(String[] args) {
//		System.out.println(new Address().novoMetodo());
//		System.out.println(new Address().getNovoField());
//	} 
//
//	//	adicionando metodos
//	public String Address.novoMetodo() { 
//        return "this is a new method";        
//    }	
	
	
	/*public static void main(String[] args) {
		DatabaseManagerSwing m = new DatabaseManagerSwing(new JFrame());
		m.main();
		m.start();	
		
	}*/
}
