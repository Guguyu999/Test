package jsu.com.bean;

public class Room {
    String id;
    String roomid;
    String houseid;
    String cleanlevel;
    String repairs;

    public Room(){

    }

    public Room(String id, String roomid, String houseid, String cleanlevel, String repairs) {
        this.id = id;
        this.roomid = roomid;
        this.houseid = houseid;
        this.cleanlevel = cleanlevel;
        this.repairs = repairs;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getCleanlevel() {
        return cleanlevel;
    }

    public void setCleanlevel(String cleanlevel) {
        this.cleanlevel = cleanlevel;
    }

    public String getRepairs() {
        return repairs;
    }

    public void setRepairs(String repairs) {
        this.repairs = repairs;
    }

    @Override
    public String toString() {
        return "Room{" +
               "寝室号='" + roomid + '\'' +
                "楼房号='" + houseid + '\'' +
                "卫生评比等级='" + cleanlevel + '\'' +
                "设备报修情况='" + repairs + '\'' +
                '}';
    }
}
