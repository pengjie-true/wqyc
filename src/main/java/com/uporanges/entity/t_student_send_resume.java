package com.uporanges.entity;

import java.util.Date;

public class t_student_send_resume {
    private Integer sendResumeId;

    private Integer userId;

    private Integer resumeId;

    private Integer companyId;

    private Integer expectJobId1;

    private Integer expectJobId2;

    private String resumeExpectWorkplace1;

    private String resumeExpectWorkplace2;

    private Integer resumeExpectSalary;

    private Date resumeToWorkTime;

    private Integer delivarState;

    private Date deliverTime;

    public Integer getSendResumeId() {
        return sendResumeId;
    }

    public void setSendResumeId(Integer sendResumeId) {
        this.sendResumeId = sendResumeId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getResumeId() {
        return resumeId;
    }

    public void setResumeId(Integer resumeId) {
        this.resumeId = resumeId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getExpectJobId1() {
        return expectJobId1;
    }

    public void setExpectJobId1(Integer expectJobId1) {
        this.expectJobId1 = expectJobId1;
    }

    public Integer getExpectJobId2() {
        return expectJobId2;
    }

    public void setExpectJobId2(Integer expectJobId2) {
        this.expectJobId2 = expectJobId2;
    }

    public String getResumeExpectWorkplace1() {
        return resumeExpectWorkplace1;
    }

    public void setResumeExpectWorkplace1(String resumeExpectWorkplace1) {
        this.resumeExpectWorkplace1 = resumeExpectWorkplace1;
    }

    public String getResumeExpectWorkplace2() {
        return resumeExpectWorkplace2;
    }

    public void setResumeExpectWorkplace2(String resumeExpectWorkplace2) {
        this.resumeExpectWorkplace2 = resumeExpectWorkplace2;
    }

    public Integer getResumeExpectSalary() {
        return resumeExpectSalary;
    }

    public void setResumeExpectSalary(Integer resumeExpectSalary) {
        this.resumeExpectSalary = resumeExpectSalary;
    }

    public Date getResumeToWorkTime() {
        return resumeToWorkTime;
    }

    public void setResumeToWorkTime(Date resumeToWorkTime) {
        this.resumeToWorkTime = resumeToWorkTime;
    }

    public Integer getDelivarState() {
        return delivarState;
    }

    public void setDelivarState(Integer delivarState) {
        this.delivarState = delivarState;
    }

    public Date getDeliverTime() {
        return deliverTime;
    }

    public void setDeliverTime(Date deliverTime) {
        this.deliverTime = deliverTime;
    }
}