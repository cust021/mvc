package com.mvc.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mvc.common.DBCon;

public class ClassInfoRepository {

	public List<Map<String,String>> selectClassInfoList() {
		List<Map<String,String>> classInfoList = new ArrayList<>();
		
		try {
			Connection con =  DBCon.getCon();

			String sql = "SELECT * FROM CLASS_INFO WHERE 1=1";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet  rs = ps.executeQuery();
			while(rs.next()) {
				Map<String,String> classInfo = new HashMap<>();
				classInfo.put("ciNum", rs.getString("CI_NUM"));
				classInfo.put("ciName", rs.getString("CI_NAME"));
				classInfo.put("ciDesc", rs.getString("CI_DESC"));
				
				classInfoList.add(classInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return classInfoList;
		
	}

	public Map<String,String> selectclassInfo(String ciNum) {
		
		try {
			Connection con = DBCon.getCon();

			String sql = "SELECT * FROM CLASS_INFO WHERE 1=1 AND CI_NUM=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,ciNum);
			ResultSet  rs = ps.executeQuery();
			while(rs.next()) {
				Map<String,String> classInfo = new HashMap<>();
				classInfo.put("ciNum", rs.getString("CI_NUM"));
				classInfo.put("ciName", rs.getString("CI_NAME"));
				classInfo.put("ciDesc", rs.getString("CI_DESC"));
				
				return classInfo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int insertClassInfo(Map<String,String> classInfo) {
		String sql = "INSERT INTO CLASS_INFO(CI_NAME, CI_DESC)";
		sql += " VALUES(?,?)";
		Connection con = DBCon.getCon();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, classInfo.get("ciName"));
			ps.setString(2, classInfo.get("ciDesc"));
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int updateClassInfo(Map<String,String> classInfo) {
		String sql = "UPDATE CLASS_INFO";
		sql += " SET CI_NAME=?,";
		sql += " CI_DESC=?";
		sql += " WHERE CI_NUM=?";
		Connection con = DBCon.getCon();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, classInfo.get("ciName"));
			ps.setString(2, classInfo.get("ciDesc"));
			ps.setString(3, classInfo.get("ciNum"));
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int deleteClassInfo(String ciNum) {
		String sql = "DELETE FROM CLASS_INFO WHERE CI_NUM=?";
		Connection con = DBCon.getCon();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, ciNum);
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
