package model.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Contract {

	private int idContract;
	private LocalDate date;
	private double totalValue;
	private List<Installment> installment = new ArrayList<>();
	
	public Contract(int idContract, LocalDate date, double totaValue) {
		
		this.idContract = idContract;
		this.date = date;
		this.totalValue = totaValue;
	
	}

	public int getIdContract() {
		return idContract;
	}

	public void setIdContract(int idContract) {
		this.idContract = idContract;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(double totaValue) {
		this.totalValue = totaValue;
	}

	public List<Installment> getInstallment() {
		return installment;
	}

}
