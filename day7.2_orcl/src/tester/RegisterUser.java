package tester;

import org.hibernate.*;

import dao.UserDaoImpl;
import pojos.User;
import pojos.UserType;

import static utils.HibernateUtils.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class RegisterUser {

	public static void main(String[] args) {
		try (SessionFactory sf = getSf(); Scanner sc = new Scanner(System.in)) {
			// SimpleDateFormat for parsing string--->java.util.Da
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			/*
			 * public User(String name, String email, String password, String role, double
			 * regAmount, UserType userType, boolean isActive,Date regDate) {
			 * 
			 */
			System.out.println("Enter user dtls : nm em pass role amt user-type active date ");
			User u = new User(sc.next(), sc.next(), sc.next(), 
					sc.next(), sc.nextDouble(),
					UserType.valueOf(sc.next().toUpperCase()), 
					sc.nextBoolean(), sdf.parse(sc.next()));
			//create dao inst
			UserDaoImpl dao=new UserDaoImpl();
			//invoke dao's method for auto persistence
			System.out.println(dao.registerUser(u));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
