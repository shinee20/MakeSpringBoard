package org.coc.dao;

import java.util.List;

import javax.inject.Inject;

import org.coc.domain.BoardVO;
import org.coc.service.BoardService;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Inject
	private BoardDAO dao;

	
	@Override
	public void insertBoard(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.insertBoard(vo);
	}

	@Override
	public BoardVO selectBoard(int bno) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectBoard(bno);
	}

	@Override
	public void modify(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.updateBoard(vo);
	}

	@Override
	public void remove(int bno) throws Exception {
		// TODO Auto-generated method stub
		dao.deleteBoard(bno);
	}

	@Override
	public List<BoardVO> selectAllBoard() throws Exception {
		// TODO Auto-generated method stub
		return dao.selectAllBoard();
	}
	
	
	
}
