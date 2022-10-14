package kr.or.board.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.board.model.vo.Board;
import kr.or.board.model.vo.BoardRowmapper;
import kr.or.board.model.vo.FileRowMapper;
import kr.or.board.model.vo.FileVO;
import kr.or.member.model.vo.Member;
import kr.or.member.model.vo.MemberRowmapper;

@Repository
public class BoardDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public BoardDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Board> boardAllList() {
		// TODO Auto-generated method stub
		String query = "select * from board";
		List list = jdbcTemplate.query(query, new BoardRowmapper());
		if (list.isEmpty()) {
			return null;
		} else {
			return (ArrayList<Board>) list;
		}
	}

	public int boardWrite(Board b) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO BOARD VALUES(BOARD_SEQ.NEXTVAL,?,?,?,TO_CHAR(SYSDATE,('YYYY-MM-DD')))";
		Object[] params = { b.getBoardTitle(), b.getBoardWriter(), b.getBoardContent() };
		int result = jdbcTemplate.update(query, params);
		return result;
	}

	public Member selectOneMember(Member m) {
		String query = "select * from member_tbl where member_id=? and member_pw=?";
		Object[] params = { m.getMemberId(), m.getMemberPw() };
		List list = jdbcTemplate.query(query, params, new MemberRowmapper());
		// 조회는 항상 List타입으로 데이터를 반환
		if (list.isEmpty()) {
			return null;
		} else {
			Member member = (Member) list.get(0);
			return member;
		}
	}

	public Board selectOneView(int boardNo) {
		// TODO Auto-generated method stub
		String query = "select * from board where board_no = ?";
		Object[] params = {boardNo};
		List list = jdbcTemplate.query(query, params, new BoardRowmapper());
		if(list.isEmpty()) {
			return null;
		}else {
			return (Board)list.get(0);
		}
	}

	public int insertBoard(Board b) {
		String query = "insert into board values(member_seq.nextval,?,?,?,to_char(sysdate,'yyyy-mm-dd'))";
	      Object[] params = {b.getBoardTitle(),b.getBoardWriter(),b.getBoardContent()};
	      int result = jdbcTemplate.update(query,params);
	      return result;
	}

	public int selectBoardNo() {
		// TODO Auto-generated method stub
		String query = "select max(board_no) from board";
		int boardNo = jdbcTemplate.queryForObject(query, int.class);
		return boardNo;
	}

	public int insertFile(FileVO fileVO) {
		// TODO Auto-generated method stub
		String query = "insert into file_tbl values(file_seq.nextval,?,?,?)";
		Object[] params = {fileVO.getBoardNo(),fileVO.getFileName(),fileVO.getFilepath()};
		int result = jdbcTemplate.update(query,params);
		return result;
	}

	public ArrayList<FileVO> selectFileList(int boardNo) {
		// TODO Auto-generated method stub
		String query = "select * from file_tbl where board_no =?";
		Object[] params = {boardNo};
		List list = jdbcTemplate.query(query, params, new FileRowMapper());
		if(list.isEmpty()) {
			return null;
		}else {
			return (ArrayList<FileVO>)list;
		}
	}

	public FileVO boardFileDown(int fileNo) {
		// TODO Auto-generated method stub
		String query = "select * from file_tbl where file_no=?";
		Object[] params = {fileNo};
		List list = jdbcTemplate.query(query, params, new FileRowMapper());
		if(list.isEmpty()) {
			return null;
		}else {
			return (FileVO)list.get(0);
		}
	}

	public FileVO fileName(int fileNo) {
		// TODO Auto-generated method stub
		String query = "select * from file_tbl where file_no=?";
		Object[] params = {fileNo};
		List list = jdbcTemplate.query(query, params,new FileRowMapper());
		
		return (FileVO)list.get(0);
	}

	public int updateBoard2(Board b) {
		// TODO Auto-generated method stub
		String query = "update board set board_title=?, board_content=? where board_no=?";
		Object[] params = {b.getBoardTitle(),b.getBoardContent(),b.getBoardNo()};
		int result = jdbcTemplate.update(query, params);
		return result;
	}

	public int deleteFile(int fileNo) {
		// TODO Auto-generated method stub
		String query ="delete from file_tbl where file_no = ? ";
		Object[] params = {fileNo};
		int result = jdbcTemplate.update(query,params);
				
		return result;
	}

	public int deleteBoard(int boardNo) {
		// TODO Auto-generated method stub
		String query = "delete from board where board_no=?";
		Object[] params = {boardNo};
		int result = jdbcTemplate.update(query,params);
		return result;
	}
}
