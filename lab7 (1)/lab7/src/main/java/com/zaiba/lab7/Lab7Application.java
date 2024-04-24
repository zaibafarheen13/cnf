package com.zaiba.lab7;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Lab7Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(Lab7Application.class, args);
		
		StudentService service=context.getBean(StudentService.class);
		
		while(true) {
			
			System.out.println("\nMenu\n 1. Insert\n 2. Display\n 3. Update\n 4. Delete\n 5. Exit");
			
			Scanner scan=new Scanner(System.in);
			
			try {
				
				System.out.println("Enter your choice: ");
				int choice=scan.nextInt();
				
				switch(choice) {
				case 1:
					service.addStudent(1, "kumar");
					System.out.println("Inserted");
					break;
					
				case 2:
					service.getAllStudents();
					break;
				
				
				case 3:
					service.updateStudent(1L, 1234, "KumarS");
					System.out.println("Updated");
					break;
					
				case 4:
					service.deleteStudent(1L);
					System.out.println("Deleted");
					break;
					
				case 5:
					System.exit(0);
					
			}}
			catch(InputMismatchException e) {
				System.out.println("Invalid choice");
			}
		}
	}

}
