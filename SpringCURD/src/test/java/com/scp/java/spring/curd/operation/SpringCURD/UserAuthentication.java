package com.scp.java.spring.curd.operation.SpringCURD;

public class UserAuthentication {
	
	public String authenticateUser(String userName,String password){
		
		String dbUserName="Deepali";
		String dbPassword="Dsk@143";
		
		String returnVal=AppMessages.LOGIN_INVALID;
		if (userName==null || userName.equals(AppMessages.BLANK_SPACE)) {
			returnVal=AppMessages.USERNAME_EMPTY;
		}
		else if (password==null || password.equals(AppMessages.BLANK_SPACE)) {
			returnVal=AppMessages.PASSWORD_EMPTY;
		}
		else if (dbUserName.equals(userName.trim()) && dbPassword.equals(password.trim())) {
			returnVal=AppMessages.LOGIN_SUCCESS;
		}
		return returnVal;
	}
 }

interface AppMessages{
	String LOGIN_INVALID="Invalid Credential";
	String LOGIN_SUCCESS="Login Successfully";
	String USERNAME_EMPTY="UserName can not Empty";
	String PASSWORD_EMPTY="Password can not Empty";
	String BLANK_SPACE="";
}
