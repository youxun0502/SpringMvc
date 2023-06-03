package com.liu.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.liu.model.*;

@Controller
@RequestMapping(path = "/Member")
public class MemberController {

	@Autowired
	private MemberService mService;

	@RequestMapping(path = "/memberMain")
	public String memberMain() {
		return "MemberMain";
	}

	@PostMapping(path = "/SelectMember")
	public String select(@RequestParam("memberName") String memberName, Model m) {
		if (memberName.equals("ALL")) {
			List<Member> members = mService.selectAll();
			m.addAttribute("member", members);
			return "MemberDataTable";
		} else {
			List<Member> members = mService.selectByName(memberName);
			m.addAttribute("member", members);
			return "MemberDataTable";
		}
	}

	@PostMapping(path = "/DeleteMember")
	public String delete(@RequestParam("id") int id, Model m) {

		boolean booleanDelete = mService.delete(id);
		if (booleanDelete == true) {
			List<Member> members = mService.selectAll();
			m.addAttribute("member", members);
			m.addAttribute("delete", "success");
			return "MemberDataTable";
		}
		return null;
	}

	@PostMapping(path = "/UpdateFormMember")
	public String updateForm(@RequestParam("id") int id, Model m) {
		Member member = mService.getUpdateForm(id);
		m.addAttribute("member", member);
		return "MemberUpdateForm";
	}

	@PostMapping(path = "/UpdateMember")
	public String update(@ModelAttribute("member") Member updateMember, BindingResult result, Model m) {// BindingResult
																										// 用於捕獲數據綁定過程中的錯誤與驗證結果
		if (result.hasErrors()) {
			for (FieldError error : result.getFieldErrors()) {
				System.out.println(error.getDefaultMessage());
			}
			for (ObjectError error : result.getGlobalErrors()) {
				System.out.println(error.getDefaultMessage());
			}
			List<Member> members = mService.selectAll();
			m.addAttribute("member", members);
			m.addAttribute("update", "unsuccess");
			return "MemberDataTable";
		} else {
			boolean boolean1 = mService.update(updateMember);
			if (boolean1) {
				List<Member> members = mService.selectAll();
				m.addAttribute("member", members);
				m.addAttribute("update", "success");
				return "MemberDataTable";
			} else {
				List<Member> members = mService.selectAll();
				m.addAttribute("member", members);
				m.addAttribute("update", "unsuccess");
				return "MemberDataTable";
			}
		}
	}

	@PostMapping(path = "/InsertMember")
	public String insertMember(@ModelAttribute("member") Member insertMember, BindingResult result, Model m) {
		// 用於捕獲數據綁定過程中的錯誤與驗證結果
		if (result.hasErrors()) {
			for (FieldError error : result.getFieldErrors()) {
				System.out.println(error.getDefaultMessage());
			}
			for (ObjectError error : result.getGlobalErrors()) {
				System.out.println(error.getDefaultMessage());
			}
			return "redirect:http://localhost:8080/group5/html/MemberLogin.html?register=unsuccess";
		} else {
			boolean boolean1 = mService.insert(insertMember);
			if (boolean1) {
				return "redirect:http://localhost:8080/group5/html/MemberLogin.html?register=success";
			} else {
				return "redirect:http://localhost:8080/group5/html/MemberLogin.html?register=unsuccess";
			}
		}
	}
}
