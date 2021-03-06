package org.coc.service;

import java.util.List;

import org.coc.domain.BoardVO;
import org.coc.domain.Criteria;

public interface BoardService {
	
	public void insertBoard(BoardVO vo) throws Exception;
	public BoardVO selectBoard(int bno) throws Exception;
	public void modify(BoardVO vo) throws Exception;
	public void remove(int bno) throws Exception;
	public List<BoardVO> selectAllBoard()throws Exception;
	public List<BoardVO> listCriteria(Criteria cri) throws Exception;
}
