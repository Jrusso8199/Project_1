package com.revature.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user_role")
public class UserRole {
	
	@Id
	private int roleId;
	private String type;
	@OneToMany(mappedBy="role")
	private List<User> users;
	
	
	
	public void setId(int id) {
		this.roleId = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getId() {
		return roleId;
	}
	@Override
	public String toString() {
		return "UserRole [id=" + roleId + ", type=" + type + "]";
	}
	
	

	
}
