package model;

public class CarReserveBean {
	private int reserveNo; //���� �����ȣ
	private String user_id; //�������� ����� id
	private int no;  //DB�� �Ҵ�� ������ no[��������� no(��ȣ)]
	private String name; //������
	private int carQty;  //�뿩 ����
	private int rentDuration; //�����뿩�Ⱓ
	private String startDay; //�뿩 ������[Date������ ������ ����. ������.]
	private int applyInsurance; //���谡�Կ���
	private int applyBabySeat; //���̺� ��Ʈ ��뿩��
	private int totalPrice;  //�ѷ�Ʈ ���
	//�׺���̼��� ��� ������ �⺻ �����ϴ� ������ �����Ͽ����Ƿ� �������� ����.
	
	public int getReserveNo() {
		return reserveNo;
	}
	public void setReserveNo(int reserveNo) {
		this.reserveNo = reserveNo;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCarQty() {
		return carQty;
	}
	public void setCarQty(int carQty) {
		this.carQty = carQty;
	}
	public int getRentDuration() {
		return rentDuration;
	}
	public void setRentDuration(int rentDuration) {
		this.rentDuration = rentDuration;
	}
	public String getStartDay() {
		return startDay;
	}
	public void setStartDay(String startDay) {
		this.startDay = startDay;
	}
	public int getApplyInsurance() {
		return applyInsurance;
	}
	public void setApplyInsurance(int applyInsurance) {
		this.applyInsurance = applyInsurance;
	}
	public int getApplyBabySeat() {
		return applyBabySeat;
	}
	public void setApplyBabySeat(int applyBabySeat) {
		this.applyBabySeat = applyBabySeat;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
	
}
