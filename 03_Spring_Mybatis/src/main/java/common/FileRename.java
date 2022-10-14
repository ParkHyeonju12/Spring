package common;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Component;

import kr.or.board.model.vo.FileVO;
@Component
public class FileRename {
	public String fileRename(String path, String filename) {
		String onlyFilename = filename.substring(0, filename.lastIndexOf(".")); // test
		String extention = filename.substring(filename.lastIndexOf("."));// .txt
		// 실제 업로드할 파일명
		String filepath = null;
		// 파일명이 중복되는 경우 뒤에 붙일 숫자
		int count = 0;
		while (true) {
			if (count == 0) {
				// 파일이름체크 반복 첫번째인 경우
				filepath = onlyFilename + extention; // test.txt
			} else {
				filepath = onlyFilename + "_" + count + extention;
			}
			File checkFile = new File(path + filepath);
			if (!checkFile.exists()) {
				// 중복파일명이 아닌 경우 무한 반복문 나가기
				break;
			}
			count++;
		}
		return filepath;
	}
}