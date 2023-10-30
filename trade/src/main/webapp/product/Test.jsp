<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Test</title>
</head>
<body>
	<h1>Test.jsp</h1>
	
	<input type="button" value="상품이미지" id="btnImage">
	첨부파일: <input type="file" name="file" multiple> <br>

	<select id="dealWay">
		<option>원하는 거래를 선택하세요</option>
		<option value="sell">삽니다</option>
		<option value="buy">팝니다</option>
	</select>

	<select id="condition">
		<option>상품 상태를 선택하세요</option>
		<option value="1">미개봉</option>
		<option value="2">상</option>
		<option value="3">중</option>
		<option value="4">하</option>
	</select>

	<script>
		// 첫 번째 select 요소를 선택
		const firstSelect = document.getElementById('dealWay');

		// 두 번째 select 요소를 선택
		const secondSelect = document.getElementById('condition');

		// 첫 번째 select 요소의 변경 이벤트를 감지
		firstSelect.addEventListener('change', function() {
			// 첫 번째 select 요소의 선택된 옵션 값을 가져옴
			const selectedValue = dealWay.value;

			// 두 번째 select 요소를 비활성화 또는 활성화
			if (selectedValue === 'sell') {
				condition.disabled = true; // 비활성화
				condition.selectedIndex = 0;
			} else {
				condition.disabled = false; // 활성화
			}
		});
	</script>
	
    <select id="select1">
        <option value="option1">Option 1</option>
        <option value="option2">Option 2</option>
        <option value="option3">Option 3</option>
    </select>

    <select id="select2">
        <!-- This select box will be populated dynamically based on the selection in the first box. -->
    </select>

    <script>
        // Get references to the two select boxes
        const select1 = document.getElementById('select1');
        const select2 = document.getElementById('select2');

        // Define the options for the second select box
        const optionsForOption1 = ['Suboption 1.1', 'Suboption 1.2', 'Suboption 1.3'];
        const optionsForOption2 = ['Suboption 2.1', 'Suboption 2.2', 'Suboption 2.3'];
        const optionsForOption3 = ['Suboption 3.1', 'Suboption 3.2', 'Suboption 3.3'];

        // Function to populate the second select box based on the selection in the first box
        function populateSelect2() {
            const selectedOption = select1.value;
            select2.innerHTML = ''; // Clear the second select box

            // Add options based on the selected option in the first box
            let optionsToUse = [];
            if (selectedOption === 'option1') {
                optionsToUse = optionsForOption1;
            } else if (selectedOption === 'option2') {
                optionsToUse = optionsForOption2;
            } else if (selectedOption === 'option3') {
                optionsToUse = optionsForOption3;
            }

            for (const option of optionsToUse) {
                const optionElement = document.createElement('option');
                optionElement.value = option;
                optionElement.textContent = option;
                select2.appendChild(optionElement);
            }
        }

        // Populate the second select box when the page loads
        populateSelect2();

        // Add an event listener to the first select box to update the second select box when its value changes
        select1.addEventListener('change', populateSelect2);
    </script>

</body>
</html>