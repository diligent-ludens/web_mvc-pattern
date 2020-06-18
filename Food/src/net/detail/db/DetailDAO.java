package net.detail.db;

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

public class DetailDAO {
	DataSource ds;
	Connection con;
	PreparedStatement psmt;
	ResultSet rs;
	
	public DetailDAO() {
		Context init;
		try {
			init = new InitialContext();
			ds = (DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
		} catch (NamingException e) {
			System.out.println("db 연결 실패");
			return;
		}
	}
	// 카테고리 파트
	// 카테고리 별 리스트 개수
		public int getKoreaListCount() {
			int count = 0;
			
			try{
				con = ds.getConnection();
				psmt = con.prepareStatement("select count(*) from DETAIL where DETAIL_CATEGORY = '한식'"); 
				rs = psmt.executeQuery();
				
				if(rs.next()){
					count = rs.getInt(1);
				}
			}catch(Exception e){
				System.out.println("getListCount 에러: " + e);			
			}finally{
				if(rs!=null) try{rs.close();}catch(SQLException e){}
				if(psmt!=null) try{psmt.close();}catch(SQLException e){}
				if(con!=null) try{con.close();}catch(SQLException e){}
			}
			return count;
		}
		
		public int getChinaListCount() {
			int count = 0;
			
			try{
				con = ds.getConnection();
				psmt = con.prepareStatement("select count(*) from DETAIL where DETAIL_CATEGORY = '중식'"); 
				rs = psmt.executeQuery();
				
				if(rs.next()){
					count = rs.getInt(1);
				}
			}catch(Exception e){
				System.out.println("getListCount 에러: " + e);			
			}finally{
				if(rs!=null) try{rs.close();}catch(SQLException e){}
				if(psmt!=null) try{psmt.close();}catch(SQLException e){}
				if(con!=null) try{con.close();}catch(SQLException e){}
			}
			return count;
		}
		
		public int getWestListCount() {
			int count = 0;
			
			try{
				con = ds.getConnection();
				psmt = con.prepareStatement("select count(*) from DETAIL where DETAIL_CATEGORY = '양식'"); 
				rs = psmt.executeQuery();
				
				if(rs.next()){
					count = rs.getInt(1);
				}
			}catch(Exception e){
				System.out.println("getListCount 에러: " + e);			
			}finally{
				if(rs!=null) try{rs.close();}catch(SQLException e){}
				if(psmt!=null) try{psmt.close();}catch(SQLException e){}
				if(con!=null) try{con.close();}catch(SQLException e){}
			}
			return count;
		}
		
		public int getSnackListCount() {
			int count = 0;
			
			try{
				con = ds.getConnection();
				psmt = con.prepareStatement("select count(*) from DETAIL where DETAIL_CATEGORY = '분식'"); 
				rs = psmt.executeQuery();
				
				if(rs.next()){
					count = rs.getInt(1);
				}
			}catch(Exception e){
				System.out.println("getListCount 에러: " + e);			
			}finally{
				if(rs!=null) try{rs.close();}catch(SQLException e){}
				if(psmt!=null) try{psmt.close();}catch(SQLException e){}
				if(con!=null) try{con.close();}catch(SQLException e){}
			}
			return count;
		}
		
		// 카테고리 별 정보 가져오기
		public List getKoreaFoodList(int page, int limit) {
			
			String food_list_sql = "select DETAIL_NUM, DETAIL_NAME, DETAIL_CATEGORY, DETAIL_ADDTER from "
					+ "(select rownum rnum, DETAIL_NUM, DETAIL_NAME, DETAIL_CATEGORY, DETAIL_ADDTER from DETAIL "
					+ "where DETAIL_CATEGORY = '한식') "
					+ "where (rnum >= ? and rnum <= ?)\r\n";
			
			 
			List list = new ArrayList();
		
			int startrow = (page - 1) * 10;
			int endrow = limit;
			
			try {
				con = ds.getConnection();
				psmt = con.prepareStatement(food_list_sql);
				psmt.setInt(1, startrow); 
				psmt.setInt(2, endrow);
				rs = psmt.executeQuery();
				
				while(rs.next()) {
					DetailBean dto = new DetailBean();
					dto.setDETAIL_NUM(rs.getInt("DETAIL_NUM"));
					dto.setDETAIL_NAME(rs.getString("DETAIL_NAME"));
					dto.setDETAIL_CATEGORY(rs.getString("DETAIL_CATEGORY"));
					dto.setDETAIL_ADDTER(rs.getString("DETAIL_ADDTER"));
				
					list.add(dto);
				}
				
				return list;
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				if(rs != null)try{rs.close();}catch(SQLException ex){}
				if(psmt !=null)try{psmt.close();}catch(SQLException ex){}
				if(con != null) try{con.close();}catch(SQLException ex){}
			}
			return null;
		}
		
		public List getChinaFoodList(int page, int limit) {
			
			String food_list_sql = "select DETAIL_NUM, DETAIL_NAME, DETAIL_CATEGORY, DETAIL_ADDTER from "
					+ "(select rownum rnum, DETAIL_NUM, DETAIL_NAME, DETAIL_CATEGORY, DETAIL_ADDTER from DETAIL "
					+ "where DETAIL_CATEGORY = '중식') "
					+ "where (rnum >= ? and rnum <= ?)\r\n";
			
			 
			List list = new ArrayList();
		
			int startrow = (page - 1) * 10;
			int endrow = limit;
			
			try {
				con = ds.getConnection();
				psmt = con.prepareStatement(food_list_sql);
				psmt.setInt(1, startrow); 
				psmt.setInt(2, endrow);
				rs = psmt.executeQuery();
				
				while(rs.next()) {
					DetailBean dto = new DetailBean();
					dto.setDETAIL_NUM(rs.getInt("DETAIL_NUM"));
					dto.setDETAIL_NAME(rs.getString("DETAIL_NAME"));
					dto.setDETAIL_CATEGORY(rs.getString("DETAIL_CATEGORY"));
					dto.setDETAIL_ADDTER(rs.getString("DETAIL_ADDTER"));
				
					list.add(dto);
				}
				
				return list;
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				if(rs != null)try{rs.close();}catch(SQLException ex){}
				if(psmt !=null)try{psmt.close();}catch(SQLException ex){}
				if(con != null) try{con.close();}catch(SQLException ex){}
			}
			return null;
		}
		
		public List getWestFoodList(int page, int limit) {
			
			String food_list_sql = "select DETAIL_NUM, DETAIL_NAME, DETAIL_CATEGORY, DETAIL_ADDTER from "
					+ "(select rownum rnum, DETAIL_NUM, DETAIL_NAME, DETAIL_CATEGORY, DETAIL_ADDTER from DETAIL "
					+ "where DETAIL_CATEGORY = '양식') "
					+ "where (rnum >= ? and rnum <= ?)\r\n";
			
			 
			List list = new ArrayList();
		
			int startrow = (page - 1) * 10;
			int endrow = limit;
			
			try {
				con = ds.getConnection();
				psmt = con.prepareStatement(food_list_sql);
				psmt.setInt(1, startrow); 
				psmt.setInt(2, endrow);
				rs = psmt.executeQuery();
				
				while(rs.next()) {
					DetailBean dto = new DetailBean();
					dto.setDETAIL_NUM(rs.getInt("DETAIL_NUM"));
					dto.setDETAIL_NAME(rs.getString("DETAIL_NAME"));
					dto.setDETAIL_CATEGORY(rs.getString("DETAIL_CATEGORY"));
					dto.setDETAIL_ADDTER(rs.getString("DETAIL_ADDTER"));
				
					list.add(dto);
				}
				
				return list;
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				if(rs != null)try{rs.close();}catch(SQLException ex){}
				if(psmt !=null)try{psmt.close();}catch(SQLException ex){}
				if(con != null) try{con.close();}catch(SQLException ex){}
			}
			return null;
		}
		
		public List getSnackFoodList(int page, int limit) {
			
			String food_list_sql = "select DETAIL_NUM, DETAIL_NAME, DETAIL_CATEGORY, DETAIL_ADDTER from "
					+ "(select rownum rnum, DETAIL_NUM, DETAIL_NAME, DETAIL_CATEGORY, DETAIL_ADDTER from DETAIL "
					+ "where DETAIL_CATEGORY = '분식') "
					+ "where (rnum >= ? and rnum <= ?)\r\n";
			
			 
			List list = new ArrayList();
		
			int startrow = (page - 1) * 10;
			int endrow = limit;
			
			try {
				con = ds.getConnection();
				psmt = con.prepareStatement(food_list_sql);
				psmt.setInt(1, startrow); 
				psmt.setInt(2, endrow);
				rs = psmt.executeQuery();
				
				while(rs.next()) {
					DetailBean dto = new DetailBean();
					dto.setDETAIL_NUM(rs.getInt("DETAIL_NUM"));
					dto.setDETAIL_NAME(rs.getString("DETAIL_NAME"));
					dto.setDETAIL_CATEGORY(rs.getString("DETAIL_CATEGORY"));
					dto.setDETAIL_ADDTER(rs.getString("DETAIL_ADDTER"));
				
					list.add(dto);
				}
				
				return list;
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				if(rs != null)try{rs.close();}catch(SQLException ex){}
				if(psmt !=null)try{psmt.close();}catch(SQLException ex){}
				if(con != null) try{con.close();}catch(SQLException ex){}
			}
			return null;
		}
	
	// 상세정보 파트
	public List getDetailList() {
		List<DetailBean> list = new ArrayList();
		String sql="select DETAIL_NUM, DETAIL_CATEGORY,DETAIL_NAME,DETAIL_CONTENT,DETAIL_ADDTER,DETAIL_IMAGE  from detail";
						
		
		try {
			con = ds.getConnection();
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			System.out.println(rs.next());
			
			while(rs.next()) {
				DetailBean agb = new DetailBean();
				agb.setDETAIL_NUM(rs.getInt("DETAIL_NUM"));
				agb.setDETAIL_CATEGORY(rs.getString("DETAIL_CATEGORY"));
				agb.setDETAIL_NAME(rs.getString("DETAIL_NAME"));
				agb.setDETAIL_CONTENT(rs.getString("DETAIL_CONTENT"));
				agb.setDETAIL_ADDTER(rs.getString("DETAIL_ADDTER"));
				agb.setDETAIL_IMAGE(rs.getString("DETAIL_IMAGE"));
				//agb.setDETAIL_BEST(rs.getInt("dti_best"));
				//agb.setDETAIL_DATE(rs.getString("dti_date"));
				 
				list.add(agb);
				System.out.println("if조건 들어옴");
				
				
			}
			return list;
			
		} catch (Exception e) {
			e.getStackTrace();
		}
		finally{
			if(rs != null)try{rs.close();}catch(SQLException ex){}
			if(psmt !=null)try{psmt.close();}catch(SQLException ex){}
			if(con != null) try{con.close();}catch(SQLException ex){}
		}
		return null;
	}
	
	public DetailBean getDetail(int num) {
		DetailBean agb = null;
		try {
			con = ds.getConnection();
			String sql="select * from detail where DETAIL_NUM=?";
			psmt = con.prepareStatement(sql);
			psmt.setInt(1,num);
			
			rs=psmt.executeQuery();
			
			if(rs.next()){
			agb = new DetailBean();
				agb.setDETAIL_NUM(rs.getInt("DETAIL_NUM"));
				agb.setDETAIL_CATEGORY(rs.getString("DETAIL_CATEGORY"));
				agb.setDETAIL_NAME(rs.getString("DETAIL_NAME"));
				agb.setDETAIL_CONTENT(rs.getString("DETAIL_CONTENT"));
				agb.setDETAIL_ADDTER(rs.getString("DETAIL_ADDTER"));
				 /* agb.setDETAIL_AMOUNT(rs.getInt("dti_amount"));
				 * agb.setDETAIL_LOCATION(rs.getInt("dti_location"));
				 * agb.setDETAIL_IMAGE(rs.getString("dti_image"));
				 * agb.setDETAIL_BEST(rs.getInt("dti_best"));
				 */
			}
			
			return agb;
			
		} catch (SQLException e) {
			System.out.println("getDetail 에러 : " + e);;
		}
		finally{
			try{
				if(rs!=null)rs.close();
				if(psmt!=null)psmt.close();
				if(con!=null)con.close();
			}catch(Exception e) {}
		}
		return null;
	}
	
	//글 등록
	public boolean insertDetail(DetailBean detailBean) {
		int result = 0;
		int num=0;
		
		String sql="select max(DETAIL_NUM) from detail";
		
		try {
			con = ds.getConnection();
			psmt=con.prepareStatement(sql);
			rs=psmt.executeQuery();
			
			if(rs.next()) {
				num = rs.getInt(1)+1;
			}else {
				num=1;
			}
			sql="insert into detail (DETAIL_NUM, DETAIL_CATEGORY, DETAIL_NAME, DETAIL_CONTENT,"
					+ "DETAIL_ADDTER) values(?,?,?,?,?)";
			
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, num);
			psmt.setString(2, detailBean.getDETAIL_CATEGORY());
			psmt.setString(3, detailBean.getDETAIL_NAME());
		    psmt.setString(4, detailBean.getDETAIL_CONTENT());
			psmt.setString(5, detailBean.getDETAIL_ADDTER()); 
			
			result = psmt.executeUpdate();
			
			if(result == 0 ) {return false;}
			
			return true;
		}catch(Exception ex){
			System.out.println("boardInsert 에러 : "+ex);
		}finally{
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(psmt!=null) try{psmt.close();}catch(SQLException ex){}
			if(con!=null) try{con.close();}catch(SQLException ex){}
		}
		return false;
	}
	
