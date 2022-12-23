package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PaypalService;

public class Application {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println("Enter the Contact data: ");
		System.out.println("Contact Number: ");
		int idContact = scan.nextInt();
		System.out.println("Date(DD/MM/YYYY) ");
		LocalDate date = LocalDate.parse(scan.next(), fmt);
		System.out.println("Contact Value: ");
		double totalValue = scan.nextDouble();
		
		Contract contract = new Contract(idContact, date, totalValue);//instancia do contrato
		
		System.out.println("Enter installments: ");
		int installments = scan.nextInt();
		System.out.println(contract);
		
		ContractService contractService = new ContractService(new PaypalService());
		
		contractService.processContract(contract, installments);//Instanciada as parcelas e feito os calculos
		
		System.out.println("Installments: ");
		
		for(Installment c: contract.getInstallment()) {
			
			System.out.println(c);
		}
		
	}

}
