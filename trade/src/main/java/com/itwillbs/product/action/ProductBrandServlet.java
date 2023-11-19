package com.itwillbs.product.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

@WebServlet("/product/ProductBrandServlet")
public class ProductBrandServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            String category = request.getParameter("category");
            
            // 여기에서 category에 따라 DB 등에서 소분류(brand) 목록을 가져오는 로직을 작성
            List<String> brandList = getProductBrandListFromDB(category);

            // 소분류(brand) 목록을 클라이언트로 전송
            out.print("<ul>");
            for (String brand : brandList) {
                out.print("<li><a href='#'>" + brand + "</a></li>");
            }
            out.print("</ul>");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            out.close();
        }
    }

    // 실제로는 DB에서 소분류(brand) 목록을 가져오는 메서드
    private List<String> getProductBrandListFromDB(String category) {
        // 여기에 DB에서 소분류(brand) 목록을 가져오는 로직을 작성
        // 예를 들어, ProductDAO.getProductBrandList(category) 등을 호출하여 목록을 가져오면 됨
        List<String> brandList = new ArrayList<>();
        // 여기에서 실제로 DB에서 데이터를 가져오는 로직이 들어가야 합니다.
        // brandList에는 대분류(category)에 해당하는 소분류(brand) 목록이 들어가야 합니다.
        brandList.add("삼성");
        brandList.add("엘지");
        brandList.add("애플");
        brandList.add("HP");
        brandList.add("레노버");
        brandList.add("플레이스테이션");
        brandList.add("닌텐도");
        brandList.add("캐논");
        brandList.add("니콘");
        brandList.add("소니");
        brandList.add("라이카");
        brandList.add("코닥");
        brandList.add("보스");
        brandList.add("마샬");
        brandList.add("기타");
        return brandList;
    }
}
