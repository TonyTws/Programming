import java.util.*;

public class Arrays1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Document> documents = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            documents.add(new Document(sc.nextInt(), sc.next(), sc.next(), sc.nextDouble()));
        }
        Collections.sort(documents);
        for(Document document : documents){
            if(document.getPages() % 2 != 0) {
                System.out.println(document.getId() + " " + document.getTitle() + " " + document.getFolderName() + " " +  (int) document.getPages());
            }
        }
    }

}
class Document implements Comparable<Document>
{
    int id;
    String title;
    String folderName;
    double pages;

    public Document(int id, String title, String author, double price) {
        this.id = id;
        this.title = title;
        this.folderName = author;
        this.pages = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public double getPages() {
        return pages;
    }

    public void setPages(double pages) {
        this.pages = pages;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    @Override
    public int compareTo(Document o) {
        double id = o.getId();
        return (int)(this.id - id);
    }
}

