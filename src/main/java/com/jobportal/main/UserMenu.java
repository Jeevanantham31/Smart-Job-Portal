package com.jobportal.main;

import java.util.*;
import com.jobportal.dao.*;
import com.jobportal.entity.*;
import com.jobportal.util.*;

public class UserMenu {

    public static void showMenu(User user) {
        Scanner sc = new Scanner(System.in);
        JobDao jobDao = new JobDao();
        ApplicationDao applicationDao = new ApplicationDao();

        int choice;

        do {
            ConsoleUI.title("USER DASHBOARD - " + user.getName());

            ConsoleUI.option(1, "View All Jobs");
            ConsoleUI.option(2, "Apply for Job");
            ConsoleUI.option(3, "View My Applications");
            ConsoleUI.option(4, "Logout");

            System.out.print(Color.WHITE + "\nChoose an option: " + Color.RESET);
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    ConsoleUI.title("AVAILABLE JOBS");
                    jobDao.displayAllJobs();
                    break;

                case 2:
                	ConsoleUI.title("APPLY FOR A JOB");

                	boolean hasJobs = jobDao.displayAllJobs();

                	if (!hasJobs) {
                	    ConsoleUI.warning("⚠️ No jobs available.");
                	    ConsoleUI.info("Returning to User Menu...");
                	    break;  
                	}

                	System.out.print(Color.CYAN + "Enter Job ID: " + Color.RESET);
                	int id = sc.nextInt();

                	Job job = jobDao.getJobById(id);

                	if (job != null) {
                	    applicationDao.applyJob(new Application(user, job, "Applied"));
                	    ConsoleUI.success("Application Submitted..!");
                	} else {
                	    ConsoleUI.error("Invalid Job ID!");
                	}
                	break;



                case 3:
                    ConsoleUI.title("MY APPLICATIONS");

                    List<Application> apps = applicationDao.getApplicationsByUser(user);

                    if (apps.isEmpty()) {
                        ConsoleUI.warning("No Applications Found.");
                    } else {
                        for (Application a : apps) {
                            System.out.println(Color.YELLOW +
                                    "Job: " + a.getJob().getTitle() +
                                    " | Company: " + a.getJob().getCompany().getName() +
                                    " | Status: " + a.getStatus() +
                                    Color.RESET);
                        }
                    }
                    break;

                case 4:
                    ConsoleUI.info("Logging out...");
                    break;

                default:
                    ConsoleUI.error("Invalid Option!");
            }

        } while (choice != 4);
    }
}
