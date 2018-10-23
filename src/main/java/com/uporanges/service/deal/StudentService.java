package com.uporanges.service.deal;

import java.util.Map;

import com.uporanges.entity.Student;
import com.uporanges.entity.StudentResume;
import com.uporanges.entity.StudentSendResume;
import com.uporanges.entity.User;
import com.uporanges.evo.BackJSON;
import com.uporanges.evo.StuCollectJobT;
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
	public BackJSON getCompanyJobs(int company_id);
	//学生向老师提交申请
	public String toTeacher(TTeacherVerifyStudent ttvs);
	//学生查看自己发送给公司的简历（待审核阶段）
	public BackJSON checkSendResume(int user_id);
	//学生查看自己发送给公司的简历（已通过）
	public BackJSON passedResume(int user_id);
	//学生查看自己发送给公司的简历（没通过）
	public BackJSON rejectResume(int user_id);
	//查看自己投递的简历的详细信息
	public BackJSON sendResumeDetail(int send_resume_id);
	//学生修改自己发送的简历
	public String alterSendResume(StudentSendResume ssr);
	//取消发送的简历
	public String deleteSendResume(int send_resume_id, int user_id);
	//学生查看自己向老师提交的申请：（待审核的）
	public BackJSON checkApplyTeacher(int user_id);
	//已经通过的申请
	public BackJSON passedTeacher(int user_id);
	//没通过的申请
	public BackJSON rejectTeacher(int user_id);
	//学生查看自己的申请详情
	public String checkApplyDetail(int student_id, int teacher_id);
	//修改申请
	public String alterApplyTeacher(Map<String, Object> map);
	//取消申请
	public String deleteApplyTeacher(int student_id, int teacher_id);
	//学生收藏岗位
	public String collectJob(StuCollectJobT scjt);
	//查看时收藏的岗位
	public BackJSON seeCollectJob(int user_id);
	//取消收藏岗位
	public String deleteCollectJob(int user_id, int job_id, int company_id);
	
}
