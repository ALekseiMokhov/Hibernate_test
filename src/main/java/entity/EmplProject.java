package entity;

import java.util.Objects;

public class EmplProject {
    private long ID;
    private long employeeId;
    private long projectId;

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public EmplProject() {
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmplProject that = (EmplProject) o;
        return getID() == that.getID() &&
                getEmployeeId() == that.getEmployeeId() &&
                getProjectId() == that.getProjectId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getID(), getEmployeeId(), getProjectId());
    }

    @Override
    public String toString() {
        return "EmplProject{" +
                "ID=" + ID +
                ", employeeId=" + employeeId +
                ", projectId=" + projectId +
                '}';
    }
}
