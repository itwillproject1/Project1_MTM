document.addEventListener("DOMContentLoaded", function () {
    var categoryLinksA = document.getElementById('category-aa').getElementsByTagName('a');
    var categoryLinksB = document.getElementById('category-bb').getElementsByTagName('a');
    var productListTitle = document.getElementById('product-list-title');

    function updateProductListTitle(categoryName) {
        productListTitle.innerText = categoryName;
        // localStorage에 선택된 카테고리 저장
        localStorage.setItem('selectedCategory', categoryName);
    }

    function addCategoryLinkListeners(categoryLinks) {
        for (var i = 0; i < categoryLinks.length; i++) {
            categoryLinks[i].addEventListener('click', function (event) {
                event.preventDefault();
                var categoryName = this.innerText;
                updateProductListTitle(categoryName);
            });
        }
    }

    // 페이지 로드 시 localStorage에 저장된 카테고리 불러오기
    var storedCategory = localStorage.getItem('selectedCategory');
    if (storedCategory) {
        updateProductListTitle(storedCategory);
    }

    // 카테고리 A에 이벤트 리스너 추가
    addCategoryLinkListeners(categoryLinksA);

    // 카테고리 B에 이벤트 리스너 추가
    addCategoryLinkListeners(categoryLinksB);
});
