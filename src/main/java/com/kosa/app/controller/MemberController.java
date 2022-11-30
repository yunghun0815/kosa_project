package com.kosa.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kosa.app.model.MemberVo;
import com.kosa.app.service.IMemberService;

@RequestMapping("/member")
@Controller
public class MemberController {

	@Autowired
	IMemberService memberSerivce;
	
	@GetMapping("/login")
	public String loginPage(@RequestParam(value="exception", required = false) String exception, Model model) {
		model.addAttribute("exception", exception);
		return "/member/login";
	}
	@GetMapping("/signup")
	public String signupPage() {
		return "/member/signup";
	}
	@PostMapping("/signup")
	public String signup(MemberVo vo) {
		memberSerivce.signup(vo);
		return "redirect:/member/login";
	}
}
