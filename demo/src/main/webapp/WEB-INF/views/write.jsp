<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>게시글 작성</title>

    <!-- Bootstrap & Summernote CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="<c:url value='/css/footer.css' />">
    <!-- Custom CSS -->
    <link rel="stylesheet" href="<c:url value='/css/style.css' />">

    <!-- jQuery, Bootstrap, Summernote JS -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/lang/summernote-ko-KR.min.js"></script>

    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
        }
        .main-content {
            max-width: 800px;
            margin: 50px auto;
            padding: 20px;
            background: white;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }
        .form-actions {
            display: flex;
            justify-content: center;
            gap: 10px;
        }
        .btn-primary {
            background-color: #007bff;
            border: none;
        }
        .btn-primary:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

<!-- 헤더 -->
<header class="bg-dark text-white p-3 text-center">
    <h1>게시글 작성</h1>
</header>

<!-- 메인 컨텐츠 -->
<main class="main-content">
    <form id="postForm" action="/write" method="post">
        <div class="mb-3">
            <label for="title" class="form-label">제목</label>
            <input type="text" class="form-control" id="title" name="title" placeholder="제목을 입력하세요" required>
        </div>

        <div class="mb-3">
            <label for="summernote" class="form-label">내용</label>
            <div id="summernote"></div>
            <input type="hidden" name="content" id="content">
        </div>

        <!-- 삭제 여부 기본값 설정 -->
        <input type="hidden" name="del" value="0">

        <div class="form-actions">
            <button type="submit" class="btn btn-primary">저장</button>
            <button type="reset" class="btn btn-secondary">초기화</button>
        </div>
    </form>
</main>

<!-- 푸터 -->
<footer class="site-footer">
    <p>&copy; 2024 My Website. All rights reserved.</p>
</footer>


<script>
    $(document).ready(function () {
        // Summernote 초기화
        $('#summernote').summernote({
            height: 300,
            lang: 'ko-KR', // 한국어 설정
            placeholder: '내용을 입력하세요...'
        });

        // 폼 제출 시 Summernote 데이터를 hidden input에 저장
        $('#postForm').on('submit', function () {
            var markup = $('#summernote').summernote('code');
            $('#content').val(markup);
        });
    });
</script>




</body>
</html>
