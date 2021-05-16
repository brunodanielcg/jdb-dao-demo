package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;
import model.entities.Seller;

public class Program2 {

	public static void main(String[] args) {


	Scanner sc = new Scanner (System.in);
	
	DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
	
	System.out.println("=== TEST 1: deparment findById ===");
	Department dep = departmentDao.findById(1);
	System.out.println(dep);
	
	System.out.println("\n=== TEST 2: seller findAll ===");
	List<Department> list = departmentDao.findAll();
	for (Department obj : list) {
		System.out.println(obj);
	}
	
	System.out.println("\n=== TEST 3: department insert ===");
	Department newDepartment = new Department (13, "newDepartmentName");
	departmentDao.insert(newDepartment);
	System.out.printf("Inserted! New department id = " + newDepartment.getId(), " . New department name = " + newDepartment.getName());
	System.out.println();
	
	System.out.println("\n=== TEST 4: department update ===");
	dep = departmentDao.findById(1);
	dep.setName("UpdatedName");
	departmentDao.update(dep);
	System.out.println("Update completed");
	
	System.out.println("\n=== TEST 5: department findAll ===");
	list = departmentDao.findAll();
	for (Department obj : list) {
		System.out.println(obj);
	}
	
	System.out.println("\n=== TEST 5: department delete ===");
	System.out.println("Enter id for delete test: ");
	int id = sc.nextInt();
	departmentDao.deleteById(id);
	System.out.println("Delete completed");

}
	
}
