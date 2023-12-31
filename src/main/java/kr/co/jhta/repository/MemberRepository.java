package kr.co.jhta.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.jhta.entity.Member;

public interface MemberRepository extends JpaRepository<Member, String> {

	// 이메일로 사용자 조회하는 메서드를 직접 정의한다.
	/*
	 * select *
	 * from members
	 * where email = ?
	 */
	Optional<Member> findByEmail(String email);
}
