package com.itwillbs.product.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.product.db.ProductDAO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

public class ProductListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	//	System.out.println(" M : ProductListAction_execute() 실행 ");

		// 전달정보 검색어 정보 저장
		String category = request.getParameter("category");
		String[] catInfo = { "휴대폰&태블릿", "데스크탑", "노트북", "게임기기", "가전제품", "카메라", "음향기기", "기타" };
		if (category == null || category.equals("선택"))
			category = null;
		else {
			int i = Integer.parseInt(category);
			category = catInfo[i];
		}
		String brand = request.getParameter("brand");
		if(brand == null || brand.isEmpty()) brand = null;
		String deal_way = request.getParameter("deal_way");
		if(deal_way == null || deal_way.isEmpty()) deal_way = null;
		String search = request.getParameter("search");
		String selectedCategory = request.getParameter("category");

		System.out.println(" M : 전체검색어 : " + search);

		// 기존에 저장된 글정보를 가져와서 화면에 출력;
		ProductDAO dao = new ProductDAO();
		int count = 0;

		count = dao.getProductCount(category, brand, deal_way, search);
		
		/********************* 페이징처리 1 *******************/
		// 한 페이지에 출력할 글의 개수 설정
		int pageSize = 8;

		// 현 페이지가 몇페이지 인지확인
		String pageNum = request.getParameter("pageNum");
		if (pageNum == null) {
			pageNum = "1";
		}

		// 시작행 번호 계산하기
		// 1 11 21 31 41 .....
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage - 1) * pageSize + 1;

		// 끝행 번호 계산
		// 10 20 30 40 50 .....
		int endRow = currentPage * pageSize;
		

		/********************* 페이징처리 1 *******************/
		
		ArrayList<String> brandList = new ArrayList<>();

		// 여기에서 원하는 브랜드를 하드코딩하여 추가
		if ("0".equals(selectedCategory)) {
		    brandList.add("삼성");
		    brandList.add("애플");
		    brandList.add("엘지");
		    brandList.add("기타");

		} else if ("1".equals(selectedCategory)) {
		    brandList.add("삼성");
		    brandList.add("엘지");
		    brandList.add("애플");
		    brandList.add("hp");
		    brandList.add("기타");
		    
		} else if ("2".equals(selectedCategory)) {
		    brandList.add("삼성");
		    brandList.add("엘지");
		    brandList.add("애플");
		    brandList.add("hp");
		    brandList.add("레노버");
		    brandList.add("기타");
		    
		} else if ("3".equals(selectedCategory)) {
		    brandList.add("플레이스테이션");
		    brandList.add("닌텐도");
		    brandList.add("기타");
		    
		} else if ("4".equals(selectedCategory)) {
		    brandList.add("삼성");
		    brandList.add("엘지");
		    brandList.add("기타");
		    
		} else if ("5".equals(selectedCategory)) {
		    brandList.add("캐논");
		    brandList.add("니콘");
		    brandList.add("소니");
		    brandList.add("라이카");
		    brandList.add("코닥");
		    brandList.add("기타");
		    
		} else if ("6".equals(selectedCategory)) {
		    brandList.add("소니");
		    brandList.add("보스");
		    brandList.add("마샬");
		    brandList.add("기타");
		
		}
		
		request.setAttribute("brandList", brandList);
		System.out.println(" M : size :" + brandList.size());
		
		ArrayList<String> dealWayList = new ArrayList<>();

		// 여기에서 원하는 딜 웨이를 하드코딩하여 추가
		if ("0".equals(selectedCategory)) {
		    // 딜 웨이 목록 추가
		    dealWayList.add("삽니다");
		    dealWayList.add("팝니다");

		} else if ("1".equals(selectedCategory)) {
		    // 딜 웨이 목록 추가
		    dealWayList.add("삽니다");
		    dealWayList.add("팝니다");


		} else if ("2".equals(selectedCategory)) {
		    // 딜 웨이 목록 추가
		    dealWayList.add("삽니다");
		    dealWayList.add("팝니다");


		} else if ("3".equals(selectedCategory)) {
		    // 딜 웨이 목록 추가
		    dealWayList.add("삽니다");
		    dealWayList.add("팝니다");


		} else if ("4".equals(selectedCategory)) {
		    // 딜 웨이 목록 추가
		    dealWayList.add("삽니다");
		    dealWayList.add("팝니다");


		} else if ("5".equals(selectedCategory)) {
		    // 딜 웨이 목록 추가
		    dealWayList.add("삽니다");
		    dealWayList.add("팝니다");


		} else if ("6".equals(selectedCategory)) {
		    // 딜 웨이 목록 추가
		    dealWayList.add("삽니다");
		    dealWayList.add("팝니다");

		}  else if ("7".equals(selectedCategory)) {
		    // 딜 웨이 목록 추가
		    dealWayList.add("삽니다");
		    dealWayList.add("팝니다");
		    
		}


		request.setAttribute("dealWayList", dealWayList);
		System.out.println(" M : size :" + dealWayList.size());

		// DAO - 글정보 모두(list)를 가져오는 메서드 호출
		ArrayList ProductList = new ArrayList();
		
		try {
		    if (count > 0) {
		        // 공통된 메서드 호출 부분
		        ProductList = dao.getProductList(startRow, pageSize, category, brand, deal_way, search);
		        
		        System.out.println("");

		        // 리스트를 출력 => 연결된 뷰페이지에서 출력하도록 정보 전달
		        request.setAttribute("ProductList", ProductList);
		    }

		    System.out.println(" M : size :" + ProductList.size());

		} catch (Exception e) {
		    e.printStackTrace();
		}
		

		/******************* 페이징처리 2 *********************/
		// 전체 페이지수
		int pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);

		// 한 화면에 보여줄 페이지 블럭개수
		int pageBlock = 5;

		// 페이지 블럭의 시작번호 계산
		int startPage = ((currentPage - 1) / pageBlock) * pageBlock + 1;

		// 페이지 블럭의 마지막번호 계산
		int endPage = startPage + pageBlock - 1;
		// 페이지의 글이 없는경우
		if (endPage > pageCount) {
			endPage = pageCount;
		}

		/******************* 페이징처리 2 *********************/

		// 페이징 처리에 필요한 정보 모두를 request영역에 저장해서 전달
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("count", count);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("pageBlock", pageBlock);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		
		// 페이지 이동준비 
		ActionForward forward = new ActionForward();
		forward.setPath("./productList.jsp");
		forward.setRedirect(false);

		return forward;
	}

}
