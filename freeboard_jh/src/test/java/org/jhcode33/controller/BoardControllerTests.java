package org.jhcode33.controller;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
//웹 환경임을 명시한다.
@WebAppConfiguration
//파일이 두개이기 때문에 배열로 들어간다.
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
	                  ,"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@Log4j
public class BoardControllerTests {
	
	@Autowired
	private WebApplicationContext ctx;
	
	private MockMvc mockMvc;
	
	//mockMvc를 만드는 코드를 직접 작성함.
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
		
	}
	
	//controller의 list를 테스트 할꺼임.
	//체이닝기법
	@Ignore
	public void testList() throws Exception{
		log.info(
			 mockMvc.perform(MockMvcRequestBuilders.get("/board/list"))
			.andReturn()
			.getModelAndView()
			.getModelMap()	
				);
	}
	
	@Ignore
	public void testRegister() throws Exception {
		//web에서 ?를 사용해서 parameter 값을 넘기는 것을 코드로 임시로 해주는 것임. 
		String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
																  .param("title", "목업제목")
																  .param("content", "목업 내용")
																  .param("writer", "목업 작성자"))
							       .andReturn() 
								   .getModelAndView()
								   .getViewName();
	
		log.info("==============="+resultPage);
	}
	
	@Ignore
	public void testGet() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/board/get")
											  .param("bno", "2"))
				.andReturn()
				.getModelAndView()
				.getModelMap();
	}
	
	@Ignore
	public void testModify() throws Exception{
		String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/modify")
																  .param("bno", "12")
																  .param("title", "modify")
																  .param("content", "modify")
																  .param("writer", "modify 작성자"))
												.andReturn() 
												.getModelAndView()
												.getViewName();
		log.info("==============="+resultPage);
	}
	
	@Test
	public void testRemove() throws Exception{
		String resultPage = mockMvc.perform(MockMvcRequestBuilders.get("/board/remove")
																  .param("bno", "12"))
								   .andReturn()
								   .getModelAndView()
								   .getViewName();
		log.info("==============="+resultPage);
	}
		
}
