package com.uporanges.evo;

import java.sql.Date;
import java.sql.Timestamp;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TStudentResume {

	private Integer resume_id;
	private Integer user_id;
	private String resume_name;
	private MultipartFile resume_pic;
	private String resume_sex;
	@JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
	private Date resume_birthday;
	private String resume_country;
	private String resume_address;
	private String resume_phone1;
	private String resume_phone2;
	private String resume_school;
	@JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
	private Date resume_graduationtime;
	private Integer education_id1;
	private Integer certificate_id1;
	private Integer certificate_id2;
	private Integer certificate_id3;
	private Integer resume_major1;
	private Integer resume_major2;
	private String resume_honor;
	private String resume_project_experience;
	private String resume_internship_experience;
	private String resume_school_experience;
	private String resume_works;
	private String resume_hobby;
	private String resume_evaluate;
	private MultipartFile resume_document;
	private Timestamp resume_creattime;
	public TStudentResume() {}
	public TStudentResume(Integer resume_id, Integer user_id, String resume_name, MultipartFile resume_pic,
			String resume_sex, Date resume_birthday, String resume_country, String resume_address, String resume_phone1,
			String resume_phone2, String resume_school, Date resume_graduationtime, Integer education_id1,
			Integer certificate_id1, Integer certificate_id2, Integer certificate_id3, Integer resume_major1,
			Integer resume_major2, String resume_honor, String resume_project_experience,
			String resume_internship_experience, String resume_school_experience, String resume_works,
			String resume_hobby, String resume_evaluate, MultipartFile resume_document, Timestamp resume_creattime) {
		super();
		this.resume_id = resume_id;
		this.user_id = user_id;
		this.resume_name = resume_name;
		this.resume_pic = resume_pic;
		this.resume_sex = resume_sex;
		this.resume_birthday = resume_birthday;
		this.resume_country = resume_country;
		this.resume_address = resume_address;
		this.resume_phone1 = resume_phone1;
		this.resume_phone2 = resume_phone2;
		this.resume_school = resume_school;
		this.resume_graduationtime = resume_graduationtime;
		this.education_id1 = education_id1;
		this.certificate_id1 = certificate_id1;
		this.certificate_id2 = certificate_id2;
		this.certificate_id3 = certificate_id3;
		this.resume_major1 = resume_major1;
		this.resume_major2 = resume_major2;
		this.resume_honor = resume_honor;
		this.resume_project_experience = resume_project_experience;
		this.resume_internship_experience = resume_internship_experience;
		this.resume_school_experience = resume_school_experience;
		this.resume_works = resume_works;
		this.resume_hobby = resume_hobby;
		this.resume_evaluate = resume_evaluate;
		this.resume_document = resume_document;
		this.resume_creattime = resume_creattime;
	}
	public Integer getResume_id() {
		return resume_id;
	}
	public void setResume_id(Integer resume_id) {
		this.resume_id = resume_id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getResume_name() {
		return resume_name;
	}
	public void setResume_name(String resume_name) {
		this.resume_name = resume_name;
	}
	public MultipartFile getResume_pic() {
		return resume_pic;
	}
	public void setResume_pic(MultipartFile resume_pic) {
		this.resume_pic = resume_pic;
	}
	public String getResume_sex() {
		return resume_sex;
	}
	public void setResume_sex(String resume_sex) {
		this.resume_sex = resume_sex;
	}
	public Date getResume_birthday() {
		return resume_birthday;
	}
	public void setResume_birthday(Date resume_birthday) {
		this.resume_birthday = resume_birthday;
	}
	public String getResume_country() {
		return resume_country;
	}
	public void setResume_country(String resume_country) {
		this.resume_country = resume_country;
	}
	public String getResume_address() {
		return resume_address;
	}
	public void setResume_address(String resume_address) {
		this.resume_address = resume_address;
	}
	public String getResume_phone1() {
		return resume_phone1;
	}
	public void setResume_phone1(String resume_phone1) {
		this.resume_phone1 = resume_phone1;
	}
	public String getResume_phone2() {
		return resume_phone2;
	}
	public void setResume_phone2(String resume_phone2) {
		this.resume_phone2 = resume_phone2;
	}
	public String getResume_school() {
		return resume_school;
	}
	public void setResume_school(String resume_school) {
		this.resume_school = resume_school;
	}
	public Date getResume_graduationtime() {
		return resume_graduationtime;
	}
	public void setResume_graduationtime(Date resume_graduationtime) {
		this.resume_graduationtime = resume_graduationtime;
	}
	public Integer getEducation_id1() {
		return education_id1;
	}
	public void setEducation_id1(Integer education_id1) {
		this.education_id1 = education_id1;
	}
	public Integer getCertificate_id1() {
		return certificate_id1;
	}
	public void setCertificate_id1(Integer certificate_id1) {
		this.certificate_id1 = certificate_id1;
	}
	public Integer getCertificate_id2() {
		return certificate_id2;
	}
	public void setCertificate_id2(Integer certificate_id2) {
		this.certificate_id2 = certificate_id2;
	}
	public Integer getCertificate_id3() {
		return certificate_id3;
	}
	public void setCertificate_id3(Integer certificate_id3) {
		this.certificate_id3 = certificate_id3;
	}
	public Integer getResume_major1() {
		return resume_major1;
	}
	public void setResume_major1(Integer resume_major1) {
		this.resume_major1 = resume_major1;
	}
	public Integer getResume_major2() {
		return resume_major2;
	}
	public void setResume_major2(Integer resume_major2) {
		this.resume_major2 = resume_major2;
	}
	public String getResume_honor() {
		return resume_honor;
	}
	public void setResume_honor(String resume_honor) {
		this.resume_honor = resume_honor;
	}
	public String getResume_project_experience() {
		return resume_project_experience;
	}
	public void setResume_project_experience(String resume_project_experience) {
		this.resume_project_experience = resume_project_experience;
	}
	public String getResume_internship_experience() {
		return resume_internship_experience;
	}
	public void setResume_internship_experience(String resume_internship_experience) {
		this.resume_internship_experience = resume_internship_experience;
	}
	public String getResume_school_experience() {
		return resume_school_experience;
	}
	public void setResume_school_experience(String resume_school_experience) {
		this.resume_school_experience = resume_school_experience;
	}
	public String getResume_works() {
		return resume_works;
	}
	public void setResume_works(String resume_works) {
		this.resume_works = resume_works;
	}
	public String getResume_hobby() {
		return resume_hobby;
	}
	public void setResume_hobby(String resume_hobby) {
		this.resume_hobby = resume_hobby;
	}
	public String getResume_evaluate() {
		return resume_evaluate;
	}
	public void setResume_evaluate(String resume_evaluate) {
		this.resume_evaluate = resume_evaluate;
	}
	public MultipartFile getResume_document() {
		return resume_document;
	}
	public void setResume_document(MultipartFile resume_document) {
		this.resume_document = resume_document;
	}
	public Timestamp getResume_creattime() {
		return resume_creattime;
	}
	public void setResume_creattime(Timestamp resume_creattime) {
		this.resume_creattime = resume_creattime;
	}
	
}
