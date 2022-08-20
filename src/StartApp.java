import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import com.student.manage.Student;
import com.student.manage.StudentDao;

public class StartApp {
	public static void main(String args[]) throws IOException {
		System.out.println("Welcome to the student management system app");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			
			System.out.println("press 1 to add student");
			System.out.println("press 2 to delete student");
			System.out.println("press 3 to display student");
			System.out.println("press 4 to update students details");
			System.out.println("press 0 to exit application");
			int c=Integer.parseInt(br.readLine());
			
			if(c==1) {
				//add students
				System.out.println("enter student name:");
				String name=br.readLine();
				
				System.out.println("enter student phone:");
				String phone=br.readLine();
				
				System.out.println("enter student city:");
				String city=br.readLine();
				
				//create student object to store student data
				Student st=new Student(name,phone,city);
				boolean answer=StudentDao.insertStudentToDB(st);
				
				if(answer) {
					System.out.println("Student is added successfully.....");
				}
				
				else {
					System.out.println("something went wrong.....");
				}
				
				System.out.println(st);
			}
			
			else if(c==2) {
				//delete student
				System.out.println("Enter the student id to delete:");
				int userid=Integer.parseInt(br.readLine());
				boolean answer2=StudentDao.deleteStudent(userid);
				
				if(answer2) {
					System.out.println("the student data is deleted.");
				}
				
				else {
					System.out.println("something went wrong");
				}
			}
			
			else if(c==3) {
				//display student
				StudentDao.showAllStudents();
				
			}
			
			else if(c==4) {

				//update the student data

				System.out.println("Please enter student id to update student");

				int id= Integer.parseInt(br.readLine());
				System.out.println("Enter name to update");

				String name= br.readLine();

				System.out.println("Enter mobile to update");

				String mobile = br.readLine();

				System.out.println("Enter city to update");

				String city = br.readLine();
				Student st = new Student (name,city, mobile);

				boolean answer= StudentDao.updateStudent(st,id);

				if(answer== true)
				{ 
					System.out.println("Succefully Updated");

				}
				else {

				System.out.println("Failed!");
				}

				System.out.println();
			}
			else if (c==0){
				//system.exit
				break;
				}
			else {
				
			}
		}
		System.out.println("thanku for using my application.....");
	}

}
