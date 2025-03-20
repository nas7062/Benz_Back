# 🚗 Mercedes-Benz 웹 애플리케이션

![mainpage_720](https://github.com/user-attachments/assets/8c44f7d2-4b15-446f-bf9f-635b183a33d6)
***
## 1.Project Overview(프로젝트 개요)
#### [UREAC] Mini Project 1 (4조) 김민석,김현우
+ Mercedes-Benz 플랫폼 구현을 통한 웹 아키텍처 이해 및 실습.
+ 사용자 경험을 중요시하며 사용자가 직관적으로 이해하고 편리하게 사용할 수 있도록 설계.
***

## 2.Team Members (팀원 소개)
<table>
  <tbody>
    <tr>
      <td align="center"><a href=""><img src="https://avatars.githubusercontent.com/u/84384915?v=4"width="100px;" alt=""/><br /><sub><b>FE : 김민석</b></sub></a><br /></td>
      <td align="center"><a href=""><img src="https://avatars.githubusercontent.com/u/100756731?v=4" width="100px;" alt=""/><br /><sub><b>FE : 김현우</b></sub></a><br /></td>
    </tr>
  </tbody>
</table>

## 3. Key Features(주요 기능)
+ 회원가입
  +  FrontEnd와 BackEnd에서 모두 유효성 검사 (백엔드로 넘어오는 도중 변질 혹은 조작될 가능성 배제시키기 위함.)
  +  회원가입시 MySql DB에 유저 정보가 저장됨 (비밀번호는 암호화 하여 저장됨)
  +  FrontEnd에서 유효성 검사를 통해 Message를 출력해 사용자 경험(UX) 개선
+ 로그인
  + FrontEnd와 BackEnd에서 모두 유효성 검사 (백엔드로 넘어오는 도중 변질 혹은 조작될 가능성 배제시키기 위함.)
  + FrontEnd에서 Email 입력을 먼저 입력받아 확인한 후, 비밀번호를 입력하도록 설계.
    + 무작위 계정 로그인 시도를 차단.
    + Brute Force 공격 완화
    + 잘못된 이메일 차단 (불필요한 로그인 시도를 줄이고, 사용자 경험(UX)도 개선)
  + FrontEnd에서 유효성 검사를 통해 Message를 출력해 사용자 경험(UX) 개선
  + 토큰 및 세션 관리 (JWT)
    + 로그인 시 사용자에게 토큰 발급.
    + 사용자가 특정 행동(ex) 위시리스트 추가 및 삭제)을 하면 해당 유저의 로그인 시간을 현재 시간으로 갱신.
    + 일정 시간이 지나도록 요청이 없으면 자동 로그아웃 처리.
+ 메인 모델 선택
    + 사용자가 특정 이미지를 보면 회전하는 애니메이션 효과 적용.
    + 이미지를 클릭하면 모델 페이지에서 해당 모델에 맞는 카테고리가 자동 선택되어 표시되도록 적용.
+ 위시리스트
  + 로그인한 사용자만 위시리스트 기능 사용 가능.
  + 로그인 한 사용자의 위시리스트를 불러와서 표시.
  + 위시리스트에 모델 추가 및 삭제 기능 지원.
## 4. 기술 스택
### FrontEnd : <img src="https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=HTML5&logoColor=black"> <img src="https://img.shields.io/badge/Css-1572B6?style=for-the-badge&logo=Css&logoColor=white"><img src="https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=JavaScript&logoColor=black"> <img src="https://img.shields.io/badge/React-61DAFB?style=for-the-badge&logo=React&logoColor=black">
### BackEnd : <img src="https://img.shields.io/badge/SpringBoot-6DB33F?style=for-the-badge&logo=SpringBoot&logoColor=white"> 
### DataBase : <img src="https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=MySQL&logoColor=white">
### Cooperation :  <img src="https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=Git&logoColor=white">  <img src="https://img.shields.io/badge/Slack-4A154B?style=for-the-badge&logo=Slack&logoColor=white">  <img src="https://img.shields.io/badge/Notion-000000?style=for-the-badge&logo=Notion&logoColor=white">

