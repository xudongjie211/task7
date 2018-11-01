package com.jnshu.pojo;

public class Course {
	public long cid;
    public long getCid() {
		return cid;
	}
	public void setCid(long cid) {
		this.cid = cid;
	}
	public String coursename;
    public String intro;
    public String careerThreshold;
    public String difficulty;
    public String skills;
    public  String growth;
    public  String companyCount;
    public  String firstSalary;
    public  String secondSalary;
    public  String thirdSalary;
    public long create_at;
    public long update_at;
    
    
    public Course(){}
	public Course(String coursename, String intro, String careerThreshold, String difficulty, String skills,
			String growth, String companyCount, String firstSalary, String secondSalary, String thirdSalary,
			long create_at) {
		super();
	
		this.coursename = coursename;
		this.intro = intro;
		this.careerThreshold = careerThreshold;
		this.difficulty = difficulty;
		this.skills = skills;
		this.growth = growth;
		this.companyCount = companyCount;
		this.firstSalary = firstSalary;
		this.secondSalary = secondSalary;
		this.thirdSalary = thirdSalary;
		this.create_at = create_at;
	}

	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getCareerThreshold() {
		return careerThreshold;
	}
	public void setCareerThreshold(String careerThreshold) {
		this.careerThreshold = careerThreshold;
	}
	public String getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public String getGrowth() {
		return growth;
	}
	public void setGrowth(String growth) {
		this.growth = growth;
	}
	public String getCompanyCount() {
		return companyCount;
	}
	public void setCompanyCount(String companyCount) {
		this.companyCount = companyCount;
	}
	public String getFirstSalary() {
		return firstSalary;
	}
	public void setFirstSalary(String firstSalary) {
		this.firstSalary = firstSalary;
	}
	public String getSecondSalary() {
		return secondSalary;
	}
	public void setSecondSalary(String secondSalary) {
		this.secondSalary = secondSalary;
	}
	public String getThirdSalary() {
		return thirdSalary;
	}
	public void setThirdSalary(String thirdSalary) {
		this.thirdSalary = thirdSalary;
	}
	public long getCreate_at() {
		return create_at;
	}
	public void setCreate_at(long create_at) {
		this.create_at = create_at;
	}
	public long getUpdate_at() {
		return update_at;
	}
	public void setUpdate_at(long update_at) {
		this.update_at = update_at;
	}
	@Override
	public String toString() {
		return "Course [coursename=" + coursename + ", intro=" + intro + ", careerThreshold=" + careerThreshold
				+ ", difficulty=" + difficulty + ", skills=" + skills + ", growth=" + growth + ", companyCount="
				+ companyCount + ", firstSalary=" + firstSalary + ", secondSalary=" + secondSalary + ", thirdSalary="
				+ thirdSalary + ", create_at=" + create_at + "]";
	}
	

	
	
	
}
