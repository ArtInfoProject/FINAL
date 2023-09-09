package com.art.project.artist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.art.project.artist.dto.ArtistDTO;
import com.art.project.artist.service.ArtistService;
import com.art.project.common.Page;

@Controller
@RequestMapping(value = "/artist")
public class ArtistController {

	@Autowired
	private ArtistService artistService;

	// 아티스트 리스트
	@GetMapping("artistList")
	public String getList(Model model, @RequestParam(value = "listPageNum") int listPageNum,
			@RequestParam(value = "searchType", required = false, defaultValue = "name") String searchType,
			@RequestParam(value = "keyword", required = false, defaultValue = "") String keyword) {

		Page page = new Page();

		page.setListPageNum(listPageNum);
		page.updateCount(artistService.searchCount(searchType, keyword));

		page.setSearchType(searchType);
		page.setKeyword(keyword);

		List<ArtistDTO> list = null;

		list = artistService.artistSearch(page.getDisplayPost(), page.getPostNum(), searchType, keyword);

		model.addAttribute("list", list);
		model.addAttribute("page", page);
		model.addAttribute("selectPageNum", listPageNum);
		return "tiles/artist/artistList?listPageNum=1";

	}

	// 아티스트 정보
	@GetMapping("detail")
	public String getDetail(Model model, ArtistDTO artistDTO) {
		ArtistDTO detailArtist = artistService.detailArtist(artistDTO);
		List<ArtistDTO> detailPicture = artistService.detailPicture(artistDTO);

		model.addAttribute("detailArtist", detailArtist);
		model.addAttribute("detailPicture", detailPicture);

		return "tiles/artist/detail";
	}

	// 아티스트 등록 페이지로 이동(관리자만)
	@GetMapping("write")
	@PreAuthorize("isAuthenticated() and hasRole('ROLE_ADMIN')")
	public String getWrite() {

		return "tiles/artist/artistWriteForm";
	}

	// 아티스트 등록(관리자만)
	@PostMapping("write")
	@PreAuthorize("isAuthenticated() and hasRole('ROLE_ADMIN')")
	public String postWrite(ArtistDTO artistDTO) {

		artistService.write(artistDTO);

		return "redirect:artistList?listPageNum=1";
	}

	// 아티스트 정보 수정 페이지로 이동(관리자만)
	@GetMapping("update")
	@PreAuthorize("isAuthenticated() and hasRole('ROLE_ADMIN')")
	public String getUpdate(Model model, ArtistDTO artistDTO) {

		ArtistDTO detailArtist = artistService.detailArtist(artistDTO);
		model.addAttribute("detailArtist", detailArtist);

		return "tiles/artist/artistUpdateForm";
	}

	// 아티스트 정보 수정(관리자만)
	@PostMapping("update")
	@PreAuthorize("isAuthenticated() and hasRole('ROLE_ADMIN')")
	public String postUpdate(ArtistDTO artistDTO) {
		artistService.update(artistDTO);

		return "redirect:artistList?listPageNum=1";
	}

	// 아티스트 작품 등록 페이지로 이동(관리자만)
	@GetMapping("registrationWork")
	@PreAuthorize("isAuthenticated() and hasRole('ROLE_ADMIN')")
	public String getRegistrationWork() {
		return "tiles/artist/registrationWrite"; // ArtistDTO artistDTO, Model model
	}

	// 아티스트 작품 등록(관리자만)
	@PostMapping("registrationWork")
	@PreAuthorize("isAuthenticated() and hasRole('ROLE_ADMIN')")
	public String postRegistrationWork(ArtistDTO artistDTO) {

		artistService.registrationWork(artistDTO);

		return "redirect:detail?artist_idx=" + artistDTO.getArtist_idx();
	}

	// 아티스트 작품 정보 수정 페이지로 이동(관리자만)
	@GetMapping("updatePicture")
	@PreAuthorize("isAuthenticated() and hasRole('ROLE_ADMIN')")
	public String getPictureUpdate(Model model, ArtistDTO artistDTO) {
		ArtistDTO detailPicture = artistService.listOnePicture(artistDTO);

		model.addAttribute("detailPicture", detailPicture);

		return "tiles/artist/picturesUpdateForm";
	}

	// 아티스트 작품 정보 수정(관리자만)
	@PostMapping("updatePicture")
	@PreAuthorize("isAuthenticated() and hasRole('ROLE_ADMIN')")
	public String postPictureUpdate(ArtistDTO artistDTO) {
		artistService.updatePicture(artistDTO);

		return "redirect:detail?artist_idx=" + artistDTO.getArtist_idx();
	}

	// 아티스트 삭제(관리자만)
	@GetMapping("artistDelete")
	@PreAuthorize("isAuthenticated() and hasRole('ROLE_ADMIN')")
	public String artistDelete(@RequestParam(value = "artist_idx") int idx) {
		artistService.artistDelete(idx);

		return "redirect:artistList?listPageNum=1";
	}

	// 아티스트 작품 삭제(관리자만)
	@GetMapping("pictureDelete")
	@PreAuthorize("isAuthenticated() and hasRole('ROLE_ADMIN')")
	public String pictureDelete(@RequestParam(value = "picture_idx") int idx) {

		artistService.pictureDelete(idx);

		return "redirect:artistList?listPageNum=1";
	}
}
