package com.liu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.liu.model.Member;
import com.liu.model.MemberService;

@Controller
@RequestMapping(path = "/Main")
@SessionAttributes(names = { "managerBeans", "character" })
public class MainFunction {

	@Autowired
	private MemberService mService;

	@PostMapping(path = "/MemberLogin")
	public String ProcessAction(@RequestParam("email") String email, @RequestParam("memberPwd") String memberPwd,
			Model m) {
		List<Member> member = mService.isMember(email, memberPwd);
		if (member.isEmpty()) {
			return "MemberLoginError";
		} else if (member.get(0).getLevelId() == 100) {
			m.addAttribute("managerBeans", member.get(0));
			m.addAttribute("character", "manager");
			return "main";
		} else {
			m.addAttribute("memberBeans", member.get(0));
			m.addAttribute("character", "member");
			return "Home";
		}
	}

	@RequestMapping(path = "/GoBackToHome")
	public String goBackToHome() {
		return "main";
	}

	@PostMapping(path = "/ManagerLogout")
	public String managerLogout(SessionStatus status) {
		status.setComplete();
		return "redirect:../html/MemberLogin.html?logout=success";
	}

	@RequestMapping(path = "/Register", method = { RequestMethod.GET, RequestMethod.POST })
	public String memberRegister(Model m) {
		m.addAttribute("member", new Member());
		return "MemberRegister";
	}
}
