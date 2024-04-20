package pstudio.j063;
public class Todo {
    private String title;
    private String content;
    private String deadline;
    private String category;

    // 생성자 - 제목만으로 생성
    public Todo(String title) {
        this.title = title;
    }

    // 생성자 - 모든 일정정보로 생성
    public Todo(String title, String content, String deadline, String category) {
        this.title = title;
        this.content = content;
        this.deadline = deadline;
        this.category = category;
    }

    // Getter and Setter methods
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    // toString method

    public String toString() {
        return "Todo{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", deadline='" + deadline + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
