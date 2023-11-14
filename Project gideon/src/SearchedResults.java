public class SearchedResults {
    private int articleNumber;
    private String title;
    private String content;

    public SearchedResults(int articleNumber, String title, String content) {
        this.articleNumber = articleNumber;
        this.title = title;
        this.content = content;
    }

    public int getArticleNumber() {
        return articleNumber;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}


