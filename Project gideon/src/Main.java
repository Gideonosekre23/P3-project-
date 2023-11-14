import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter user input:");
        String userInput = scanner.nextLine();
        scanner.close();
        Application application = new Application();
        Integer articleNumber = application.extractArticleNumber(userInput);
        Input input = new Input(articleNumber);

        SearchedResults result = application.searchArticle(input.getUserInput());
        Output.printResults(result);




    }
}