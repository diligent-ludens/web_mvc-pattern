package net.food.qna.db;

import java.sql.Date;

public class QnaDTO {//자바빈 선언
	private int QNA_NUM;
	private String QNA_NAME;
	private String QNA_PASS;
	private String QNA_SUBJECT;
	private String QNA_CONTENT;
	private int QNA_RE_REF;
	private int QNA_RE_LEV;
	private int QNA_RE_SEQ;
	private int QNA_READCOUNT;
	private Date QNA_DATE;
	
	public int getQNA_NUM() {
		return QNA_NUM;
	}
	public void setQNA_NUM(int qNA_NUM) {
		QNA_NUM = qNA_NUM;
	}
	public String getQNA_NAME() {
		return QNA_NAME;
	}
	public void setQNA_NAME(String qNA_NAME) {
		QNA_NAME = qNA_NAME;
	}
	public String getQNA_PASS() {
		return QNA_PASS;
	}
	public void setQNA_PASS(String qNA_PASS) {
		QNA_PASS = qNA_PASS;
	}
	public String getQNA_SUBJECT() {
		return QNA_SUBJECT;
	}
	public void setQNA_SUBJECT(String qNA_SUBJECT) {
		QNA_SUBJECT = qNA_SUBJECT;
	}
	public String getQNA_CONTENT() {
		return QNA_CONTENT;
	}
	public void setQNA_CONTENT(String qNA_CONTENT) {
		QNA_CONTENT = qNA_CONTENT;
	}
	public int getQNA_RE_REF() {
		return QNA_RE_REF;
	}
	public void setQNA_RE_REF(int qNA_RE_REF) {
		QNA_RE_REF = qNA_RE_REF;
	}
	public int getQNA_RE_LEV() {
		return QNA_RE_LEV;
	}
	public void setQNA_RE_LEV(int qNA_RE_LEV) {
		QNA_RE_LEV = qNA_RE_LEV;
	}
	public int getQNA_RE_SEQ() {
		return QNA_RE_SEQ;
	}
	public void setQNA_RE_SEQ(int qNA_RE_SEQ) {
		QNA_RE_SEQ = qNA_RE_SEQ;
	}
	public int getQNA_READCOUNT() {
		return QNA_READCOUNT;
	}
	public void setQNA_READCOUNT(int qNA_READCOUNT) {
		QNA_READCOUNT = qNA_READCOUNT;
	}
	public Date getQNA_DATE() {
		return QNA_DATE;
	}
	public void setQNA_DATE(Date qNA_DATE) {
		QNA_DATE = qNA_DATE;
	}

	
}
