package jsu.com.bean;

public class Student {
    String id;
    String sno;
    String name;
    String classgrade;
    String roomid;
    String houseid;

    public Student(){

    }

    public Student(String sno, String name, String classgrade, String roomid, String houseid) {
        this.sno = sno;
        this.name = name;
        this.classgrade = classgrade;
        this.roomid = roomid;
        this.houseid = houseid;
    }

    public Student(String id, String sno, String name, String classgrade, String roomid, String houseid) {
        this.id = id;
        this.sno = sno;
        this.name = name;
        this.classgrade = classgrade;
        this.roomid = roomid;
        this.houseid = houseid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassgrade() {
        return classgrade;
    }

    public void setClassgrade(String classgrade) {
        this.classgrade = classgrade;
    }

    public String getRoomid() {
        return roomid;
    }

    public void setRoomid(String roomid) {
        this.roomid = roomid;
    }

    public String getHouseid() {
        return houseid;
    }

    public void setHouseid(String houseid) {
        this.houseid = houseid;
    }

    @Override
    public String toString() {
        return "Student{" +
                "学号='" + sno + '\'' +
                "姓名='" + name + '\'' +
                "班级='" + classgrade + '\'' +
                "寝室号='" + roomid + '\'' +
                "楼房号='" + houseid + '\'' +
                '}';
    }
}
