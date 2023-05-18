package model.entities;

public class Invoice {
	
	private double basicPyament;
	private double tax;
	
	
	public Invoice() {
		
	}


	public Invoice(double basicPyament, double tax) {
		this.basicPyament = basicPyament;
		this.tax = tax;
	}


	public double getBasicPyament() {
		return basicPyament;
	}


	public void setBasicPyament(double basicPyament) {
		this.basicPyament = basicPyament;
	}


	public double getTax() {
		return tax;
	}


	public void setTax(double tax) {
		this.tax = tax;
	}
	
	public Double getTotalPayment() {//utiliza o get para buscar as informações 
		return getBasicPyament() + getTax();
	}
	
}
