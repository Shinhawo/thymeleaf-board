package kr.co.jhta.web.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.jhta.exception.DuplicatedEmailException;
import kr.co.jhta.exception.DuplicatedMemberIdException;
import kr.co.jhta.service.MemberService;
import kr.co.jhta.web.form.RegisterMemberForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Controller
@RequestMapping("/member")
@Slf4j
public class MemberControiller {

	private final MemberService memberService;
	
	@GetMapping("/register")
	public String form(Model model) {
	
		model.addAttribute("registerMemberForm", new RegisterMemberForm());
		return "member/form";
	}
	
	@PostMapping("/register")
	public String register(@Valid RegisterMemberForm form, BindingResult errors) {
		log.info("errors -> {}", errors);
		if(errors.hasErrors()) {
			// 유효성 체크를 통과하지 못한 경우 입력 폼 화면으로 다시 돌려보낸다.
			return "member/form";
		}
		
		try {
			memberService.registerUser(form);
		} catch (DuplicatedMemberIdException ex) {
			errors.rejectValue("id", null, "이미 사용중인 아이디입니다.");
			return "member/form";
		} catch (DuplicatedEmailException ex) {
			errors.rejectValue("email", null, "이미 사용중인 이메일입니다.");
			return "member/form";
		}
		
		return "redirect:registered";
	}
	
	@GetMapping("/registered")
	public String registered() {
		
		return "member/registered";
	}
}
