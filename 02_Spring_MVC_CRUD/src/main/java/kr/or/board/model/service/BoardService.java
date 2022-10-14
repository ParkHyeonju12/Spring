package kr.or.board.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.board.model.dao.BoardDao;
import kr.or.board.model.vo.Board;
import kr.or.board.model.vo.FileVO;
import kr.or.member.model.vo.Member;

@Service
public class BoardService {
@Autowired
private BoardDao dao;

	public BoardService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Board> boardAllList() {
		// TODO Auto-generated method stub
		ArrayList<Board> list = dao.boardAllList();
		return list;
	}

	public int boardWrite(Board b) {
		// TODO Auto-generated method stub
		int result = dao.boardWrite(b);
		return result;
	}

	public Member selectOneMember(Member m) {
		// TODO Auto-generated method stub
		Member member = dao.selectOneMember(m);
		return member;
	}

	public Board selectOneView(int boardNo) {
		// TODO Auto-generated method stub
		Board b  = dao.selectOneView(boardNo);
		ArrayList<FileVO> fileList = dao.selectFileList(boardNo);
		b.setFileList(fileList);
		return b;
	}

	public int insertBoard2(Board b, ArrayList<FileVO> list) {
		// TODO Auto-generated method stub
		int result = dao.insertBoard(b);
		//insert가 성공한경우 파일을 insert
		//이때 파일이 없으면 insert할 필요없음
		if(result>0) {
			int boardNo = 0;
			if(!list.isEmpty()) {
				//가장 최근에 들어간 boardNo를 조회
				boardNo = dao.selectBoardNo();
				for(FileVO fileVO : list) {
					//board테이블에 방금 insert한 board_no를 참조하기 위해 setter로 값 세팅
					fileVO.setBoardNo(boardNo);
					result += dao.insertFile(fileVO);
				}
			}
		}
		return result;
	}

	public FileVO boardFileDown(int fileNo) {
		// TODO Auto-generated method stub
		FileVO fv = dao.boardFileDown(fileNo);
		return fv;
	}

	public FileVO fileName(int fileNo) {
		// TODO Auto-generated method stub
		FileVO fileName = dao.fileName(fileNo);
		return fileName;
	}

	public int boardUpdate2(Board b, int[] fileNoList) {
		// TODO Auto-generated method stub
		//1. board테이블 수정(제목,내용)
		int result = dao.updateBoard2(b);
		if(result>0) {
			//2. 새 첨부파일이 있으면 insert
			for(FileVO fv : b.getFileList()) {
				fv.setBoardNo(b.getBoardNo());
				result += dao.insertFile(fv);
			}
			if(fileNoList != null) {
				//3. 삭제한 파일이 있으면 delete
				for(int fileNo : fileNoList) {
					result += dao.deleteFile(fileNo);
				}
			}
		}
		return result;
	}

	public ArrayList<FileVO> boardDelete2(int boardNo) {
		// TODO Auto-generated method stub
		ArrayList<FileVO> fileList = dao.selectFileList(boardNo);
		//board 테이블에서 삭제
		int result = dao.deleteBoard(boardNo);
		if(result>0) {
			return fileList;
		}else {
			return null;
		}
	}



}
