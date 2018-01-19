package com.rui.web.controller.robot.util;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

public class BaseDao {	
	private static final String url = "jdbc:mysql://192.168.254.47/control";  
    private static final String name = "com.mysql.jdbc.Driver";  
	private static final String user = "root";
	private static final String password = "123456";
	
	/**
	 * ���� ip��ַ
	 * @author : zhuxueke
	 * @since : 2018��1��17��
	 */
	public static String Update(String targetIp,String admin){
		String ip = targetIp;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			String sql = "select * from computer where ip = ? and name = ?";
			Class.forName(name);//ָ����������  
            conn = DriverManager.getConnection(url, user, password);//��ȡ����  
            ps = conn.prepareStatement(sql);//׼��ִ�����  
            ps.setString(1, targetIp);
            ps.setString(2, admin);
            rs = ps.executeQuery();
            if(rs.next()){
            	//����
            	sql = "update computer set ip = ?, name = ?,update_time = ? where id = ?";   
            	ps = conn.prepareStatement(sql);
                ps.setString(1, ip);
            	ps.setString(2, admin);
            	ps.setTimestamp(3,new Timestamp(System.currentTimeMillis()));
            	ps.setInt(4, rs.getInt("id"));
            }else{
            	//����
            	sql = "insert into computer values(?,?,?,?,'123456')"; 
            	int id = getMaxId(conn,ps,rs) + 1;
            	ps = conn.prepareStatement(sql);
            	ps.setInt(1, id);
                ps.setString(2, admin);
            	ps.setString(3, ip);
            	ps.setTimestamp(4,new Timestamp(System.currentTimeMillis()));
            }
            ps.executeUpdate();      
		}catch(Exception e){
			e.printStackTrace();		
		}finally{
			try{
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(conn != null) conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return ip;
	}
	
	@SuppressWarnings("finally")
	private static int getMaxId(Connection conn,PreparedStatement ps,ResultSet rs){
		int ret = 0;
		String sql = "select max(id) as mid from computer";
		try{
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()){
				ret = rs.getInt(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			return ret;	
		}
		
		
	}
}
