package com.pmws.beans;
/**
 *@author guruprasanna n
 */
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
@Component
public class UserValidator implements org.springframework.validation.Validator {
	public boolean supports(Class<?> clazz) {
        return UserBean.class.isAssignableFrom(clazz);
    }
 
    public void validate(Object target, Errors errors) {
    	UserBean customer = (UserBean)target;
        String userName = customer.getUserName();
        String password = customer.getPassword();
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "customer.userName");
        /*ValidationUtils.rejectIfEmptyOrWhitespace(errors, "age", "customer.age.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "customer.password.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confPassword", "customer.confPassword.empty");
        */
        //Business validation
        if(userName.isEmpty()){
            errors.rejectValue("userName","user name must be enter");
        }
        
}
}