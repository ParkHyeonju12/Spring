package kr.or.board.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.board.model.vo.Board;
import kr.or.board.model.vo.FileVO;

@Repository
public class BoardDao {
	@Autowired
	private SqlSessionTemplate sqlSession;

	public ArrayList<Board> selectBoardList(HashMap<String, Object> map) {
		List list = sqlSession.selectList("board.selectBoardList", map);
		return (ArrayList<Board>) list;
	}

	// 전체 게시물 조회
	public int selectBoardCount() {
		int totalCount = sqlSession.selectOne("board.totalCount");
		return totalCount;
	}

	// 게시물 상세 조회
	public Board selectOneBoard(int boardNo) {
		return sqlSession.selectOne("board.selectOneBoard", boardNo);
	}

	// 게시물 상세 조회->file_tbl조회
	public ArrayList<FileVO> selectFileList(int boardNo) {
		List list = sqlSession.selectList("board.selectFileList", boardNo);
		return (ArrayList<FileVO>) list;
	}

	public int insertBoard(Board b) {
		int result = sqlSession.insert("board.insertBoard",b);
		return result;
	}

	public int selectBoardNo() {
		int boardNo = sqlSession.selectOne("board.selectBoardNo");
		return boardNo;
	}

	public int insertFile(FileVO fv) {
		int result = sqlSession.insert("board.insertFile",fv);
		return result;
	}

}