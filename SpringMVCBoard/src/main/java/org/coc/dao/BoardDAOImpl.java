package org.coc.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.coc.domain.BoardVO;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOImpl implements BoardDAO{

	@Inject
	private SqlSession session;
	
	private static String namespace="org.coc.mapper.BoardMapper";
	
	@Override
	public void insertBoard(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		session.insert(namespace+".insertBoard", vo);
	}

	@Override
	public BoardVO selectBoard(int bno) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".selectBoard", bno);
	}

	@Override
	public List<BoardVO> selectAllBoard() throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace +".selectAllBoard");
	}

	@Override
	public void updateBoard(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		session.update(namespace+".updateBoard", vo);
	}

	@Override
	public void deleteBoard(int bno) throws Exception {
		// TODO Auto-generated method stub
		session.delete(namespace+".deleteBoard", bno);
		
	}

	
}
