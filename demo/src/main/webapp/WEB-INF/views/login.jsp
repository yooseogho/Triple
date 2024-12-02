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
		/* 메인 레이아웃 */
		.main-content {
		    display: flex;
		    justify-content: center;
		    align-items: center;
		    height: 80vh;
		    background-color: #f5f5f5;
		    font-family: 'Arial', sans-serif;
		}

		/* 로그인 섹션 */
		.login-section {
		    width: 100%;
		    max-width: 400px;
		    padding: 20px;
		    background: #ffffff;
		    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
		    border-radius: 8px;
		    text-align: center;
		}

		/* 제목 스타일 */
		.login-container h2 {
		    margin-bottom: 20px;
		    font-size: 24px;
		    color: #333;
		}

		/* 폼 스타일 */
		.login-form {
		    display: flex;
		    flex-direction: column;
		    gap: 15px;
		}

		.form-group {
		    text-align: left;
		}

		label {
		    display: block;
		    margin-bottom: 5px;
		    font-size: 14px;
		    color: #555;
		}

		input[type="text"],
		input[type="password"] {
		    width: 100%;
		    padding: 10px;
		    border: 1px solid #ddd;
		    border-radius: 4px;
		    font-size: 14px;
		}

		input[type="text"]:focus,
		input[type="password"]:focus {
		    border-color: #007bff;
		    outline: none;
		}

		/* 버튼 스타일 */
		.btn-submit {
		    width: 100%;
		    padding: 10px;
		    background: #35424a; /* 헤더 배경색 */
		    border: none;
		    border-radius: 4px;
		    color: white;
		    font-size: 16px;
		    cursor: pointer;
		    transition: background-color 0.3s;
		}

		.btn-submit:hover {
		    background-color: #0056b3;
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
	    <section class="login-section">
	        <div class="login-container">
				<h2>TRIPLE 로그인</h2>
	            <form action="<c:url value='/login' />" method="post" class="login-form">
	                <div class="form-group">
	                    <label for="id">ID:</label>
	                    <input type="text" name="id" id="id" placeholder="아이디를 입력하세요" required />
	                </div>
	                <div class="form-group">
	                    <label for="passwd">Password:</label>
	                    <input type="password" name="passwd" id="passwd" placeholder="비밀번호를 입력하세요" required />
	                </div>
	                <button type="submit" class="btn-submit">로그인</button>
	            </form>
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
	</footer>

	
	
	
</body>
</html>
