package com.art.project.exhibition.dto;

import java.sql.Date;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ExhibitionDTO {

	private int exhibition_idx; // 게시글 번호(PK)

	private String exhibition_title; // 전시회 제목
	
	private String exhibition_writer; // 작가

	private LocalDateTime exhibition_registDate; // 게시글 등록일자

	private Date exhibition_start; // 전시시작날짜

	private Date exhibition_end; // 전시종료날짜

	private String exhibition_region; // 전시지역

	private String exhibition_location; // 전시장소

	private String exhibition_img; // 전시이미지

	private String exhibition_contents; // 전시내용

	private String exhibition_url; // 링크

	private String exhibition_category; // 구분(개인/단체)

	private int exhibition_hits; // 조회수
}
