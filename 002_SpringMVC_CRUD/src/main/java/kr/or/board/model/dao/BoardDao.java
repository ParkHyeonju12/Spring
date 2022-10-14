package kr.or.board.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import kr.or.board.model.vo.Board;
import kr.or.board.model.vo.BoardListRowMapper;

@Repository
public class BoardDao {
@Autowired
private JdbcTemplate jdbcTemplate;
	public BoardDao() {
	
		super();
		// TODO Auto-generated constructor stub
	}
	public ArrayList<Board> selectAllBoard() {
		// TODO Auto-generated method stub
		String query="select board_no,board_title,board_writer,board_Date from board order by 1 DESC";
		List list = jdbcTemplate.query(query, new BoardListRowMapper());
		return (ArrayList<Board>)list;
	}
	public int insertBoard(Board b) {
		// TODO Auto-generated method stub
		String query ="INSERT INTO BOARD VALUES(BOARD_SEQ.NEXTVAL,?,?,?,TO_CHAR(SYSDATE,('YYYY-MM-DD')))";
		Object[] params = {b.getBoardTitle(),b.getBoardWriter(),b.getBoardContent()};
		int result = jdbcTemplate.update(query,params);
		return result;
	}

}
