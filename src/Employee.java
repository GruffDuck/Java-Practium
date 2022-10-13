import java.util.Scanner;

import static java.lang.System.*;

public class Employee {
    public static String name;
    public static double salary;
    public static int workHours;
    public static int hireYear;
    public static double tax;
    public static int bonus;
    public static double zam;

    public static void main(String args[]) {
        out.println("Lütfen isminizi giriniz :");
        Scanner isim = new Scanner(in);
        name = isim.nextLine();
        out.println("Lütfen güncel maaşınızı giriniz :");
        Scanner maas = new Scanner(in);
        salary = maas.nextDouble();
        out.println("Lütfen haftalık çalışma saatinizi giriniz :");
        Scanner saat = new Scanner(in);
        workHours = saat.nextInt();
        out.println("Lütfen kaç yılında işe başladığınızı  giriniz :");
        Scanner yil = new Scanner(in);
        hireYear = yil.nextInt();
        Employee emp = new Employee(name, salary, workHours, hireYear);
    }

    public Employee(String name, double salary, int workHours, int hireYear) {
        Tax(salary);
        Bonus(salary, workHours);
        RaiseSalary(salary, hireYear);
        toString(name, salary, tax, workHours, hireYear);
    }

    public void Tax(double salary) {
        if (salary >= 1000) {
            tax = salary * 3 / 100;
        }

    }

    public void Bonus(double salary, int workHours) {
        if (workHours > 40) {
            bonus = (workHours - 40) * 30;
        }

    }

    public void RaiseSalary(double salary, int hireYear) {
        int year = 2021 - hireYear;
        if (year > 0 && year < 10) {
            zam = (salary * 0.05);
        } else if (year >= 10 && year < 20) {
            zam = salary * 0.1;
        } else if (year >= 20) {
            zam = salary * 0.15;
        }

    }

    public void toString(String name, double salary, double tax, int workHours, int hireYear) {
        double taxSalary = salary + bonus - tax;
        double lastSalary = taxSalary + zam;
        out.println("İsim:" + name + "\n" + "Maaşı: " + salary + "\n" + "Haftalık çalışma saati: " + workHours + "\n" + "Kaç yılında işe başladığı  : " + hireYear + "\n");
        out.println("Maaşından kesilen vergi : " + tax + "\n" + "Aldığı bonus : " + bonus + "\n" + "Aldığı zam: " + zam + "\n");
        out.println("Vergi ve bonusla birlikte maaşı :" + taxSalary + "\n" + "toplam maaş :" + lastSalary);
    }
}
