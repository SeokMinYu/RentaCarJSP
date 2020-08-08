package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class carDAO { // �߿��� ����
	
	Connection con; //����Ÿ���̽��� �����ϵ��� ����
	PreparedStatement pstmt; // DB������ ��������ִ� ��ü
	ResultSet rs; // ��������� ���Ϲ޾� �������ִ� ��ü
	
	//mysql db�� �����ϱ�
	String user="root";
	String user_pass="root";
	//������������, ssl ���ܰ� �߻��� ���� �Ʒ��� ���� ?useSSL=false �� �߰��������.
	String url="jdbc:mysql://localhost:3306/carDb?useSSL=false"; //carDb�� db�̸�
	
	//DB ���� �޼ҵ�
	public void getCon( ) {
		try{
			//�ش� �����ͺ��̽��� ����Ѵٰ� ����(Ŭ���� ���:mysql�� ���)
			Class.forName("com.mysql.jdbc.Driver");
			//�ش� �����ͺ��̽��� ����
			con = DriverManager.getConnection(url, user, user_pass);
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
	}
	
	//�������� 4���� �ڵ����� �����ϴ� �޼ҵ�
	public Vector<carBean> getSelect4Car(){ //���� �߿�
		//���� type�� ����
		Vector<carBean> vec = new Vector<>();
		//DB ����
		getCon();
		
		try {
			String sql = "select * from car where category='������' order by no desc";//table�� : car <- �������� �߿�
			pstmt = con.prepareStatement(sql);
			//ResultSet Ÿ���� ���� �����͸� ����
			rs = pstmt.executeQuery();
			int cnt=0;
			while (rs.next()) { //<- �߿� next()
				carBean bean = new carBean();
				bean.setNo(rs.getInt(1)); // ���࿡ ���� �ε���
				bean.setName(rs.getString(2));
				bean.setCompany(rs.getString(3));
				bean.setCategory(rs.getString(4));
				bean.setPassengers(rs.getInt(5));
				bean.setFuel(rs.getString(6));
				bean.setCc(rs.getInt(7));
				bean.setPrice(rs.getInt(8));
				bean.setImgfile(rs.getString(9));
				bean.setInfo(rs.getString(10));
				
				//���Ϳ� bean Ŭ���� �߰�
				vec.add(bean); //���� bean ��ü �߰�
				cnt++;
				if (cnt >= 4) break; //�ݺ��� Ż��
				
			}
			pstmt.close();
			con.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return vec;// ������ ������.
	}
	
	//���õ� Category�� ���� �ڵ��� ����Ʈ�� �����Ͽ� �����ִ� method
	public Vector<carBean> getCarCategory(String cate){
		//���� Ÿ���� �̸� ����
		Vector<carBean> vec = new Vector<carBean>();
		//�����͸� ���� bean Ŭ������ ����
		//carBean bean = null;
		//DB����
		getCon();
		try {
			//������ �ۼ�
			String sql = "select * from car where category=?";
			pstmt = con.prepareStatement(sql);
			//?�����ϱ�
			pstmt.setString(1, cate);
			rs = pstmt.executeQuery();
			//�ݺ����� ����Ͽ� bean ������ vector�� �����ϱ�
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
				
				//���Ϳ� bean Ŭ���� �߰�
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
	
	//��� ������ �˻��ϴ� method �ۼ�
	public Vector<carBean> getAllCar(){
		//���� Ÿ���� �̸� ����
				Vector<carBean> vec = new Vector<>();
				//�����͸� ���� bean Ŭ������ ����
				//carBean bean = null;
				//DB����
				getCon();
				try {
					//������ �ۼ�
					String sql = "select * from car";
					pstmt = con.prepareStatement(sql);
					rs = pstmt.executeQuery();
					//�ݺ����� ����Ͽ� bean ������ vector�� �����ϱ�
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
						
						//���Ϳ� bean Ŭ���� �߰�
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
	
	//���õ� �ϳ��� �ڵ��� ������ �о���� method
	public carBean getOneCarData(int no) {
		//�������� ����
		carBean bean = new carBean();
		getCon();
		
		try {
			String sql = "select * from car where no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			//����� rs�� ����
			rs = pstmt.executeQuery();
			//�ϳ��� �����͸� �����Ƿ�
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
	
	//�ϳ��� ���� ������ ���� ���� ������ �����ϴ� method�ۼ�
	public void insertCarReservation(CarReserveBean rbean) { // �߿�
		getCon(); //DB�������� ���� 
		
		try {
			//�����ȣ��(reserveNo)�� auto_increment ��� ������� �ڵ� ����
			String sql = "insert into carReserveTable(user_id, no,name,carQty,rentDuration,startDay,applyInsurance,applyBabySeat,totalPrice) "
					+ "values(?,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			//?�� �� �Ҵ� , �������� get
			pstmt.setString(1,rbean.getUser_id());
			pstmt.setInt(2, rbean.getNo());
			pstmt.setString(3,rbean.getName());
			pstmt.setInt(4, rbean.getCarQty());
			pstmt.setInt(5, rbean.getRentDuration());
			pstmt.setString(6, rbean.getStartDay());
			pstmt.setInt(7, rbean.getApplyInsurance());
			pstmt.setInt(8, rbean.getApplyBabySeat());
			pstmt.setInt(9, rbean.getTotalPrice());
			
			pstmt.executeUpdate(); //�߿� - �����Ҷ����
			
			pstmt.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//ȸ���� ��Ʈī ���� ������ �о���� method
	public Vector<CarReserveBean> getAllReservation(String userId){
		Vector<CarReserveBean> vec = new Vector<>();//���� Ÿ��
				
		getCon();
		//2���� ���̺��� ���ÿ� �д� ��� �Ұ�
		// �� ���̺��� ������ ������Ű�� ������ ��� ����.
		//String sql="select * from car natural join carReserveTable"
		//          + "where now() < to_date(startDay, 'yyyy-MM-dd') and user_id=?";
		try {
			//���� ��¥���� ������ ���� �˻�
			//��¥�� '2019-07-01' ���ڿ��� �νĵ� �Ǹ�, ���ڿ��� ����Ǹ� �񱳰� ������. curdate() ['2019-06-10']���� ��¥�� �ǹ���.
			//select * from carReserveTable where '2019-06-08' < startDay; //�̰͵� ��ȿ��.(sql workbench���� ������ �� ��)
			
			String sql = "select * from carReserveTable where user_id=? and (startDay >= curdate())"; //��Ʈ������ �� curdate ���糯¥
			pstmt = con.prepareStatement(sql);
			//?
			pstmt.setString(1, userId);
			
			rs = pstmt.executeQuery(); // �о���϶�
			
			while (rs.next()) {
				CarReserveBean rbean = new CarReserveBean();
				rbean.setReserveNo(rs.getInt(1));
				rbean.setUser_id(rs.getString(2));
				rbean.setNo(rs.getInt(3)); //����DB��Ϲ�ȣ
				rbean.setName(rs.getString(4)); //�����̸�
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
	//���� ���(����) �޼ҵ� ����
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
			//�����ȣ��(reserveNo)�� auto_increment ��� ������� �ڵ� ����
			String sql = "insert into car(name, company,category,passengers,fuel,cc,price,imgfile,info) "
					+ "values(?,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			//?�� �� �Ҵ�
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

