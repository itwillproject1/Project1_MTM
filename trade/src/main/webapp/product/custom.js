$(document).ready(function() {
    function getDealWayFromUrl() {
        const urlParams = new URLSearchParams(window.location.search);
        return urlParams.get('deal_way');
    }

    function getCategoryFromUrl() {
        const urlParams = new URLSearchParams(window.location.search);
        return urlParams.get('category');
    }

    function updateTitle() {
        const dealWay = getDealWayFromUrl();
        const category = getCategoryFromUrl();
        let title = '상품 목록';

        if (dealWay === '삽니다') {
            title = '삽니다';
        } else if (dealWay === '팝니다') {
            title = '팝니다';
        } else {
            switch (category) {
                case '0':
                    title = '휴대폰&태블릿';
                    break;
                case '1':
                    title = '데스크탑';
                    break;
                case '2':
                    title = '노트북';
                    break;
                case '3':
                    title = '게임기기';
                    break;
                case '4':
                    title = '가전제품';
                    break;
                case '5':
                    title = '카메라';
                    break;
                case '6':
                    title = '음향기기';
                    break;
                case '7':
                    title = '기타';
                    break;
                default:
                    title = '상품 목록';
            }
        }

        $('.title').text(title);
    }

    updateTitle();
});
