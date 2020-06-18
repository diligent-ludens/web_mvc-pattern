package net.food.qna.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class QnaDAO {
	DataSource ds;
	Connection con;
	PreparedStatement psmt;
	ResultSet rs;
	
	public QnaDAO() {
		try{
			Context init = new InitialContext();
	  	    ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
	  		
		}catch(Exception ex){
			System.out.println("DB 연결 실패 : " + ex);
			return;
		}
	}
	
	//글의 개수 구하기
	public int getListCount() {
		int x= 0;
		
		try{
			con = ds.getConnection();
			psmt = con.prepareStatement("select count(*) from qna");//count(*) 총 레코드의 갯수
			rs = psmt.executeQuery();
			
			if(rs.next()){
				x=rs.getInt(1);
			}
		}catch(Exception ex){
			System.out.println("getListCount 에러: " + ex);			
		}finally{
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(psmt!=null) try{psmt.close();}catch(SQLException ex){}
			if(con!=null) try{con.close();}catch(SQLException ex){}
		}
		return x;
	}
	
	//글 목록 보기
	public List getQnaList(int page,int limit){
	
		String qna_list_sql=
				"select * from "+
				"(select rownum rnum,QNA_NUM,QNA_NAME,QNA_SUBJECT,"+
				"QNA_CONTENT,QNA_RE_REF,QNA_RE_LEV,"+
				"QNA_RE_SEQ,QNA_READCOUNT,QNA_DATE from "+
				"(select * from qna order by QNA_RE_REF desc,QNA_RE_SEQ asc)) "+
				"where rnum>=? and rnum<=?";
		
		List list = new ArrayList();
		
		int startrow=(page-1)*10+1; //읽기 시작할 row 번호.
		int endrow=startrow+limit-1; //읽을 마지막 row 번호.	
		
		try{
			con = ds.getConnection();
			psmt = con.prepareStatement(qna_list_sql);
			psmt.setInt(1, startrow);
			psmt.setInt(2, endrow);
			rs = psmt.executeQuery();
			
			while(rs.next()){
				QnaDTO qna = new QnaDTO();
				qna.setQNA_NUM(rs.getInt("QNA_NUM"));
				qna.setQNA_NAME(rs.getString("QNA_NAME"));
				qna.setQNA_SUBJECT(rs.getString("QNA_SUBJECT"));
				qna.setQNA_CONTENT(rs.getString("QNA_CONTENT"));
				qna.setQNA_RE_REF(rs.getInt("QNA_RE_REF"));
				qna.setQNA_RE_LEV(rs.getInt("QNA_RE_LEV"));
				qna.setQNA_RE_SEQ(rs.getInt("QNA_RE_SEQ"));
				qna.setQNA_READCOUNT(rs.getInt("QNA_READCOUNT"));
				qna.setQNA_DATE(rs.getDate("QNA_DATE"));
				
				list.add(qna);
			}
			
			return list;
			
		}catch(Exception ex){
			System.out.println("getQnaList 에러 : " + ex);
		}finally{
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(psmt!=null) try{psmt.close();}catch(SQLException ex){}
			if(con!=null) try{con.close();}catch(SQLException ex){}
		}
		
		return null;
	}
	
	//글 내용 보기.
	public QnaDTO getDetail(int num) throws Exception{
		
		QnaDTO qna = null;
		
		try{
			con = ds.getConnection();
			psmt = con.prepareStatement("select * from qna where QNA_NUM = ?");
			psmt.setInt(1, num);
			
			rs= psmt.executeQuery();
			
			if(rs.next()){
				qna = new QnaDTO();
				qna.setQNA_NUM(rs.getInt("QNA_NUM"));
				qna.setQNA_NAME(rs.getString("QNA_NAME"));
				qna.setQNA_SUBJECT(rs.getString("QNA_SUBJECT"));
				qna.setQNA_CONTENT(rs.getString("QNA_CONTENT"));
				qna.setQNA_RE_REF(rs.getInt("QNA_RE_REF"));
				qna.setQNA_RE_LEV(rs.getInt("QNA_RE_LEV"));
				qna.setQNA_RE_SEQ(rs.getInt("QNA_RE_SEQ"));
				qna.setQNA_READCOUNT(rs.getInt("QNA_READCOUNT"));
				qna.setQNA_DATE(rs.getDate("QNA_DATE"));
			}
			
			return qna;
			
		}catch(Exception ex){
			System.out.println("getDetail 에러 : " + ex);
		}finally{
			if(rs != null)try{rs.close();}catch(SQLException ex){}
			if(psmt !=null)try{psmt.close();}catch(SQLException ex){}
			if(con != null) try{con.close();}catch(SQLException ex){}
		}
		return null;
	}
	
	//글 등록
	public boolean qnaInsert(QnaDTO qna){
		int num = 0;
		String sql = "";
		int result = 0;
		
		try{
			con = ds.getConnection();
			psmt = con.prepareStatement("select max(QNA_NUM) from qna");
			rs = psmt.executeQuery();
			
			if(rs.next())
				num = rs.getInt(1)+1;
			else
				num = 1;
			
			sql="insert into qna (QNA_NUM,QNA_NAME,QNA_PASS,"
				+"QNA_SUBJECT, QNA_CONTENT, QNA_RE_REF,"
				+"QNA_RE_LEV,QNA_RE_SEQ,QNA_READCOUNT, QNA_DATE) "
				+"values(?,?,?,?,?,?,?,?,?,sysdate)";
			
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, num);
			psmt.setString(2, qna.getQNA_NAME());
			psmt.setString(3, qna.getQNA_PASS());
			psmt.setString(4, qna.getQNA_SUBJECT());
			psmt.setString(5, qna.getQNA_CONTENT());
			psmt.setInt(6, num);
			psmt.setInt(7, 0);
			psmt.setInt(8, 0);
			psmt.setInt(9, 0);
			
			result = psmt.executeUpdate();
			
			if(result ==0 )return false;
			
			return true;
		}catch(Exception ex){
			System.out.println("qnaInsert 에러 : "+ex);
		}finally{
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(psmt!=null) try{psmt.close();}catch(SQLException ex){}
			if(con!=null) try{con.close();}catch(SQLException ex){}
		}
		return false;
	}
	
	//글 답변
	public int qnaReply(QnaDTO qna){
		
		String qna_max_sql = "select max(qna_num) from qna";
		String sql = "";
		int num = 0;
		int result = 0;
		
		int re_ref = qna.getQNA_RE_REF();
		int re_lev = qna.getQNA_RE_LEV();
		int re_seq = qna.getQNA_RE_SEQ();
		
		try{
			con = ds.getConnection();
			psmt = con.prepareStatement(qna_max_sql);
			rs = psmt.executeQuery();
			if(rs.next())num = rs.getInt(1)+1;
			else num=1;
			
			sql="update qna set QNA_RE_SEQ = QNA_RE_SEQ+1 "
				+"where QNA_RE_REF = ? "
				+"and QNA_RE_SEQ > ?";
			
			psmt = con.prepareStatement(sql);
			psmt.setInt(1,re_ref);
			psmt.setInt(2,re_seq);
			result = psmt.executeUpdate();
			
			re_seq++;
			re_lev++;
			
			sql="insert into qna (QNA_NUM,QNA_NAME,QNA_PASS,QNA_SUBJECT,"
				+"QNA_CONTENT, QNA_RE_REF,QNA_RE_LEV,QNA_RE_SEQ,"
				+"QNA_READCOUNT,QNA_DATE) values (?,?,?,?,?,?,?,?,?,sysdate)";
			
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, num);
			psmt.setString(2, qna.getQNA_NAME());
			psmt.setString(3, qna.getQNA_PASS());
			psmt.setString(4, qna.getQNA_SUBJECT());
			psmt.setString(5, qna.getQNA_CONTENT());
			psmt.setInt(6, re_ref);
			psmt.setInt(7, re_lev);
			psmt.setInt(8, re_seq);
			psmt.setInt(9, 0);
			psmt.executeUpdate();
			
			return num;
		}catch(SQLException ex){
			System.out.println("qnaReply 에러 : "+ex);
		}finally{
			if(rs != null)try{rs.close();}catch(SQLException ex){}
			if(psmt != null)try{psmt.close();}catch(SQLException ex){}
			if(con != null) try{con.close();}catch(SQLException ex){}
		}
		return 0;
	}
	
	//글 수정
	public boolean qnaModify(QnaDTO modifyqna) throws Exception{
		
		String sql="update qna set QNA_SUBJECT=?, QNA_CONTENT=? where QNA_NUM=?";
		
		try{
			con = ds.getConnection();
			psmt = con.prepareStatement(sql);
			psmt.setString(1, modifyqna.getQNA_SUBJECT());
			psmt.setString(2, modifyqna.getQNA_CONTENT());
			psmt.setInt(3, modifyqna.getQNA_NUM());
			psmt.executeUpdate();
			return true;
		}catch(Exception ex){
			System.out.println("qnaModify 에러 : " + ex);
		}finally{
			if(rs != null)try{rs.close();}catch(SQLException ex){}
			if(psmt != null)try{psmt.close();}catch(SQLException ex){}
			if(con != null) try{con.close();}catch(SQLException ex){}
		}
		return false;
	}
	
	//글 삭제
	public boolean qnaDelete(int num){
		
		String qna_delete_sql = "delete from qna where QNA_NUM=?";
		
		int result=0;
		
		try{
			con = ds.getConnection();
			psmt = con.prepareStatement(qna_delete_sql);
			psmt.setInt(1, num);
			result = psmt.executeUpdate();
			if(result == 0)return false;
			
			return true;
		}catch(Exception ex){
			System.out.println("qnaDelete 에러 : "+ex);
		}finally{
			try{
				if(psmt != null)psmt.close();
				if(con != null) con.close();
			}catch(Exception ex){}
		}
		
		return false;
	}
	
	//조회수 업데이트
	public void setReadCountUpdate(int num) throws Exception{
		
		String sql="update qna set QNA_READCOUNT = "
					 +"QNA_READCOUNT+1 where QNA_NUM = "+num;
		
		try{
			con = ds.getConnection();
			psmt = con.prepareStatement(sql);
			psmt.executeUpdate();
		} catch(SQLException ex) {
			System.out.println("setReadCountUpdate 에러 : "+ex);
		} finally{
			try{
				if(psmt != null) psmt.close();
				if(con != null) con.close();
			} catch(Exception ex){}
		}
	}
	
	//글쓴이인지 확인
	public boolean isQnaWriter(int num, String pass){
		
		String qna_sql="select * from qna where QNA_NUM=?";
		
		try{
			con = ds.getConnection();
			psmt = con.prepareStatement(qna_sql);
			psmt.setInt(1, num);
			rs = psmt.executeQuery();
			rs.next();
			
			if(pass.equals(rs.getString("QNA_PASS"))){
				return true;
			}
		}catch(SQLException ex){
			System.out.println("isQnaWriter 에러 : "+ex);
		}finally{
			try{
				if(psmt!=null)psmt.close();
				if(con!=null) con.close();
			}catch(Exception ex){}
		}
		return false;
	}
}
	