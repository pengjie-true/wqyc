package com.uporanges.evo;

import org.springframework.web.multipart.MultipartFile;

public class StudentResumePicDoc {

	private Integer resume_id;
	private Integer user_id;
	private MultipartFile resume_pic;
	private MultipartFile resume_document;
	public StudentResumePicDoc() {}
	public StudentResumePicDoc(Integer resume_id, Integer user_id, MultipartFile resume_pic,
			MultipartFile resume_document) {
		super();
		this.resume_id = resume_id;
		this.user_id = user_id;
		this.resume_pic = resume_pic;
		this.resume_document = resume_document;
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
	public MultipartFile getResume_pic() {
		return resume_pic;
	}
	public void setResume_pic(MultipartFile resume_pic) {
		this.resume_pic = resume_pic;
	}
	public MultipartFile getResume_document() {
		return resume_document;
	}
	public void setResume_document(MultipartFile resume_document) {
		this.resume_document = resume_document;
	}
	
}
