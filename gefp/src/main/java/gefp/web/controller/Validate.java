package gefp.web.controller;

import gefp.model.User;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class Validate implements Validator{
	
	private static final String matcher = "((?=.*\\d)(?=.*[a-z]).{4,20})";


	@Override
	public boolean supports(Class<?> paramClass) {
		return User.class.equals(paramClass);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		User user=(User)obj;
		if(!(user.getPassword().matches(matcher)))
		{
			
				errors.rejectValue("password","errors.passowrd.short", "Please Enter Password of atleast 4 Character with one letter and number ");
					
		}
		
	}

}
