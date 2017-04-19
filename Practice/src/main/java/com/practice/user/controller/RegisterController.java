package com.practice.user.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.practice.user.enums.UserState;
import com.practice.user.form.UserForm;
import com.practice.user.form.validator.UserFormValidator;
import com.practice.user.model.User;
import com.practice.user.service.UserService;
import com.practice.utils.UUIDUtils;

@Controller
@RequestMapping({ "/user/register" })
public class RegisterController {

	@Resource
	private UserService service;
	@Resource
	private UserFormValidator userFormValidator;

	@InitBinder("userForm")
	protected void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.addValidators(userFormValidator);
	}

	@RequestMapping(method = RequestMethod.GET)
	public String display(Model m, HttpServletRequest request) {

		if (!m.containsAttribute("userForm")) {
			m.addAttribute("userForm", new UserForm());
		}

		return "frontend/user/register";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String regist(@Valid @ModelAttribute("userForm") UserForm userForm, BindingResult bindingResult,
			HttpServletRequest request, RedirectAttributes attr, Model m) {

		if (bindingResult.hasErrors()) {
			attr.addFlashAttribute("org.springframework.validation.BindingResult.userForm", bindingResult);
			attr.addFlashAttribute("userForm", userForm);
			System.out.println("error");
			return "redirect:/user/register";
		}

		service.add(userForm.toUser());
		m.addAttribute("msg", "註冊完畢，請去信箱啟用帳號，在進行登入");

		return "frontend/public/msg";
	}

	// Ajax 驗證username是否存在
	@RequestMapping(value = { "/find/{username}/{timestamp}" }, method = RequestMethod.GET)
	public ResponseEntity<String> addProductToChart(@PathVariable("username") String username,
			@PathVariable("timestamp") String timestamp) throws IOException {

		String result;
		User u = service.findByUsername(username);
		System.out.println(username);
		if (u == null) {
			result = "<font color='green'>帳號可使用</font>";
		} else {
			result = "<font color='red'>帳號不可使用</font>";
		}

		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	// 用戶啟用帳號
	@RequestMapping(value = { "{username}/active/{code}" }, method = RequestMethod.GET)
	public String active(@PathVariable("code") String code, Model m) {

		User user = service.findByCode(code);
		if (user == null) {
			m.addAttribute("msg", "啟用失敗");
			return "frontend/public/msg";
		}
		
		user.setState(UserState.ACTIVE.value());
		user.setCode(null);
		service.update(user);
		m.addAttribute("msg", "完成啟用，可以登入了!!!");

		return "frontend/public/msg";
	}

}