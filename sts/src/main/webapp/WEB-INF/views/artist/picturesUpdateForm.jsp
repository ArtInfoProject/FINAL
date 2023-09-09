<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>UPDATE</title>

<link
	href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&family=Noto+Sans+KR:wght@300;700&family=Quicksand:wght@600&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="${path}/resources/css/write.css" />
</head>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<body>
	<div id="writeBody">
	<form action="/artist/updatePicture?picture_idx=${detailPicture.picture_idx}" method="post">
<%-- 		<c:out value="${detailPicture.artist_idx}" /> --%>
<%-- 		<c:out value="${detailPicture.picture_idx}" /> --%>
		<div id="board-catetory">
			<p>작품 수정</p>
		</div>
		<div>
			<label>작품명 : </label><input type="text" id="picture_title"
				name="picture_title" value="${detailPicture.picture_title}">
		</div>
		<div>
			<label>작품 size : </label><input type="text" id="picture_size"
				name="picture_size" value="${detailPicture.picture_size}">
		</div>
		<div>
			<label>작품 재료 : </label><input type="text" id="picture_supplies"
				name="picture_supplies" value="${detailPicture.picture_supplies}">
		</div>
		<div>
			<label>작품 이미지 : </label> <input type="text" id="picture_file"
				name="picture_file" value="${detailPicture.picture_file}">
		</div>
		<div class="button-container">
			<button class="del">
			<a href="<c:url value='/artist/pictureDelete?picture_idx=${detailPicture.picture_idx}'/>">삭제</a></button> 		
			<button type="submit">제출</button>
			<button type="button" onclick="history.back();">취소</button>
		</div>
		<input type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}" />
	</form>
	</div>
	<!-- name 속성은 스크립트단에서 id 속성은 Server단에서 주로 사용된다. -->
</body>

</html>