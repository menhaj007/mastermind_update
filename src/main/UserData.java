package main;

public class UserData {
    int id;
    String computerFeedback;
    String userGuess;
    String computerGeneratedCode;
    int userId;

    public UserData() {
    }
    public UserData(int id, String computerFeedback, String userGuess, String computerGeneratedCode, int userId) {
        this.id = id;
        this.computerFeedback = computerFeedback;
        this.computerGeneratedCode = computerGeneratedCode;
        this.userGuess = userGuess;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComputerFeedback() {
        return computerFeedback;
    }

    public void setComputerFeedback(String computerFeedback) {
        this.computerFeedback = computerFeedback;
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
        computerFeedback + "\n" +
        userGuess + "\n" +
        computerGeneratedCode + "\n" +
        userId;
    }
}
