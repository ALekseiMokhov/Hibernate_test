package entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;
@Entity
@Table(name = "PROJECT")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="TITLE")
    private String title;
    @ManyToMany(mappedBy = "projects")
    private Set<Employee> employees;

    public Project() {
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return getId() == project.getId() &&
                Objects.equals(getTitle(), project.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(),getEmployees());
    }

    @Override
    public String toString() {
        return "project{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
