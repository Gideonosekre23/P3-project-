import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        while (true)
        {
            Output.print("Enter Article:");
            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("exit"))
            {
                Output.print("Exiting the program.");
                break;
            }

            Application application = new Application();
            Integer articleNumber = application.extractArticleNumber(userInput);
            Input input = new Input(articleNumber);

            SearchedResults result = application.searchArticle(input.getUserInput());
            Output.printResults(result);



        }

        scanner.close();

    }
}