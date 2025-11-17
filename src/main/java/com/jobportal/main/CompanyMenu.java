package com.jobportal.main;

import java.util.List;
import java.util.Scanner;
import com.jobportal.dao.*;
import com.jobportal.entity.Company;
import com.jobportal.entity.Job;
import com.jobportal.util.*;

public class CompanyMenu {

    public static void showMenu(Company company) {
        Scanner sc = new Scanner(System.in);
        JobDao jobDao = new JobDao();

        int choice;

        do {
            ConsoleUI.companyTitle("COMPANY DASHBOARD - " + company.getName());

            ConsoleUI.option(1, "Post Job");
            ConsoleUI.option(2, "View Posted Jobs");
            ConsoleUI.option(3, "Logout");

            System.out.print(Color.GREEN + "\nChoose an option: " + Color.RESET);
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    ConsoleUI.companyTitle("POST NEW JOB");

                    System.out.print(Color.CYAN + "Job Title: " + Color.RESET);
                    String title = sc.nextLine();

                    System.out.print(Color.CYAN + "Description: " + Color.RESET);
                    String desc = sc.nextLine();

                    System.out.print(Color.CYAN + "Location: " + Color.RESET);
                    String location = sc.nextLine();

                    jobDao.postJob(new Job(title, desc, location, company));
                    ConsoleUI.success("Job Posted Successfully!");
                    break;

                case 2:
                    ConsoleUI.companyTitle("MY POSTED JOBS");

                    List<Job> list = jobDao.getJobsByCompany(company);

                    if (list.isEmpty()) {
                        ConsoleUI.warning("No Jobs Posted Yet.");
                    } else {
                        for (Job j : list) {
                            System.out.println(Color.YELLOW +
                                "ID: " + j.getId() +
                                " | Title: " + j.getTitle() +
                                " | Location: " + j.getLocation() + 
                                Color.RESET);
                        }
                    }
                    break;

                case 3:
                    ConsoleUI.info("Logging out...");
                    break;

                default:
                    ConsoleUI.error("Invalid Choice!");
            }

        } while (choice != 3);
    }
}
