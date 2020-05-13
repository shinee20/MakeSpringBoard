package org.coc.controller;

import javax.inject.Inject;

import org.coc.domain.BoardVO;
import org.coc.domain.Criteria;
import org.coc.domain.PageMaker;
import org.coc.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	private BoardService service;
	
	@RequestMapping(value="/regist", method=RequestMethod.GET)
	public void registGET(BoardVO board, Model model) throws Exception {
		logger.info("regist get.....");
	}
	
	@RequestMapping(value="/regist", method=RequestMethod.POST)
	public String registPOST(BoardVO board, RedirectAttributes rttr) throws Exception {
		logger.info("regist post.....");
		logger.info(board.toString());
		
		service.insertBoard(board);
		rttr.addFlashAttribute("result", "success");
//		return "/board/success"; //뷰 이름을 넘겨준다.
		return "redirect:/board/listAll"; //같은 내용을 또 입력하지않도록 목록 사이트로 이동한다. 
	}
	
	@RequestMapping(value="/listAll", method=RequestMethod.GET) 
	public void listAll(Model model) throws Exception {
		logger.info("show all list....");
		model.addAttribute("list", service.selectAllBoard()); //model에 담아서 반환한다. 
	}
	
//	@RequestMapping(value="/listAll", method=RequestMethod.GET) 
//	public @ResponseBody List<BoardVO> listAll() throws Exception {
//		return service.selectAllBoard();
//	}
	
	
	@RequestMapping(value="/listCri", method=RequestMethod.GET)
	public void ListAll(Criteria cri, Model model) throws Exception {
		logger.info("show all list cri....");
		model.addAttribute("list", service.listCriteria(cri));
	}
	
	@RequestMapping(value="/listPage", method=RequestMethod.GET)
	public void ListPage(Criteria cri, Model model) throws Exception {
		
		logger.info(cri.toString());
		model.addAttribute("list", service.listCriteria(cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(131);
		
		
		model.addAttribute("pageMaker", pageMaker);
	}
	
	
}
