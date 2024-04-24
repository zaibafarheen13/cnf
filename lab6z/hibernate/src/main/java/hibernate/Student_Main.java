package hibernate;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.Query;

@SuppressWarnings("deprecation")
public class Student_Main {
	
	SessionFactory sc = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	//SessionFactory sc = new Configuration().configure("/path/to/hibernate.cfg.xml").buildSessionFactory();
	Session session = sc.openSession();
	Transaction t = session.beginTransaction();
	
	public void insert(int id,int usn,String name) {
		Student s = new Student();
		s.setId(id);
		s.setName(name);
		s.setUsn(usn);
		session.save(s);
		t.commit();
	}
	
	public void delete(int id) {
		Query q = session.createQuery("Delete from Student where id=:id");
		q.setParameter("id",id);
		int status = q.executeUpdate();
		if(status == 0) {
			System.out.println(id + "Deleted Successfully");
		}else {
			System.out.println(id + "not found");
		}
	}
	
	public void display() {
	    Query q = session.createQuery("from Student");
	    List<Student> students = q.getResultList();
	    System.out.println("List of Students");
	    for (Student student : students) {
	        System.out.println(student.toString());
	    }
	}

	
	public void search(int id) {
	    Query q = session.createQuery("from Student where id = :id");
	    q.setParameter("id", id);
	    List<Student> students = q.getResultList();
	    if (students.isEmpty()) {
	        System.out.println("Not Found");
	    } else {
	        System.out.println("Student Details");
	        for (Student student : students) {
	            System.out.println(student.toString());
	        }
	    }
	}

	
	public static void main(String[] args) {
		Student_Main sm = new Student_Main();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		lp:while(true) {
			System.out.println("1:Insert");
			System.out.println("2:Delete");
			System.out.println("3:Search");
			System.out.println("4:Display");
			System.out.println("7:Exit");
			System.out.println("Make Your Choice");
			int ch = sc.nextInt();
			switch(ch) {
			
			case 1:
				System.out.print("Enter the Student Details to insert \n");
				System.out.print("Enter the Student id \n");
				int id = sc.nextInt();
				System.out.print("Enter the Student usn \n");
				int usn = sc.nextInt();
				System.out.print("Enter the Student name \n");
				String name = sc.next();
				sm.insert(id, usn, name);
				break;
				
			case 2:
				System.out.print("Enter student id to delete\n");
				System.out.print("Enter the Student id \n");
				id = sc.nextInt();
				sm.delete(id);
				break;
				
			case 3:
				System.out.print("Enter student id to search\n");
				System.out.print("Enter the Student id \n");
				id = sc.nextInt();
				sm.search(id);
				break;
				
			case 4:
				sm.display();
				break;
				
			case 7:
				break lp;
			default:
				System.out.println("Invalid Choice");
				
			}
		}
	}
	
}

