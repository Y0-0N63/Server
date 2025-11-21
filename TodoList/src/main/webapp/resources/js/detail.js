// 목록으로 버튼 클릭 시 "/"로 이동 (GET 요청)
const goToList = document.querySelector("#goToList");

// 목록으로 버튼이 클릭된 경우
goToList.addEventListener("click", () => {
  // "/" 메인 페이지 요청 (GET 방식)
  location.href = "/";
});

// 할 일 상세 조회 페이지의 url 부분에서 쿼리스트링 값 얻어오기
// location.search : url 상의 쿼리스트링만 얻어오기 (ex. ?todoNo=3)
// URLSearchParams() : 쿼리스트링 객체 형태로 다룰 수 있는 JS 내장 객체
const todoNo = new URLSearchParams(location.search).get("todoNo");

// 완료 여부 변경
const completeBtn = document.querySelector("#completeBtn");
completeBtn.addEventListener("click", () => {
  // 현재 보고 있는 Todo의 완료 여부를 O(true) <-> X(false) 변경 요청 (GET)
  location.href = "/todo/complete?todoNo=" + todoNo;
});

// 삭제 버튼
const deleteBtn = document.querySelector("#deleteBtn");
deleteBtn.addEventListener("click", () => {
  // 정말 삭제할 것인지 confirm()을 이용해 확인 > confirm() : 확인 클릭 시 true, 취소 클릭 시 false

  // 취소 클릭 시
  if (!confirm("정말 삭제하시겠습니까?")) return;

  // 확인 클릭 시 > /todo/delete?todoNo=... GET 방식으로 요청 보내기
  location.href = "/todo/delete?todoNo=" + todoNo;
});

// 수정 버튼 클릭 시
const updateBtn = document.querySelector("#updateBtn");
updateBtn.addEventListener("click", ()=>{
  // 수정할 수 있는 화면으로 이동 요청(GET 요청)
  location.href = "/todo/update?todoNo=" + todoNo;
});