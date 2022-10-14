package kr.or.board.model.vo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class BoardListRowMapper implements RowMapper{

	@Override
	public Object mapRow(ResultSet rset, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Board b = new Board();
		b.setBoardNo(rset.getInt("board_no"));
		b.setBoardTitle(rset.getNString("board_title"));
		b.setBoardWriter(rset.getNString("board_writer"));
		b.setBoardDate(rset.getNString("board_date"));
		return b;
	}

}
