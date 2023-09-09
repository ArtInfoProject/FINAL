<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link
        href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&family=Noto+Sans+KR:wght@300;700&family=Quicksand:wght@600&display=swap"
        rel="stylesheet">
      <link rel="stylesheet" href="${path}/resources/css/write.css" />
</head>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>

<body>
<div id="writeBody">
    <form action="/artist/write" method="post">
<!--     <input type="hidden" > -->
        <div id="board-catetory">
            <p>아티스트 등록</p>
        </div>
        <div>
            <label>작가명 : </label><input type="text" id="artist_name" name="artist_name">
        </div>
        <div>
            <label>작가 국적 : </label><input type="text" id="artist_nationality" name="artist_nationality">
        </div>
        <div>
            <label>작가 학력 : </label><input type="text" id="artist_edu" name="artist_edu">
        </div>
        <div>
            <label>작가 경력 & 이력 : </label>
            <textarea id="artist_career" name="artist_career" rows="10" cols="40"></textarea>
            <!--          <input type="button" id="artist_career" name= "artist_career"/> -->
            <!--          <input type="button" value="-" onclick="deleteInput();"/> -->
            <!--          <div id="parah"></div> -->
        </div>
        <div>
            <label>작가소개 : </label>
            <textarea name="artist_note" id="artist_note" rows="20" cols="50"></textarea>
        </div>
        <div>
            <label>작가 프로필사진 : </label> <input type="file" id="artist_photo" name="artist_photo" accept=".jpg,.png">
        </div>
        <div class="button-container">
            <button type="reset">다시쓰기</button>
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