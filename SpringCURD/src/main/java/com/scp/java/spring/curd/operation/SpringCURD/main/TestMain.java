package com.scp.java.spring.curd.operation.SpringCURD.main;

import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.scp.java.spring.curd.operation.SpringCURD.entityclass.Employee;
import com.scp.java.spring.curd.operation.SpringCURD.exception.RecordNotFound;
import com.scp.java.spring.curd.operation.SpringCURD.service.EmplyoeeInterface;

public class TestMain {
	
	public static Logger logger = Logger.getLogger(TestMain.class);
	static{
		logger.setLevel(Level.ALL);
		
	}
	public static void main(String[] args) throws  InterruptedException, RecordNotFound {
				
		ApplicationContext context=new ClassPathXmlApplicationContext("/com/scp/java/spring/curd/operation/SpringCURD/main/beanCrud.xml");
		EmplyoeeInterface empInter=(EmplyoeeInterface) context.getBean("empRef");
		Employee emp1=new  Employee();
		emp1.setEmpId(6);
		emp1.setEmpName("Devendra");
		emp1.setEmpAddress("Solapur");
		emp1.setEmpSalary(22000.00);
		
		empInter.addEmployee(emp1);
		System.out.println("Employee:"+emp1);
		
		//All Emplyoee Details
		List<Employee> listOfEmp=empInter.allEmployee();
		for (Employee empAll : listOfEmp) {
			System.out.println("All Employee:"+empAll);
		}

		// one single Emp data featch  --done
		Employee emp2 = empInter.getSingleEmp(1);
		System.out.println("Single Employee Data:" + emp2);

		// update Employee Record --done
		Employee emp3 = empInter.getSingleEmp(3);
		System.out.println("Before Updatation:"+emp3);
		emp3.setEmpName("Chirag");
		emp3.setEmpAddress("Latur");
		emp3.setEmpSalary(45678.98);
		empInter.updateEmployee(emp3);
		System.out.println("After Updatation:"+emp3);
		
		//delete particular Emp record ---done
		empInter.deleteEmployee(6);
		System.out.println("Record deleted SuccessFully");
		System.out.println("After Deleting Record Updated DB Record is:");
		List<Employee> listOfEmp1=empInter.allEmployee();
		for (Employee empAll1 : listOfEmp1) {
			System.out.println("All Employee:"+empAll1);
		}
		
		
		for (int i = 0; i < 10; i++) {
			PropertyConfigurator.configure("log4j.properties");
			logger.trace("Sample Trace Message");
			logger.debug("Sample debug message");
			logger.info("Sample info message");
			logger.warn("Sample warn message");
			logger.error("Sample error message");
			logger.fatal("Sample fatal message");
			
			System.out.println("Log4j file created for dailyRooling printed.....!!!!");
			Thread.sleep(20500);
		}
	}
}




/*
 *            OUTPUT
 * Hibernate: 
    insert 
    into
        Employee_Hib_spring
        (empAddress, empName, empSalary, Emp_Id) 
    values
        (?, ?, ?, ?)
Employee:
 Employee [empId=2, empName=Lalita, empAddress=Nagpur, empSalary=44000.0]
Hibernate: 
    select
        this_.Emp_Id as Emp_Id1_0_0_,
        this_.empAddress as empAddre2_0_0_,
        this_.empName as empName3_0_0_,
        this_.empSalary as empSalar4_0_0_ 
    from
        Employee_Hib_spring this_ limit ?
All Employee:
 Employee [empId=1, empName=Deepali, empAddress=Pune, empSalary=12000.0]
All Employee:
 Employee [empId=2, empName=Lalita, empAddress=Nagpur, empSalary=44000.0]
All Employee:
 Employee [empId=3, empName=Mangesh, empAddress=Nagar, empSalary=67000.0]
All Employee:
 Employee [empId=4, empName=Rehan, empAddress=Banglore, empSalary=89000.0]
All Employee:
 Employee [empId=5, empName=Faguni, empAddress=UK, empSalary=220000.0]
All Employee:
 Employee [empId=6, empName=Rahul, empAddress=Kolkata, empSalary=66000.0]
Hibernate: 
    select
        employee0_.Emp_Id as Emp_Id1_0_0_,
        employee0_.empAddress as empAddre2_0_0_,
        employee0_.empName as empName3_0_0_,
        employee0_.empSalary as empSalar4_0_0_ 
    from
        Employee_Hib_spring employee0_ 
    where
        employee0_.Emp_Id=?
Single Employee Data:
 Employee [empId=4, empName=Rehan, empAddress=Banglore, empSalary=89000.0]
Hibernate: 
    select
        employee0_.Emp_Id as Emp_Id1_0_0_,
        employee0_.empAddress as empAddre2_0_0_,
        employee0_.empName as empName3_0_0_,
        employee0_.empSalary as empSalar4_0_0_ 
    from
        Employee_Hib_spring employee0_ 
    where
        employee0_.Emp_Id=?
Before Updatation:
 Employee [empId=3, empName=Mangesh, empAddress=Nagar, empSalary=67000.0]
Hibernate: 
    update
        Employee_Hib_spring 
    set
        empAddress=?,
        empName=?,
        empSalary=? 
    where
        Emp_Id=?
After Updatation:
 Employee [empId=3, empName=Chirag, empAddress=Latur, empSalary=45678.98]
Hibernate: 
    select
        employee0_.Emp_Id as Emp_Id1_0_0_,
        employee0_.empAddress as empAddre2_0_0_,
        employee0_.empName as empName3_0_0_,
        employee0_.empSalary as empSalar4_0_0_ 
    from
        Employee_Hib_spring employee0_ 
    where
        employee0_.Emp_Id=?
Hibernate: 
    delete 
    from
        Employee_Hib_spring 
    where
        Emp_Id=?
Record deleted SuccessFully
After Deleting Record Updated DB Record is:
Hibernate: 
    select
        this_.Emp_Id as Emp_Id1_0_0_,
        this_.empAddress as empAddre2_0_0_,
        this_.empName as empName3_0_0_,
        this_.empSalary as empSalar4_0_0_ 
    from
        Employee_Hib_spring this_ limit ?
All Employee:
 Employee [empId=1, empName=Deepali, empAddress=Pune, empSalary=12000.0]
All Employee:
 Employee [empId=2, empName=Lalita, empAddress=Nagpur, empSalary=44000.0]
All Employee:
 Employee [empId=3, empName=Chirag, empAddress=Latur, empSalary=45678.98]
All Employee:
 Employee [empId=4, empName=Rehan, empAddress=Banglore, empSalary=89000.0]
All Employee:
 Employee [empId=5, empName=Faguni, empAddress=UK, empSalary=220000.0]
Log4j file created for dailyRooling printed.....!!!!
Log4j file created for dailyRooling printed.....!!!!

 *            
 */

