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

public class ProductDAO {
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

		System.out.println("DAO: DB 연결 성공");

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

	// 글 작성 메서드(uploadProduct)
	public int uploadProduct(ProductDTO dto) {
		int bno = 0;
		try {
			con = getCon();

			// sql, pstmt
			sql = "select max(bno) from Product";
			pstmt = con.prepareStatement(sql);

			// sql 쿼리 실행
			rs = pstmt.executeQuery();

			// 데이터 처리(글번호 계산)
			if (rs.next()) {
				bno = rs.getInt(1) + 1;
			}

			System.out.println("DAO: 글번호: " + bno);

			// sql, pstmt
			sql = "insert into Product (bno, user_id, deal_way, title, category, brand, "
					+ "price, product_status, content, views, date_time, file_name, like_count) values (?,?,?,?,?,?,?,?,?,?,now(),?,?)";
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, bno);
			pstmt.setString(2, dto.getUser_id());
			pstmt.setString(3, dto.getDeal_way());
			pstmt.setString(4, dto.getTitle());
			pstmt.setString(5, dto.getCategory());

			pstmt.setString(6, dto.getBrand());
			pstmt.setInt(7, dto.getPrice());
			pstmt.setString(8, dto.getProduct_status());
			pstmt.setString(9, dto.getContent());
			pstmt.setInt(10, 0); // 조회수 0
			pstmt.setString(11, dto.getFile_name());
			pstmt.setInt(12, 0); // 찜 0

			// sql 실행
			pstmt.executeUpdate();
			dto.setBno(bno);
			System.out.println("DAO: " + bno + "번 글 작성 완료");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return bno;
	} // uploadProduct() 종료

