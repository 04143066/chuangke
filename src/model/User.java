package model;

import java.sql.Blob;
import java.util.Date;

public class User {

	private int uid;
	private int uage;
	private int ugroup;
	private Blob upicture;
	private boolean usex;
	private String utell;
	private String uname;
	private String upasswd;
	private Date ubirthday;
	private String uprofile;
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getUage() {
		return uage;
	}
	public void setUage(int uage) {
		this.uage = uage;
	}
	public int getUgroup() {
		return ugroup;
	}
	public void setUgroup(int ugroup) {
		this.ugroup = ugroup;
	}
	
	public Blob getUpicture() {
		return upicture;
	}
	public void setUpicture(Blob upicture) {
		this.upicture = upicture;
	}
	public boolean isUsex() {
		return usex;
	}
	public void setUsex(boolean usex) {
		this.usex = usex;
	}
	public String getUtell() {
		return utell;
	}
	public void setUtell(String utell) {
		this.utell = utell;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpasswd() {
		return upasswd;
	}
	public void setUpasswd(String upasswd) {
		this.upasswd = upasswd;
	}
	public Date getUbirthday() {
		return ubirthday;
	}
	public void setUbirthday(Date ubirthday) {
		this.ubirthday = ubirthday;
	}
	public String getUprofile() {
		return uprofile;
	}
	public void setUprofile(String uprofile) {
		this.uprofile = uprofile;
	}
	
	
	
}
