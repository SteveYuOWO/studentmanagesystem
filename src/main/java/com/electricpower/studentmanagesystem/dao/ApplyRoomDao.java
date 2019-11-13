package com.electricpower.studentmanagesystem.dao;

import com.electricpower.studentmanagesystem.dbutils.DBUtils;
import com.electricpower.studentmanagesystem.pojo.ApplyRoom;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@Repository
public class ApplyRoomDao {
    public ApplyRoom getApplyRoombyStuNum(String stuNum) {
        ApplyRoom applyRoom=null;
        Connection conn = DBUtils.getConnection();
        Statement stmt = DBUtils.getStatement(conn);
        ResultSet rs = DBUtils.executeQuery(stmt, "select * from applyRoom where stuNum='" + stuNum + "'");
        try{
            while (rs.next()){
                applyRoom=new ApplyRoom();
                applyRoom.setId(rs.getInt(1)).setStuNum(rs.getString(2));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        DBUtils.releaseStatement(stmt);
        DBUtils.releaseConnection(conn);
        return applyRoom;
    }

    public void addStudent(String stuNum) {
        Connection conn = DBUtils.getConnection();
        Statement stmt = DBUtils.getStatement(conn);
        DBUtils.execute(stmt, "insert applyRoom values(null,'"+stuNum+"',0)");
        DBUtils.releaseStatement(stmt);
        DBUtils.releaseConnection(conn);
    }
}