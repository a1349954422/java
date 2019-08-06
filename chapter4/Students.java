package studentsStore;

public class Students {
    private String last_name;
    private String first_name;
    private double score;

    public Students() {
    }

    public Students(String last_name, String first_name, double score) {
        this.last_name =last_name;
        this.first_name = first_name;
        this.score = score;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
