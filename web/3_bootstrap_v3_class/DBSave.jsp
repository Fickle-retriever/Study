<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="dbcon.*"%>    
<% 
		request.setCharacterEncoding("utf-8"); 
		String name = request.getParameter("name");
		String item = request.getParameter("item");
		String content = request.getParameter("content");
		String stars = request.getParameter("stars");
		
		ItemVO vo = new ItemVO();	
		vo.setName(name);
		vo.setItem(item);
		vo.setContent(content);
		vo.setStars(stars);		
		
		
		ItemDAO dao = new ItemDAO();
		dao.insert(vo);
		
%>
    
 
 
 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	상품평 등록을 완성하였습니다.
	
</body>
</html>