## 5. 폴더 구조
```
📦src
 ┣ 📂assets
 ┃ ┗ 📜car-icon.png
 ┣ 📂component
 ┃ ┣ 📂Footer
 ┃ ┃ ┣ 📜Foot.css
 ┃ ┃ ┗ 📜Foot.jsx
 ┃ ┣ 📂Models
 ┃ ┃ ┣ 📜HoverRotateImg.jsx
 ┃ ┃ ┣ 📜ModelCard.jsx
 ┃ ┃ ┣ 📜ModelCardItem.css
 ┃ ┃ ┗ 📜ModelCardItem.jsx
 ┃ ┣ 📂Navigation
 ┃ ┃ ┣ 📜Navigation.jsx
 ┃ ┃ ┗ 📜Navigation.module.css
 ┃ ┣ 📂Productlists
 ┃ ┃ ┣ 📜ProductFilter.jsx
 ┃ ┃ ┣ 📜ProductFilter.module.css
 ┃ ┃ ┣ 📜Productlist.jsx
 ┃ ┃ ┗ 📜Productlist.module.css
 ┃ ┗ 📂Wishlist
 ┃ ┃ ┣ 📜Wishlist.jsx
 ┃ ┃ ┗ 📜Wishlist.module.css
 ┣ 📂pages
 ┃ ┣ 📂Detail
 ┃ ┃ ┣ 📜ProductDetail.jsx
 ┃ ┃ ┗ 📜ProductDetail.module.css
 ┃ ┣ 📂Login
 ┃ ┃ ┣ 📜Login.jsx
 ┃ ┃ ┗ 📜Login.module.css
 ┃ ┣ 📂Main
 ┃ ┃ ┣ 📜Main.jsx
 ┃ ┃ ┗ 📜Main.module.css
 ┃ ┣ 📂Products
 ┃ ┃ ┣ 📜Product.jsx
 ┃ ┃ ┗ 📜Product.module.css
 ┃ ┣ 📂Signup
 ┃ ┃ ┣ 📜Signup.jsx
 ┃ ┃ ┗ 📜SignUp.module.css
 ┃ ┗ 📂Wish
 ┃ ┃ ┣ 📜Wish.jsx
 ┃ ┃ ┗ 📜Wish.module.css
 ┣ 📜App.css
 ┣ 📜App.js
 ┣ 📜App.test.js
 ┣ 📜index.css
 ┣ 📜index.js
 ┣ 📜logo.svg
 ┣ 📜reportWebVitals.js
 ┣ 📜Routing.js
 ┗ 📜setupTests.js
```

```
📦main
 ┣ 📂java
 ┃ ┗ 📂com
 ┃ ┃ ┗ 📂shop
 ┃ ┃ ┃ ┗ 📂car
 ┃ ┃ ┃ ┃ ┣ 📂controller
 ┃ ┃ ┃ ┃ ┃ ┣ 📜ModelController.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜ProductController.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜UserController.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📜WishlistController.java
 ┃ ┃ ┃ ┃ ┣ 📂dao
 ┃ ┃ ┃ ┃ ┃ ┣ 📜LoginDao.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜ModelDao.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜ProductDao.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜UserDao.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📜WishlistDao.java
 ┃ ┃ ┃ ┃ ┣ 📂dto
 ┃ ┃ ┃ ┃ ┃ ┣ 📜Login.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜Model.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜Product.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜User.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📜Wishlist.java
 ┃ ┃ ┃ ┃ ┣ 📂service
 ┃ ┃ ┃ ┃ ┃ ┣ 📜ModelService.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜ProductService.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜UserService.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📜WishlistService.java
 ┃ ┃ ┃ ┃ ┣ 📂util
 ┃ ┃ ┃ ┃ ┃ ┣ 📜JwtTokenProvider.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📜OpenCrypt.java
 ┃ ┃ ┃ ┃ ┗ 📜BenzApplication.java
 ┗ 📂resources
 ┃ ┣ 📂config
 ┃ ┃ ┗ 📜secu.properties
 ┃ ┣ 📂mapper
 ┃ ┃ ┣ 📜login.xml
 ┃ ┃ ┣ 📜model.xml
 ┃ ┃ ┣ 📜product.xml
 ┃ ┃ ┣ 📜user.xml
 ┃ ┃ ┗ 📜wishlist.xml
 ┃ ┗ 📜application.properties
```
