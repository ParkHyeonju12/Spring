package kr.or.board.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import common.FileRename;
import kr.or.board.model.service.BoardService;
import kr.or.board.model.vo.Board;
import kr.or.board.model.vo.BoardPageData;
import kr.or.board.model.vo.FileVO;

@Controller
public class BoardController {
	@Autowired
	private BoardService service;
	@Autowired
	private FileRename fileRename;
	
	@RequestMapping(value="/boardList.do")
	public String boardList(int reqPage, Model model) {
		BoardPageData bpd = service.selectBoardList(reqPage);
		model.addAttribute("list",bpd.getList());
		model.addAttribute("pageNavi",bpd.getPageNavi());
		model.addAttribute("reqPage",bpd.getReqPage());
		model.addAttribute("numPerPage",bpd.getNumPerPage());
		return "board/boardList";
	}
	
	@RequestMapping(value="/boardView.do")
	public String boardView(int boardNo, Model model) {
		Board b = service.selectOneBoard(boardNo);
		model.addAttribute("b", b);
		return "board/boardView";
	}
	
	@RequestMapping(value="/boardWriterFrm.do")
	public String boardWriterFrm() {
		return "board/boardWriterFrm";
	}
	
	@RequestMapping(value = "/boardWrite.do")
	public String boardWirte(Board b, MultipartFile[] boardFile, HttpServletRequest request) {
		ArrayList<FileVO> fileList = new ArrayList<FileVO>();
		if(boardFile[0].isEmpty() ) {
			
		}else {
			String savePath = request.getSession().getServletContext().getRealPath("/resources/upload/board/");
			for(MultipartFile file: boardFile) {
				String filename = file.getOriginalFilename();
				String filepath = fileRename.fileRename(savePath, filename);
				
				try {
					//파일 업로드 로직
					FileOutputStream fos = new FileOutputStream(new File(savePath + filepath));
					BufferedOutputStream bos = new BufferedOutputStream(fos);
					//파일변환
					byte[] bytes = file.getBytes();
					//실제 파일로 쓰는 작업
					bos.write(bytes);
					bos.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				FileVO fileVO = new FileVO();
				fileVO.setFilename(filename);
				fileVO.setFilepath(filepath);
				fileList.add(fileVO);
			}
			b.setFileList(fileList);
			int result = service.insertBoard(b);
		}
		return "redirect:/boardList.do?reqPage=1";
	}
}
