package com.uporanges.service.deal;

import java.io.File;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.uporanges.entity.Job;
import com.uporanges.entity.Student;
import com.uporanges.entity.StudentResume;
import com.uporanges.entity.StudentSendResume;
import com.uporanges.entity.User;
import com.uporanges.evo.BackJSON;
import com.uporanges.evo.StuApplyTeacher;
import com.uporanges.evo.StuCollectJob;
import com.uporanges.evo.StuCollectJobT;
import com.uporanges.evo.StuResumeCheck;
import com.uporanges.evo.StudentInfo;
import com.uporanges.evo.StudentResumePicDoc;
import com.uporanges.evo.TStudentResume;
import com.uporanges.evo.TStudentSendResume;
import com.uporanges.evo.TTeacherVerifyStudent;
import com.uporanges.mapper.deal.StudentMapper;
import com.uporanges.util.Value;

@Service
@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.DEFAULT)
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentMapper studentMapper;
	
	public int addStudent(Student student) {
		long now = System.currentTimeMillis();
		student.setStu_createdtime(new Timestamp(now));
		student.setStu_status(1);
		student.setIs_mobile_check(1);
		student.setLast_login_time(new Timestamp(now));
		return studentMapper.addStudent(student);
	}
	@Transactional
	public Map<String, Object> addUserStudent(User user, Student student) {
		Map<String, Object> result = new HashMap<String, Object>();
		MultipartFile pic = user.getUser_pic();
		result.put("code", 400);
		if(studentMapper.addUser(user)==1) {
			int user_id = user.getUser_id();
			//写入用户头像
			if(pic!=null) {
				String path = Value.getUserpicpath();
				//文件名字： 1-1539663242037-pic.jpg
				String fileName = user.getUser_id()+"-"+System.currentTimeMillis()+"-"+pic.getOriginalFilename();
				File file = new File(path+File.separator+fileName);
				try {
					pic.transferTo(file);
					studentMapper.addUserPicture(user_id, fileName);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			student.setUser(user);
			if(studentMapper.addStudent(student)==1)
			{
				result.replace("code", 200);
				result.put("user_id", user_id);
			}
		}
		return result;
	}
	public int alterStudent(Student student) {
		return studentMapper.alterStudent(student);
	}
	public BackJSON getStudentInfo(String user_id) {
		BackJSON json = new BackJSON();
		json.setCode(200);
		StudentInfo studentInfo = studentMapper.getStudentInfo(user_id);
		if(studentInfo!=null) 
			json.setData(studentInfo);
		else 
			json.setCode(400);
		return json;
	}
	public boolean ifPhoneIn(String phone) {
		if(studentMapper.getUseridName(phone)!=null)
			return true;
		return false;
	}
	public boolean ifeMailIn(String email) {
		if(studentMapper.getStudentIdName(email)!=null)
			return true;
		return false;
	}
	@Transactional
	public String addResume(StudentResume sr) {
		String data = "";
		long now = System.currentTimeMillis();
		//图片和简历名字前缀
		String prefixName = sr.getStudent().getUser().getUser_id()+"-"+now+"-";
		MultipartFile pic = sr.getResume_pic();
		MultipartFile doc = sr.getResume_document();
		//文件名字：user_id-当前毫秒数-文件名字 
		String picName = prefixName + pic.getOriginalFilename();
		String docName = prefixName + doc.getOriginalFilename();
		sr.setResume_creattime(new Timestamp(now));
		if(studentMapper.addResume(sr, picName, docName)==1) {
			//获取要写入的文件
			File picFile = new File(Value.getStudentresumepicpath()+File.separator+picName);
			File docFile = new File(Value.getStudentresumepath()+File.separator+docName);
			try {
				pic.transferTo(picFile);
				doc.transferTo(docFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
			data = "{\"code\":200, \"resume_id\":"+sr.getResume_id()+"}";
		} else
			data = "{\"code\":400, \"resume_id\":0}";
		return data;
	}
	public String selectCode(String codeName) {
		return JSONObject.toJSONString(studentMapper.getCodebyName(codeName));
	}
	@Transactional
	public String alterResume(TStudentResume tsr) {
		String data = "{\"code\":200}";
		MultipartFile pic = tsr.getResume_pic();
		MultipartFile doc = tsr.getResume_document();
		String picName = "";
		String docName = "";
		if(pic!=null || doc!=null) {
			Map<String, Object> preName = studentMapper.getFilePathbyId(tsr.getResume_id(), tsr.getUser_id());
			String prefixName = tsr.getUser_id()+"-"+System.currentTimeMillis()+"-";
			try {
				//首先删除之前的文件，在增加新文件
				if(pic!=null) {
					File prePic = new File((String) preName.get("resume_pic"));
					if(prePic.exists())
						prePic.delete();
					picName = prefixName+pic.getOriginalFilename();
					File picFile = new File(Value.getStudentresumepicpath()+File.separator+picName);
					pic.transferTo(picFile);
				}
				if(doc!=null) {
					File preDoc = new File((String) preName.get("resume_document"));
					if(preDoc.exists())
						preDoc.delete();
					docName = prefixName+doc.getOriginalFilename();
					File docFile = new File(Value.getStudentresumepath()+File.separator+docName);
					doc.transferTo(docFile);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		if(studentMapper.alterResume(tsr, picName, docName)!=1)
			data = "{\"code\":400}";
		return data;
	}
	@Transactional
	public String updateResumePic(StudentResumePicDoc srpd) {
		String data = "{\"code\":200}";
		int user_id = srpd.getUser_id();
		int resume_id = srpd.getResume_id();
		MultipartFile picture = srpd.getResume_pic();
		String picName = user_id+"-"+System.currentTimeMillis()+"-"+picture.getOriginalFilename();
		File prePic = new File((String) studentMapper.getFilePathbyId(resume_id, user_id).get("resume_pic"));
		File picFile = new File(Value.getUserpicpath()+File.separator+picName);
		if(prePic.exists())
			prePic.delete();
		try {
			picture.transferTo(picFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(studentMapper.updateResumePic(resume_id, user_id, picName)!=1)
			data = "{\"code\":400}";
		return data;
	}
	@Transactional
	public String deleteResumePicDoc(int resume_id, int user_id, int id) {
		String data = "{\"code\":200}";
		boolean flag = true;
		Map<String, Object> preName = studentMapper.getFilePathbyId(resume_id, user_id);
		File preFile = null;
		if(id==1) {
			preFile = new File((String) preName.get("resume_pic"));
			if(preFile.exists())
				if(!preFile.delete())
					flag = false;
		} else if(id==2) {
			preFile = new File((String) preName.get("resume_document"));
			if(preFile.exists())
				if(!preFile.delete())
					flag = false;
		}
		if(!flag)
			data = "{\"code\":400}";
		return data;
	}
	@Transactional
	public String updateResumeDoc(StudentResumePicDoc srpd) {
		String data = "{\"code\":200}";
		MultipartFile resume_document = srpd.getResume_document();
		int user_id = srpd.getUser_id();
		String docName = user_id+"-"+System.currentTimeMillis()+"-"+resume_document.getOriginalFilename();
		File docFile = new File(Value.getStudentresumepath()+File.separator+docName);
		try {
			resume_document.transferTo(docFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(studentMapper.updateResumeDoc(srpd.getResume_id(), user_id, docName)!=1)
			data = "{\"code\":400}";
		return data;
	}
	@Transactional
	public String deleteResume(int user_id, int resume_id) {
		String data = "{\"code\":400}";
		if(studentMapper.deleteResume(user_id, resume_id)==1) {
			Map<String, Object> praName = studentMapper.getFilePathbyId(resume_id, user_id);
			File praPic = new File((String) praName.get("resume_id"));
			File praDoc = new File((String) praName.get("resume_document"));
			if(praPic.exists())
				praPic.delete();
			if(praDoc.exists())
				praDoc.delete();
			data = "{\"code\":200}";
		}
		return data;
	}
	@Transactional(readOnly=true)
	public BackJSON getStudentResume(int user_id) {
		BackJSON json = new BackJSON();
		json.setCode(200);
		StudentResume sr = studentMapper.getStudentResume(user_id);
		if(sr!=null) 
			json.setData(sr);
		else 
			json.setCode(400);
		return json;
	}
	@Transactional
	public String sendResume(TStudentSendResume tsr) {
		String data = "{\"code\":400, \"send_resume_id\":0}";
		//delivar_state 0-没看，1-录用，2-拒绝
		tsr.setDelivar_state(0);
		tsr.setDeliver_time(new Timestamp(System.currentTimeMillis()));
		if(studentMapper.sendResume(tsr)==1) 
			data = "{\"code\":200, \"send_resume_id\":"+tsr.getSend_resume_id()+"}";
		return data;
	}
	public BackJSON getCompanyJobs(int company_id) {
		BackJSON json = new BackJSON();
		json.setCode(400);
		List<Job> cjs = studentMapper.getCompanyJobs(company_id);
		if(cjs.size()>0) {
			json.setCode(200);
			json.setData(cjs);
		} else
			json.setCode(202);
		return json;
	}
	//join_state 0-没看，1-录用， 2-拒绝
	@Transactional
	public String toTeacher(TTeacherVerifyStudent ttvs) {
		String data = "{\"code\":200}";
		ttvs.setJoin_state(0);
		ttvs.setJoin_time(new Timestamp(System.currentTimeMillis()));
		if(studentMapper.toTeacher(ttvs)!=1)
			data = "{\"code\":400}";
		return data;
	}
	public BackJSON checkSendResume(int user_id) {
		BackJSON json = new BackJSON();
		json.setCode(400);
		List<StuResumeCheck> src = studentMapper.checkSendResume(user_id);
		if(src.size()>0) {
			json.setData(src);
			json.setCode(200);
		} else
			json.setCode(202);
		return json;
	}
	public BackJSON passedResume(int user_id) {
		BackJSON json = new BackJSON();
		json.setCode(400);
		List<StuResumeCheck> src = studentMapper.passedResume(user_id);
		if(src.size()>0) {
			json.setData(src);
			json.setCode(200);
		} else
			json.setCode(202);
		return json;
	}
	public BackJSON rejectResume(int user_id) {
		BackJSON json = new BackJSON();
		json.setCode(400);
		List<StuResumeCheck> src = studentMapper.rejectResume(user_id);
		if(src.size()>0) {
			json.setData(src);
			json.setCode(200);
		} else
			json.setCode(202);
		return json;
	}
	public BackJSON sendResumeDetail(int send_resume_id) {
		BackJSON json = new BackJSON();
		json.setCode(400);
		json.setData(studentMapper.sendResumeDetail(send_resume_id));
		json.setCode(200);
		return json;
	}
	@Transactional
	public String alterSendResume(StudentSendResume ssr) {
		String data = "{\"code\":200}";
		ssr.setDeliver_time(new Timestamp(System.currentTimeMillis()));
		if(studentMapper.alterSendResume(ssr)!=1)
			data = "{\"code\":400}";
		return data;
	}
	@Transactional
	public String deleteSendResume(int send_resume_id, int user_id) {
		String data = "{\"code\":200}";
		if(studentMapper.deleteSendResume(send_resume_id, user_id)!=1)
			data = "{\"code\":400}";
		return data;
	}
	public BackJSON checkApplyTeacher(int user_id) {
		BackJSON json = new BackJSON();
		json.setCode(400);
		List<StuApplyTeacher> sat = studentMapper.checkApplyTeacher(user_id);
		if(sat.size()>0) {
			json.setData(sat);
			json.setCode(200);
		} else
			json.setCode(202);
		return json;
	}
	public BackJSON passedTeacher(int user_id) {
		BackJSON json = new BackJSON();
		json.setCode(400);
		List<Map<String, Object>> sat = studentMapper.passedTeacher(user_id);
		if(sat.size()>0) {
			json.setData(sat);
			json.setCode(200);
		} else
			json.setCode(202);
		return json;
	}
	public BackJSON rejectTeacher(int user_id) {
		BackJSON json = new BackJSON();
		json.setCode(400);
		List<Map<String, Object>> sat = studentMapper.rejectTeacher(user_id);
		if(sat.size()>0) {
			json.setData(sat);
			json.setCode(200);
		} else
			json.setCode(202);
		return json;
	}
	public String checkApplyDetail(int student_id, int teacher_id) {
		String data = "{\"code\":400}";
		String stu_mess = studentMapper.checkApplyDetail(student_id, teacher_id);
		if(stu_mess!=null)
			data = "{\"code\":200, \"student_message\":"+JSONObject.toJSONString(stu_mess)+"}";
		return data;
	}
	@Transactional
	public String alterApplyTeacher(Map<String, Object> map) {
		String data = "{\"code\":200}";
		map.put("join_time", new Timestamp(System.currentTimeMillis()));
		if(studentMapper.alterApplyTeacher(map)!=1)
			data = "{\"code\":400}";
		return data;
	}
	@Transactional
	public String deleteApplyTeacher(int student_id, int teacher_id) {
		String data = "{\"code\":200}";
		if(studentMapper.deleteApplyTeacher(student_id, teacher_id)!=1)
			data = "{\"code\":400}";
		return data;
	}
	@Transactional
	public String collectJob(StuCollectJobT scjt) {
		String data = "{\"code\":200}";
		scjt.setCollect_time(new Timestamp(System.currentTimeMillis()));
		if(studentMapper.collectJob(scjt)!=1)
			data = "{\"code\":400}";
		return data;
	}
	@Transactional(readOnly=true)
	public BackJSON seeCollectJob(int user_id) {
		BackJSON json = new BackJSON();
		json.setCode(400);
		List<StuCollectJob> scj = studentMapper.seeCollectJob(user_id);
		if(scj.size()>0) {
			json.setData(scj);
			json.setCode(200);
		} else
			json.setCode(202);
		return json;
	}
	@Transactional
	public String deleteCollectJob(int user_id, int job_id, int company_id) {
		String data = "{\"code\":200}";
		if(studentMapper.deleteCollectJob(user_id, job_id, company_id)!=1)
			data = "{\"code\":400}";
		return data;
	}

}
