package com.jobportal.main;

import java.util.Scanner;
import com.jobportal.dao.*;
import com.jobportal.entity.Company;
import com.jobportal.entity.User;
import com.jobportal.util.Color;
import com.jobportal.util.ConsoleUI;

public class MainApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserDao userDao = new UserDao();
        CompanyDao companyDao = new CompanyDao();

        while (true) {

        	System.out.print("\n==================================");
            System.out.print(Color.GREEN + "★ JOB PORTAL SYSTEM ★" + Color.RESET);
            System.out.print("==================================\n\n");
            
            ConsoleUI.option(1, "Register as User");
            ConsoleUI.option(2, "Register as Company");
            ConsoleUI.option(3, "Login as User");
            ConsoleUI.option(4, "Login as Company");
            ConsoleUI.option(5, "Exit");

            System.out.print(Color.WHITE + "\nChoose an option: " + Color.RESET);
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    ConsoleUI.userTitle("USER REGISTRATION");
                    sc.nextLine();

                    System.out.print(Color.CYAN + "Enter Name: " + Color.RESET);
                    String uname = sc.nextLine();

                    System.out.print(Color.CYAN + "Enter Email: " + Color.RESET);
                    String uemail = sc.nextLine();

                    System.out.print(Color.CYAN + "Enter Password: " + Color.RESET);
                    String upass = sc.nextLine();

                    userDao.registerUser(new User(uname, uemail, upass));
                    ConsoleUI.success("User registered successfully!");
                    break;

                case 2:
                    ConsoleUI.companyTitle("COMPANY REGISTRATION");
                    sc.nextLine();

                    System.out.print(Color.CYAN + "Enter Company Name: " + Color.RESET);
                    String cname = sc.nextLine();

                    System.out.print(Color.CYAN + "Enter Email: " + Color.RESET);
                    String cemail = sc.nextLine();

                    System.out.print(Color.CYAN + "Enter Password: " + Color.RESET);
                    String cpass = sc.nextLine();

                    System.out.print(Color.CYAN + "Enter Location: " + Color.RESET);
                    String cloc = sc.nextLine();

                    companyDao.registerCompany(new Company(cname, cemail, cpass, cloc));
                    ConsoleUI.success("Company registered successfully!");
                    break;

                case 3:
                    ConsoleUI.userTitle("USER LOGIN");
                    sc.nextLine();

                    System.out.print(Color.CYAN + "Enter Email: " + Color.RESET);
                    String loginEmail = sc.nextLine();

                    System.out.print(Color.CYAN + "Enter Password: " + Color.RESET);
                    String loginPass = sc.nextLine();

                    User loggedUser = userDao.login(loginEmail, loginPass);
                    ConsoleUI.loading("Verifying");

                    if (loggedUser != null) {
                        ConsoleUI.success("Login Successful!");
                        UserMenu.showMenu(loggedUser);
                    } else {
                        ConsoleUI.error("Invalid Username or Password!");
                    }
                    break;

                case 4:
                    ConsoleUI.companyTitle("COMPANY LOGIN");
                    sc.nextLine();

                    System.out.print(Color.CYAN + "Enter Email: " + Color.RESET);
                    String compEmail = sc.nextLine();

                    System.out.print(Color.CYAN + "Enter Password: " + Color.RESET);
                    String compPass = sc.nextLine();

                    Company loggedCompany = companyDao.login(compEmail, compPass);
                    ConsoleUI.loading("Verifying");

                    if (loggedCompany != null) {
                        ConsoleUI.success("Login Successful!");
                        CompanyMenu.showMenu(loggedCompany);
                    } else {
                        ConsoleUI.error("Invalid Credentials!");
                    }
                    break;

                case 5:
                	System.out.println(Color.RED+ "Exiting.."+Color.RESET);
                	System.out.println("Thank you for using.🎉");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    ConsoleUI.error("Invalid Option! Try Again.");
            }
        }
    }
}
