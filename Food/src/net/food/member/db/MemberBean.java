package net.food.member.db;

import java.sql.*;

public class MemberBean {
	public String getMEMBER_NAME() {
		return MEMBER_NAME;
	}
	public void setMEMBER_NAME(String mEMBER_NAME) {
		MEMBER_NAME = mEMBER_NAME;
	}
	public String getMEMBER_ID() {
		return MEMBER_ID;
	}
	public void setMEMBER_ID(String mEMBER_ID) {
		MEMBER_ID = mEMBER_ID;
	}
	public String getMEMBER_PW() {
		return MEMBER_PW;
	}
	public void setMEMBER_PW(String mEMBER_PW) {
		MEMBER_PW = mEMBER_PW;
	}
	public String getMEMBER_PWCK() {
		return MEMBER_PWCK;
	}
	public void setMEMBER_PWCK(String mEMBER_PWCK) {
		MEMBER_PWCK = mEMBER_PWCK;
	}
	public String getMEMBER_EMAIL() {
		return MEMBER_EMAIL;
	}
	public void setMEMBER_EMAIL(String mEMBER_EMAIL) {
		MEMBER_EMAIL = mEMBER_EMAIL;
	}
	public String getMEMBER_TEL() {
		return MEMBER_TEL;
	}
	public void setMEMBER_TEL(String mEMBER_TEL) {
		MEMBER_TEL = mEMBER_TEL;
	}
	private String MEMBER_NAME;
	private String MEMBER_ID;
	private String MEMBER_PW;
	private String MEMBER_PWCK;
	private String MEMBER_EMAIL;
	private String MEMBER_TEL;
	
	
}

