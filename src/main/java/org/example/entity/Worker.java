package org.example.entity;

public class Worker {
    private int id;
    private String status;
    private String name;
    private String experience;
    private String education;
    private String department;

    public Worker(int id, String status, String name, String experience, String education, String department) {
        this.id = id;
        this.status = status;
        this.name = name;
        this.experience = experience;
        this.education = education;
        this.department = department;
    }

    public Worker() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "id: " + id +
                ", status: " + status +
                ", name: " + name +
                ", experience: " + experience +
                ", education: " + education +
                ", department: " + department;
    }
}


