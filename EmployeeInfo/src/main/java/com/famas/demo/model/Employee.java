package com.famas.demo.model;

public class Employee {
	
		private int employeeID;
		private String employeeName;
		private String employeePost;
		private String employeeEmail;
		private int employeeSalary;
		private Avatar avatar;
		
		public int getEmployeeID() {
			return employeeID;
		}
		public void setEmployeeID(int employeeID) {
			this.employeeID = employeeID;
		}
		public String getEmployeeName() {
			return employeeName;
		}
		public void setEmployeeName(String employeeName) {
			this.employeeName = employeeName;
		}
		public String getEmployeePost() {
			return employeePost;
		}
		public void setEmployeePost(String employeePost) {
			this.employeePost = employeePost;
		}
		public String getEmployeeEmail() {
			return employeeEmail;
		}
		public void setEmployeeEmail(String employeeEmail) {
			this.employeeEmail = employeeEmail;
		}
		public int getEmployeeSalary() {
			return employeeSalary;
		}
		public void setEmployeeSalary(int employeeSalary) {
			this.employeeSalary = employeeSalary;
		}
		public Employee(int employeeID, String employeeName, String employeePost, String employeeEmail,
				int employeeSalary) {
			super();
			this.employeeID = employeeID;
			this.employeeName = employeeName;
			this.employeePost = employeePost;
			this.employeeEmail = employeeEmail;
			this.employeeSalary = employeeSalary;
		}
		public Employee() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Avatar getAvatar() {
			return avatar;
		}
		public void setAvatar(Avatar avatar) {
			this.avatar = avatar;
		}
		

}
