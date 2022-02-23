package com.cg.paymentapp;




import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class PaymentWalletApplication {
	
	private static Logger logger = LogManager.getLogger(PaymentWalletApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(PaymentWalletApplication.class, args);
		
        logger.info("***********SERVER STARTED**********");
       
		
	}

}