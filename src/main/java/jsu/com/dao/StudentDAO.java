package jsu.com.dao;

import jsu.com.bean.Student;
import jsu.com.utils.DBUtils;

import java.sql.ResultSet;

public class StudentDAO {
    //根据查询条件查询学生信息
    public Student selStuMessage(String message, String methond) throws Exception {
        String sql = "select * from student where "+methond+"='"+message+"'";
        Student student = new Student();
        ResultSet rs = DBUtils.selectMessage(sql);
        while(rs.next()) {
            student.setId(rs.getString("id"));
            student.setSno(rs.getString("sno"));
            student.setName(rs.getString("name"));
            student.setClassgrade(rs.getString("classgrade"));
            student.setRoomid(rs.getString("roomid"));
            student.setHouseid(rs.getString("houseid"));
        }
        if(student.getId()==null){
            return null;
        }
        return student;
    }

    //根据id修改学生信息
    public static boolean updateStudent(Student student,String id) {
        String sql = "update student set sno = ?,name = ?,classgrade = ?,roomid = ?,houseid = ? where id = ?";
        return DBUtils.update(sql,student.getSno(),student.getName(),student.getClassgrade(),
                student.getRoomid(),student.getHouseid(),id);
    }
}
