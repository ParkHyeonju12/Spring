package kr.or.board.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.board.model.dao.BoardDao;
import kr.or.board.model.vo.Board;
import kr.or.board.model.vo.BoardPageData;
import kr.or.board.model.vo.FileVO;

@Service
public class BoardService {
   @Autowired
   private BoardDao dao;

   public BoardPageData selectBoardList(int reqPage) {
      //한 페이지당 보여줄 게시물 수
      int numPerPage = 5;
      //reqPage 1 -> 1~5, reqPage 2 -> 6~10
      int end = reqPage*numPerPage;
      int start = end-numPerPage+1;
      //계산한 start, end 이용해서 게시물 목록 조회
      HashMap<String, Object> map = new HashMap<String, Object>();
      map.put("start",start);
      map.put("end", end);
      ArrayList<Board> list = dao.selectBoardList(map);
      //pageNavi 시작
      //전체 페이지 수 계산 필요 -> 전체 게시물 수 조회
      int totalCount = dao.selectBoardCount();
      //전체 페이지수 계산
      int totalPage = 0;
      if(totalCount%numPerPage==0) {
         totalPage = totalCount/numPerPage;
      }else {
         totalPage = totalCount/numPerPage +1;
      }
      
      //페이지 네비 길이
      int pageNaviSize = 5;
      //현재 페이지가 가운데로 오게 -> 현재 4페이지면 23456 이런식으로
      int pageNo = 1;
      if(reqPage>3) {
         pageNo=reqPage-2;
      }
      //pageNavi생성 시작
      String pageNavi="";
      //이전버튼
      if(pageNo!=1) {
         pageNavi+="<a href='/boardList.do?reqPage="+(pageNo-1)+"'>[이전]</a>";
      }
      //페이지 숫자 생성
      for(int i=0; i<pageNaviSize;i++) {
         if(pageNo==reqPage) {
            pageNavi += "<span>"+pageNo+"</span>";
         }else {
            pageNavi += "<a href='/boardList.do?reqPage="+pageNo+"'>"+pageNo+"</a>";
         }
         pageNo++;
         if(pageNo>totalPage) {
            break;
         }
      }
      //다음 버튼
      if(pageNo<=totalPage) {
         pageNavi += "<a href='/boardList.do?reqPage="+pageNo+"'>[다음]</a>";
      }
      BoardPageData bpd = new BoardPageData(list, pageNavi, reqPage, numPerPage);
      return bpd;
   }

   //게시판 상세 보기
   public Board selectOneBoard(int boardNo) {
      //board테이블 조회
      Board b = dao.selectOneBoard(boardNo);
      //file_tbl조회
      //ArrayList<FileVO> list = dao.selectFileList(boardNo);
      //b.setFileList(list);
      return b;
   }

public int insertBoard(Board b) {
	//board 테이블 insert
	System.out.println("dao수행전"+b.getBoardNo());
	int result = dao.insertBoard(b);
	System.out.println("dao수행후"+b.getBoardNo());
	if(result>0) {
		//insert 된 boardNo를 조회
		//int boardNo = dao.selectBoardNo();
		//file_tbl 테이블 insert
		for(FileVO fv : b.getFileList()) {
			fv.setBoardNo(b.getBoardNo());
			result += dao.insertFile(fv);
		}
	}
	return result;
}
}