package com.practice.user.form.validator;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.practice.user.form.UserForm;
import com.practice.user.model.User;
import com.practice.user.service.UserService;

@Component
public class UserFormValidator  implements Validator{
	@Resource 
	private UserService userService;
	
	@Override
	public boolean supports(Class<?> aClass) {
		return UserForm.class.equals(aClass);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		UserForm userForm = (UserForm)obj;
		User existUser = userService.findByUsername(userForm.getUsername());

        if (!userForm.getPassword().equals(userForm.getRepassword())) {
            errors.rejectValue("repassword", "ErrorConfirm");
        }
        if(existUser != null) {
        	errors.rejectValue("username", "UsernameIsUsed");
        }
	}
}
