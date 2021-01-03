package jsu.com.dao;

import jsu.com.bean.Room;
import jsu.com.utils.DBUtils;
import java.sql.ResultSet;
import java.util.List;

public class RoomDAO {
    //查询学生宿舍情况
    public Room selRoomMessage(String message) throws Exception {
        String sql = "select * from room where roomid='"+message+"'";
        Room room = new Room();
        ResultSet rs = DBUtils.selectMessage(sql);
        while(rs.next()) {
            room.setId(rs.getString("id"));
            room.setRoomid(rs.getString("roomid"));
            room.setHouseid(rs.getString("houseid"));
            room.setCleanlevel(rs.getString("cleanlevel"));
            room.setRepairs(rs.getString("repairs"));
        }
        if(room.getId()==null){
            return null;
        }
        return room;
    }

    //删除宿舍信息
    public boolean deleteRoom(String message) throws Exception {
        String sql = "delete from room where roomid= ?";
        return DBUtils.deleteMessage(sql,message);
    }

    //查询寝室的数情况
    public Integer selectUserCount(String roomid) {
        String sql = "select count(*) from room where roomid=?";
        Integer count = DBUtils.getCount(sql,roomid);
        return count;
    }

    // 保存寝室记录
    public boolean saveRoom(Room room) {
        String sql = "insert into room(id,roomid,houseid,cleanlevel,repairs)" +
                "values(?,?,?,?,?)";
        return DBUtils.save(sql,room.getId(),room.getRoomid(),room.getHouseid(),room.getCleanlevel(),room.getRepairs());
    }

    //根据id修改寝室信息
    public boolean updateRoom(String name, String message, String id) {
        String sql = "update room set "+name+"=? where id = ?";
        return DBUtils.update(sql,message,id);
    }

    //查询所有宿舍信息
    public List<Room> selectRoom() throws Exception {
        String sql = "select * from room";
        List<Room> rooms = DBUtils.selectRooms(sql);
        return rooms;
    }
}
