package pojos;

import java.util.Date;
//JPA anno
import javax.persistence.*;//J2EE spec

@Entity //mandatory cls level anno
@Table(name="iacsd_users",schema="system")
public class User {
	/*
	 * User --- id, name ,eamil,password,role,
	 * regAmount,regDate,userType,image
	 * 
	 */
	
	private Integer userId; //ID prop MUST be Serializable
	private String name,email,password,role;
	private double regAmount;
	private UserType userType; //enum
	private byte[] image;
	private boolean isActive;
	private Date regDate;
	//def constr --MUST
	public User() {
		System.out.println("in user constr");
	}
	public User(String name, String email, String password, String role, double regAmount, UserType userType,
			boolean isActive,Date regDate) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
		this.regAmount = regAmount;
		this.userType = userType;
		this.isActive = isActive;
		this.regDate=regDate;
	}
	//select all s/g
	@Id //madatory --- PK constraint 
	//@GeneratedValue(strategy=GenerationType.IDENTITY) //auto increment
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id")
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	@Column(length=20) //varchar (20)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(length=20,unique=true) //varchar (20) , unique
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(length=20)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(length=20)
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Column(name="reg_amt")
	public double getRegAmount() {
		return regAmount;
	}
	public void setRegAmount(double regAmount) {
		this.regAmount = regAmount;
	}
	@Enumerated(EnumType.STRING)
	@Column(name="user_type",length=20)
	public UserType getUserType() {
		return userType;
	}
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	@Lob //large object
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	@Column(name="is_active")
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	@Temporal(TemporalType.DATE)
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", password=" + password + ", role="
				+ role + ", regAmount=" + regAmount + ", userType=" + userType + ", isActive=" + isActive + regDate;
	}
	
	
	 

}
