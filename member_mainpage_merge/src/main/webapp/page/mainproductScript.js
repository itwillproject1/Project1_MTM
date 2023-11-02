document.addEventListener('DOMContentLoaded', function () {
  const slider1 = document.querySelector('.slider1');
  let counter = 1;

  function showSlide(index) {
    slider1.style.transform = `translateX(${-index * 100}%)`;
  }

  function nextSlide() {
    counter++;
    if (counter === slider1.children.length - 3) {
      counter = 1;
      showSlide(counter);
    } else {
      showSlide(counter);
    }
  }

  function prevSlide() {
    counter--;
    if (counter === 0) {
      counter = slider1.children.length - 4;
      showSlide(counter);
    } else {
      showSlide(counter);
    }
  }

  document.querySelector('.next-btn').addEventListener('click', nextSlide);
  document.querySelector('.prev-btn').addEventListener('click', prevSlide);

  // 초기 슬라이드 표시
  showSlide(counter);
});
