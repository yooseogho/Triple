<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시글 상세보기</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/header.css' />">
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/aside.css' />">
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/footer.css' />">
	<link rel="stylesheet" type="text/css" href="<c:url value='/css/main.css' />">
	<style>
		.post-detail {
		    background-color: #fff; /* 배경색 */
		    border-radius: 8px; /* 모서리 둥글게 */
		    box-shadow: 0 0 15px rgba(0, 0, 0, 0.1); /* 그림자 효과 */
		    padding: 20px; /* 안쪽 여백 */
		    margin: 20px auto; /* 위아래 여백, 중앙 정렬 */
		    max-width: 800px; /* 최대 너비 */
		    font-family: 'Arial', sans-serif; /* 폰트 스타일 */
		}

		.post-info {
		    margin-bottom: 20px; /* 정보 섹션과 액션 섹션 사이에 여백 */
		}

		.post-info p {
		    font-size: 1.2em; /* 텍스트 크기 */
		    line-height: 1.6; /* 줄 간격 */
		    color: #333; /* 텍스트 색상 */
		    margin: 10px 0; /* 상하 여백 */
		}

		.post-info strong {
		    color: #007bff; /* 제목 부분 강조 색상 */
		}

		.post-action {
		    text-align: right; /* 버튼을 오른쪽 정렬 */
		}

		.post-action .btn {
		    background-color: #007bff; /* 버튼 배경색 */
		    color: white; /* 버튼 텍스트 색상 */
		    padding: 10px 20px; /* 버튼 패딩 */
		    text-decoration: none; /* 밑줄 제거 */
		    border-radius: 5px; /* 버튼 모서리 둥글게 */
		    font-size: 1.1em; /* 버튼 텍스트 크기 */
		    transition: background-color 0.3s ease; /* 호버 효과 */
		}

		.post-action .btn:hover {
		    background-color: #0056b3; /* 호버 시 배경색 변경 */
		}

		.post-action .btn:active {
		    background-color: #004085; /* 클릭 시 배경색 변경 */
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
	<header class="site-header">
	    <h1 class="site-title">TRIPLE POSTS</h1>

	    <nav class="site-nav">
	        <ul class="nav-list">
	            <li class="nav-item"><a class="nav-link" href="<c:url value='/' />">홈</a></li>

	            <c:choose>
	                <c:when test="${not empty sessionScope['SPRING_SECURITY_CONTEXT']}">
						<li class="nav-item">
						    <span class="nav-text">
						        <strong>${pageContext.request.userPrincipal.name}님</strong>
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

    <!-- 콘텐츠 섹션 -->
	<aside class="sidebar">
	    <h2>광고</h2>
	    <ul>
	        <li>광고1</li>
	        <li>광고2</li>
	        <li>광고3</li>
	    </ul>
	</aside>

        <main class="main-content">
			
           <section class="post-detail">
                <div class="post-info">
                    <p><strong>제목:</strong> ${board.title}</p>
                    <p><strong>작성자 ID:</strong> ${board.memNo}</p>
                    <p><strong>내용:</strong></p>
                    <p>${board.content}</p>
                </div>
                <div class="post-action">
                    <a href="<c:url value='/'/>" class="btn">목록으로 돌아가기</a>
                </div>
            </section>
			
        </main>

		
		
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
        <div class="container">
            <p>&copy; 2024 My Website. All rights reserved.</p>
        </div>
    </footer>
</body>
</html>
