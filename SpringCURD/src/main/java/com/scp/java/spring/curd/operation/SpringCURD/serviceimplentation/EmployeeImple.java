package com.scp.java.spring.curd.operation.SpringCURD.serviceimplentation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.apache.log4j.Logger;

import com.scp.java.spring.curd.operation.SpringCURD.entityclass.Employee;
import com.scp.java.spring.curd.operation.SpringCURD.exception.RecordNotFound;
import com.scp.java.spring.curd.operation.SpringCURD.service.EmplyoeeInterface;

@Repository
public class EmployeeImple implements EmplyoeeInterface {
	
	public static List<Employee> listEmployee=new ArrayList<Employee>();
	public static Logger logger = Logger.getLogger(EmplyoeeInterface.class);
    private SessionFactory sessionFactory;
    //HibernateTemplate template;  
    
    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }
    
    public void setSessionFactory(SessionFactory sf){
    	this.sessionFactory=sf;
    }
	public void addEmployee(Employee e) {
		Session session=this.sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(e);
		listEmployee.add(e);
		session.flush();
		tx.commit();
		logger.info("Saved Successfully...."+e);
		
	}

	public void updateEmployee(Employee e) throws RecordNotFound {
		Session session=this.sessionFactory.openSession();
		Transaction tx1=session.beginTransaction();
		session.update(e);	
		tx1.commit();
		logger.info("Update Successfully...."+e);
		session.close();
		recordNotFoundProduct(e.getEmpId());
	}

	public void deleteEmployee(int id) throws RecordNotFound {
		Session session=this.sessionFactory.openSession();
		Transaction tx2=session.beginTransaction();
		Employee emp=(Employee)session.load(Employee.class, id);
		if(null!=emp){
			session.delete(emp);
		}
		tx2.commit();
		logger.info("Deleted Successfully...."+emp);
		session.close();
		recordNotFoundProduct(emp.getEmpId());
	}

	public Employee getSingleEmp(int id) throws RecordNotFound {
		Session session=this.sessionFactory.openSession();
		Employee emp=(Employee)session.load(Employee.class, new Integer(id));
		//recordNotFoundProduct(emp.getEmpId());	
		logger.info("Employee Record :"+emp);
		
		session.close();
		return emp;
	}

	@SuppressWarnings("unchecked")  
	public List<Employee> allEmployee() {
	Session session=this.sessionFactory.openSession();
	Transaction tx3=session.beginTransaction();
		 List<Employee> empList=session.createCriteria(Employee.class, "from employee_hib_spring").setMaxResults(20).list();
		tx3.commit();
		session.close();
		return empList;
	}
	
	
	private void recordNotFoundProduct(int id) throws RecordNotFound {
		
		for (int i = 0; i < allEmployee().size(); i++) {
			for (int j = i + 1; j < allEmployee().size(); j++) {
				if (allEmployee().get(i).getEmpId() != allEmployee().get(j).getEmpId()) {
					throw new RecordNotFound("This Id Not Found In DataBase....!");
				}
			}
		}
				
		/*Iterator<Employee> itrEmp=allEmployee().iterator();
		Employee emp=null;
		while (itrEmp.hasNext()) {
			//Employee employee = (Employee) itrEmp.next();
			if ((emp=(Employee)itrEmp.next()).getEmpId()!=id) {
				throw new RecordNotFound("This Id Not Found In DataBase....!");
			}
		}
		*/
		
	}
	
	
	

}


