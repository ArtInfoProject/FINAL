<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${path}/resources/css/write.css" />
<title>Insert title here</title>
</head>
<!-- <script type="text/javascript"> -->
<!-- // 	$(document).ready(function() { -->
<!-- // 		$("#changeTest").change(function() { -->
<!-- // 			console.log("값변경테스트: " + $(this).val()); -->
<!-- // 			$("#changeTest").val($(this).val()); -->

<!-- // 		}); -->
<!-- // 	}); -->
<!-- </script> -->
<body>
	<div id="writeBody">
		<form action="/community/update?community_idx=${detail.community_idx}"
			method="post">
			<div id="board-catetory">
				<p>커뮤니티 글수정</p>
			</div>
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}"> <label>글 번호 :
				${detail.community_idx}</label>
			<div>
				<label>카테고리</label>
				<%-- 						${detail} --%>
				<select id="community_category" name="community_category">
					<option value="">선택하세요</option>
					<option value="광고홍보"
						${detail.community_category == '광고홍보' ? 'selected' : '' }>광고홍보</option>
					<option value="구인구직"
						${detail.community_category == '구인구직' ? 'selected' : '' }>구인구직</option>
					<option value="중고장터"
						${detail.community_category == '중고장터' ? 'selected' : ' ' }>중고장터</option>
				</select>
			</div>
			<div>
				<label>제목</label> <input type="text" name="community_title"
					value="${detail.community_title}" />
			</div>
			<div>
				<label>내용</label>
				<textarea rows="20" cols="50" id="community_contents"
					name="community_contents">${detail.community_contents}</textarea>
			</div>
			<div class="button-container">
				<button type="submit">수정</button>
				<button type="button" onclick="history.back();">취소</button>
			</div>
		</form>
	</div>
</body>
</html>