package kr.or.board.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import kr.or.board.model.service.BoardService;
import kr.or.board.model.vo.Board;

@Controller
public class BoardController {
	@Autowired
	private BoardService service;

	@RequestMapping(value="/boardList.do")
	public String boardList(Model model) {
		ArrayList<Board> list = service.selectAllBoard();
		if(list.isEmpty()) {
			return null;
		}else {
			model.addAttribute("list",list);
			return "board/boardAllList";
		}
	}
	@RequestMapping(value="/boardWriteFrm.do")
	public String boardWriteFrm() {
		return "board/boardWrite";
	}
	@RequestMapping(value="/boardWrite.do")
	public String boardWrite(Board b) {
		int result = service.insertBoard(b);
		return "redirect:/boardList.do";
	}
	@RequestMapping(value="/boardWriteFrm2.do")
	public String boardWriteFrm2() {
		return "board/boardWrite2";
	}
	@RequestMapping(value="/boardWrite2.do")
	public String boardWrite2(Board b, MultipartFile[] boardfile) {
		System.out.println(b);
		System.out.println(boardfile.length);
		return "redirect:/boardList.do";
	}
}
