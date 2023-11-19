public class Output {
    public static void displayResult(int articleNumber, String title, String content) {
        System.out.println("Article Number: " + articleNumber);
        System.out.println("Title: " + title);
        System.out.println("Content:\n" + content);
    }

    public static void displayNotFound() {
        System.out.println("Article not found.");
    }
    public static void print(String words) {
        System.out.println(words);
    }
    public static void printResults(SearchedResults results) {
        if (results != null) {
            System.out.println("Search Results:");
            displayResult(results.getArticleNumber(), results.getTitle(), results.getContent());
        } else {
            displayNotFound();
        }
    }
}
