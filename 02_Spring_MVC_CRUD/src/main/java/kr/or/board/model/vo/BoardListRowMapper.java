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
		b.setBoardTitle(rset.getString("board_title"));
		b.setBoardWriter(rset.getString("board_writer"));
		b.setDate(rset.getString("board_date"));
		return b;
	}
}