package main.java.spring.bankapp;

import org.apache.log4j.Logger;
import org.springframework.validation.BeanPropertyBindingResult;

public class FixedDepositService {
	private static Logger logger = Logger.getLogger(FixedDepositService.class);
	private FixedDepositDao fixedDepositDao;

	public FixedDepositService() {
		logger.info("initializing");
	}

	public void setFixedDepositDao(FixedDepositDao fixedDepositDao) {
		logger.info("Setting fixedDepositDao property");
		this.fixedDepositDao = fixedDepositDao;
	}

	public FixedDepositDetails getFixedDepositDetails(long id) {
		return fixedDepositDao.getFixedDepositDetails(id);
	}
	// create deposit only when validator returns no error
	public boolean createFixedDeposit(FixedDepositDetails fdd) throws Exception{
		BeanPropertyBindingResult bindingResult = new BeanPropertyBindingResult(fdd,"Errors");
		FixedDepositValidator validator = new FixedDepositValidator();
		validator.validate(fdd, bindingResult);
		
		if(bindingResult.getErrorCount() > 0){
			logger.error("Errors were found while validating FixedDepositDetails instance");
			return false;
		}
		
			fixedDepositDao.createFixedDeposit(fdd);
			logger.info("Created fixed deposit");
			return true;
		
	}
}
