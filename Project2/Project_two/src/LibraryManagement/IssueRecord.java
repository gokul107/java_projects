package LibraryManagement;

import java.time.LocalDate;

public class IssueRecord {

    private String studentId;
    private LocalDate issueDate;
    private LocalDate dueDate;

    public IssueRecord(String studentId) {
        this.studentId = studentId;
        this.issueDate = LocalDate.now();
        this.dueDate = issueDate.plusDays(7);
    }

    public String getStudentId() {
        return studentId;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }
}
