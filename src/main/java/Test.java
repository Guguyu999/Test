import jsu.com.bean.Record;
import jsu.com.bean.Room;
import jsu.com.bean.Student;
import jsu.com.bean.User;
import jsu.com.dao.RecordDAO;
import jsu.com.dao.RoomDAO;
import jsu.com.dao.StudentDAO;
import jsu.com.dao.UserDAO;
import jsu.com.utils.DBUtils;

import java.sql.ResultSet;
import java.util.List;

public class Test {
    public static void main(String[] args) throws Exception {
//        User user = new User(null,"djz","123456","大姐和猪","女",20);
//        if(new UserDAO().saveUser(user)){
//            System.out.println("保存成功！");
//        }else{
//            System.out.println("保存失败");
//        }
//        User user = new User();
//        ResultSet rs = UserDAO.getUserById("1");
//        while(rs.next()) {
//            user.setId(rs.getString("id"));
//            user.setUsername(rs.getString("username"));
//            user.setPassword(rs.getString("password"));
//            user.setRealname(rs.getString("realname"));
//            user.setSex(rs.getString("sex"));
//            user.setAge(rs.getInt(6));
//        }
//        String username="guguyu";
//        String password="123456";
//        String sql = "select * from user where username='"+username+"' and password='"+password+"'";

//        System.out.println(sql);
//        user = UserDAO.NameAndPsd("guguyu","123456");
//        System.out.println(user.toString());


//        Record record = new Record(null,"憨批","2020-12-30 12:00","2020-12-30 18:00","13623456789","无","无");
//        if(new RecordDAO().saveRecord(record)){
//            System.out.println("记录信息保存成功！");
//        }else{
//            System.out.println("记录信息保存失败");
//        }
//        Record record = new Record("1","憨批","2020-12-30 12:00","2020-12-30 18:00","13623456789","无","无");
//        boolean flag = new RecordDAO().searchMessage(record);
//        if(flag){
//            System.out.println("1111111");
//        }

//        String methond="sno";
//        String message="2018401278";
//        String sql = "select * from student where "+methond+"='"+message+"'";
//        System.out.println(sql);
//        Student student = new Student();
//        student = new StudentDAO().selStuMessage(message,methond);
//        System.out.println(student.toString());

//        Student student = new Student("2020666666","hhh","20软6","666","6栋");
//        boolean flag = StudentDAO.updateStudent(student,"5");
//        if (flag){
//            System.out.println("修改成功");
//        }else {
//            System.out.println("修改失败");
//        }

//        if(new RoomDAO().deleteRoom("666")){
//            System.out.println("删除成功");
//        }else{
//            System.out.println("删除失败");
//        }

//        Room room = new RoomDAO().selRoomMessage("666");
//        System.out.println(room.toString());

//        Room room = new Room(null,"333","3栋","一般","门损坏");
//        if(new RoomDAO().saveRoom(room)){
//            System.out.println("保存成功！");
//        }else{
//            System.out.println("保存失败");
//        }
//        String cleanlevel = "cleanlevel";
//        boolean flag = new RoomDAO().updateRoom(cleanlevel,"优秀","9");
//        if(flag){
//            System.out.println("修改成功");
//        }else {
//            System.out.println("修改失败");
//        }

//        System.out.println(isLetterDigit("123"));
//        System.out.println(isLetterDigit("abc"));
//        System.out.println(isLetterDigit("_123abc"));
//        System.out.println(isLetterDigit("abc123"));
//        System.out.println(isLetterDigit("1a2b3c"));
//        System.out.println(isLetterDigit("aaabbbccc123"));
//        System.out.println(isLetterDigit("哈哈a"));
//        System.out.println(isLetterDigit("a哈哈"));
//        System.out.println(isLetterDigit("哈a哈a"));
//        System.out.println(isLetterDigit("哈哈"));

        RoomDAO roomDao = new RoomDAO();
        try {
            List<Room> rooms = roomDao.selectRoom();
            System.out.println(rooms);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public static boolean isLetterDigit(String str) {
//        //字母开头，后面只能包含字母或数字,并且长度是4-10之间
////        String regex = "^[a-zA-Z][a-zA-Z0-9]{5,13}+$";
//        //只能是汉字,并且长度是1-10之间
//        String regex = "^[\u4e00-\u9fa5]{0,11}$";
//        return str.matches(regex);
//    }
}
