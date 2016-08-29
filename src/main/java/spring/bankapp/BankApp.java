package main.java.spring.bankapp;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BankApp {
	private static Logger logger = Logger.getLogger(BankApp.class);

	public static void main(String args[]) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:main/resources/META-INF/spring/applicationContext.xml");
		FixedDepositController fixedDepositController = (FixedDepositController) context
				.getBean("controller");

		logger.info("Submission status of fixed deposit : "
				+ fixedDepositController.submit());
		logger.info("Returned fixed deposit info : "
				+ fixedDepositController.get());
		
		// validate deposit amount is not 0
		FixedDepositService FixedDepositService = context.getBean(FixedDepositService.class);
		FixedDepositService.createFixedDeposit(new FixedDepositDetails(1,0,12,"some@somedomain.com"));
		FixedDepositService.createFixedDeposit(new FixedDepositDetails(1,1000,12,"some@somedomain.com"));
	}
}
