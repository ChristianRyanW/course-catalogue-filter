package com.webservice.home;

public class DataClass {

	public static class loginStatus{
		private String status;
		private String token;
		
		public void setStatus(String status, String token) {
			this.status = status;
			this.token = token;
		}
		
		public String getstatus() {return status;}
		public String gettoken() {return token;}
	}
	
	public static class RegisterStatus{
		private String status;
		private String message;
		
		public void setStatus(String status, String message) {
			this.status = status;
			this.message = message;
		}
		
		public String getstatus() {return status;}
		public String getmessage() {return message;}
	}
	
	public static class CourseData{
		private String course_subject;
		private String course_number;
		private String course_name;
		private String course_desc;
		
		public void setClass(String course_subject, String course_number, String course_name, String course_desc) {
			this.course_subject = course_subject;
			this.course_number = course_number;
			this.course_name = course_name;
			this.course_desc = course_desc;
		}
		
		public String getcourse_subject() {return course_subject;}
		public String getcourse_number() {return course_number;}
		public String getcourse_name() {return course_number;}
		public String getcourse_desc() {return course_number;}
	}
}
