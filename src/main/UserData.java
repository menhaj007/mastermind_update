package main;

public class UserData {
    int id;
    int correct;
    int incorrect;
    int wrong;
    String userGuess;
    String computerGeneratedCode;
    int userId;

    public UserData() {
    }
    public UserData(int id, int correct, int incorrect, int wrong, String userGuess, String computerGeneratedCode, int userId) {
        this.id = id;
        this.correct = correct;
        this.incorrect = incorrect;
        this.wrong = wrong;
        this.userGuess = userGuess;
        this.computerGeneratedCode = computerGeneratedCode;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserGuess() {
        return userGuess;
    }

    public void setUserGuess(String userGuess) {
        this.userGuess = userGuess;
    }

    public String getComputerGeneratedCode() {
        return computerGeneratedCode;
    }

    public void setComputerGeneratedCode(String computerGeneratedCode) {
        this.computerGeneratedCode = computerGeneratedCode;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    @Override
    public String toString() {
        return "" + id + "\n" +
        correct + "\n" +
        incorrect + "\n" +
        wrong + "\n" +
        userGuess + "\n" +
        computerGeneratedCode + "\n" +
        userId;
    }

    public int getCorrect() {
        return correct;
    }

    public void setCorrect(int correct) {
        this.correct = correct;
    }

    public int getIncorrect() {
        return incorrect;
    }

    public void setIncorrect(int incorrect) {
        this.incorrect = incorrect;
    }

    public int getWrong() {
        return wrong;
    }

    public void setWrong(int wrong) {
        this.wrong = wrong;
    }
}
