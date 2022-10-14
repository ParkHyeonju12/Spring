package kr.or.board.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

import common.FileRename;
import kr.or.board.model.service.BoardService;
import kr.or.board.model.vo.Board;
import kr.or.board.model.vo.FileVO;
import kr.or.member.model.vo.Member;

@Controller
public class BoardController {
	@Autowired
	private BoardService service;
	@Autowired
	private FileRename fileRename;

	public BoardController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(value = "/boardLogin.do")
	public String boardLogin(Member m, HttpSession session) {
		Member member = service.selectOneMember(m);
		if (member != null) {
			session.setAttribute("m", member);
		}
		// 메인페이지로 이동 -> return "redirect:주소"
		// ->ViewResolver가 앞뒤에 값을 붙이지 않고 주소 요청
		return "board/loginSuccess";
	}

	@RequestMapping(value = "/boardList.do")
	public String boardList(Model model) {
		ArrayList<Board> list = service.boardAllList();
		model.addAttribute("list", list);
		return "board/boardAllList";
	}

	@RequestMapping(value = "/boardWriteFrm.do")
	public String boardWriteFrm() {
		return "board/boardWriteFrm";
	}

	@RequestMapping(value = "/boardWrite.do")
	public String boardWrite(Board b, @SessionAttribute Member m) {
		// Member m2 = (Member)session.getAttribute("m");
		// m.getMemberId();
		b.setBoardWriter(m.getMemberId());
		int result = service.boardWrite(b);
		if (result > 0) {
			return "board/loginSuccess";
		} else {
			return "redirect:/";
		}

	}

	@RequestMapping(value = "/boardView.do")
	public String boardView(Model model, int boardNo) {
		Board b = service.selectOneView(boardNo);
		model.addAttribute("b", b);
		return "board/boardView";
	}

	@RequestMapping(value = "boardWriteFrm2.do")
	public String boardWriteFrm2() {
		return "board/boardWriteFrm2";
	}

