<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">

a {
  outline: 0;
  text-decoration: none;
}
.nav{display: flex;
  align-items: center;
  height: 100vh;
  background: #fefefe;
  }
  
.navigation {
  width: 100%;
  border-bottom: 1.5px solid rgba(223,190,106,0.7);
  font-family: 'Pathway Gothic One', sans-serif;
  font-size: 22px;
}

.menu {
  display: flex;
  justify-content: center;
  max-width: 1150px;
  margin: 0 auto;
  padding-left: 0;
}

.menu__item {
  display: inline-block;
  white-space: nowrap;
}
@media screen and (max-width: 480px) {
  .menu__item:nth-child(n + 3) {
    display: none;
  }
  .menu__item:nth-child(2) .menu__link {
    border-right: 0;
  }
}
@media screen and (max-width: 768px) {
  .menu__item:nth-child(n + 4) {
    display: none;
  }
  .menu__item:nth-child(3) .menu__link {
    border-right: 0;
  }
}
@media screen and (max-width: 992px) {
  .menu__item:nth-child(n + 5) {
    display: none;
  }
  .menu__item:nth-child(4) .menu__link {
    border-right: 0;
  }
}
.menu__item:last-child .menu__link {
  border-right: 0;
}

.menu__link {
  display: block;
  padding: 6px 30px 3px;
  border-right: 2px dotted rgba(223,190,106,0.7);
}
.menu__link:hover .menu__first-word, .menu__link:focus .menu__first-word {
  transform: translate3d(0, -105%, 0);
}
.menu__link:hover .menu__second-word, .menu__link:focus .menu__second-word {
  transform: translate3d(0, 105%, 0);
}
@media screen and (min-width: 768px) {
  .menu__link {
    padding: 6px 40px 3px;
  }
}

.menu__title {
  display: inline-block;
  overflow: hidden;
}

.menu__first-word,
.menu__second-word {
  display: inline-block;
  position: relative;
  transition: transform .3s;
}
.menu__first-word::before,
.menu__second-word::before {
  position: absolute;
  content: attr(data-hover);
}

.menu__first-word {
  color:#505050;
}
.menu__first-word::before {
  top: 105%;
  color:rgba(223,190,106,0.7);
}

.menu__second-word {
 color:rgba(223,190,106,0.7);
}
.menu__second-word::before {
  bottom: 105%;
  color: #505050;
}
h1{line-height: 80px; text-decoration:none; text-align: center; }
</style>
<title>관리자 페이지</title>
</head>
<body>
<h1><a href="AdmainCountCommand.do" style="color :rgba(223,190,106,0.7);"><img src="img/logo.png" width="120px"></a></h1>


<nav class="navigation">
  <ul class="menu">
    <li class="menu__item">
      <a href="AdmainCountCommand.do" class="menu__link" id = "main">
        <span class="menu__title">
          <span class="menu__first-word" data-hover="메인">
          	  메인
          </span>
          <span class="menu__second-word" data-hover="페이지">
           	 페이지
          </span>
        </span>
      </a>
    </li>

    <li class="menu__item">
      <a href="AUserLCommand.do" class="menu__link" id = "user">
        <span class="menu__title">
          <span class="menu__first-word" data-hover="회원">
       	     회원
          </span>
          <span class="menu__second-word" data-hover="관리">
         	   관리
          </span>
        </span>
      </a>
    </li>

    <li class="menu__item">
      <a href="AReviewLCommand.do" class="menu__link" id = "review"> 
        <span class="menu__title">
          <span class="menu__first-word" data-hover="후기">
            	후기
          </span>
          <span class="menu__second-word" data-hover="관리">
      		     관리
          </span>
        </span>
      </a>
    </li>
    <li class="menu__item">
      <a href="ADeliveryLCommand.do" class="menu__link" id = "delivery"> 
        <span class="menu__title">
          <span class="menu__first-word" data-hover="배송">
            	배송
          </span>
          <span class="menu__second-word" data-hover="관리">
      		     관리
          </span>
        </span>
      </a>
    </li>

    <li class="menu__item">
      <a href="ACounselingLCommand.do" class="menu__link" id = "counseling">
        <span class="menu__title">
          <span class="menu__first-word" data-hover="문의">
            	문의
          </span>
          <span class="menu__second-word" data-hover="관리">
            	관리 
          </span>
        </span>
      </a>
    </li>

    <li class="menu__item">
      <a href="AWineLCommand.do" class="menu__link" id="wine">
        <span class="menu__title">
          <span class="menu__first-word" data-hover="와인">
            	와인
          </span>
          <span class="menu__second-word" data-hover="리스트">
            	리스트
          </span>
        </span>
      </a>
    </li>

    <li class="menu__item">
      <a href="ANoticeLCommand.do" class="menu__link" id ="notice">
        <span class="menu__title">
          <span class="menu__first-word" data-hover="공지">
            	공지
          </span>
          <span class="menu__second-word" data-hover="사항">
             사항
          </span>
        </span>
      </a>
    </li>
  </ul>
</nav>


</body>
</html>