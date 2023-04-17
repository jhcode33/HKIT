package org.jhcode33.controller;

import org.jhcode33.domain.BoardDTO;
import org.jhcode33.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*") // /board URL로 들어오는 모든 맵핑을 처리함.
@AllArgsConstructor
public class BoardController {
	
	//interface 타입으로 선언해서 코드의 유연함을 줌.
	//@Setter(onMethod_ = {@Autowired})
	private BoardService service;
	
	
	@GetMapping("/list")
	public void list(Model model) {
		model.addAttribute("list", service.getList());
		//return 타입을 적어주지 않으면 내부적으로 return "list.jsp"; 이 되어서 화면이 넘어가도록 되어있다.
		//return "list.jsp";
	}
	
	@PostMapping("/register")
	public String register(BoardDTO dto, RedirectAttributes rttr) {
		log.info("===============register: "+dto);
		service.register(dto);
		//사용자에게 몇번을 등록했는지 알려주기 위해 아래와 같이 함.
		//. Flash Attribute는 일시적으로 존재하는 데이터로, 다른 페이지로 Redirect 할 때 한 번만 사용 가능합니다.
		rttr.addFlashAttribute("result", dto.getBno());
		
		//정보가 바뀌었다는 의미로 redirect: 를 붙여서 해당 list 페이지로 이동하도록 재요청하는 것임
		return "redirect:/board/list";
	}
	
	@GetMapping("/get")
	public void get(Model model, @RequestParam("bno") long bno) {
		log.info("=============get: "+bno);
		model.addAttribute("dto", service.get(bno));
	}
	
	@PostMapping("/modify")
	public String modify(BoardDTO dto, RedirectAttributes rttr) {
		log.info("=============modify: " + dto);
		
		//성공 실패에 따라 if 절로 success를 화면에 전송
		if(service.modify(dto)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
	}
	
	@GetMapping("/remove")
	public String remove(long bno) {
		log.info("=============remove: " + bno);
		service.remove(bno);
		return "redirect:/board/list";
	}
}
