# JHS-NumberBaseball-with-REST

# 개발환경

스프링부트 2.7.3
postgreSQL
java17
mybatis -> mapper.xml 이용


# 개발표준
회사 내규에 따름

R 8080포트

# 구조

회원가입 
로그인
로비
게임창
===========
게임창 입장시
웹소켓(소켓) 연결
정답 입력
매칭
정답 유츄
r에게 요청, rest
처리(값 처리, 타겟 매핑)
s에게 요청 전달, 클라이언트에게 응답 리턴
s가 타겟에게 전달
각 클라이언트에서 표현

====================================================
# json 구조
회원가입, 로그인 - 우선순위 낮음 일단 제외
type, username, socketid, usernumber
Socket Register : username, socketid
Number Register : username, usernumber
Number Guess : username, target, inputnumber
Result : username, inputnumber, result(c에게 전달시 target 포함)
Chat : username, target, chat
Challenge : username, target

==================================================
# 기능
로그인, 회원가입 -> 스프링 시큐리티
로비 -> 게임 시작 버튼, 접속자 명단, 본인 정보 (javascript, ajax, userRestAPI)
게임창 -> 본인 정보, 상대방 정보, 채팅창, 게임창, 채팅입력, 게임입력 (javascript, userRestAPI)
결과 도출 -> Rest API Java
채팅 전달 -> Socket, WebSocket

====================================================
# 클라이언트 종류
자바
파이썬
안드로이드
웹

====================================================
0. Security
1. Rest
2. Socket
3. Client
