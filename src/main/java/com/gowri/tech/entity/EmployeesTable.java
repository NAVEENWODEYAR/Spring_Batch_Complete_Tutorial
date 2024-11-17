package com.gowri.tech.entity;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

/**
 * @author -NaveenWodeyar
 * @date -17-Nov-2024
 * @time - 7:24:53 pm
 * @location -
 */
@Entity
public class EmployeesTable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer empId;
	
	private String empName;
	
	private String empRole;
	
	private String empDept;
	
	private String empMail;
	
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinTable(name = "EMP_PROJECT_TABLE",joinColumns = {
			@JoinColumn(referencedColumnName = "empId",name = "employeeId")
	},
	inverseJoinColumns = {
			@JoinColumn(referencedColumnName = "projectId",name = "projectId")
	})
	private List<Projects> projectList;
	
	public EmployeesTable() {}

	/**
	 * @return the empId
	 */
	public Integer getEmpId() {
		return empId;
	}

	/**
	 * @param empId the empId to set
	 */
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	/**
	 * @return the empName
	 */
	public String getEmpName() {
		return empName;
	}

	/**
	 * @param empName the empName to set
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	/**
	 * @return the empRole
	 */
	public String getEmpRole() {
		return empRole;
	}

	/**
	 * @param empRole the empRole to set
	 */
	public void setEmpRole(String empRole) {
		this.empRole = empRole;
	}

	/**
	 * @return the empDept
	 */
	public String getEmpDept() {
		return empDept;
	}

	/**
	 * @param empDept the empDept to set
	 */
	public void setEmpDept(String empDept) {
		this.empDept = empDept;
	}

	/**
	 * @return the empMail
	 */
	public String getEmpMail() {
		return empMail;
	}

	/**
	 * @param empMail the empMail to set
	 */
	public void setEmpMail(String empMail) {
		this.empMail = empMail;
	}

	/**
	 * @return the projectList
	 */
	public List<Projects> getProjectList() {
		return projectList;
	}

	/**
	 * @param projectList the projectList to set
	 */
	public void setProjectList(List<Projects> projectList) {
		this.projectList = projectList;
	}

	@Override
	public int hashCode() {
		return Objects.hash(empDept, empId, empMail, empName, empRole, projectList);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeesTable other = (EmployeesTable) obj;
		return Objects.equals(empDept, other.empDept) && Objects.equals(empId, other.empId)
				&& Objects.equals(empMail, other.empMail) && Objects.equals(empName, other.empName)
				&& Objects.equals(empRole, other.empRole) && Objects.equals(projectList, other.projectList);
	}

	@Override
	public String toString() {
		return "EmployeesTable [empId=" + empId + ", empName=" + empName + ", empRole=" + empRole + ", empDept="
				+ empDept + ", empMail=" + empMail + ", projectList=" + projectList + "]";
	}
	
	
}