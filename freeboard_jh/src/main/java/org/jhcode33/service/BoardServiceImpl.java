package org.jhcode33.service;

import java.util.List;

import org.jhcode33.domain.BoardDTO;
import org.jhcode33.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

//Service 역할을 하는 것, Component의 하위, 객체를 생성하여 Spring container에 저장.
@Service
@Log4j
public class BoardServiceImpl implements BoardService {
	//DAO라고 생각하면 된다.
	//mapper 객체 주입, @Setter을 사용해 자동화함.
	@Setter(onMethod_ = {@Autowired})
	private BoardMapper mapper;
	
	//등록
	@Override
	public void register(BoardDTO dto) {
		mapper.insertSelectKey(dto);
		log.info("===========출력내용==========");
		log.info("register: "+dto);
		log.info("===========출력내용==========");
	}

	//하나만 가져오기
	@Override
	public BoardDTO get(long bno) {
		log.info("=======getOne=========");
		return mapper.getOne(bno);
	}

	//수정
	@Override
	public boolean modify(BoardDTO dto) {
		log.info("==============modify");
		return mapper.update(dto) >= 1;
	}

	//삭제
	@Override
	public boolean remove(long bno) {
		log.info("==============remove");
		return mapper.delete(bno) == 1;
	}

	//전체목록
	@Override
	public List<BoardDTO> getList() {
		log.info("===========getList()==========");
		return mapper.getList();
	}
}
