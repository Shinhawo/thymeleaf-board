package kr.co.jhta.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import kr.co.jhta.entity.Member;
import kr.co.jhta.exception.DuplicatedEmailException;
import kr.co.jhta.exception.DuplicatedMemberIdException;
import kr.co.jhta.repository.MemberRepository;
import kr.co.jhta.web.form.RegisterMemberForm;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberService {

	private final MemberRepository memberRepository;
	
	public void registerUser(RegisterMemberForm form) {
		
		// 아이디로 사용자 정보 조회하기
		Optional<Member> opyionalMember = memberRepository.findById(form.getId());
		if (opyionalMember.isPresent()) {
			throw new DuplicatedMemberIdException(form.getId());
		}
		
		// 이메일로 사용자 정보 조회하기
		opyionalMember = memberRepository.findByEmail(form.getEmail());
		if (opyionalMember.isPresent()) {
			throw new DuplicatedEmailException(form.getEmail());
		}
		
		Member member = new Member();
		BeanUtils.copyProperties(form, member);
		memberRepository.save(member);			
	}
	
}
