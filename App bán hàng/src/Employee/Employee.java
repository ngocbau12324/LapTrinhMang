package Employee;

import Dungchung.person;
import java.io.Serializable;
import java.text.SimpleDateFormat;

public class Employee extends person implements Serializable
{
    private String employeeCode;
    private String birthday;
    private String position;
    public Employee()
    {
        super();
        employeeCode=null;
        birthday=null;
        position=null;
    }
    
    public Employee(String name, String numberPhone, String address, String employeeCode, String birthday, String position) {
		super(name, numberPhone, address);
		// TODO Auto-generated constructor stub
		setEmployeeCode(employeeCode);
		setBirthday(birthday);
		setPosition(position);
	}

	public void xuat(){
        System.out.format("|%7s       |  ", employeeCode);
        System.out.format("%10s          |  ", super.getName());
        System.out.format("%12s     |  ", birthday);
        System.out.format("%13s        |  ", super.getNumberPhone());
        System.out.format("%23s   |   ", super.getAddress());
        System.out.format("%21s     |\n", position);
    }
    public String getEmployeeName() {
        return super.getName();
    } 
    public String getAddress() {
        return super.getAddress();
    }
    public String getNumberPhone() {
        return super.getNumberPhone();
    }
    public String getEmployeeCode() {
        return employeeCode;
    } 
    public String getBirthDay() {
        return birthday;
    }
    public String getPosition() {
        return position;
    }

    public void setEmployeeName(String employeeName) {
        super.setName(employeeName);
    }
    public void setAddress(String address) {
        super.setAddress(address);
    }
    public void setNumberPhone(String numberPhone) {
        super.setNumberPhone(numberPhone);
    }
    public void setEmployeeCode(String employeeCode) {        
        this.employeeCode = employeeCode;
    }
    public void setBirthday(String birthday) {
        /*String pattern="dd/mm/yyyy";
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(pattern);
        this.ngaysinh = simpleDateFormat.format(ngaysinh);*/
         this.birthday = birthday;
    }
  
    public void setPosition(String position) {
        this.position = position;
    }

	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}
}
