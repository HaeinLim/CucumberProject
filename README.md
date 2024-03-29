# 오이나라
회원 간 거래글 조회 및 거래가 가능한 중고 거래 웹 사이트입니다. 

## 목차
  - [개요](#개요)
  - [프로그램 설명](#프로그램-설명)
  - [프로그램 화면](#프로그램-화면)
## 개요
  - 프로젝트명 : 오이나라
  - 프로젝트 진행기간 : 2023.07.18-2023.08.02
  - 사용 기술 : Spring Framework, JSP, JAVA, AJAX, JQuery, HTML, CSS, JavaScript, Oracle SQL, MyBatis
  - 팀 구성원 : 최민진(팀장), 이경민, 이지환, 임해인, 장민석

## 프로그램 설명
<div align="center">
  <table>
    <tr>
      <td>
        <img src="https://github.com/HaeinLim/CucumberProject/assets/140698817/f8d4e45c-ea5f-4f95-9782-bfc32a828f96" width="600" height="400">
      </td>
    </tr>
    <tr>
      <td align="center">로그인 전 메인 페이지</td>
    </tr>
  </table>
</div>
공유 경제의 인기에 따라 중고 거래에 대한 인식이 개선되어 중고 거래가 활성화됨에 따라 중고 거래 웹 사이트를 개발하게 되었습니다.

  - 회원가입만 한다면 할 수 있다! 중고 거래 🛍️ <br>
    비회원은 메인 페이지에서 거래글을 단순 조회, 카테고리 조회, 검색 조회를할 수 있으나 거래글을 둘러볼 수 없습니다. 거래글을 둘러보기 위해선 회원가입을 진행해야하며
    이메일, 이메일 인증, 비밀번호, 비밀번호 확인, 아이디(중복체크 필수), 전화번호, 전화번호 인증을 진행하면 회원가입이 진행됩니다. 로그인을 하면 거래글 둘러보기가
    가능해집니다. <br>
    cf) 인증 소스의 경우 개인 키가 포함되기 때문에 이 부분은 소스에 포함되어있지 않습니다.

  - 거래글 둘러보기 😄<br>
    메인 페이지 거래글의 둘러보기 버튼을 클릭해 거래글의 상세 페이지로 이동할 수 있습니다. 상세 페이지에서 판매자의 닉네임을 클릭하면 판매자의 회원 페이지를
    볼 수 있습니다. 판매자의 닉네임 옆 채팅 아이콘을 클릭하면 판매자와 1:1 채팅을 진행할 수 있습니다. 판매자의 아이디와 로그인한 세션 아이디가 다르다면
    게시글을 신고하는 버튼이, 동일하다면 거래글을 수정할 수 있는 수정 버튼이 출력됩니다. 빈 하트를 클릭하면 하트가 채워지며 찜 카운트가 1 증가합니다. 조회수는
    회원이 로그인 할 때 쿠키가 생성되고, 거래글의 상세 페이지로 이동할 때 조회수를 1 증가시켜줍니다. 이 때 중복 증가를 방지하기 위해 이미 쿠키가 존재한다면
    조회수가 증가하지 않도록 구현하였습니다. 문의가 있다면 하단의 문의 입력란에 작성 후 입력하면 판매자가 확인 후 답변을 달 수 있습니다. 문의와 답변에 있는
    느낌표 아이콘을 클릭하면 해당 문의나 답변을 신고할 수 있습니다.

  - 나를 위한 페이지, 마이 페이지 📃 <br>
    우측 상단의 사람 모양 아이콘을 클릭하면 마이 페이지로 이동할 수 있습니다. 마이 페이지에선 내 정보를 수정할 수 있고, 내가 찜한 거래글 목록, 작성한 거래글 목록,
    내 구매 내역, 리뷰, 진행 중인 채팅 내역을 확인할 수 있습니다. 포인트는 다른 회원이 내가 판매한 물품을 구매한 후 나에 대한 리뷰를 작성했을 때 준 포인트가 
    합산되어 나타납니다. 리뷰는 내 구매 내역에서 작성할 수 있습니다.

  - 다른 회원의 정보를 보려면, 회원 페이지 📃 <br>
    다른 회원의 닉네임을 클릭하면 해당 회원의 페이지로 이동할 수 있습니다. 이 페이지에서는 해당 회원의 포인트와 작성한 거래글, 회원이 받은 리뷰를 조회할 수 있습니다.

  - 관리자 페이지 📃 <br>
    관리자 계정으로 로그인하면 우측 상단에 관리자페이지로 이동할 수 있는 링크가 생깁니다. 관리자페이지에선 관리자의 정보를 수정할 수 있고, 회원 관리, 게시물 관리,
    문의글 관리, 채팅 관리, 리뷰 관리를 진행할 수 있습니다. 회원 외의 관리는 모두 신고된 내용을 관리하며 신고된 글을 삭제하거나 신고 내역을 삭제할 수 있습니다.

## 프로그램 화면

  - 회원가입, 이메일 및 비밀번호 찾기

<div align="center">
  <table align="center">
    <tr>
      <th>회원가입</th><th>이메일 찾기</th><th>비밀번호 찾기</th>
    </tr>
    <tr>
      <td>
        <img src="https://github.com/HaeinLim/CucumberProject/assets/140698817/dafb0418-b771-40ce-a84c-251b47c7dc3c" width="400" height="200">
      </td>
      <td>
        <img src="https://github.com/HaeinLim/CucumberProject/assets/140698817/12326b59-25fe-400f-beda-baec7428f9a3" width="400" height="200">
      </td>
      <td>
        <img src="https://github.com/HaeinLim/CucumberProject/assets/140698817/9b078dc3-b3d4-4a22-91b7-1808c143dc7d" width="400" height="200">
      </td>
    </tr>
    <tr>
      <td>
        - 비회원일 경우 회원가입 진행<br>
        - 모든 항목 필수 기입<br>
        - 중복 확인, 인증 등 조건 만족시<br>
          빨간 글씨 > 초록 글씨로 변경
      </td>
      <td>
        - 회원가입 때 입력한 전화번호로<br>
          인증받아 이메일 찾기 가능
      </td>
      <td>
        - 회원가입 때 입력한 이메일로<br>
          새로운 비밀번호 전송
      </td>
    </tr>
  </table>
</div>

  - 메인 및 상세 페이지

<div align="center">
  <table align="center">
      <tr>
        <th>회원 로그인 메인 페이지</th><th>상세 페이지 상단</th><th>상세페이지 하단</th>
      </tr>
      <tr>
        <td>
          <img src="https://github.com/HaeinLim/CucumberProject/assets/140698817/0f368630-4f58-4dd4-8514-b104da8bb840" width="400" height="200">
        </td>
        <td>
          <img src="https://github.com/HaeinLim/CucumberProject/assets/140698817/72403b04-df53-42b6-82f7-a8160556fd0c" width="400" height="200">
        </td>
        <td>
          <img src="https://github.com/HaeinLim/CucumberProject/assets/140698817/b608cbf5-a4f0-44c1-b831-1f1570e2605e" width="400" height="200">
        </td>
      </tr>
      <tr>
        <td>
          - 우측 상단에 마이페이지 이동 아이콘과 로그아웃 아이콘 생성 <br>
          - + 버튼을 클릭하여 거래글 작성 가능 <br>
          - 다양한 방법으로 거래글 조회 가능 및 둘러보기 가능
        </td>
        <td>
          - 판매자 닉네임을 클릭해 판매자의 회원 페이지 조회 가능 <br>
          - 채팅 아이콘을 클릭해 판매자와 1:1 채팅 가능 <br>
          - 거래물 신고 가능(판매자 본인일 경우 수정 버튼)
        </td>
        <td>
          - 거래글 찜 가능 <br>
          - 문의 작성 및 답변 가능 <br>
          - 문의 및 답변 신고 가능
        </td>
      </tr>
  </table>
</div>

  - 마이 페이지, 회원 페이지, 관리자 페이지

<div align="center">
  <table align="center">
      <tr>
        <th>마이 페이지</th><th>회원 페이지</th><th>관리자 페이지</th>
      </tr>
      <tr>
        <td>
          <img src="https://github.com/HaeinLim/CucumberProject/assets/140698817/079c8eb1-b8b6-41c5-a1ac-51107f4e12de" width="400" height="200">
        </td>
        <td>
          <img src="https://github.com/HaeinLim/CucumberProject/assets/140698817/4e930f95-bb3f-4cf5-995c-335280c944a7" width="400" height="200">
        </td>
        <td>
          <img src="https://github.com/HaeinLim/CucumberProject/assets/140698817/c2e965ed-d330-4ea7-bfe8-0d09e9726019" width="400" height="200">
        </td>
      </tr>
      <tr>
        <td>
          - 내 정보 수정 가능 <br>
          - 찜 목록, 게시물 목록, 구매 내역, 리뷰, 채팅 내역 확인 가능 <br>
          - 내 포인트 조회 가능
        </td>
        <td>
          - 다른 회원의 게시물 목록, 받은 리뷰 확인 가능 <br>
          - 회원의 포인트 조회 가능
        </td>
        <td>
          - 관리자 정보 수정 가능 <br>
          - 회원 관리, 회원 관리, 게시물 관리, 문의글 관리, <br>
            채팅 관리, 리뷰 관리 가능
        </td>
      </tr>
  </table>
</div>

  - 채팅

<div>
  <table>
    <tr>
      <th align="center">채팅</th>
    </tr>
    <tr>
      <td align="center">
        <img src="https://github.com/HaeinLim/CucumberProject/assets/140698817/13f7f8bd-cc37-467a-b701-66c64ec55499" width="600" height="400">
    </tr>
    <tr>
      <td>
        - 판매자와 1:1 채팅 가능 <br>
        - 판매자는 채팅창에서 '거래중', '거래완료' 상태로 변경 가능 <br>
        - 채팅 신고 가능
      </td>
    </tr>
  </table>
</div>
