package com.gowri.tech.entity;

import java.util.*;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

/**
 * @author -NaveenWodeyar
 * @date -17-Nov-2024
 * @time - 7:23:24 pm
 * @location -
 */
@Entity
public class Projects {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer projectId;
	
	@NotNull(message = "Project name cannot be null")  
    @Min(value = 100000, message = "Pin must be at least 6 digits")  
    @JsonProperty("PROJECT_NAME") 
	private String projectName;
	
	@NotNull(message = "Project Lead cannot be null")  
    @Min(value = 100000, message = "Pin must be at least 6 digits")  
    @JsonProperty("PROJECT_LEAD") 
	private String pojectLead;
	
	@NotNull(message = "Project type cannot be null")  
    @Min(value = 100000, message = "Pin must be at least 6 digits")  
    @JsonProperty("PROJECT_TYPE") 
	private String projectType;
	
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinTable(name = "EMP_PROJECT_TABLE",joinColumns = {
			@JoinColumn(referencedColumnName = "projectId",name = "projectId")
	},
	inverseJoinColumns = {
			@JoinColumn(referencedColumnName = "empId",name = "employeeId")
	})
	private List<EmployeesTable> employeesTable;
	
	public Projects() {}

	/**
	 * @param projectId
	 * @param projectName
	 * @param pojectLead
	 * @param projectType
	 * @param employeesTable
	 */
	public Projects(Integer projectId, String projectName, String pojectLead, String projectType,
			List<EmployeesTable> employeesTable) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.pojectLead = pojectLead;
		this.projectType = projectType;
		this.employeesTable = employeesTable;
	}

	/**
	 * @return the projectId
	 */
	public Integer getProjectId() {
		return projectId;
	}

	/**
	 * @param projectId the projectId to set
	 */
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	/**
	 * @return the projectName
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * @param projectName the projectName to set
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/**
	 * @return the pojectLead
	 */
	public String getPojectLead() {
		return pojectLead;
	}

	/**
	 * @param pojectLead the pojectLead to set
	 */
	public void setPojectLead(String pojectLead) {
		this.pojectLead = pojectLead;
	}

	/**
	 * @return the projectType
	 */
	public String getProjectType() {
		return projectType;
	}

	/**
	 * @param projectType the projectType to set
	 */
	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

	/**
	 * @return the employeesTable
	 */
	public List<EmployeesTable> getEmployeesTable() {
		return employeesTable;
	}

	/**
	 * @param employeesTable the employeesTable to set
	 */
	public void setEmployeesTable(List<EmployeesTable> employeesTable) {
		this.employeesTable = employeesTable;
	}

	@Override
	public int hashCode() {
		return Objects.hash(employeesTable, pojectLead, projectId, projectName, projectType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Projects other = (Projects) obj;
		return Objects.equals(employeesTable, other.employeesTable) && Objects.equals(pojectLead, other.pojectLead)
				&& Objects.equals(projectId, other.projectId) && Objects.equals(projectName, other.projectName)
				&& Objects.equals(projectType, other.projectType);
	}

	@Override
	public String toString() {
		return "Projects [projectId=" + projectId + ", projectName=" + projectName + ", pojectLead=" + pojectLead
				+ ", projectType=" + projectType + ", employeesTable=" + employeesTable + "]";
	}
	
	
	
}
