package com.krishnaraddi.SpringOrm;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.krishnaraddi.SpringOrm.dao.EmployeeDao;
import com.krishnaraddi.SpringOrm.entity.Employee;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("com/krishnaraddi/SpringOrm/config/config.xml");
		EmployeeDao bean = context.getBean("empdao", EmployeeDao.class);

		Scanner scan = new Scanner(System.in);

		boolean flag = true;
		while (flag) {
			System.out.println("press 1 to insert elements");
			System.out.println("press 2 to delete elements");
			System.out.println("press 3 to update elements");
			System.out.println("press 4 to display employee");
			System.out.println("press 5 to display all the employee");
			int key = scan.nextInt();
			switch (key) {
			case 1:
				Employee emp = new Employee(101, "krishnaraddi", "globallogic");
				int insertData = bean.insertData(emp);
				System.out.println(insertData);
				break;

			case 2:
				System.out.println("enter the employee id to delete");
				int id=scan.nextInt();
				emp=new Employee();
				emp.setId(id);
				break;
			case 3:
				System.out.println("enter the id need to update");
				id=scan.nextInt();
				System.out.println("enter the name to be updated");
				String name=scan.next();
				System.out.println("enter the college to be updated");
				String company=scan.next();
				
				emp=new Employee();
				emp.setName(name);
				emp.setCompany(company);
				break;
			case 4:
				System.out.println("enter the id to fetch");
				id=scan.nextInt();
				Employee fetchData = bean.fetchData(id);
				System.out.println(fetchData);
				break;
			case 5:
				List<Employee> fetchAll = bean.fetchAll();
				for (Employee employee : fetchAll) {
					System.out.println(employee);
				}
				break;
			default:
				System.out.println("u have pressed an invalid input please try again");
				flag = false;
				break;
			}
		}

	}

}
