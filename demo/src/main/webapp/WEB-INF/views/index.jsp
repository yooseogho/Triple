<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시글 목록</title>
	<link rel="stylesheet" type="text/css" href="<c:url value='/css/header.css' />">
	<link rel="stylesheet" type="text/css" href="<c:url value='/css/aside.css' />">
	<link rel="stylesheet" type="text/css" href="<c:url value='/css/main.css' />">
	<link rel="stylesheet" type="text/css" href="<c:url value='/css/footer.css' />">
	<style>
		.main-content {
		    flex-grow: 1; /* 메인 콘텐츠가 남은 공간을 차지하도록 설정 */
		    padding: 20px; /* 메인 콘텐츠 패딩 */
		    background: #f9f9f9; /* 메인 배경색 */
		    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* 메인 콘텐츠 그림자 */
		    border-radius: 8px; /* 모서리 둥글게 */
		    margin: 20px; /* 여백 추가 */
		}

		.main-content h2 {
		    font-size: 1.8em; /* 제목 크기 */
		    color: #333; /* 제목 색상 */
		    margin-bottom: 20px; /* 제목 아래 여백 */
		}

		.post-table {
		    width: 100%; /* 테이블 너비 */
		    border-collapse: collapse; /* 테이블 경계선 겹치지 않게 */
		}

		.post-table th, .post-table td {
		    padding: 12px; /* 셀 패딩 */
		    text-align: left; /* 텍스트 왼쪽 정렬 */
		    border-bottom: 1px solid #ddd; /* 아래 경계선 */
		}

		.post-table th {
		    background-color: #2c3e50; /* 어두운 네이비 블루 색상 */
		    color: white; /* 텍스트 색상 */
		    font-weight: bold; /* 텍스트 두껍게 */
		    font-size: 1.1em; /* 글씨 크기 조정 */
		    text-align: left; /* 텍스트 왼쪽 정렬 */
		    padding: 12px 15px; /* 패딩 추가 */
		    border-bottom: 3px solid #34495e; /* 본문과 구분되는 두꺼운 하단 경계선 */
		    text-transform: uppercase; /* 텍스트 대문자화 */
		    letter-spacing: 1px; /* 글자 간격 추가 */
		    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1); /* 테두리 그림자 효과 */
		}

		 

		.post-table tr:hover {
		    cursor: pointer; /* 클릭 가능하도록 마우스 커서 변경 */
		    background-color: #e0e0e0; /* 마우스 오버 시 배경색을 좀 더 진하게 */
		    transition: background-color 0.5s ease; /* 부드러운 배경색 전환 효과 */
		}
		.nav-text strong {
		    color: #4CAF50;
		    font-size: 1.2em;
		    font-weight: bold;
		}


	</style>
	
	
</head>
<body>
    <!-- 헤더 -->
	
	<!-- 헤더 -->
	<header class="site-header">
	    <h1 class="site-title">석호!!!</h1>

	    <nav class="site-nav">
	        <ul class="nav-list">
	            <li class="nav-item"><a class="nav-link" href="<c:url value='/' />">홈</a></li>

	            <c:choose>
	                <c:when test="${not empty sessionScope['SPRING_SECURITY_CONTEXT']}">
	                    <!-- 알림이 한 번만 뜨게 처리 -->
	                    <c:if test="${empty sessionScope['alertShown']}">
	                        <script>
	                            alert('${username}님, 환영합니다!');
	                        </script>
	                        <c:set var="alertShown" value="true" scope="session" />
	                    </c:if>

	                    <li class="nav-item">
	                        <span class="nav-text">
	                            <strong>${username}님</strong>
	                        </span>
	                    </li>

	                    <li class="nav-item">
	                        <a class="nav-link" href="<c:url value='/logout' />">로그아웃</a>
	                    </li>
	                </c:when>

	                <c:otherwise>
	                    <li class="nav-item"><a class="nav-link" href="<c:url value='/login' />">로그인</a></li>
	                    <li class="nav-item"><a class="nav-link" href="<c:url value='/signup' />">회원가입</a></li>
	                </c:otherwise>
	            </c:choose>
				
	        </ul>
	    </nav>
	</header>

	
	
	<aside class="sidebar">
	    <h2>광고</h2>
	    <ul>
	        <li>광고1</li>
	        <li>광고2</li>
	        <li>광고3</li>
	    </ul>
	</aside>

	<!-- 메인 -->
	<main class="main-content">
	    <section>
	     
	        <!-- 게시글 목록 테이블 -->
	        <table class="post-table">
	            <thead>
	                <tr>
	                    <th>번호</th>
	                    <th>제목</th>
	                    <th>작성자</th>
	                    <th>작성일</th>
	                </tr>
	            </thead>
	            <tbody>
	                <c:forEach var="board" items="${boards}">
	                    <tr onclick="window.location.href='${board.no}'">
	                        <td>${board.no}</td>
	                        <td>${board.title}</td>
	                        <td>${board.writerId}</td>
	                        <td>${board.boardDate}</td>
	                    </tr>
	                </c:forEach>
	            </tbody>
	        </table>
			<!-- 게시글 쓰기 버튼 -->
			        <div class="post-actions">
			            <button class="btn-write" onclick="window.location.href='/write'">게시글 작성</button>
			        </div>
			        
	    </section>
	</main>


	<!-- 사이드바 -->
	<aside class="sidebar">
	    <h2>광고</h2>
	    <ul>
	        <li>광고1</li>
	        <li>광고2</li>
	        <li>광고3</li>
	    </ul>
	</aside>


	<!-- 푸터 -->
		<footer class="site-footer">
		    <p>&copy; 2024 My Website. All rights reserved.</p>
			<p>자동화 배포 프로젝트입니다.</p>
		    <p>우리는 지속적인 개선과 혁신을 통해 최상의 서비스를 제공합니다.</p>
		    <p>문의: tjrgh6362@naver.com</p>
		</footer>
	
	
</body>
</html>
