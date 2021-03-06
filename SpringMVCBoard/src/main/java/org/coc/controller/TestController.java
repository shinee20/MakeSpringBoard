package org.coc.controller;

import org.coc.domain.BoardVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class TestController {
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@RequestMapping("doA")
	public void doA() {
		logger.info("doA called ....");
	}
	@RequestMapping("doB")
	public void doB() {
		logger.info("doB called ....");
	}
	@RequestMapping("doC")
	public String doC(@ModelAttribute("msg") String msg) {
		logger.info("doC called ....");
		return "result";
	}
//	@RequestMapping("/doD")
//	public String doD(Model model) {
//		logger.info("doD called ....");
//		BoardVO board = new BoardVO("sample Board", 100000);
//		model.addAttribute(board);
//		return "boardDetail";
//	}
	
	@RequestMapping("/doE")
	public String doE(RedirectAttributes rttr) {
		logger.info("doE called but redirect to doF");
		rttr.addFlashAttribute("msg","This is msg with redirect");
		 //addAttribute -> url에 파라미터 값이 뜬다. 
		//addFlashAttribute-> 리다이렉트 된 URL만 뜬다. 
		return "redirect:/doF";
	}
	
	//리다이렉트 
	@RequestMapping("/doF")
	public void doF(@ModelAttribute("msg") String msg) {
		logger.info("doF called ...."+msg);
		
	}
	
//	@RequestMapping("/doJSON")
//	public @ResponseBody BoardVO doJSON() {
//		//@ResponseBody-> json으로객체를 넘긴다. 
////		logger.info("doJSON called ....");
//		BoardVO board = new BoardVO("샘플상품" , 30000);
//		return board; //객체를 넘긴다. 
//	}
}
