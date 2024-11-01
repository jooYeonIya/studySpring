package domain;

import javax.persistence.*;

@Entity
@Table(name="employee")
public class Employee {
    @Id
    @Column(name="emp_id", length=6)
    private String empId;
    private String empName;

    // @OneToMany FetchType.LAZY 지연 로딩
    // @OneToOne // fatch type: EAGER 즉시 로딩 - 무조건 다 가져와
    // @OneToOne(fetch = FetchType.LAZY) 따로 설정해줄 수도 있음
    @ManyToOne(fetch = FetchType.LAZY) // 기본 타입은 fatch type: EAGER
    //@Entity 또는 @Column 에서 카멜케이스를 사용할 경우 JPA가 스네이크 케이스로 변경해서 쿼리 날림.
    @JoinColumn(name="dept_id")
    private Department dept;
    private String joinDate;
    private long salary;

    public Employee() {

    }

    public Employee(String empId, String empName, Department dept, String joinDate, long salary) {
        this.empId = empId;
        this.empName = empName;
        this.dept = dept;
        this.joinDate = joinDate;
        this.salary = salary;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }
}
