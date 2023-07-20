package kr.co.jhta.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicInsert;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "sample_board_members")
@Getter
@Setter
@NoArgsConstructor
@DynamicInsert
public class Member {

	@Id
	// updatable -> 변경 가능?
	@Column(name = "member_id", updatable = false)
	private String id;
	
	@Column(name = "member_password", nullable = false)
	private String password;
	
	@Column(name = "member_name", nullable = false)
	private String name;
	
	@Column(name = "member_email", nullable = false, unique = true)
	private String email;
	
	@Column(name = "member_tel")
	private String tel;
	
	@Column(name = "member_deleted")
	private String deleted;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "MEMBER_UPDATED_DATE")
	private Date updateDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "MEMBER_CREATED_DATE")
	private Date createDate;
}
