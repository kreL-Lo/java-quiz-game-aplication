package models.server.mongo;

public class QuestionAnswer {
    int right;
    int wrong;

    public void setRight(int right) {
        this.right = right;
    }

    public void setWrong(int wrong) {
        this.wrong = wrong;
    }

    public int getRight() {
        return right;
    }

    public int getWrong() {
        return wrong;
    }
}
