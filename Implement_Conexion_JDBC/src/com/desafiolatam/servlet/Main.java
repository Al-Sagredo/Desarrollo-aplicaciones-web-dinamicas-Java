package com.desafiolatam.servlet;

import java.util.ArrayList;
import java.util.List;

import com.desafiolatam.dao.ListarDaoImpl;
import com.desafiolatam.modelo.Customers;

public class Main {
	
	public static void main(String[] args) {
		ListarDaoImpl listarDao = new ListarDaoImpl();
		List<Customers> customers = new ArrayList<>();
		customers = listarDao.muestraResultado();
		for(Customers customer:customers) {
			System.out.println("Nombre: " + customer.getName());
			System.out.println("Edad: " + customer.getAge());
			System.out.println("Sueldo: " + customer.getSalary());
			System.out.println("\n");
			
		}
		
	}

}
