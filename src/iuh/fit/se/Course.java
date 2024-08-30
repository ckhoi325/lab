/*
*@ (#) Course.java		1.0 Aug 29, 2024
*
*Copyright (c) 2024 IUH. All rights reserved
*/
package iuh.fit.se;
/*
*@description:
*@author: Chu Anh Khoi
*@date: Aug 29, 2024
*version: 1.0
*/
public class Course {
	private int credit;
	private String department;
	private String id;
	private String title;
	
	public Course() {
		this(0,"","","");
	}

	public Course(int credit, String department, String id, String title) {
		this.credit=credit;
		this.department=department;
		this.id=id;
		this.title=title;
	}
	
	
	public void setCredit(int credit){
		if(credit<0) 
			throw new IllegalArgumentException("credit must greater than 0");
		this.credit=credit;
	}
	public int getCredit() {
		return credit;
	}
	
	
	public void setDepartment(String department) {
		if(department==null || department.trim().length()==0)
			throw new IllegalArgumentException("Length of the array must be greater than 0");
		this.department=department;	
	}
	public String getDepartment() {
		return department;		
	}
	
	
	public void setId(String id) {
        if (id == null || id.trim().length() < 3)
            throw new IllegalArgumentException("ID must have at least 3 characters");
        for (int i=0;i<id.length();i++){
            char c = id.charAt(i);
            if (!Character.isLetterOrDigit(c))
                throw new IllegalArgumentException("ID must contain only letters or digits");
        }
        this.id = id;
    }
	public String getId() {
		return id;
	}
	
	
	public void setTitle(String title) {
		if(title == null || title.trim().length()<0)
			throw new IllegalArgumentException("Title must not be empty");
		this.title=title;
	}
	public String getTitle() {
		return title;
	}
	@Override
	public String toString() {
		return String.format("%-10s%-20s%-10s%-20s",credit,department,id,title);
	}
	
	
	
	
	

}
