package org.coc.dao;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.coc.domain.MemberVO;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO{
	
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace= "org.coc.mapper.MemberMapper";

	@Override
	public String getTime() {
		// TODO Auto-generated method stub
		
		return sqlSession.selectOne(namespace+".getTime");
	}

	@Override
	public void insertMember(MemberVO vo) {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace+".insertMember", vo);
		
	}
	
	
	@Override
	public MemberVO readMember(String userid) throws IOException {
		// TODO Auto-generated method stub
		return (MemberVO)sqlSession.selectOne(namespace+".selectMember", userid);
	}

	@Override
	public MemberVO readWithPW(String userid, String userpw) throws IOException {
		// TODO Auto-generated method stub
		Map<String, Object> paramMap = new HashMap<String, Object>(); // 파라미터가 2개 이상 전달되므로 map 타입의 객체 구성해서 보낸다. 
		
		
		paramMap.put("userid", userid);
		paramMap.put("userpw", userpw);
		
		return sqlSession.selectOne(namespace+".readWithPW", paramMap);
	}

}
