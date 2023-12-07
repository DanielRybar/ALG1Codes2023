package assignments08_structured_data;

public class U09TestResult {

    private String firstName;
    private String lastName;
    private String studentId;
    private double points;

    public U09TestResult(String fn, String ln, String id, double points) {
        this.firstName = fn;
        this.lastName = ln;
        this.studentId = id;
        this.points = points;
    }

    public String getName() {
        return this.firstName + " " + this.lastName;
    }

    public void setFirstName(String val) {
        this.firstName = val;
    }

    public void setLastName(String val) {
        this.lastName = val;
    }

    public String getId() {
        return this.studentId;
    }

    public void setId(String val) {
        this.studentId = val;
    }

    public double getPoints() {
        return this.points;
    }

    public void setPoints(double val) {
        this.points = val;
    }

    public int getGrade() {
        if (this.points < 60) {
            return 5;
        } else if (this.points >= 60 && this.points < 70) {
            return 4;
        } else if (this.points >= 70 && this.points < 80) {
            return 3;
        } else if (this.points >= 80 && this.points < 90) {
            return 2;
        } else {
            return 1;
        }
    }

    @Override
    public String toString() {
        return String.format("Jmeno: %s, Id: %s, Body: %s",
                this.firstName + " " + this.lastName, this.studentId, this.points);
    }
}