	// 조회수를 1 증가시키는 updateReadcount()
	public void updateReadcount(int bno) {
		try {
			// 1. 디비 연결
			con = getCon();

			// 2. sql 작성, pstmt 객체
			sql = "update Product set views=views+1 where bno=?";
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, bno);

			// 3. sql 실행
			pstmt.executeUpdate();

			System.out.println("DAO: 게시판 조회수 1 증가 완료!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
	} // updateReadcount() 종료

	// 특정 번호에 해당하는 글 정보를 가져오는 getProduct(int bno) 메서드
	public ProductDTO getProduct(int bno) {
		ProductDTO dto = null;

		try {
			con = getCon();

			// sql, pstmt
			sql = "select * from Product where bno = ?";
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, bno);

			// sql 실행
			rs = pstmt.executeQuery();

			// 데이터 처리
			if (rs.next()) {
				dto = new ProductDTO(); // 데이터가 있을 때 객체를 생성(메모리 활용을 위해)

				dto.setBno(rs.getInt("bno"));
				dto.setContent(rs.getString("content"));
				dto.setUser_id(rs.getString("user_id"));
				dto.setDeal_way(rs.getString("deal_way"));
				dto.setTitle(rs.getString("title"));
				dto.setCategory(rs.getString("category"));
				dto.setBrand(rs.getString("brand"));
				dto.setPrice(rs.getInt("price"));
				dto.setProduct_status(rs.getString("product_status"));
				dto.setContent(rs.getString("content"));
				dto.setViews(rs.getInt("views"));
				dto.setDate_time(rs.getTimestamp("date_time"));
				dto.setFile_name(rs.getString("file_name"));
				dto.setLike_count(rs.getInt("like_count"));
				dto.setDeal_status(rs.getInt("deal_status"));
				dto.setDeal_user_id(rs.getString("deal_user_id"));
			}
			System.out.println("DAO: 글 정보 조회 완료!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}

		return dto;
	} // getProduct(int bno) 종료

	// 글 개수 계산 메서드 - getProductCount()
	public int getProductCount() {
		int result = 0;

		try {
			con = getCon();
			// 3. sql 작성(select) & pstmt 객체
			sql = "select count(*) from Product";
			pstmt = con.prepareStatement(sql);

			// 4. sql 실행
			rs = pstmt.executeQuery();
			// 5. 데이터 처리 - 개수를 저장
			if (rs.next()) {
				result = rs.getInt(1);
			}
			System.out.println(" DAO : 개수 " + result + "개");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}

		return result;
	}
	// 글 개수 계산 메서드 - getProductCount()

	// 검색시 글 개수 계산 메서드 - getProductCount(search)
	public int getProductCount(String search) {
		int result = 0;

		try {
			// 1. 드라이버 로드
			// 2. 디비 연결
			con = getCon();

			// 3. sql 작성(select) & pstmt 객체
			sql = "select count(*) from Product " + "where title like ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + search + "%");

			// 4. sql 실행
			rs = pstmt.executeQuery();

			// 5. 데이터 처리 - 개수를 저장
			if (rs.next()) {
				result = rs.getInt(1);
				// result = rs.getInt("count(*)");
			}
			System.out.println(" DAO : 개수 " + result + "개");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}

		return result;
	}
	// 검색시 글 개수 계산 메서드 - getProductCount(search)

	// 카테고리별 글 개수 계산 메서드 - getCategoryProductCount(category)
	public int getCategoryProductCount(String category) {
		int result = 0;

		try {
			// 1. 드라이버 로드
			// 2. 디비 연결
			con = getCon();

			// 3. sql 작성(select) & pstmt 객체
			sql = "select count(*) from Product where category like ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + category + "%");

			// 4. sql 실행
			rs = pstmt.executeQuery();

			// 5. 데이터 처리 - 개수를 저장
			if (rs.next()) {
				result = rs.getInt(1);
				// result = rs.getInt("count(*)");
			}

			System.out.println(" DAO : 개수 " + result + "개");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}

		return result;
	}
	// 카테고리별 글 개수 계산 메서드 - getCategoryProductCount(category)

	// 글 정보 목록을 가져오는 메서드 - getProductList(int startRow,int pageSize)
	public ArrayList getProductList(int startRow, int pageSize) {
		// 글정보를 저장하는 배열
		ArrayList ProductList = new ArrayList();
		try {
			// 디비연결정보
			// 1. 드라이버 로드
			// 2. 디비 연결
			con = getCon();
			// 3. SQL 작성(select) & pstmt 객체
			sql = "select * from Product order by re_ref desc,re_seq asc limit ?,?";
			pstmt = con.prepareStatement(sql);
			// ????
			pstmt.setInt(1, startRow - 1); // 시작행번호-1
			pstmt.setInt(2, pageSize); // 개수
			// 4. SQL 실행
			rs = pstmt.executeQuery();
			// 5. 데이터 처리
			// 글정보 전부 가져오기
			while (rs.next()) {
				ProductDTO dto = new ProductDTO();

				dto.setBno(rs.getInt("bno"));
				dto.setContent(rs.getString("content"));
				dto.setUser_id(rs.getString("user_id"));
				dto.setDeal_way(rs.getString("deal_way"));
				dto.setTitle(rs.getString("title"));
				dto.setCategory(rs.getString("category"));
				dto.setBrand(rs.getString("brand"));
				dto.setPrice(rs.getInt("price"));
				dto.setProduct_status(rs.getString("product_status"));
				dto.setContent(rs.getString("content"));
				dto.setViews(rs.getInt("views"));
				dto.setDate_time(rs.getTimestamp("date_time"));
				dto.setFile_name(rs.getString("file_name"));
				dto.setLike_count(rs.getInt("like_count"));
				dto.setDeal_status(rs.getInt("deal_status"));
				dto.setDeal_user_id(rs.getString("deal_user_id"));

				// 글 하나의 정보를 배열의 한칸에 저장
				ProductList.add(dto);

			} // while

			System.out.println(" DAO : 글 목록 조회성공! ");
			System.out.println(" DAO : " + ProductList.size());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return ProductList;
	}
	// 글 정보 목록을 가져오는 메서드 -getProductList(int startRow,int pageSize) 종료

	// 검색 목록을 가져오는 메서드 - getProductList(int startRow,int pageSize,String search)
	public ArrayList getProductList(int startRow, int pageSize, String search) {
		// 글정보를 저장하는 배열
		ArrayList ProductList = new ArrayList();
		try {
			// 디비연결정보
			// 1. 드라이버 로드
			// 2. 디비 연결
			con = getCon();

			// 3. SQL 작성(select) & pstmt 객체
			sql = "select * from Product " + "where title like ? " + "limit ?,?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + search + "%"); // %검색어%
			pstmt.setInt(2, startRow - 1); // 시작행번호-1
			pstmt.setInt(3, pageSize); // 개수
			// 4. SQL 실행
			rs = pstmt.executeQuery();
			// 5. 데이터 처리
			// 글정보 전부 가져오기
			while (rs.next()) {
				ProductDTO dto = new ProductDTO();

				dto.setBno(rs.getInt("bno"));
				dto.setContent(rs.getString("content"));
				dto.setUser_id(rs.getString("user_id"));
				dto.setDeal_way(rs.getString("deal_way"));
				dto.setTitle(rs.getString("title"));
				dto.setCategory(rs.getString("category"));
				dto.setBrand(rs.getString("brand"));
				dto.setPrice(rs.getInt("price"));
				dto.setProduct_status(rs.getString("product_status"));
				dto.setContent(rs.getString("content"));
				dto.setViews(rs.getInt("views"));
				dto.setDate_time(rs.getTimestamp("date_time"));
				dto.setFile_name(rs.getString("file_name"));
				dto.setLike_count(rs.getInt("like_count"));
				dto.setDeal_status(rs.getInt("deal_status"));
				dto.setDeal_user_id(rs.getString("deal_user_id"));

				// 글 하나의 정보를 배열의 한칸에 저장
				ProductList.add(dto);

			} // while
			System.out.println(" DAO : 검색창 글 목록 조회성공! ");
			System.out.println(" DAO : " + ProductList.size());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}

		return ProductList;
	}// 검색 목록을 가져오는 메서드 -getProductList(int startRow,int pageSize,String search) 종료

	// 카테고리별 글목록을 가져오는 메서드 - getCategoryProductList(int startRow,int pageSize,String category)
	public ArrayList getCategoryProductList(int startRow, int pageSize, String category) {
		// 글정보를 저장하는 배열
		ArrayList ProductList = new ArrayList();
		try {
			// 디비연결정보
			// 1. 드라이버 로드
			// 2. 디비 연결
			con = getCon();

			// 3. SQL 작성(sele&ct) & pstmt 객체
			sql = "select * from Product " + "where category like ? " + "limit ?,?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + category + "%"); // %검색어%
			pstmt.setInt(2, startRow - 1); // 시작행번호-1
			pstmt.setInt(3, pageSize); // 개수
			// 4. SQL 실행
			rs = pstmt.executeQuery();
			// 5. 데이터 처리
			// 글정보 전부 가져오기
			while (rs.next()) {
				ProductDTO dto = new ProductDTO();

				dto.setBno(rs.getInt("bno"));
				dto.setContent(rs.getString("content"));
				dto.setUser_id(rs.getString("user_id"));
				dto.setDeal_way(rs.getString("deal_way"));
				dto.setTitle(rs.getString("title"));
				dto.setCategory(rs.getString("category"));
				dto.setBrand(rs.getString("brand"));
				dto.setPrice(rs.getInt("price"));
				dto.setProduct_status(rs.getString("product_status"));
				dto.setContent(rs.getString("content"));
				dto.setViews(rs.getInt("views"));
				dto.setDate_time(rs.getTimestamp("date_time"));
				dto.setFile_name(rs.getString("file_name"));
				dto.setLike_count(rs.getInt("like_count"));
				dto.setDeal_status(rs.getInt("deal_status"));
				dto.setDeal_user_id(rs.getString("deal_user_id"));

				// 글 하나의 정보를 배열의 한칸에 저장
				ProductList.add(dto);

				System.out.println(" DAO : 카테고리별 글 목록 조회성공! ");
				System.out.println(" DAO : " + ProductList.size());

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return ProductList;
	}// 카테고리별 상품 목록을 가져오는 메서드 -getBrandProductList(int startRow,int pageSize,String category) 종료

	// 사용자 아이디에 해당하는 상품 정보(상품명, 상품상태, 가격) 가져오는 ProductInfo(user_id) 메서드
	public ProductDTO ProductInfo(String user_id) {
		ProductDTO dto = null;
		try {
			con = getCon();
			// sql, pstmt
			sql = "select * from Product where user_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user_id);
			// sql 실행
			rs = pstmt.executeQuery();

			// 데이터 처리
			if (rs.next()) {
				dto = new ProductDTO();
				dto.setFile_name(rs.getString("file_name"));
				dto.setTitle(rs.getString("title"));
				dto.setProduct_status(rs.getString("product_status"));
				dto.setPrice(rs.getInt("price"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return dto;
	} // ProductInfo(user_id) 종료

	// 조회순으로 글 정보 목록을 가져오기() - getPopularList()
	public ArrayList<ProductDTO> getPopularList() {
		ArrayList<ProductDTO> productPopList = new ArrayList<ProductDTO>();
		ProductDTO dto = null;
		try {
			// 1.2. 디비연결
			con = getCon();
			// 3. sql 구문 작성(select) & pstmt 객체
			sql = "SELECT * FROM Product ORDER BY views DESC limit 8"; // views 내림차순으로 8개까지 정렬
			pstmt = con.prepareStatement(sql);
			// 4. sql 실행
			rs = pstmt.executeQuery();
			// 5. 데이터 처리
			while (rs.next()) {
				dto = new ProductDTO();
				dto.setBno(rs.getInt("bno"));
				dto.setContent(rs.getString("content"));
				dto.setUser_id(rs.getString("user_id"));
				dto.setDeal_way(rs.getString("deal_way"));
				dto.setTitle(rs.getString("title"));
				dto.setCategory(rs.getString("category"));
				dto.setBrand(rs.getString("brand"));
				dto.setPrice(rs.getInt("price"));
				dto.setProduct_status(rs.getString("product_status"));
				dto.setContent(rs.getString("content"));
				dto.setViews(rs.getInt("views"));
				dto.setDate_time(rs.getTimestamp("date_time"));
				dto.setFile_name(rs.getString("file_name"));
				dto.setLike_count(rs.getInt("like_count"));
				dto.setDeal_status(rs.getInt("deal_status"));
				dto.setDeal_user_id(rs.getString("deal_user_id"));

				// 글 하나의 정보를 배열의 한칸에 저장
				productPopList.add(dto);
			} // while
			System.out.println(" DAO : 상품 정보 조회성공!");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return productPopList;
	}
	// 특정 글의 정보를 가져오기() - getPopularList()

	// 최신순으로 글 정보 목록을 가져오기() - getRecentList()
	public ArrayList<ProductDTO> getRecentList() {
		ArrayList<ProductDTO> productRecList = new ArrayList<ProductDTO>();
		ProductDTO dto2 = null;
		try {
			// 1.2. 디비연결
			con = getCon();
			// 3. sql 구문 작성(select) & pstmt 객체
			sql = "SELECT * FROM Product ORDER BY date_time DESC limit 8"; // date_time 내림차순으로 8개까지 정렬
			pstmt = con.prepareStatement(sql);
			// 4. sql 실행
			rs = pstmt.executeQuery();
			// 5. 데이터 처리
			while (rs.next()) {
				dto2 = new ProductDTO();
				dto2.setBno(rs.getInt("bno"));
				dto2.setContent(rs.getString("content"));
				dto2.setUser_id(rs.getString("user_id"));
				dto2.setDeal_way(rs.getString("deal_way"));
				dto2.setTitle(rs.getString("title"));
				dto2.setCategory(rs.getString("category"));
				dto2.setBrand(rs.getString("brand"));
				dto2.setPrice(rs.getInt("price"));
				dto2.setProduct_status(rs.getString("product_status"));
				dto2.setContent(rs.getString("content"));
				dto2.setViews(rs.getInt("views"));
				dto2.setDate_time(rs.getTimestamp("date_time"));
				dto2.setFile_name(rs.getString("file_name"));
				dto2.setLike_count(rs.getInt("like_count"));
				dto2.setDeal_status(rs.getInt("deal_status"));
				dto2.setDeal_user_id(rs.getString("deal_user_id"));
				
				// 글 하나의 정보를 배열의 한칸에 저장
				productRecList.add(dto2);
			} // while
			System.out.println(" DAO : 상품 정보 조회성공!");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return productRecList;
	}
	// 특정 글의 정보를 가져오기() - getRecentList()
	
	// 글을 삭제하는 deleteProduct(bno)
	public int deleteProduct(int bno) {
		int result = -1; // -1(글정보없음, 에러), 0(비밀번호 오류), 1(정상처리)

		try {
			con = getCon();

			// 비밀번호가 맞을 때
			// sql, pstmt
			sql = "delete from Product where bno=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bno);

			// sql 실행, 결과 저장
			result = pstmt.executeUpdate();

			System.out.println("DAO: 글 삭제 완료, 결과: " + result);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return result;
	} // deleteProduct(bno) 종료
	
	// 글을 수정하는 updateProduct(bno)
	public int updateProduct(ProductDTO dto) {
		int bno = dto.getBno();
		try {
			
			con = getCon();

			// sql, pstmt
			sql = "update Product set deal_way=?, title=?, category=?, brand=?, "
					+ "price=?, product_status=?, content=?, file_name=? where bno=?";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, dto.getDeal_way());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getCategory());
			pstmt.setString(4, dto.getBrand());
			pstmt.setInt(5, dto.getPrice());
			pstmt.setString(6, dto.getProduct_status());
			pstmt.setString(7, dto.getContent());
			pstmt.setString(8, dto.getFile_name());
			pstmt.setInt(9, bno); 

			// sql 실행
			pstmt.executeUpdate();
			System.out.println("DAO: " + bno + "번 글 수정 완료");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return bno;
	}

	// 유저의 팝니다 상품만 불러오는 메서드 - getAllUserProducts(String userId)
	public List<ProductDTO> getAllUserProducts(String user_id, String deal_way) {
		ArrayList<ProductDTO> userProducts = new ArrayList<>();

		try {
			con = getCon();
			// 3. sql 구문 작성(select) & pstmt 객체
			sql = "SELECT * FROM Product WHERE user_id = ? AND deal_way = ? AND deal_status = 1";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user_id);
			pstmt.setString(2, deal_way); // deal_way 파라미터를 사용
			// 4. sql 실행
			rs = pstmt.executeQuery();
			// 5. 데이터 처리
			while (rs.next()) {
				ProductDTO dto = new ProductDTO();
				dto.setBno(rs.getInt("bno"));
				dto.setContent(rs.getString("content"));
				dto.setUser_id(rs.getString("user_id"));
				dto.setDeal_way(rs.getString("deal_way"));
				dto.setTitle(rs.getString("title"));
				dto.setCategory(rs.getString("category"));
				dto.setBrand(rs.getString("brand"));
				dto.setPrice(rs.getInt("price"));
				dto.setProduct_status(rs.getString("product_status"));
				dto.setContent(rs.getString("content"));
				dto.setViews(rs.getInt("views"));
				dto.setDate_time(rs.getTimestamp("date_time"));
				dto.setFile_name(rs.getString("file_name"));
				dto.setLike_count(rs.getInt("like_count"));
				dto.setDeal_status(rs.getInt("deal_status"));
				dto.setDeal_user_id(rs.getString("deal_user_id"));

				// 글 하나의 정보를 리스트에 추가
				userProducts.add(dto);
			}
			System.out.println(" DAO: 상품 정보 조회 성공!");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return userProducts;

	}// 유저의 팝니다 상품만 불러오는 메서드 종료
	
	// 유저의 모든 등록 상품을 불러오는 메서드 - getAllUserProducts(String userId)
	public List<ProductDTO> getAllUserProducts(String user_id) {
		ArrayList<ProductDTO> userProducts = new ArrayList<>();
		
		try {
			con = getCon();
			// 3. sql 구문 작성(select) & pstmt 객체
			sql = "SELECT * FROM Product WHERE user_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user_id);

			// 4. sql 실행
			rs = pstmt.executeQuery();
			// 5. 데이터 처리
			while (rs.next()) {
				ProductDTO dto = new ProductDTO();
				dto.setBno(rs.getInt("bno"));
				dto.setContent(rs.getString("content"));
				dto.setUser_id(rs.getString("user_id"));
				dto.setDeal_way(rs.getString("deal_way"));
				dto.setTitle(rs.getString("title"));
				dto.setCategory(rs.getString("category"));
				dto.setBrand(rs.getString("brand"));
				dto.setPrice(rs.getInt("price"));
				dto.setProduct_status(rs.getString("product_status"));
				dto.setContent(rs.getString("content"));
				dto.setViews(rs.getInt("views"));
				dto.setDate_time(rs.getTimestamp("date_time"));
				dto.setFile_name(rs.getString("file_name"));
				dto.setLike_count(rs.getInt("like_count"));
				dto.setDeal_status(rs.getInt("deal_status"));
				dto.setDeal_user_id(rs.getString("deal_user_id"));
				
				// 글 하나의 정보를 리스트에 추가
				userProducts.add(dto);
			}
			System.out.println(" DAO: 상품 정보 조회 성공!");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return userProducts;		
	}// getAllUserProducts(String userId) 종료
	
	
	
	
	
	
}