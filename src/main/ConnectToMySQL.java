package main;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * ConnectToMySQL uses jdbc driver to establish connection with mysql. At the end of this page the commands for creating
 * table using SQL is provided.
 *
 */
public class ConnectToMySQL {
    public static void readFeedback() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mastermind", "menhajsharaf", "helloworld.com");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM computer_feedback");
            while (resultSet.next()) {
                String userData = resultSet.getString("id") +  "\t" + resultSet.getString("userName") + "\t" + resultSet.getString("correctNumberLocation") + "\t" + resultSet.getString("correctNumberOnly") + "\t" + resultSet.getString("incorrectGuess")+ "." ;
                System.out.println(userData);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void writeFeedbackIntoDB(HashMap<String, Integer> userFeedbackObj, String userName) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mastermind", "menhajsharaf", "helloworld.com");
            Statement statement = connection.createStatement();
            String sqlCommand = "INSERT INTO computer_feedback (userName, correctNumberLocation, correctNumberOnly, incorrectGuess)" + "VALUES ('" + userName + "'" + "," +"'"+ userFeedbackObj.get("correctNumberLocation") +"'" +"," +"'"+ userFeedbackObj.get("correctNumberOnly") +"'"+ "," + userFeedbackObj.get("incorrectGuess") + ")";
            ResultSet resultSet = statement.executeQuery("SELECT * FROM computer_feedback");
            //statement.executeQuery(sqlCommand);
            statement.executeUpdate(sqlCommand);
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void writeInputHistoryIntoDB(String userNameValue, String resultValue) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mastermind", "menhajsharaf", "helloworld.com");
            Statement statement = connection.createStatement();
            String sqlCommand = "INSERT INTO user_input_history (userName, userInput)" + "VALUES ('"+ userNameValue +"'"+ "," + resultValue + ")";
            statement.executeUpdate(sqlCommand);
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void readUserInputHistoryFromDB() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mastermind", "menhajsharaf", "helloworld.com");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM user_input_history");
            while (resultSet.next()) {
                String userData = resultSet.getString("id") +  "\t" + resultSet.getString("userName") + "\t" + resultSet.getString("userInput") + "." ;
                System.out.println(userData);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void deleteDataFromComputerFeedback() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mastermind", "menhajsharaf", "helloworld.com");
            Statement statement = connection.createStatement();
            String sqlCommand = "DELETE FROM computer_feedback";
            statement.executeUpdate(sqlCommand);
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void writeFeedbackGuessToDB(String userNameValue, String feedbackValue, String guessValue) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mastermind", "menhajsharaf", "helloworld.com");
            Statement statement = connection.createStatement();
            String sqlCommand = "INSERT INTO user_name_feedback_guess (userName, feedback, guess)" + "VALUES ('"+
                    userNameValue +"'"+ ",'" + feedbackValue + "'" + ",'" + guessValue + "')";
            statement.executeUpdate(sqlCommand);
            System.out.println("successfully saved!");
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void readFeedbackGuessFromDB() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mastermind", "menhajsharaf", "helloworld.com");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM user_name_feedback_guess");
            while (resultSet.next()) {
                String userData = resultSet.getString("id") +  "\t" + resultSet.getString("userName") + "\t" + resultSet.getString("feedback") + "\t" + resultSet.getString("guess") + "." ;
                System.out.println(userData);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * ConnectToMySQL only works if the tables exist.
     */
    public static void commentedSQLCommands() {
        System.out.println("This is method includes the SQL commands and commented.");
        /*
        CREATE database mastermind;
        use mastermind;
        CREATE TABLE computer_feedback(
                id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
                userName VARCHAR(30) NULL,
                correctNumberLocation INT NULL,
                correctNumberOnly INT NULL,
                incorrectGuess INT NULL
        );
        CREATE TABLE user_input_history(
                id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
                userName VARCHAR(30) NULL,
                userInput VARCHAR(250) NULL
        );

        CREATE TABLE user_name_feedback_guess(
                id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
                userName VARCHAR(30) NULL,
                feedback VARCHAR(250) NULL,
                guess VARCHAR(250) NULL
        );
        show tables;
        desc user_name_feedback_guess;
        drop table table_name;
        */
    }

    public static Integer saveUserInToDB(String userName) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mastermind", "menhajsharaf", "helloworld.com");
            Statement statement = connection.createStatement();
            String sqlCommand = "INSERT INTO user (userName)" + "VALUES ('"+ userName + "')";
            statement.executeUpdate(sqlCommand);
            System.out.println("successfully saved!");
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getUserNameTest(userName);
    }
    private static Integer getUserNameTest(String userName) {
        Integer idFound = null;
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mastermind", "menhajsharaf", "helloworld.com");
            Statement readStatement = connection.createStatement();
            ResultSet resultSet = readStatement.executeQuery("SELECT * FROM user where userName = '" + userName +"'");
            while (resultSet.next()) {
                idFound = resultSet.getInt("id");
                String userData = resultSet.getString("id") +  "\t" + resultSet.getString("userName") + "." ;
                System.out.println(userData);
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idFound;
    }
//    @SuppressWarnings("unchecked")
    public static HashMap<Integer, String> getUserFromDB(String userName) {
        HashMap<Integer, String> userObj = new HashMap<>();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mastermind", "menhajsharaf", "helloworld.com");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM user where userName = '" + userName +"'");
            while (resultSet.next()) {
                int userId = resultSet.getInt("id");
                String user = resultSet.getString("userName");
                userObj.put(userId, user);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userObj;
    }
    public static void saveUserDataInDB(int correct, int incorrect, int wrong, String userGuess, String computerGeneratedCode, int userId) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mastermind", "menhajsharaf", "helloworld.com");
            Statement statement = connection.createStatement();
            String sqlCommand = "INSERT INTO userData (correct, incorrect, wrong, userGuess, computerGeneratedCode, userId)" +
                    "VALUES ('" + correct +"'"+ ",'" + incorrect +"'"+ ",'" + wrong +"'"+ ",'" + userGuess +"'"+ ",'" +  computerGeneratedCode +"'"+ ",'" + userId +"')";
            statement.executeUpdate(sqlCommand);
            System.out.println("successfully saved!");
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<UserData> getUserDataFromDB() {
        ArrayList<UserData> userDataList = new ArrayList<UserData>();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mastermind", "menhajsharaf", "helloworld.com");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM userData");
//            (int id, String userFeedback, String userGuess, String computerGeneratedCode, int userId)
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int correct = resultSet.getInt("correct");
                int incorrect = resultSet.getInt("incorrect");
                int wrong = resultSet.getInt("wrong");
                String userGuess = resultSet.getString("userGuess");
                String computerGeneratedCode = resultSet.getString("computerGeneratedCode");
                int userId = resultSet.getInt("userId");
                UserData userData = new UserData(id, correct, incorrect, wrong, userGuess, computerGeneratedCode, userId);
                userDataList.add(userData);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userDataList;
    }
    public static ArrayList<UserData> getUsersDataFromDb(int userId) {
        ArrayList<UserData> userDataList = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mastermind", "menhajsharaf", "helloworld.com");
            Statement readStatement = connection.createStatement();
            ResultSet resultSet = readStatement.executeQuery("SELECT * FROM userData where userId = '" + userId +"'");
            while (resultSet.next()) {
                UserData userData = new UserData();
//                resultSet.getInt("id"), resultSet.getString("computerFeedback"), resultSet.getString("userGuess"), resultSet.getString("computerGeneratedCode")
                userData.setId(resultSet.getInt("id"));
                userData.setCorrect(resultSet.getInt("correct"));
                userData.setIncorrect(resultSet.getInt("incorrect"));
                userData.setWrong(resultSet.getInt("wrong"));
                userData.setUserGuess(resultSet.getString("userGuess"));
                userData.setComputerGeneratedCode(resultSet.getString("computerGeneratedCode"));
                userData.setUserId(userId);
//                System.out.println(userData.toString());
                if (userData != null)
                    userDataList.add(userData);
                else
                    System.out.println("No data found!");
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userDataList;
    }
}
