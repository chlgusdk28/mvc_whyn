<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

session.removeAttribute("PRICE");
session.removeAttribute("PERIOD");
session.removeAttribute("BOTTLE");
session.removeAttribute("CAL");
session.removeAttribute("FIRSTQ");
session.removeAttribute("SECONDQ");
session.removeAttribute("THIRDQ");
session.removeAttribute("FOURTHQ");
session.removeAttribute("FIFTHQ");
session.removeAttribute("FNUM");
session.removeAttribute("SNUM");
session.removeAttribute("TNUM");
session.removeAttribute("FFNUM");

%>
<script type="text/javascript">
alert("결제가 취소되었습니다. 당신의 구독정보가 삭제됩니다.");
location.href="index.jsp";

</script>
</body>
</html>