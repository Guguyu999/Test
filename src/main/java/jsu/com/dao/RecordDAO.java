package jsu.com.dao;

import jsu.com.bean.Record;
import jsu.com.utils.DBUtils;
import java.sql.ResultSet;

public class RecordDAO {
    // 保存登记信息
    public boolean saveRecord(Record record) {
        String sql = "insert into record(id,name,starttime,endtime,tel,intoitems,outitems)" +
                "values(?,?,?,?,?,?,?)";
        return DBUtils.save(sql,record.getId(),record.getName(),record.getStarttime(),record.getEndtime(),
                record.getTel(),record.getIntoitems(),record.getOutitems());
    }

    //查找是否有相同的登记信息
    public boolean searchMessage(Record record) throws Exception {
        String sql = "select * from record where name='"+record.getName()+"'";
        Record selrecord = new Record();
        ResultSet rs = DBUtils.selectMessage(sql);
        while(rs.next()) {
            selrecord.setId(rs.getString("id"));
            selrecord.setName(rs.getString("name"));
            selrecord.setStarttime(rs.getString("starttime"));
            selrecord.setEndtime(rs.getString("endtime"));
            selrecord.setTel(rs.getString("tel"));
            selrecord.setIntoitems(rs.getString("intoitems"));
            selrecord.setOutitems(rs.getString("outitems"));
        }
        //判断登记信息是否相同
        if(record.getName().equals(selrecord.getName())&&record.getStarttime().equals(selrecord.getStarttime())&&
                record.getEndtime().equals(selrecord.getEndtime())&&record.getTel().equals(selrecord.getTel())&&
                record.getIntoitems().equals(selrecord.getIntoitems())&&record.getOutitems().equals(selrecord.getOutitems())){
            return true;
        }else {
            return false;
        }
    }
}
