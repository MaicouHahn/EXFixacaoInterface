package model.services;

import java.time.LocalDate;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {

	private OnlinePaymentService onlinePaymentService;

	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}

	public void processContract(Contract contract, int month) {

		double basicQuota = contract.getTotalValue() / 3;

		for (int i = 1; i <= month; i++) {

			LocalDate dueDate = contract.getDate().plusMonths(i);
			double interest = onlinePaymentService.interest(basicQuota, i);
			double fee = onlinePaymentService.paymentFee(basicQuota + interest);
			double quota = basicQuota + interest + fee;
			
			contract.getInstallment().add(new Installment(dueDate,quota));
		}

	}
}
