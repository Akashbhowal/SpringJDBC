package com.orm.test;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.orm.shop.shop;
import com.orm.shopDAO.shopDaoImpl;

public class main {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/orm/test/config.xml");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter what you want to do in table 'shop'--->\n1)Insert Record\n2)Update Record\n3)Delete Record\n4)Read record by id\n5)Show all records");
		int x = Integer.parseInt(sc.nextLine());
		shopDaoImpl sp = (shopDaoImpl)ctx.getBean("shopDaoImpl");
		switch (x) {
		case 1: {
			System.out.println("Enter insert query (table column-id int,item string, price double)");
			
			System.out.println(sp.create(sc.nextLine()));
			break;
		}
		case 2: {
			System.out.println("Enter update query (table column-id int,item string, price double)");
			System.out.println(sp.update(sc.nextLine()));
			break;
		}
		case 3: {
			System.out.println("Enter delete query (table column-id int,item string, price double)");
			System.out.println(sp.delete(sc.nextLine()));
			break;
		}
		case 4: {
			System.out.println("Enter id whose record you want:-");
			shop s=sp.read(Integer.parseInt(sc.nextLine()));
			System.out.println(s.getId()+" "+s.getItem()+" "+s.getPrice());
			break;
		}
		case 5: {
			System.out.println("Showing all records of Shop:-");
			List<shop> s1 = sp.read();
			for(shop s:s1)
			{
			System.out.println(s.getId()+" "+s.getItem()+" "+s.getPrice());
			}
			break;
		}
		default: {
			System.out.println("Not choosen anything!");
			break;
		}
		}

	}

}
