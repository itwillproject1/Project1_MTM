document.addEventListener('DOMContentLoaded', function () {
  var scrollToTopBtn = document.getElementById('scrollToTopBtn');

  // Show or hide the button based on scroll position
  window.addEventListener('scroll', function () {
    if (window.scrollY > 300) {
      scrollToTopBtn.style.display = 'block';
    } else {
      scrollToTopBtn.style.display = 'none';
    }
  });

  // Scroll to the top when the button is clicked
  scrollToTopBtn.addEventListener('click', function () {
    window.scrollTo({
      top: 0,
      behavior: 'smooth'
    });
  });
});