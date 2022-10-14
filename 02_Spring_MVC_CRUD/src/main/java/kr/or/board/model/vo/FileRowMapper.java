package kr.or.board.model.vo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class FileRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rset, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		FileVO file = new FileVO();
		file.setBoardNo(rset.getInt("board_no"));
		file.setFilepath(rset.getString("filepath"));
		file.setFileNo(rset.getInt("file_no"));
		file.setFileName(rset.getString("filename"));
		return file;
	}

}
