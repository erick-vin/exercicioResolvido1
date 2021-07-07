package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Departament;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter department's name: ");
		String departmentName = sc.nextLine();
		
		System.out.println("Enter work data:");
		
		System.out.print("Name: ");
		String workerName = sc.nextLine();
		
		System.out.print("Level: ");
		String workerLevel = sc.nextLine();
		
		System.out.print("Base Salary: ");
		double baseSalary = sc.nextDouble();
		
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Departament(departmentName));
		
		System.out.print("How many contracts to this worker? ");
		int n = sc.nextInt();
		
		for(int i=1; i <= n; i++) {
			System.out.println("Enter contract #" + i + " data: ");
			System.out.print("Date (DD/MM/YYYY): ");
			Date contractDate = sdf.parse(sc.next());
			
			System.out.print("Value per hour: ");
			Double valuePerHour = sc.nextDouble();
			
			System.out.print("Duration (Hours): ");
			Integer hours = sc.nextInt();
			
			HourContract hourContract = new HourContract(contractDate, valuePerHour, hours);
			worker.addContract(hourContract);
		}
		
		System.out.println("Enter and year to calculate income (MM/YYYY): ");
		String dataIncome = sc.next();
		
		Integer dataIncomeMonth = Integer.parseInt(dataIncome.substring(0, 2));
		Integer dataIncomeYear = Integer.parseInt(dataIncome.substring(3));
		
		System.out.println(dataIncomeMonth);
		System.out.println(dataIncomeYear);
		System.out.println("Nome: " + worker.getName());
		System.out.println("Department: " + worker.getDepartament().getName());
		System.out.println("Income for " + dataIncome + ": " + String.format("%.2f", worker.income(dataIncomeYear, dataIncomeMonth)));
		sc.close();

	}

}