	public boolean deleteDetail(int num){
		
		String sql="delete from detail where DETAIL_NUM=?";
		int result = 0;
		
		try {
			con = ds.getConnection();
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, num);
			result = psmt.executeUpdate();
			if(result == 0) return false;
			
			return true;
		} catch (Exception e) {
			System.out.println("deleteDetail 에러 : " + e);
		}finally{
			try{
				if(psmt!=null)psmt.close();
				if(con!=null)con.close();
			}catch(Exception ex) {}
		}
		return false;
	}
	
	public boolean modifyDetail(DetailBean detailBean) throws Exception{
		String sql="update detail set DETAIL_CONTENT=?, DETAIL_ADDTER=? where DETAIL_NUM=? ";

		try {
			con = ds.getConnection();
			psmt = con.prepareStatement(sql);
			psmt.setString(1, detailBean.getDETAIL_CONTENT());
			psmt.setString(2, detailBean.getDETAIL_ADDTER());
			psmt.setInt(3, detailBean.getDETAIL_NUM());
			psmt.executeUpdate();

			return true;
		} catch (Exception e) {
			System.out.println("modifyDetail 에러 : " + e);
		}
		finally{
			if(rs != null)try{rs.close();}catch(SQLException ex){}
			if(psmt != null)try{psmt.close();}catch(SQLException ex){}
			if(con != null) try{con.close();}catch(SQLException ex){}
		}
		return false;
	}
}
