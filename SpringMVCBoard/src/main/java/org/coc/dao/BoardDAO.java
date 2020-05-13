package org.coc.dao;

import java.util.List;

import org.coc.domain.BoardVO;
import org.coc.domain.Criteria;

public interface BoardDAO 
{

	public void insertBoard(BoardVO vo) throws Exception;
	public BoardVO selectBoard(int bno)throws Exception;
	public List<BoardVO> selectAllBoard()throws Exception;
	public void updateBoard(BoardVO vo)throws Exception;
	public void deleteBoard(int bno)throws Exception;
	
	//paging 
	public List<BoardVO> listPage(int page) throws Exception;
	public List<BoardVO> listCriteria(Criteria cri) throws Exception;
}
