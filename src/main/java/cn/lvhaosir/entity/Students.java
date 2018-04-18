package cn.lvhaosir.entity;

import javax.persistence.*;

@Table(name = "students")
public class Students {
    @Id
    @Column(name = "student_id")
    private Integer studentId;

    @Column(name = "student_card_id")
    private String studentCardId;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "student_password")
    private String studentPassword;

    @Column(name = "department_id")
    private Integer departmentId;

    @Column(name = "class_id")
    private Integer classId;

    @Column(name = "room_id")
    private Integer roomId;

    /**
     * @return student_id
     */
    public Integer getStudentId() {
        return studentId;
    }

    /**
     * @param studentId
     */
    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    /**
     * @return student_card_id
     */
    public String getStudentCardId() {
        return studentCardId;
    }

    /**
     * @param studentCardId
     */
    public void setStudentCardId(String studentCardId) {
        this.studentCardId = studentCardId;
    }

    /**
     * @return student_name
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * @param studentName
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     * @return student_password
     */
    public String getStudentPassword() {
        return studentPassword;
    }

    /**
     * @param studentPassword
     */
    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword;
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

    /**
     * @return class_id
     */
    public Integer getClassId() {
        return classId;
    }

    /**
     * @param classId
     */
    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    /**
     * @return room_id
     */
    public Integer getRoomId() {
        return roomId;
    }

    /**
     * @param roomId
     */
    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }
}