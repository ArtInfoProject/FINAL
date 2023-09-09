<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&family=Noto+Sans+KR:wght@300;700&family=Quicksand:wght@600&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="${path}/resources/css/exi_detail.css" />

<meta charset="UTF-8">
<title>전시회 상세</title>
</head>
<body>
	<div class="ex_detail_header">
		<p>${detail.exhibition_title}</p>
		<p>작성일자: ${detail.exhibition_registDate}</p>
	</div>
	<div class="ex_detail_contents">
		<img src="${detail.exhibition_img}" alt="Image 1">
		<div class="ex_details">
			<table>
				<tr>
					<th>작가명
					</td>
					<td>| ${detail.exhibition_writer}</td>
				</tr>
				<tr>
					<th>전시기간
					</td>
					<td>| ${detail.exhibition_start} ~ ${detail.exhibition_end}</td>
				</tr>
				<tr>
					<th>전시장소
					</td>
					<td>| 을지로 하트원 H.art1</td>
				</tr>
				<tr>
					<th>상세주소
					</td>
					<td>| 서울 중구 을지로 167 (을지로4가 39-1번지) 4층</td>
				</tr>
			</table>
		</div>
		<p class="ex_detail_content_long">${detail.exhibition_contents}</p>

		<div class="edit">
			<sec:authorize access="isAuthenticated() and hasRole('ROLE_ADMIN')">
				<a href="/exhibition/update?exhibition_idx=${detail.exhibition_idx}"
					role="button">수정</a>
				<a href="/exhibition/delete?exhibition_idx=${detail.exhibition_idx}"
					role="button">삭제</a>
			</sec:authorize>
		</div>
		<div class="list">
        	<a href="<c:url value='/exhibition/exhibitionList?listPageNum=1'/>">목록</a>
        </div>
	</div>
</body>
</html>