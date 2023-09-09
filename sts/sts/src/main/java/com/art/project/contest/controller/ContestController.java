package com.art.project.contest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.art.project.common.Page;
import com.art.project.contest.dto.ContestDTO;
import com.art.project.contest.service.ContestService;

@Controller
@RequestMapping(value = "/contest")
public class ContestController {

	@Autowired
	private ContestService contestService;

//	페이징처리, 검색기능
	@GetMapping("contestList")
	public String getList(Model model, @RequestParam(value="listPageNum") int listPageNum
						, @RequestParam(value="searchType", required = false, defaultValue = "comm-title") String searchType
						, @RequestParam(value="keyword", required = false, defaultValue = "") String keyword) {

		Page page = new Page();
		
		page.setListPageNum(listPageNum);
		page.updateCount(contestService.searchCount(searchType, keyword));
		page.setSearchType(searchType);
		page.setKeyword(keyword);
		
		List<ContestDTO> list = null;
		list = contestService.listPageSearch(page.getDisplayPost(), page.getPostNum(), searchType, keyword);

		model.addAttribute("list", list);
		model.addAttribute("page", page);
		model.addAttribute("selectPageNum", listPageNum);
		return "tiles/contest/contestList?listPageNum=1";
	}

	@GetMapping("detail")
	public String getDetail(Model model, @RequestParam(value = "contest_idx") int idx) {

		ContestDTO detail = contestService.detail(idx);
		model.addAttribute("detail", detail);

		return "tiles/contest/detail";
	}

	// 글등록페이지 이동(관리자만)
	@GetMapping("write")
	@PreAuthorize("isAuthenticated() and hasRole('ROLE_ADMIN')")
	public String getWrite() {

		return "tiles/contest/contestWriteForm";
	}
	
	// 글등록(관리자만)
	@PostMapping("write")
	@PreAuthorize("isAuthenticated() and hasRole('ROLE_ADMIN')")
	public String postWrite(ContestDTO contestDTO) {

		contestService.write(contestDTO);

		return "redirect:contestList?listPageNum=1";
	}

	// 글 수정페이지 이동(관리자만)
	@GetMapping("update")
	@PreAuthorize("isAuthenticated() and hasRole('ROLE_ADMIN')")
	public String getUpdate(Model model, @RequestParam(value = "contest_idx") int idx) {
		ContestDTO detail = contestService.detail(idx);
		model.addAttribute("detail", detail);

		return "tiles/contest/contestUpdateForm";
	}

	// 글 수정(관리자만)
	@PostMapping("update")
	@PreAuthorize("isAuthenticated() and hasRole('ROLE_ADMIN')")
	public String postUpdate(ContestDTO contestDTO) {		
		contestService.update(contestDTO);

		return "redirect:contestList?listPageNum=1";
	}
	
	// 글 삭제(관리자만)
	@GetMapping("delete")
	@PreAuthorize("isAuthenticated() and hasRole('ROLE_ADMIN')")
	public String getDelete(@RequestParam(value="contest_idx") int idx) {
		contestService.delete(idx);
		
		return "redirect:contestList?listPageNum=1";
	}
}
