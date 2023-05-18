package application;

import java.util.Scanner;

import java.util.Locale;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.BrazilTaxServices;
import model.services.RentalServices;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
	
		DateTimeFormatter formatoDaData = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		System.out.println("Entre com os dados do aluguel");
		System.out.print("Modelo do carro: ");
		String carModel = sc.nextLine();
		System.out.println("Retirada (dd/MM/yy hh:mm): ");
		LocalDateTime start = LocalDateTime.parse(sc.nextLine(),formatoDaData);
		System.out.println("Retorno(dd/MM/yy hh:mm): ");
		LocalDateTime finish = LocalDateTime.parse(sc.nextLine(),formatoDaData);

		CarRental cr = new CarRental(start, finish, new Vehicle(carModel));
		
		BrazilTaxServices TaxServices = new BrazilTaxServices();
		
		System.out.print("Entre com preço por hora: ");
		double pricePerHour = sc.nextDouble();
		System.out.print("Entre com preço por dia: ");
		double pricePerDay = sc.nextDouble();
		
		RentalServices rentalServices = new RentalServices(pricePerDay, pricePerHour, new BrazilTaxServices());
		
		rentalServices.processInvoice(cr);
		
		System.out.println("Fatura: ");
		System.out.println("Pagamento básico: " + cr.getInvoice().getBasicPyament() );
		System.out.println("Imposto: " + cr.getInvoice().getTax());
		System.out.println("Pagamento total: " + cr.getInvoice().getTotalPayment());
		
	}

}
