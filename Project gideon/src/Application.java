import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    private static final String URL = "jdbc:sqlite:C:/Users/gideo/OneDrive/Desktop/P3 Database/constitution.db";
    private static final String USER = "";
    private static final String PASSWORD = "";
    public Integer extractArticleNumber(String input) {
        // Define a regular expression to match article numbers like "Article 1" or "article one"
        String regex = "(?i)(what is )?article\\s*(\\d+)";
        // The regular expression uses "(?i)" for case-insensitive matching.

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            // Extract the matched number
            String numberStr = matcher.group(2);

            try {
                // Parse the number as an integer
                return Integer.parseInt(numberStr);
            } catch (NumberFormatException e) {
                // Handle any parsing errors here, such as if the number is not valid
                System.out.println("Error parsing number: " + numberStr);
            }
        }


        return -1;
    }


    public static SearchedResults searchArticle(int articleNumber) {
            try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
                String sql = "SELECT * FROM article WHERE number = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setInt(1, articleNumber);
                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
                        if (resultSet.next()) {
                            String title = resultSet.getString("title");
                            String content = resultSet.getString("content");
                            return new SearchedResults(articleNumber, title, content);
                        } else {
                            return null;
                        }
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }
    }





