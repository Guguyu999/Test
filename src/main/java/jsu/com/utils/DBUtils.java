package jsu.com.utils;

import jsu.com.bean.Room;

import java.lang.reflect.Method;
import java.sql.*;
import java.util.*;

public class DBUtils {
    private static final String DriverName = "com.mysql.jdbc.Driver";   // MySQL驱动程序
    private static final String DBUrl = "jdbc:mysql://localhost:3306/dorm?useSSL=true";   // 数据库连接地址
    private static final String DBUsername = "root";   // 用户名
    private static final String DBPassword = "123456";   // 密码

    // 获取连接对象
    public static Connection getConnection() throws Exception {
        // 加载数据库驱动程序
        Class.forName(DriverName);
        return DriverManager.getConnection(DBUrl, DBUsername, DBPassword);
    }

    // 类型参数，类型变量，类型是可以变化
    public static <T> List<T> getList(Class<T> clazz, String sql, Object... args)  {

        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        List<T> userList = null;

        try {
            // 获取数据库连接对象
            conn = DBUtils.getConnection();

            // 预编译SQL语句
            ps = conn.prepareStatement(sql);

            // 如果有条件参数
            if (args != null && args.length > 0) {
                for (int i = 0; i < args.length; ++i) {
                    ps.setObject(i + 1, args[i]);
                }
            }

            // 执行查询，获取结果集
            rs = ps.executeQuery();

            // 获取结果集元数据
            ResultSetMetaData rsmd = rs.getMetaData();

            //获取当前结果集的列数
            int colnum = rsmd.getColumnCount();

            //开辟空间
            userList = new ArrayList<T>();

            while (rs.next()) {
                // key存放列名，value存放列值，for循环完成之后rowMap存放了一条记录
                Map<String, Object> rowMap = new HashMap<String, Object>();

                for (int i = 1; i <= colnum; i++) {
                    String columnName = rsmd.getColumnLabel(i);
                    Object columnValue = rs.getObject(columnName);

                    // 判断查询出来的类的类型，如果是java.sql.Date转成java.util.Date
                    if (columnValue instanceof java.sql.Date) {
                        java.sql.Date date = (java.sql.Date) columnValue;
                        columnValue = new java.util.Date(date.getTime());
                    }
                    rowMap.put(columnName, columnValue);
                }
                //创建一个User对象，给这个User对象赋值
                T bean = clazz.newInstance();
                // userClass  User.class的字节码文件
//            Class<User> clazz = User.class;
                //根据列名给类属性赋值  "set" + 属性名("set" + Id)
                //循环rowMap给User所有属性赋值
                for (Map.Entry<String, Object> entry : rowMap.entrySet()) {

                    String propertyName = entry.getKey();
                    Object propertyValue = entry.getValue();

                    //获取propertyName属性赋值的set方法
                    String methodName = "set" + propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);

                    //对象获取自己对应的字节码文件
                    Method method = clazz.getMethod(methodName, propertyValue.getClass());

                    //调用方法给属性赋值
                    method.invoke(bean, propertyValue);
                }
                userList.add(bean);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            close(conn, ps, rs);
        }
        return userList;
    }

    public static void close(Connection conn, Statement ps, ResultSet rs){
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //    保存对象方法
    public static boolean save(String sql, Object... args)  {

        Connection conn = null;
        PreparedStatement pstate = null;
        Integer count= null;

        try {
            // 获取数据库连接对象
            conn = DBUtils.getConnection();

            // 预编译SQL语句
            pstate = conn.prepareStatement(sql);

            // 如果有条件参数
            if (args != null && args.length > 0) {
                for (int i = 0; i < args.length; ++i) {
                    pstate.setObject(i + 1, args[i]);
                }
            }

            // 返回更新的记录数
            count = pstate.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            close(conn, pstate, null);
        }
        return count != null && count > 0 ? true : false;
    }

    // 查询记录数量
    public static Integer getCount(String sql, Object...args) {

        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pstate = null;
        Integer count = null;

        try {
            // 获取数据库连接对象
            conn = DBUtils.getConnection();

            // 预编译SQL语句
            pstate = conn.prepareStatement(sql);

            // 如果有条件参数
            if (args != null && args.length > 0) {
                for (int i = 0; i < args.length; ++i) {
                    pstate.setObject(i + 1, args[i]);
                }
            }

            // 执行查询，获取结果集
            rs = pstate.executeQuery();

            while (rs.next()) {

                count = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            close(conn, pstate, rs);
        }
        return count;
    }

    // 更新操作
    public static boolean update(String sql, Object... args)  {

        Connection conn = null;
        PreparedStatement ps = null;
        Integer count = 0;

        try {
            // 获取数据库连接对象
            conn = DBUtils.getConnection();

            // 预编译SQL语句
            ps = conn.prepareStatement(sql);

            // 如果有条件参数
            if (args != null && args.length > 0) {
                for (int i = 0; i < args.length; ++i) {
                    ps.setObject(i + 1, args[i]);
                }
            }

            count = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            close(conn, ps, null);
        }
        return count>0?true:false;
    }

    // 更新操作
    public static Integer updateMessage(String sql, Object... args)  {

        Connection conn = null;
        PreparedStatement ps = null;
        Integer count = null;
        ResultSet rs = null;

        try {
            // 获取数据库连接对象
            conn = DBUtils.getConnection();

            // 预编译SQL语句
            ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

            // 如果有条件参数
            if (args != null && args.length > 0) {
                for (int i = 0; i < args.length; ++i) {
                    ps.setObject(i + 1, args[i]);
                }
            }

            ps.executeUpdate();

            rs = ps.getGeneratedKeys();

            if(rs.next()){
                count = rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            close(conn, ps, rs);
        }
        return count;
    }

    //查询信息
    public static ResultSet selectMessage(String sql) throws Exception {
        Connection connection= null;
        PreparedStatement ps = null;
        connection = DBUtils.getConnection();
        ps = connection.prepareStatement(sql);
        return ps.executeQuery();
    }

    //删除信息
    public static boolean deleteMessage(String sql, String message) throws Exception {
        Connection connection= null;
        PreparedStatement ps = null;
        connection = DBUtils.getConnection();
        ps = connection.prepareStatement(sql);
        ps.setString(1,message);
        return ps.executeUpdate() > 0;
    }

    //查询所有宿舍信息
    public static List<Room> selectRooms(String sql) throws Exception {
        List<Room> rooms = new ArrayList<>();
        Connection connection= null;
        PreparedStatement ps = null;
        connection = DBUtils.getConnection();
        ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            Room room = new Room();
            room.setId(rs.getString("id"));
            room.setRoomid(rs.getString("roomid"));
            room.setHouseid(rs.getString("houseid"));
            room.setCleanlevel(rs.getString("cleanlevel"));
            room.setRepairs(rs.getString("repairs"));
            rooms.add(room);
        }
        return rooms;
    }
}
