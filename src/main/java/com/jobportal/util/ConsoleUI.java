package com.jobportal.util;
public class ConsoleUI {

    public static void line() {
        System.out.println(Color.BLUE + "──────────────────────────────────────────────" + Color.RESET);
    }

    public static void title(String text) {
        line();
        System.out.println(Color.BOLD_CYAN + "★ " + text.toUpperCase() + " ★" + Color.RESET);
        line();
    }
    public static void userTitle(String text) {
        line();
        System.out.println(Color.BOLD_YELLOW + "★ " + text.toUpperCase() + " ★" + Color.RESET);
        line();
    }
    public static void companyTitle(String text) {
        line();
        System.out.println(Color.BOLD_PURPLE + "★ " + text.toUpperCase() + " ★" + Color.RESET);
        line();
    }
    public static void option(int number, String text) {
        System.out.println(Color.BOLD_CYAN + number + ". " + text + Color.RESET);
    }

    public static void success(String msg) {
        System.out.println(Color.BOLD_GREEN + "[✔] " + msg + Color.RESET);
    }

    public static void error(String msg) {
        System.out.println(Color.BOLD_RED + "[✘] " + msg + Color.RESET);
    }

    public static void info(String msg) {
        System.out.println(Color.CYAN + "[•] " + msg + Color.RESET);
    }

    public static void warning(String msg) {
        System.out.println(Color.BOLD_YELLOW + "! " + msg + Color.RESET);
    }

    public static void loading(String msg) {
        System.out.print(Color.PURPLE + msg);
        try {
            Thread.sleep(150); System.out.print(".");
            Thread.sleep(150); System.out.print(".");
            Thread.sleep(150); System.out.println("." + Color.RESET);
        } catch (Exception ignored) {}
    }
}
