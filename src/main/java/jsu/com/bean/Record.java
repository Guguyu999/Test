package jsu.com.bean;

public class Record {
    String id;
    String name;
    String starttime;
    String endtime;
    String tel;
    String intoitems;
    String outitems;

    public Record(){

    }

    public Record(String id, String name, String starttime, String endtime, String tel, String intoitems, String outitems) {
        this.id = id;
        this.name = name;
        this.starttime = starttime;
        this.endtime = endtime;
        this.tel = tel;
        this.intoitems = intoitems;
        this.outitems = outitems;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getIntoitems() {
        return intoitems;
    }

    public void setIntoitems(String intoitems) {
        this.intoitems = intoitems;
    }

    public String getOutitems() {
        return outitems;
    }

    public void setOutitems(String outitems) {
        this.outitems = outitems;
    }

    @Override
    public String toString() {
        return "Record{" +
                "姓名='" + name + '\'' +
                ", 访问时间='" + starttime + '\'' +
                ", 结束访问时间='" + endtime + '\'' +
                ", 电话号码='" + tel + '\'' +
                ", 进楼物品='" + intoitems + '\'' +
                ", 出楼物品='" + outitems + '\'' +
                '}';
    }
}
