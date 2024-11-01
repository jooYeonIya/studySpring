package domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="dept")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="dept_id")
    private int deptId;
    @Column(name="dept_name", length = 10, nullable = false)
    private String deptName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id")
    private Company company;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
// 연관 관계의 주인이 누구인지 설정해주기!
    // 연관 관계의 주인은 FK가 있는 쪽, 필드명 써주기
//    @OneToMany(mappedBy = "dept")
//    List<Employee> employeeList = new ArrayList<Employee>();

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

//    public List<Employee> getEmployeeList() {
//        return employeeList;
//    }
}
