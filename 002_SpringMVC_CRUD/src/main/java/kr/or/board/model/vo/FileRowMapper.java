package kr.or.board.model.vo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class FileRowMapper implements RowMapper{

	@Override
	public Object mapRow(ResultSet rset, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		FileVO f = new FileVO();
		f.setFileNo(rset.getInt("file_no"));
		f.setBoardNo(rset.getInt("board_no"));
		f.setFilename(rset.getNString("filename"));
		f.setFilepath(rset.getNString("filepath"));
		return f;
	}

}
