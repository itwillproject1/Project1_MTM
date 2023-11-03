package com.itwillbs.product.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

@WebServlet("*.com")
@MultipartConfig(
      fileSizeThreshold=0)
public class ProductFrontController extends HttpServlet{

   protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      System.out.println("C: ProductFrontController.doProcess()");
      
      /************************1. 가상주소 계산 시작************************/
      System.out.println("\n---------------1. 가상주소 계산 시작---------------");
      String requestURI = request.getRequestURI(); // 가상주소
      System.out.println("\tC: requestURI: " + requestURI);
      
      String CTXPath = request.getContextPath(); // 프로젝트 이름
      System.out.println("\tC: CTXPath: " + CTXPath);
      
      String command = requestURI.substring(CTXPath.length());
      System.out.println("\tC: command: " + command);
      System.out.println("---------------1. 가상주소 계산 종료---------------");
      /************************1. 가상주소 계산 종료************************/
      
      
      /************************2. 가상주소 매핑 시작************************/
      System.out.println("\n---------------2. 가상주소 매핑 시작---------------");
      ActionForward forward = new ActionForward();
      Action action = null;
      
      if(command.equals("/main/Main.com")) {
         System.out.println("\tC: /Main.com 호출");
         System.out.println("\tC: 패턴3 - DB 사용 O, 뷰페이지 출력");
         
//         action = new ActionForward();
//
//         forward.setPath("./realmain.jsp");
//         forward.setRedirect(false);
     
         // ProductPopListAction() 객체 생성
         action = new ProductPopListAction();
         
         try {
            forward = action.execute(request, response);
         } catch (Exception e) {
            e.printStackTrace();
         }
         
      }
      else if(command.equals("/product/ProductUpload.com")) {
         System.out.println("\tC: /ProductUpload.com 호출");
         System.out.println("\tC: 패턴1 - DB 사용 X, 뷰페이지 출력");
         
         forward = new ActionForward();
         forward.setPath("./productUpload.jsp");
         forward.setRedirect(false);
      }
      else if(command.equals("/product/ProductUploadAction.com")) {
         System.out.println("\tC: /ProductUploadAction.com 호출");
         System.out.println("\tC: 패턴2 - DB 사용 O, 페이지 이동");
         
         action = new ProductUploadAction();
         
         try {
            forward = action.execute(request, response);
         } catch (Exception e) {
            e.printStackTrace();
         }
      }
      else if(command.equals("/product/ProductContent.com")) {
         System.out.println("\tC: /product/ProductContent.com 호출");
         System.out.println("\tC: 패턴3 - DB 사용 O, 뷰페이지 출력");
         
         // BoardContentAction() 객체 생성
         action = new ProductContentAction();
         
         try {
            forward = action.execute(request, response);
         } catch (Exception e) {
            e.printStackTrace();
         }
      }
      else if(command.equals("/product/ProductList.com")) {
         System.out.println(" C : /product/ProductList.com 호출 ");
         System.out.println(" C : 패턴 3 - DB사용O, 페이지 출력");
         
         //  ProductListAction() 객체 생성
         action = new ProductListAction();
         
         try {
            forward = action.execute(request, response);
         } catch (Exception e) {
            e.printStackTrace();
         }
      }
      else if(command.equals("/main/Main.com")) {
         System.out.println(" C : /main/Main.com 호출 ");
         System.out.println(" C : 패턴 1 - DB사용O, 페이지 출력");
         
         //  ProductPopularListAction() 객체 생성
         action = new ProductPopListAction();
         
         try {
            forward = action.execute(request, response);
         } catch (Exception e) {
            e.printStackTrace();
         }
      }
      
      
      System.out.println("---------------2. 가상주소 매핑 종료---------------");
      /************************2. 가상주소 매핑 종료************************/
      
      /************************3. 가상주소 이동 시작************************/
      System.out.println("\n---------------3. 가상주소 이동 시작---------------");
      if(forward != null) {
         if(forward.isRedirect()) {
            // true
            System.out.println("\tC: 이동주소: " + forward.getPath());
            System.out.println("\tC: 이동방법: sendRedirect() 방식");
            response.sendRedirect(forward.getPath());
         } else {
            // false
            System.out.println("\tC: 이동주소: " + forward.getPath());
            System.out.println("\tC: 이동방법: forward() 방식");
            RequestDispatcher dis = request.getRequestDispatcher(forward.getPath());
            dis.forward(request, response);
         }
      }
      System.out.println("---------------3. 가상주소 이동 종료---------------");
      /************************3. 가상주소 이동 종료************************/
      
   }
   
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      System.out.println("C: ProductFrontController.doGet()");
      doProcess(request, response);
   }

   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      System.out.println("C: ProductFrontController.doPost()");
      doProcess(request, response);
   }
   
}
