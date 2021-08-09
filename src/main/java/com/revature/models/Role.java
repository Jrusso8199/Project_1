package com.revature.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity


public enum Role {
	EMPLOYEE,
	MANAGER;
private int id;
@Id
public int getId() {
	return id;
}
	

}
