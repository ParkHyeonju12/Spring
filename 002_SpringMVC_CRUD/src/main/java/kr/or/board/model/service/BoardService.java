package kr.or.board.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.board.model.dao.BoardDao;
import kr.or.board.model.vo.Board;

@Service
public class BoardService {
	@Autowired
	private BoardDao dao;
	public BoardService() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ArrayList<Board> selectAllBoard() {
		// TODO Auto-generated method stub
		return dao.selectAllBoard();
	}
	public int insertBoard(Board b) {
		// TODO Auto-generated method stub
		return dao.insertBoard(b);
	}

}
