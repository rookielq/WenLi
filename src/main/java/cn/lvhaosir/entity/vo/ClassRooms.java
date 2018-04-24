package cn.lvhaosir.entity.vo;

import cn.lvhaosir.entity.Rooms;

import java.util.List;

/**
 * Created by lvhaosir on 2018/4/24.
 */
public class ClassRooms {

    private Integer classId;

    private String className;

    private Integer teacherId;

    private List<Rooms> roomsList;


    public ClassRooms() {
    }

    public ClassRooms(Integer classId, String className, Integer teacherId, List<Rooms> roomsList) {
        this.classId = classId;
        this.className = className;
        this.teacherId = teacherId;
        this.roomsList = roomsList;
    }

    @Override
    public String toString() {
        return "ClassRooms{" +
                "classId=" + classId +
                ", className='" + className + '\'' +
                ", teacherId=" + teacherId +
                ", roomsList=" + roomsList +
                '}';
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public List<Rooms> getRoomsList() {
        return roomsList;
    }

    public void setRoomsList(List<Rooms> roomsList) {
        this.roomsList = roomsList;
    }
}
