package org.coc.dao;

import java.io.IOException;

import org.coc.domain.MemberVO;

public interface MemberDAO {
	
	public String getTime();
	
	public void insertMember(MemberVO vo);
	
	public MemberVO readMember(String userid) throws IOException;
	
	public MemberVO readWithPW(String userid, String userpw) throws IOException;
	
}
