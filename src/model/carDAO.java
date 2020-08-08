package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class carDAO { // 중요한 형식
	
	Connection con; //데이타베이스에 접속하도록 설정
	PreparedStatement pstmt; // DB쿼리를 실행시켜주는 객체
	ResultSet rs; // 쿼리결과를 리턴받아 저장해주는 객체
	
	//mysql db에 접속하기
	String user="root";
	String user_pass="root";
	//정상적이지만, ssl 예외가 발생할 때는 아래와 같이 ?useSSL=false 을 추가해줘야함.
	String url="jdbc:mysql://localhost:3306/carDb?useSSL=false"; //carDb는 db이름
	
	//DB 접속 메소드
	public void getCon( ) {
		try{
			//해당 데이터베이스를 사용한다고 선언(클래스 등록:mysql을 사용)
			Class.forName("com.mysql.jdbc.Driver");
			//해당 데이터베이스에 접속
			con = DriverManager.getConnection(url, user, user_pass);
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
	}
	
	//준중형차 4대의 자동차를 리턴하는 메소드
	public Vector<carBean> getSelect4Car(){ //벡터 중요
		//리턴 type을 정의
		Vector<carBean> vec = new Vector<>();
		//DB 접속
		getCon();
		
		try {
			String sql = "select * from car where category='준중형' order by no desc";//table명 : car <- 여기형식 중요
			pstmt = con.prepareStatement(sql);
			//ResultSet 타입의 쿼리 데이터를 받음
			rs = pstmt.executeQuery();
			int cnt=0;
			while (rs.next()) { //<- 중요 next()
				carBean bean = new carBean();
				bean.setNo(rs.getInt(1)); // 한행에 대한 인덱스
				bean.setName(rs.getString(2));
				bean.setCompany(rs.getString(3));
				bean.setCategory(rs.getString(4));
				bean.setPassengers(rs.getInt(5));
				bean.setFuel(rs.getString(6));
				bean.setCc(rs.getInt(7));
				bean.setPrice(rs.getInt(8));
				bean.setImgfile(rs.getString(9));
				bean.setInfo(rs.getString(10));
				
				//벡터에 bean 클래스 추가
				vec.add(bean); //벡터 bean 객체 추가
				cnt++;
				if (cnt >= 4) break; //반복문 탈출
				
			}
			pstmt.close();
			con.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return vec;// 데이터 리턴함.
	}
	
	//선택된 Category에 대해 자동차 리스트를 저장하여 돌려주는 method
	public Vector<carBean> getCarCategory(String cate){
		//리턴 타입을 미리 선언
		Vector<carBean> vec = new Vector<carBean>();
		//데이터를 담을 bean 클래스를 선언
		//carBean bean = null;
		//DB접속
		getCon();
		try {
			//쿼리문 작성
			String sql = "select * from car where category=?";
			pstmt = con.prepareStatement(sql);
			//?설정하기
			pstmt.setString(1, cate);
			rs = pstmt.executeQuery();
			//반복문을 사용하여 bean 단위로 vector에 저장하기
			while (rs.next()) {
				carBean bean = new carBean();
				bean.setNo(rs.getInt(1));
				bean.setName(rs.getString(2));
				bean.setCompany(rs.getString(3));
				bean.setCategory(rs.getString(4));
				bean.setPassengers(rs.getInt(5));
				bean.setFuel(rs.getString(6));
				bean.setCc(rs.getInt(7));
				bean.setPrice(rs.getInt(8));
				bean.setImgfile(rs.getString(9));
				bean.setInfo(rs.getString(10));
				
				//벡터에 bean 클래스 추가
				vec.add(bean);				
			}
			pstmt.close();
			con.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return vec;		
	}
	
	//모든 차량을 검색하는 method 작성
	public Vector<carBean> getAllCar(){
		//리턴 타입을 미리 선언
				Vector<carBean> vec = new Vector<>();
				//데이터를 담을 bean 클래스를 선언
				//carBean bean = null;
				//DB접속
				getCon();
				try {
					//쿼리문 작성
					String sql = "select * from car";
					pstmt = con.prepareStatement(sql);
					rs = pstmt.executeQuery();
					//반복문을 사용하여 bean 단위로 vector에 저장하기
					while (rs.next()) {
						carBean bean = new carBean();
						bean.setNo(rs.getInt(1));
						bean.setName(rs.getString(2));
						bean.setCompany(rs.getString(3));
						bean.setCategory(rs.getString(4));
						bean.setPassengers(rs.getInt(5));
						bean.setFuel(rs.getString(6));
						bean.setCc(rs.getInt(7));
						bean.setPrice(rs.getInt(8));
						bean.setImgfile(rs.getString(9));
						bean.setInfo(rs.getString(10));
						
						//벡터에 bean 클래스 추가
						vec.add(bean);				
					}
					pstmt.close();
					con.close();
					
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				
				return vec;		
		
	}
	
	//선택된 하나의 자동차 정보를 읽어오는 method
	public carBean getOneCarData(int no) {
		//리턴형을 선언
		carBean bean = new carBean();
		getCon();
		
		try {
			String sql = "select * from car where no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			//결과를 rs에 받음
			rs = pstmt.executeQuery();
			//하나의 데이터만 읽으므로
			if (rs.next()) {
				bean.setNo(rs.getInt(1));
				bean.setName(rs.getString(2));
				bean.setCompany(rs.getString(3));
				bean.setCategory(rs.getString(4));
				bean.setPassengers(rs.getInt(5));
				bean.setFuel(rs.getString(6));
				bean.setCc(rs.getInt(7));
				bean.setPrice(rs.getInt(8));
				bean.setImgfile(rs.getString(9));
				bean.setInfo(rs.getString(10));
			}
			pstmt.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return bean;
	}
	
	//하나의 예약 단위에 대한 예약 정보를 저장하는 method작성
	public void insertCarReservation(CarReserveBean rbean) { // 중요
		getCon(); //DB연동까지 수행 
		
		try {
			//예약번호는(reserveNo)는 auto_increment 모드 사용으로 자동 생성
			String sql = "insert into carReserveTable(user_id, no,name,carQty,rentDuration,startDay,applyInsurance,applyBabySeat,totalPrice) "
					+ "values(?,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			//?에 값 할당 , 꺼낼때는 get
			pstmt.setString(1,rbean.getUser_id());
			pstmt.setInt(2, rbean.getNo());
			pstmt.setString(3,rbean.getName());
			pstmt.setInt(4, rbean.getCarQty());
			pstmt.setInt(5, rbean.getRentDuration());
			pstmt.setString(6, rbean.getStartDay());
			pstmt.setInt(7, rbean.getApplyInsurance());
			pstmt.setInt(8, rbean.getApplyBabySeat());
			pstmt.setInt(9, rbean.getTotalPrice());
			
			pstmt.executeUpdate(); //중요 - 갱신할때사용
			
			pstmt.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//회원의 렌트카 예약 정보를 읽어오는 method
	public Vector<CarReserveBean> getAllReservation(String userId){
		Vector<CarReserveBean> vec = new Vector<>();//리턴 타입
				
		getCon();
		//2개의 테이블에서 동시에 읽는 방법 소개
		// 두 테이블에서 조건을 만조시키는 내용을 모두 읽음.
		//String sql="select * from car natural join carReserveTable"
		//          + "where now() < to_date(startDay, 'yyyy-MM-dd') and user_id=?";
		try {
			//현재 날짜보다 이후의 것을 검색
			//날짜는 '2019-07-01' 문자열로 인식도 되며, 문자열로 저장되면 비교가 가능함. curdate() ['2019-06-10']오늘 날짜를 의미함.
			//select * from carReserveTable where '2019-06-08' < startDay; //이것도 유효함.(sql workbench에서 수행해 볼 것)
			
			String sql = "select * from carReserveTable where user_id=? and (startDay >= curdate())"; //스트링으로 비교 curdate 현재날짜
			pstmt = con.prepareStatement(sql);
			//?
			pstmt.setString(1, userId);
			
			rs = pstmt.executeQuery(); // 읽어들일때
			
			while (rs.next()) {
				CarReserveBean rbean = new CarReserveBean();
				rbean.setReserveNo(rs.getInt(1));
				rbean.setUser_id(rs.getString(2));
				rbean.setNo(rs.getInt(3)); //차량DB등록번호
				rbean.setName(rs.getString(4)); //차량이름
				rbean.setCarQty(rs.getInt(5));
				rbean.setRentDuration(rs.getInt(6));
				rbean.setStartDay(rs.getString(7));
				rbean.setApplyInsurance(rs.getInt(8));
				rbean.setApplyBabySeat(rs.getInt(9));
				rbean.setTotalPrice(rs.getInt(10));
				
				vec.add(rbean);
			}
			pstmt.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vec;
	}
	//예약 취소(삭제) 메소드 정의
	public void carReserveCancel(int reserveNo) {
		getCon();
		
		try {
			String sql = "delete from carReserveTable where reserveNo=?";
			
			pstmt = con.prepareStatement(sql);
			//?
			pstmt.setInt(1, reserveNo);
			
			pstmt.executeUpdate();
			
			pstmt.close();
			con.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	//
	public void insertOneCarRegistration(carBean bean) {
		getCon();
		
		try {
			//예약번호는(reserveNo)는 auto_increment 모드 사용으로 자동 생성
			String sql = "insert into car(name, company,category,passengers,fuel,cc,price,imgfile,info) "
					+ "values(?,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			//?에 값 할당
			pstmt.setString(1,bean.getName());
			pstmt.setString(2, bean.getCompany());
			pstmt.setString(3,bean.getCategory());
			pstmt.setInt(4, bean.getPassengers());
			pstmt.setString(5, bean.getFuel());
			pstmt.setInt(6, bean.getCc());
			pstmt.setInt(7, bean.getPrice());
			pstmt.setString(8, bean.getImgfile());
			pstmt.setString(9, bean.getInfo());
			
			pstmt.executeUpdate();
			
			pstmt.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

