// 페이지가 스크롤될 때 버튼을 표시 또는 숨깁니다.
window.onscroll = function() {
  scrollFunction();
};

function scrollFunction() {
  var scrollToTopBtn = document.getElementById("scrollToTopBtn");

  if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
    scrollToTopBtn.style.display = "block";
  } else {
    scrollToTopBtn.style.display = "none";
  }
}

// 맨 위로 스크롤하는 함수
function scrollToTop() {
 window.scrollTo({
    top: 0,
    behavior: 'smooth' // 부드러운 스크롤을 위해 추가한 옵션
  });
}