package org.jhcode33.service;

import java.util.List;

import org.jhcode33.domain.BoardDTO;

//DAO가 구현할 인터페이스.
//DB에 따라 DAO의 구현부가 달라지도록 하여 결합도를 낮추는 것.
public interface BoardService {
	//사용자 위주의 용어들로 구성한다.
	//BoardMapper 쪽과 차이가 있다.
	
	//등록
	public void register(BoardDTO dto);
	
	//하나만 가져오기
	public BoardDTO get(long bno);
	
	//수정
	public boolean modify(BoardDTO dto);
	
	//삭제
	public boolean remove(long bno);
	
	//목록
	public List<BoardDTO> getList();
}
