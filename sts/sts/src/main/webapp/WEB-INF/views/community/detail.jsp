<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet" href="${path}/resources/css/com_detail.css" />

<meta charset="UTF-8">
<title>커뮤니티 상세</title>
</head>
<body>
	<div class="com_detail_header">
		<p>${detail.community_title}</p>
		<p>✍🏻${detail.member_name}</p>
		<p>${detail.community_registDate}</p>
	</div>
	<div class="com_detail_content">
		<p>${detail.community_title}</p>
		<p class="com_detail_content_long">${detail.community_contents}</p>
		<button>🙌🏻 SNS 공유</button>
	</div>
	<div class="files">
		<table>
			<tr>
				<td colspan="2" class="file">첨부파일</td>
			</tr>
			<tr>
				<td><a href="#" download>N/A</a></td>
				<td class="col-date">-</td>
			</tr>
		</table>
		<table>
			<tr>
				<td class="link">관련링크</td>
			</tr>
			<tr>
				<td><a href="#">N/A</a></td>
			</tr>
		</table>
		<div class="edit">
			<sec:authorize access="isAuthenticated()">
				<a href="/community/update?community_idx=${detail.community_idx}"
					role="button">수정</a>
				<a href="/community/delete?community_idx=${detail.community_idx}"
					role="button">삭제</a>
			</sec:authorize>
		</div>
	</div>
	<div class="article ">
		<table>
			<tr>
				<td>이전글</td>
				<td><a href="#">이전글이 없오</a></td>
			</tr>
			<tr>
				<td>다음글</td>
				<td><a href="">작업실 이사 이동</a></td>
			</tr>
		</table>
	</div>
	<div class="list">
		<a href="/community/communityList?listPageNum=1">목록</a>
	</div>
</body>
</html>