	@RequestMapping(value = "/boardWrite2.do")
	public String boardWrite2(Board b, MultipartFile[] boardFile, HttpServletRequest request) {
		// 파일목록을 저장할 리스트 생성
		ArrayList<FileVO> list = new ArrayList<FileVO>();
		// MultipartFile[]은 jsp에서 첨부한 파일 갯수만큼 길이가 생성
		// 단, 첨부파일은 한개도 첨부하지 않더라도 배열의 길이는 기본적으로 1
		// System.out.println(boardFile.length);
		// 첨부파일이 없는 경우 배열 첫번째 인덱스의 value 비어있음
		if (boardFile[0].isEmpty()) {
			// 첨부파일이 없는 경우 수행할 로직 없음
		} else {
			// 첨부파일이 있는 경우 파일업로드 수행
			// 1. 파일업로드 경로 설정(getRealPath()까지가 webapp폴더)
			String savePath = request.getSession().getServletContext().getRealPath("/resources/upload/board/");
			// 2 .반복문을 이용한 파일업로드
			for (MultipartFile file : boardFile) {
				// 파일명이 기존 업로드한 파일명과 중복되는 경우 기존파일을 삭제하고 새파일 남는현상(덮어쓰기)
				// 파일명 중복처리
				// 사용자가 업로드한 파일 이름 추출
				String filename = file.getOriginalFilename();
				String filepath = fileRename.fileRename(savePath, filename);
				// filename = test.txt라는 값을 추출
//				String onlyFilename = filename.substring(0, filename.lastIndexOf(".")); // test
//				String extention = filename.substring(filename.lastIndexOf("."));// .txt
				// 실제 업로드할 파일명
////				String filepath = null;
//				// 파일명이 중복되는 경우 뒤에 붙일 숫자
//				int count = 0;
//				while (true) {
//					if (count == 0) {
//						// 파일이름체크 반복 첫번째인 경우
//						filepath = onlyFilename + extention; // test.txt
//					} else {
//						filepath = onlyFilename + "_" + count + extention;
//					}
//					File checkFile = new File(savePath + filepath);
//					if (!checkFile.exists()) {
//						// 중복파일명이 아닌 경우 무한 반복문 나가기
//						break;
//					}
//					count++;
//				}
				// 파일명 중복체크 끝 -> 파일 업로드 진행
				// 중복처리가 끝난 파일명으로 파일업로드 진행
				try {
					FileOutputStream fos = new FileOutputStream(new File(savePath + filepath));
					// 속도개선을 위한 보조스트림 사용
					BufferedOutputStream bos = new BufferedOutputStream(fos);
					// 파일업로드
					byte[] bytes = file.getBytes();
					bos.write(bytes);
					bos.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// 파일업로드 끝(파일1개업로드)
				FileVO fileVO = new FileVO();
				fileVO.setFileName(filename);
				fileVO.setFilepath(filepath);
				list.add(fileVO);
			}
		}
		// 데이터베이스에 insert -> 비즈니스로직
		int result = service.insertBoard2(b, list);
		// 성공인경우 result == list.size()+1이여야함
		return "redirect:/boardList.do";
	}

	@RequestMapping(value = "/boardFileDown.do")
	public void boardFileDown(int fileNo, HttpServletRequest request, HttpServletResponse response) {
		// fileNo: DB에서 filename,filepath를 조회하기 위한 값
		// request : 파일이 위치하는 경로를 찾기 위해서 필요
		// response : 사용자에게 파일을 찾기위해서 필요
		
		String savePath = request.getSession().getServletContext().getRealPath("/resources/upload/board/");
		FileVO fileName = service.fileName(fileNo);
		try {
			FileInputStream fis = new FileInputStream(savePath+fileName.getFilepath());
			BufferedInputStream bis = new BufferedInputStream(fis);
			ServletOutputStream sos = response.getOutputStream();
			BufferedOutputStream bos = new BufferedOutputStream(sos);
			String resFilename = new String(fileName.getFileName().getBytes("UTF-8"),"ISO-8859-1");
			response.setContentType("application/octet-stream");
			response.setHeader("Content-Disposition", "attachment;filename="+resFilename);
			while(true) {
				int read = bis.read();
				if(read != -1) {
					bos.write(read);
				}else {
					break;
				}
			}
			bos.close();
			bis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/boardUpdateFrm2.do")
	public String boaradUpdateFrm2(int boardNo, Model model) {
		Board b = service.selectOneView(boardNo);
		model.addAttribute("b",b);
		return "board/boardUpdateFrm2";
	}
	
	@RequestMapping(value="/boardUpdate2.do")
	public String boardUpdate2(int[] fileNoList, String[] filepathList, Board b, MultipartFile[] boardFile,HttpServletRequest request) {
		ArrayList<FileVO> fileList = new ArrayList<FileVO>();
		String savaPath = request.getSession().getServletContext().getRealPath("/resources/upload/board/");
		if(!boardFile[0].isEmpty()) {
			for(MultipartFile file: boardFile) {
				String filename = file.getOriginalFilename();
				String filepath = fileRename.fileRename(savaPath, filename);
				File upFile = new File(savaPath+filepath);
				try {
					FileOutputStream fos = new FileOutputStream(upFile);
					BufferedOutputStream bos = new BufferedOutputStream(fos);
					byte[] bytes = file.getBytes();
					bos.write(bytes);
					bos.close();
					FileVO f = new FileVO();
					f.setFileName(filename);
					f.setFilepath(filepath);
					fileList.add(f);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		b.setFileList(fileList);
		int result = service.boardUpdate2(b,fileNoList);
		if(fileNoList != null && (result == (fileList.size()+fileNoList.length+1))) {
			if(filepathList != null) {
				for(String filepath : filepathList) {
					File delFile = new File(savaPath+filepath);
					delFile.delete();
				}
			}
		}
		return "redirect:/boardView.do?boardNo="+b.getBoardNo();
	}
	
	@RequestMapping(value="/boardDelete2.do")
	public String boardDelete2(int boardNo, HttpServletRequest request) {
		//board테이블삭제
		ArrayList<FileVO> list = service.boardDelete2(boardNo);
		//file_tbl삭제
		//실제파일 삭제
		if(list != null) {
			String path = request.getSession().getServletContext().getRealPath("/resources/upload/board/");
			for(FileVO file: list) {
				File delFile = new File(path+file.getFilepath());
				delFile.delete();
			}
		}
		return "redirect:/boardList.do";
			
	}
}
