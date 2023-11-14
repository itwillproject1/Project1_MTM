package com.itwillbs.product.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class SuggestSellDAO {
	// 공통 변수 선언
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private String sql = "";

	// 공통) 디비 연결하기(CP)
	private Connection getCon() throws Exception {
		Context initCTX = new InitialContext();
		DataSource ds = (DataSource) initCTX.lookup("java:comp/env/jdbc/mvc");
		con = ds.getConnection();

		System.out.println("SSDAO: DB 연결 성공");

		return con;
	}

	// 공통) 자원 해제
	private void closeDB() {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 거래를 제안한 상품을 DB에 등록하는 uploadProduct()
	public int suggestSell(SuggestSellDTO ssdto) {
		int bno = ssdto.getBuy_bno();
		try {
			con = getCon();

			sql = "insert into SuggestSell (buy_bno, sell_bno, buyer_user_id, seller_user_id, buyer_price, seller_price) values (?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, ssdto.getBuy_bno());
			pstmt.setInt(2, ssdto.getSell_bno());
			pstmt.setString(3, ssdto.getBuyer_user_id());
			pstmt.setString(4, ssdto.getSeller_user_id());
			pstmt.setInt(5, ssdto.getBuyer_price());
			pstmt.setInt(6, ssdto.getSeller_price());

			// sql 실행
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return bno;
	} // uploadProduct() 종료

	// 해당 글에 들어온 제안 목록을 가져오기() - getSuggestList()
	public ArrayList<SuggestSellDTO> getSuggestList(int buy_bno) {
		ArrayList<SuggestSellDTO> suggestList = new ArrayList<SuggestSellDTO>();
		SuggestSellDTO ssdto = null;
		try {
			// 1.2. 디비연결
			con = getCon();
			// 3. sql 구문 작성(select) & pstmt 객체
			sql = "select * from SuggestSell where buy_bno=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, buy_bno);
			// 4. sql 실행
			rs = pstmt.executeQuery();
			// 5. 데이터 처리
			// 글 하나의 정보를 DTO에 저장 후 해당 DTO를 ArrayList에 add
			while (rs.next()) {
				ssdto = new SuggestSellDTO();
				ssdto.setBuy_bno(buy_bno);
				ssdto.setSell_bno(rs.getInt("sell_bno"));
				ssdto.setBuyer_user_id(rs.getString("buyer_user_id"));
				ssdto.setSeller_user_id(rs.getString("seller_user_id"));
				ssdto.setBuyer_price(rs.getInt("buyer_price"));
				ssdto.setSeller_price(rs.getInt("seller_price"));			

				// 글 하나의 정보를 배열의 한칸에 저장
				suggestList.add(ssdto);
			} // while
			System.out.println(" DAO : 제안 정보 조회성공!");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return suggestList;
	} // getSuggestList() 종료
	
	// 중복제안 여부확인
	public List<ProductDTO> getofferOK(List<ProductDTO> sellProduct, int buy_bno) {
	    ProductDTO pdto = null;
	    try {
	        con = getCon();
	        for(int i = 0; i<sellProduct.size(); i++) {
	        	pdto = (ProductDTO)sellProduct.get(i);
	        	String sql = "SELECT * FROM SuggestSell WHERE buy_bno = ? AND sell_bno = ?";
	 	        pstmt = con.prepareStatement(sql);
	 	        pstmt.setInt(1, buy_bno);
	 	        pstmt.setInt(2, pdto.getBno());
	 	        rs = pstmt.executeQuery();

	 	        if (rs.next()) {
	 	            // 중복 제안이 존재하면 true 반환
	 	            pdto.setIsOffered(true);
	 	            System.out.println("DAO : 중복 제안이 확인되었습니다!");
	 	        } else {
	 	            // 중복 제안이 존재하지 않으면 false 반환
	 	        	pdto.setIsOffered(false);
	 	            System.out.println("DAO : 중복 제안이 없습니다.");
	 	        }
	 	        sellProduct.set(i, pdto);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        closeDB();
	    }

	    return sellProduct;
	}
		 
		 
}