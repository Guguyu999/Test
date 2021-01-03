package jsu.com.dao;

import jsu.com.bean.User;
import jsu.com.utils.DBUtils;
import java.sql.ResultSet;

public class UserDAO {
    // 保存注册用户
    public boolean saveUser(User user) {
        String sql = "insert into user(id,username,password,realname,sex,age)" +
                "values(?,?,?,?,?,?)";
        return DBUtils.save(sql,user.getId(),user.getUsername(),user.getPassword(),
                user.getRealname(),user.getSex(),user.getAge());
    }

    //查询用户名的数量
    public Integer selectUserCount(String username) {
        String sql = "select count(*) from user where username=?";
        Integer count = DBUtils.getCount(sql,username);
        return count;
    }

    //查找用户名和密码
    public static User NameAndPsd(String username, String password) throws Exception {
        String sql = "select * from user where username='"+username+"' and password='"+password+"'";
        User user = new User();
        ResultSet rs = DBUtils.selectMessage(sql);
        while(rs.next()) {
            user.setId(rs.getString("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setRealname(rs.getString("realname"));
            user.setSex(rs.getString("sex"));
            user.setAge(rs.getInt(6));
        }
        if(user.getId()==null){
            return null;
        }
        return user;
    }

    //修改用户密码
    public boolean updatePsd(String password,String id) {
        String sql = "update user set password = ? where id = ?";
        return DBUtils.update(sql,password,id);
    }
}
