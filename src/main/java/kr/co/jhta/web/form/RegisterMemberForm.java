package kr.co.jhta.web.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
// 값을 담는 용도로만 사용된다.
// 여기에 유효성검사 규칙 정의
public class RegisterMemberForm {

	
	@Size(min = 4, max = 20, message = "아이디는 최소 4글자, 최대 20글자까지만 가능합니다.")
	@NotBlank(message = "아이디는 필수 입력값입니다.")
	private String id;
	
	@NotBlank(message = "비밀번호는 필수 입력값입니다.")
	@Size(min = 8, message = "비밀번호는 최소 8글자 이상만 가능합니다.")
	private String password;
	
	@NotBlank(message = "이름은 필수 입력값입니다.")
	@Size(min = 2, message = "이름은 최소 2글자 이상만 가능합니다.")
	private String name;
	
	@NotBlank(message = "이메일은 필수 입력값입니다.")
	@Email(message = "유효한 이메일 형식이 아닙니다.")
	private String email;
	
	@NotBlank(message = "전화번호는 필수 입력값입니다.")
	@Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "유효한 전화번호 형식이 아닙니다.")
	private String tel;
}
