package com.practice.user.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.practice.user.form.UserForm;
import com.practice.user.model.User;
import com.practice.user.service.UserService;
import com.practice.user.utils.UserUtils;

@Controller
@RequestMapping({ "/user/login" })
public class LoginController {

	@Resource
	private UserService service;

	@RequestMapping(method = RequestMethod.GET)
	public String display(Model m) {

		UserForm loginForm = new UserForm();
		m.addAttribute("loginForm", loginForm);

		return "frontend/user/login";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String login(HttpSession session, @ModelAttribute("loginForm") UserForm loginForm, BindingResult bindingResult, RedirectAttributes attr) {

		User user = service.login(loginForm.getUsername(), loginForm.getPassword());
		
		if (user == null) {
			attr.addFlashAttribute("error", "帳號或密碼錯誤");
			return "redirect:/user/login";
		} else {
			UserUtils.putInSession(session, user);
			return "redirect:/";
		}
	}
}
