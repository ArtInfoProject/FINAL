package com.art.project.exhibition.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.art.project.common.Page;
import com.art.project.exhibition.dto.ExhibitionDTO;
import com.art.project.exhibition.service.ExhibitionService;

@Controller
@RequestMapping(value = "/exhibition")
public class ExhibitionController {

   @Autowired
   private ExhibitionService exhibitionService;

   @RequestMapping(value = "/exhibitionList", method = RequestMethod.GET)
   public String exhibitionSolo(Model model,
         @RequestParam(value = "listPageNum") int listPageNum,
         @RequestParam(value = "searchType", required = false, defaultValue = "title") String searchType,
         @RequestParam(value = "keyword" , required = false, defaultValue = "") String keyword,
         @RequestParam(value = "category" , required = false, defaultValue = "") String category,
         @RequestParam(value = "status" , required = false, defaultValue = "") String status) throws Exception{ // 개인전목록

      Page page = new Page();

      page.setListPageNum(listPageNum);
      page.updateCount(exhibitionService.searchCount(searchType, keyword, category, status));
      page.setSearchType(searchType);
      page.setKeyword(keyword);
      
      List<ExhibitionDTO> list;
      list = exhibitionService.exhibitionSearch(page.getDisplayPost(), page.getPostNum(), searchType, keyword, category, status);

      model.addAttribute("list", list);
      model.addAttribute("page", page);
      model.addAttribute("selectPageNum", listPageNum);
      return "tiles/exhibition/exhibitionList?listPageNum=1";
   }

   @RequestMapping(value = "/write", method = RequestMethod.GET)
   public String getWrite() { // 전시회 작성폼페이지

      return "/exhibition/exhibitionWriteForm";
   }

   @RequestMapping(value = "/write", method = RequestMethod.POST)
   public String postWrite(ExhibitionDTO exhibitionDTO) { // 전시회 작성폼페이지

      exhibitionService.write(exhibitionDTO);

      return "redirect:exhibitionList?listPageNum=1";
   }

   @RequestMapping(value = "/detail") // 글 상세내용
   public String getDetail(Model model, @RequestParam(value = "exhibition_idx") int idx) {
      ExhibitionDTO detail = exhibitionService.detail(idx);
      model.addAttribute("detail", detail);

      return "tiles/exhibition/detail";
   }

   @RequestMapping(value = "/update", method = RequestMethod.GET)
   public String getUpdate(Model model, @RequestParam(value = "exhibition_idx") int idx) { // 글 수정(기존 writeform에 적어놓앗던
                                                                     // 정보 불러오기위해 이 메소드 사용)
      ExhibitionDTO detail = exhibitionService.detail(idx);
      model.addAttribute("detail", detail);

      return "/exhibition/exhibitionUpdateForm";
   }

   @RequestMapping(value = "/update", method = RequestMethod.POST)
   public String PostUpdate(ExhibitionDTO exhibitionDTO) { // 글 수정(기존 writeform에 적어놓앗던 정보 불러오기위해 이 메소드 사용)

	   exhibitionService.update(exhibitionDTO);

      return "redirect:exhibitionList?listPageNum=1";
   }

   @RequestMapping(value = "/delete", method = RequestMethod.GET)
   public String getDelete(@RequestParam(value = "exhibition_idx") int idx) {
      
	   exhibitionService.delete(idx);

      return "redirect:exhibitionList?listPageNum=1";
   }
}