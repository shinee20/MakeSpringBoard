package org.coc;

import java.util.List;

import javax.inject.Inject;

import org.coc.dao.BoardDAO;
import org.coc.domain.BoardVO;
import org.coc.domain.Criteria;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class BoardDAOTest {
	
	@Inject
	private BoardDAO dao;
	
	private static Logger logger= LoggerFactory.getLogger(BoardDAOTest.class);
	
	@Test
	public void testUpdate() throws Exception{
		BoardVO board = new BoardVO();
		
		board.setBno(1);
		board.setTitle("수정된 글입니다. ");
		board.setContent("수정 테스트 ");
		dao.updateBoard(board);
		
	}
	
	@Test
	public void testDelete() throws Exception{
		dao.deleteBoard(1);
		
	}

	@Test
	public void testListPage()throws Exception {
		int page = 3;
		List<BoardVO> list = dao.listPage(page);
		
		for (BoardVO boardVO : list) {
			logger.info(boardVO.toString());
		}
	}
	
	@Test
	public void testListCriteria()throws Exception {
		Criteria cri = new Criteria();
		cri.setPage(2);
		cri.setPerPageNum(20);
		
		List<BoardVO> list = dao.listCriteria(cri);
		
		for (BoardVO boardVO : list) {
			logger.info(boardVO.toString());
		}
	}
}
