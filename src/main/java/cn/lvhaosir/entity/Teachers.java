package cn.lvhaosir.entity;

import javax.persistence.*;

@Table(name = "teachers")
public class Teachers {
    @Id
    @Column(name = "teacher_id")
    private Integer teacherId;

    @Column(name = "teacher_name")
    private String teacherName;

    @Column(name = "teacher_card_id")
    private String teacherCardId;

    @Column(name = "teacher_password")
    private String teacherPassword;

    @Column(name = "department_id")
    private Integer departmentId;

    /**
     * @return teacher_id
     */
    public Integer getTeacherId() {
        return teacherId;
    }

    /**
     * @param teacherId
     */
    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    /**
     * @return teacher_name
     */
    public String getTeacherName() {
        return teacherName;
    }

    /**
     * @param teacherName
     */
    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    /**
     * @return teacher_card_id
     */
    public String getTeacherCardId() {
        return teacherCardId;
    }

    /**
     * @param teacherCardId
     */
    public void setTeacherCardId(String teacherCardId) {
        this.teacherCardId = teacherCardId;
    }

    /**
     * @return teacher_password
     */
    public String getTeacherPassword() {
        return teacherPassword;
    }

    /**
     * @param teacherPassword
     */
    public void setTeacherPassword(String teacherPassword) {
        this.teacherPassword = teacherPassword;
    }

    /**
     * @return department_id
     */
    public Integer getDepartmentId() {
        return departmentId;
    }

    /**
     * @param departmentId
     */
    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }
}