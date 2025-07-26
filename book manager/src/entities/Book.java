package entities;

public class Book {
  String title;
  String author;
  BookStatus status;

  public Book(){

  }
  public Book(String title, String author, BookStatus status) {
    this.title = title;
    this.author = author;
    this.status = status;
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

  public BookStatus getStatus() {
    return status;
  }

  public void setStatus(BookStatus status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "Title: " + title +
      "\n" + "Author: " + author +
      "\n" + "Status: " + status;

  }
}

