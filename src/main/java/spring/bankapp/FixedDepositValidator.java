package main.java.spring.bankapp;

import org.springframework.validation.Validator;
import org.springframework.validation.Errors;
// Validator interface implementation
public class FixedDepositValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return FixedDepositDetails.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		FixedDepositDetails fixedDepositDetails = (FixedDepositDetails) target;
		if(fixedDepositDetails.getDepositAmount() == 0){
			errors.reject("zeroDepositAmout");
		}
	}
	
}
