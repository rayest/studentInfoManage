package cn.rayest.model;

import java.util.Date;

/**
 * Created by Rayest on 2016/8/25 0025.
 */
public class Student {
    private int stuId;
    private String stuNo;
    private String stuName;
    private String sex;
    private Date birthday;
    private int gradeId;
    private String email;
    private String stuDesc;
    private String gradeName;

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public String getStuNo() {
        return stuNo;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getGradeId() {
        return gradeId;
    }

    public void setGradeId(int gradeId) {
        this.gradeId = gradeId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStuDesc() {
        return stuDesc;
    }

    public void setStuDesc(String stuDesc) {
        this.stuDesc = stuDesc;
    }
}
