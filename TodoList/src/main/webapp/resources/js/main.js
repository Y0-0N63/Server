// 제목이 작성되지 않은 경우 form 제출 막기
const addForm = document.querySelector("#addForm");
const title = document.querySelector("[name = 'title']");

// addForm이 제출될 때
addForm.addEventListener("submit", (e) => {
  // 제목이 입력된 값을 가져와 > 양쪽 공백 제거
  const input = title.value.trim();

  // 제목이 입력되지 않았을 때
  if(input.length == 0) {
    // form 태그의 제출 이벤트 막아주기
    e.preventDefault();
    alert("제목을 입력해주세요.");
    title.focus();
  }
});