package org.jhcode33.service;

import static org.junit.Assert.assertNotNull;

import org.jhcode33.domain.BoardDTO;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {

	@Setter(onMethod_ = {@Autowired})
	private BoardService service;
	
	@Test
	public void testExist() {
		assertNotNull(service);
		log.info(service);
		log.info("serviceTest 실행");
	}
	
	@Ignore
	public void testRegister() {
		BoardDTO dto = new BoardDTO();
		dto.setTitle("등록 테스트2");
		dto.setContent("등록 테스트 중입니다.2");
		dto.setWriter("Register Test()2");
		service.register(dto);
		
		log.info(dto.getBno());
	}
	
	@Ignore
	public void testGetList() {
		service.getList();
		log.info(service.getList());
	}
	
	@Ignore
	public void testGetOne() {
		log.info("===============");
		service.get(2L);
	}
	
	@Test
	public void testModify() {
		log.info("===============");
		BoardDTO dto = new BoardDTO();
		dto.setBno(10L);
		dto.setTitle("나는 수정이다.");
		dto.setContent("수정이는 수정이다.");
		dto.setWriter("수정이가 썼다.");
		
		service.modify(dto);
	}
	
	@Ignore
	public void testRemove() {
		log.info("=========");
		service.remove(10L);
	}
	
}
