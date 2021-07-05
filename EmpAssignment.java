package assignment;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;


public class EmpAssignment {
	public static void main(String[] args) throws SQLException
	{
		Scanner scanner=new Scanner(System.in);
	System.out.println("enter 1 for static ");	
	System.out.println("enter 2 for dynamic ");
	 int option =scanner.nextInt();
	 if(option==1)
	 {
		Connection connection=null;
		java.sql.Statement statement=null;
		String url="jdbc:mysql://localhost:3306/employee";
		
		
		
		
		
		try {
			connection=(Connection) DriverManager.getConnection(url,"root","emp");
			System.out.println("enter 1 for insert ");
			System.out.println("enter 2 for delete ");
			System.out.println("enter 3 for Update ");
			System.out.println("enter 4 for rename ");
			int value=scanner.nextInt();
			switch(value)
			{
			case(1):
			{
				String query="insert into employee_info values(7888,'emp')";
				statement=connection.createStatement();
				 int result=statement.executeUpdate(query);
				 if(result!=0)
					{
						System.out.println(result +"no of rows affected....");
						
					}
					break;
				
			}
			case(2):
			{
				String query=" delete from employee_info where id=7999";
				statement=connection.createStatement();
				 int result=statement.executeUpdate(query);
				 if(result!=0)
					{
						System.out.println(result+"no of rows affected....");
					}
					break;
					
			}
			case(4):
			{
				String query=" alter table employees_info rename to employee_info";
				statement=connection.createStatement();
				 int result=statement.executeUpdate(query);
				 if(result!=0)
					{
						System.out.println(result+"no of rows affected....");
					}
					break;
					
			}
			case(3):
			{
				String query=" update employee_info set name='haritha' where Eid=7900";
				statement=connection.createStatement();
				 int result=statement.executeUpdate(query);
				 if(result!=0)
					{
						System.out.println(result+"no of rows affected....");
					}
					break;
					
			}
			}

		
		
		
		
		
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	 }else
		 if(option==2)
		 {
			 Connection connection=null;
				java.sql.PreparedStatement preparedStatement=null;
				String url="jdbc:mysql://localhost:3306/employee";
				connection=(Connection) DriverManager.getConnection(url,"root","emp");
				System.out.println("enter 1 for insert ");
				System.out.println("enter 2 for delete ");
				System.out.println("enter 3 for Update ");
				System.out.println("enter 4 for rename ");
				int value=scanner.nextInt();
				switch(value)
				{
				case(1):
				{
					System.out.println("enter id u want to change ");
					int id=scanner.nextInt();
					System.out.println("enter name u want to change ");
					String name=scanner.next();
					
					String query="insert into employee_info values(?,?)";
					preparedStatement= connection.prepareStatement(query);
					preparedStatement.setInt(1, id);
					preparedStatement.setString(2, name);
					int result= preparedStatement.executeUpdate();
					
					
				//	 int result=statement.executeUpdate(query);
					 if(result!=0)
						{
							System.out.println(result +"no of rows affected....");
							
						}
						break;
					
				}
				case(2):
				{
					System.out.println("enter Eid u want to delete ");
					int id=scanner.nextInt();
					
					
					String query="delete from employees_info where Eid=?";
					preparedStatement= connection.prepareStatement(query);
					preparedStatement.setInt(1, id);
					
					int result= preparedStatement.executeUpdate();
					
				//	 int result=statement.executeUpdate(query);
					 if(result!=0)
						{
							System.out.println(result +"no of rows affected....");
							
						}
						break;
					
				}
				case(3):
				{
					System.out.println("enter id u want to insert");
					int id=scanner.nextInt();
					System.out.println("enter name u want to insert ");
					String name=scanner.next();
					
					
					String query="insert into employees_info values(?,?)";
					preparedStatement= connection.prepareStatement(query);
					preparedStatement.setInt(1, id);
					preparedStatement.setString(2, name);
					
					int result= preparedStatement.executeUpdate();
					
				//	 int result=statement.executeUpdate(query);
					 if(result!=0)
						{
							System.out.println(result +"no of rows affected....");
							
						}
						break;
					
				}
				case(4):
				{
					System.out.println("enter table to want change");
					
					String name=scanner.next();
					
					
					String query="alter table employees_info rename to ?";
					preparedStatement= connection.prepareStatement(query);
				
					preparedStatement.setString(1, name);
					
					int result= preparedStatement.executeUpdate();
					
				//	 int result=statement.executeUpdate(query);
					 if(result!=0)
						{
							System.out.println(result +"no of rows affected....");
							
						}
						break;
					
				}
				
				
				}
				
		 

	}
	}
	}


