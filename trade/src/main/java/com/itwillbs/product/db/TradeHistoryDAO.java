package com.itwillbs.product.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.itwillbs.product.db.TradeHistoryDTO;

public class TradeHistoryDAO {

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

	// 거래 기록 저장
	public void tradehistory(TradeHistoryDTO dto) {
		try {
			con = getCon();
			sql = "insert into TradeHistory (user_id, deal_way, bno, trader_id, price, address ,tradeDate) values(?,?,?,?,?,?,now())";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, dto.getUser_id());
			pstmt.setString(2, dto.getDeal_way()); // 삽니다. 팝니다.
			pstmt.setInt(3, dto.getBno());
			pstmt.setString(4, dto.getTrader_id());
			pstmt.setInt(5, dto.getPrice());
			pstmt.setString(6, dto.getAddress());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
	}

	// 내가 구매한 상품 리스트를 받아오는 메서드 getTradeOkList()
	public List<TradeHistoryDTO> getTradeOkList(String user_id) {
		List<TradeHistoryDTO> tradeOkList = new ArrayList<TradeHistoryDTO>();
		try {
			con = getCon();

			String sql = "SELECT * FROM TradeHistory WHERE user_id = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user_id);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				TradeHistoryDTO thdto = new TradeHistoryDTO();

				thdto.setOrder_id(rs.getInt("order_id"));
				thdto.setUser_id(rs.getString("user_id"));
				thdto.setDeal_way(rs.getString("deal_way"));
				thdto.setBno(rs.getInt("bno"));
				thdto.setTrader_id(rs.getString("trader_id"));
				thdto.setPrice(rs.getInt("price"));
				thdto.setAddress(rs.getString("address"));
				thdto.setTradeDate(rs.getTimestamp("tradeDate"));

				tradeOkList.add(thdto);
			//	System.out.println("SQL 실행 결과: " + tradeOkList.size());

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return tradeOkList;
	} // getTradeOkList() 종료
	
	// 특정 주문번호에 해당하는 글 정보를 가져오는 getDetail(int index) 메서드
		public TradeHistoryDTO getDetail(int order_id) {
			TradeHistoryDTO thdto = null;

			try {
				con = getCon();

				// sql, pstmt
				sql = "select * from TradeHistory where order_id = ?";
				pstmt = con.prepareStatement(sql);

				pstmt.setInt(1, order_id);

				// sql 실행
				rs = pstmt.executeQuery();

				// 데이터 처리
				if (rs.next()) {
					thdto = new TradeHistoryDTO(); // 데이터가 있을 때 객체를 생성(메모리 활용을 위해)

					thdto.setOrder_id(rs.getInt("order_id"));
					thdto.setUser_id(rs.getString("user_id"));
					thdto.setDeal_way(rs.getString("deal_way"));
					thdto.setBno(rs.getInt("bno"));
					thdto.setTrader_id(rs.getString("trader_id"));
					thdto.setPrice(rs.getInt("price"));
					thdto.setAddress(rs.getString("address"));
					thdto.setTradeDate(rs.getTimestamp("tradeDate"));
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				closeDB();
			}

			return thdto;
		} // getProduct(int index) 종료

}