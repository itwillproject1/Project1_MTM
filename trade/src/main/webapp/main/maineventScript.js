document.addEventListener('DOMContentLoaded', function () {
  const slider = document.querySelector('.slider');
  let counter = 1;

  setInterval(() => {
    slider.style.transform = `translateX(${-counter * 100}%)`;
    counter++;

    if (counter === slider.children.length) {
      counter = 0;
    }
  }, 3000); // 이미지 전환 간격 (3초)
  
});