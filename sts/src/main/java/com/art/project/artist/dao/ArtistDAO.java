package com.art.project.artist.dao;

import java.util.List;

import com.art.project.artist.dto.ArtistDTO;

public interface ArtistDAO {

	//아티스트 글목록
	List<ArtistDTO> list();

	//상세페이지
	ArtistDTO listArtist(ArtistDTO artistDTO);
	
	List<ArtistDTO> listPicture(ArtistDTO artistDTO);

	//아티스트 삭제하기
	void artistDelete(int idx);
	
	//작품 삭제하기
	void pictureDelete(int idx);

	//아티스트 글쓰기
	void write(ArtistDTO artistDTO);

	//아티스트 글쓰기 수정
	void update(ArtistDTO artistDTO);

	//아티스트 작품 등록
	void registrationWork(ArtistDTO artistDTO);

	//작품 수정
	void updatePicture(ArtistDTO artistDTO);
	
	//한 아티스트에 한작품 상세보기
	ArtistDTO listOnePicture(ArtistDTO artistDTO);

	// 게시물 총 갯수
	public int count();
	
	// 게시물 목록 + 페이징
	public List<ArtistDTO> listPage(int displayPost, int postNum);
	
	public List<ArtistDTO> artistSearch(
			   int displayPost, int postNum, String searchType, String keyword);

	int searchCount(String searchType, String keyword);

}
