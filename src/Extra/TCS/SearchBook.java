package Extra.TCS;

import java.util.*;

public class SearchBook {
    public static void main(String[] args )  {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Book[] books = new Book[4];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            int id = sc.nextInt();
            sc.nextLine();
            String title = sc.nextLine().toLowerCase();
            String author = sc.nextLine().toLowerCase();
            double price= sc.nextDouble();
            books[i] = new Book(id,title, author,price);
        }
        String word = sc.next().toLowerCase();
        for (Book b : searchTitle(books,word)){
            System.out.println(b.getId());
        }
    }

    private static Book[] searchTitle(Book[] books, String word) {
        List<Book> list = new ArrayList<>();
        for(Book b : books){
            String str = b.getTitle();
            int index = str.indexOf(word);
            if(index != -1){
                list.add(b);
            }
        }
        Collections.sort(list, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getId() - o2.getId();
            }
        });
        Book[] books1 = new Book[list.size()];
        for (int i = 0; i < books1.length; i++) {
            books1[i] = list.get(i);
        }
        return books1;
    }
}

class Book{
    int id;
    String title;
    String author;
    double price;

    public Book(int id, String title, String author, double price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
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

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}