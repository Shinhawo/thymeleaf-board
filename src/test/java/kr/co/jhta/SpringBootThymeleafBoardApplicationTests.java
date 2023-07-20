package kr.co.jhta;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import kr.co.jhta.entity.Member;
import kr.co.jhta.repository.MemberRepository;

@SpringBootTest
class SpringBootThymeleafBoardApplicationTests {

	@Autowired
	MemberRepository memberRepository;
	
	@BeforeEach
	public void setup() {
		memberRepository.deleteAll();
	}
	
	@DisplayName("saveMember: 멤버추가에 성공한다.")
	@Test
	//@Disabled
	// test 메서드
	public void testSaveMember() {
	
		// 준비하기
		Member member = new Member();
		member.setId("hong");
		member.setPassword("zxcv1234");
		member.setName("홍길동");
		member.setEmail("hong@gamil.com");
		member.setTel("010-1234-5678");
		
		// 실행하기
		memberRepository.save(member);
		
		// 검증하기
		Member savedMember = memberRepository.findById("hong")
											 .orElseThrow(() -> new RuntimeException());
		
		assertThat(savedMember).isNotNull();
		assertThat(savedMember.getId()).isEqualTo("hong");
		assertThat(savedMember.getName()).isEqualTo("홍길동");
		
	}

}
