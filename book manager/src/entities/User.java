package entities;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static entities.BookStatus.*;


public class User {
  private String name;
  private String userName;
  private String email;
  private LocalDate birthDay;
  private List<Book> bookList = new ArrayList<>();

  public User() {
  }

  public User(String name, String userName, String email, LocalDate birthDay) {
    this.name = name;
    this.userName = userName;
    this.email = email;
    this.birthDay = birthDay;

  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public LocalDate getBirthDay() {
    return birthDay;
  }

  public List<Book> getList() {
    return bookList;
  }

  public void addBook(Book book) {
    bookList.add(book);
  }

  public void removeBook(Book book) {
    bookList.remove(book);
  }

  public void listBooks() {
    if (bookList.isEmpty()) {
      System.out.println("There are no books in your list");
    } else {
      for (Book b : bookList) {

        System.out.println("--------------");
        System.out.println("Title: " + b.getTitle());
        System.out.println("Author: " + b.getAuthor());
        System.out.println("Status: " + b.getStatus());
        System.out.println("--------------");
      }
    }
  }

  public void listRead() {
    for (Book b : bookList) {
      if (b.getStatus() == READ) {
        System.out.println("--------------");
        System.out.println("Title: " + b.getTitle());
        System.out.println("Author: " + b.getAuthor());
        System.out.println("Status: " + b.getStatus());
        System.out.println("--------------");
      }
    }
  }

  public void listByStatus(BookStatus status) {
    boolean hasBooks = false;

    for (Book b : bookList) {
      if (b.getStatus() == status) {
        if (!hasBooks) {
          System.out.println("Livros com status: " + status);
        }
        hasBooks = true;
        System.out.println("--------------");
        System.out.println("Title: " + b.getTitle());
        System.out.println("Author: " + b.getAuthor());
        System.out.println("Status: " + b.getStatus());
        System.out.println("--------------");
      }
    }

    if (!hasBooks) {
      System.out.println("There's no books with the Status: " + status);
    }
  }

  public boolean hasThisBook(String title) {
    for (Book b : bookList) {
      if (b.getTitle().equalsIgnoreCase(title)) {
        return true;
      }
    }
    return false;
  }

  public Book getBookByTitle(String title) {
    for (Book b : bookList) {
      if (b.getTitle().equalsIgnoreCase(title)) {
        return b;
      }
    }
    return null;
  }

  public void collectionStatus() {
    if (bookList.isEmpty()) {
      System.out.println("No books in the collection yet.");
      return;
    }

    int read = 0;
    int reading = 0;
    int wantToRead = 0;

    for (Book b : bookList) {
      if (b.getStatus() == READ) {
        read++;
      } else if (b.getStatus() == READING) {
        reading++;
      } else {
        wantToRead++;
      }
    }
    System.out.println("📚 ---- Collection Stats ----");
    System.out.println("✅ Books read:      " + read);
    System.out.println("📖 Currently reading: " + reading);
    System.out.println("🕓 Want to read:     " + wantToRead);
    System.out.println("📚 Total books:     " + (read + reading + wantToRead));
    System.out.println("-----------------------------");
  }
}
