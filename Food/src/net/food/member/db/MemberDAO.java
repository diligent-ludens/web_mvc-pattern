package net.food.member.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import net.food.qna.db.QnaDTO;


public class MemberDAO {
	DataSource ds;
	Connection con;
	PreparedStatement psmt;
	ResultSet rs;
	
	public MemberDAO() {
		try {
			Context init = new InitialContext();
			ds=(DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
		} catch (NamingException e) {		
			e.printStackTrace();	
		}
	}

	public boolean memberInsert(MemberBean membean) throws SQLException{
		String sql = "";
		int result = 0;
				
		try {					
			con=ds.getConnection();		
			sql= "insert into member (MEMBER_NAME, MEMBER_ID, MEMBER_PW, MEMBER_PWCK, MEMBER_EMAIL, MEMBER_TEL) "
					+"values(?,?,?,?,?,?)";
			
			psmt=con.prepareStatement(sql);
			psmt.setString(1, membean.getMEMBER_NAME());
			psmt.setString(2, membean.getMEMBER_ID());
			psmt.setString(3, membean.getMEMBER_PW());
			psmt.setString(4, membean.getMEMBER_PWCK());
			psmt.setString(5, membean.getMEMBER_EMAIL());
			psmt.setString(6, membean.getMEMBER_TEL());
			result = psmt.executeUpdate();
			
			if(result == 0) {return false;}
			else return true;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("ㅇㅇ");
		}finally {
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(psmt!=null) try{psmt.close();}catch(SQLException ex){}
			if(con!=null) try{con.close();}catch(SQLException ex){}	
			}
		return false;
		}
	
	public int userCheck(String id, String pw) throws SQLException{
		String sql = null;
		int x = -1;
		
		try{
			con = ds.getConnection();
			sql="select MEMBER_PW from member where MEMBER_ID = ?";
			psmt=con.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			
			if(rs.next()){
				String memberpw=rs.getString("MEMBER_PW");
				
				if(memberpw.equals(pw)){
					x = 1;
					return x;
				}else{
					x = 0;
					return x;
				}
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}	finally{
			try{
				if(rs!=null)rs.close();
				if(psmt!=null)psmt.close();
				if(con!=null)con.close();
			}catch(Exception ex) {}
		}
		
		return x;
	}
	
	public boolean isAdmin(String id){
		String sql="select MEMBER_ADMIN from MEMBER where MEMBER_ID=?";
		int member_admin=0;
		boolean result = false;
		try {
			con = ds.getConnection();
			psmt=con.prepareStatement(sql);
			psmt.setString(1, id);
			rs=psmt.executeQuery();
			rs.next();
			
			member_admin=rs.getInt("MEMBER_ADMIN");
			
			if(member_admin==1){
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try{
				if(rs!=null)rs.close();
				if(psmt!=null)psmt.close();
				if(con!=null)con.close();
			}catch(Exception ex) {}
		}
		return result;
	}
	
	public int confirmId(String id) throws SQLException{
		String sql=null;
		int x=-1;
		
		try{
			con = ds.getConnection();
			sql="select MEMBER_ID from member where MEMBER_ID=? ";
			
			psmt=con.prepareStatement(sql);
			psmt.setString(1, id);
			rs=psmt.executeQuery();
			
			if(rs.next()){
				x=1;
			}
		}catch(Exception e){
			e.printStackTrace();
		}	finally{
			try{
				if(rs!=null)rs.close();
				if(psmt!=null)psmt.close();
				if(con!=null)con.close();
			}catch(Exception ex) {}
		}
		
		return x;
	}
	public MemberBean findId(String name, String tel)
			throws SQLException{
				String sql=null;
				MemberBean member=null;
				
				try{
					con = ds.getConnection();
					sql="select MEMBER_ID, MEMBER_TEL from member where MEMBER_NAME=?";
					
					psmt=con.prepareStatement(sql);
					psmt.setString(1, name);
					rs=psmt.executeQuery();
					
					if(rs.next()){
						
						String membertel=rs.getString("MEMBER_TEL");
						
						if(membertel.equals(tel) ){
							member = new MemberBean();
							member.setMEMBER_ID(rs.getString("MEMBER_ID"));
							member.setMEMBER_PW(rs.getString("MEMBER_PW"));
							
						}
					}
					
					
				}catch(Exception e){
					e.printStackTrace();
				}	finally{
					try{
						if(rs!=null)rs.close();
						if(psmt!=null)psmt.close();
						if(con!=null)con.close();
					}catch(Exception ex) {}
				}
				
				return member;
			}
			
	public List getMemberList(String id){
		
		String sql=
				"select MEMBER_NAME, MEMBER_ID, MEMBER_EMAIL, MEMBER_TEL from member where MEMBER_ID = ?";
				
		
		List list = new ArrayList();
		
		
		try{
			con = ds.getConnection();
			psmt = con.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			
			if(rs.next()){
				MemberBean mem = new MemberBean();
				mem.setMEMBER_NAME(rs.getString("MEMBER_NAME"));
				mem.setMEMBER_ID(rs.getString("MEMBER_ID"));
				mem.setMEMBER_EMAIL(rs.getString("MEMBER_EMAIL"));
				mem.setMEMBER_TEL(rs.getString("MEMBER_TEL"));
				
				
				
				list.add(mem);
				return list;
			}
			
			
			
		}catch(Exception ex){
			System.out.println("getQnaList 에러 : " + ex);
		}finally{
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(psmt!=null) try{psmt.close();}catch(SQLException ex){}
			if(con!=null) try{con.close();}catch(SQLException ex){}
		}
		
		return null;
	}
	}
