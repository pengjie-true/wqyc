package com.uporanges.service.deal;

import java.util.Map;

import com.uporanges.entity.Student;
import com.uporanges.entity.StudentResume;
import com.uporanges.entity.User;
import com.uporanges.evo.BackJSON;
import com.uporanges.evo.StudentResumePicDoc;
import com.uporanges.evo.TStudentResume;
import com.uporanges.evo.TStudentSendResume;
import com.uporanges.evo.TTeacherVerifyStudent;

public interface StudentService {

	//增加学生，添加学生信息
	public int addStudent(Student student);
	//增加学生，新用户信息与学生信息同时添加
	public Map<String, Object> addUserStudent(User user, Student student);
	//修改学生信息
	public int alterStudent(Student student);
	//查询学生个人信息
	public BackJSON getStudentInfo(String user_id);
	//根据phone判断是否已经注册
	public boolean ifPhoneIn(String phone);
	//根据email判断是否已经注册
	public boolean ifeMailIn(String email);
	//学生增加基础简历
	public String addResume(StudentResume studentResume);
	//提供选择的学历or荣誉证书or专业
	public String selectCode(String codeName);
	//学生修改基础简历
	public String alterResume(TStudentResume tStudentResume);
	//学生直接添加简历新头像，覆盖原来的头像
	public String updateResumePic(StudentResumePicDoc srpd);
	//学生删除简历头像或附件
	public String deleteResumePicDoc(int resume_id, int user_id, int id);
	//学生简历附件,在删除完的基础上
	public String updateResumeDoc(StudentResumePicDoc srpd);
	//学生删除基础简历
	public String deleteResume(int user_id, int resume_id);
	//学生查看自己简历
	public BackJSON getStudentResume(int user_id);
	//学生向公司发送简历
	public String sendResume(TStudentSendResume tStudentSendResume);
	//学生查询公司提供岗位
	public BackJSON getCompanyJob(int company_id);
	//学生向老师提交申请
	public String toTeacher(TTeacherVerifyStudent ttvs);
	//学生搜索公司（没输入关键字），直接按顺序返回所有公司
	public Map<String, Object> searchCompany(int start);
	//学生搜索公司（单关键字），根据关键字搜索。返回符合条件的公司。
	public Map<String, Object> searchCompany(String key, int start);
	//学生搜索公司（多关键字）（模糊搜索）先按第一个关键字搜索，再根据第二个关键字从第一个关键字里筛选，以此类推。
	public Map<String, Object> searchCompany(String[] key, int start);
	//查看公司详细信息
	public Map<String, Object> companyDetailInfo(int user_id);
	//学生查询更多该公司提供的岗位
	public Map<String, Object> companyMoreJob(int user_id, int job_start, int job_size);
	//学生查询更多与该公司合作老师
	public Map<String, Object> companyMoreTeacher(int user_id, int teacher_start, int teacher_size);
	//根据teacher_id查询老师详细信息
	public Map<String, Object> teacherDetailInfo(int teacher_id);
	//学生查看更多与老师合作的公司
	public Map<String, Object> teacherMoreCompany(int teacher_id, int start, int size);
	
}
