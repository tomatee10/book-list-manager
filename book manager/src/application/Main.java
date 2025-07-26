package application;

import entities.*;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int controler = 0;
    String birthDay = "02-10-2006";
    User user = new User("Daniel", "Tomtee", "daniel@gmail.com", LocalDate.parse("2006-02-10"));

    System.out.println("Books Control");
    System.out.println("--------------");
    do {
      System.out.println("Select a option: ");
      System.out.println("[1] Add book");
      System.out.println("[2] Remove book");
      System.out.println("[3] Edit book staus");
      System.out.println("[4] Search a book");
      System.out.println("[5] Book list");
      System.out.println("[6] Filter by status");
      System.out.println("[7] Collection stats");
      System.out.println("[8] Close");
      controler = input.nextInt();
      input.nextLine();//buffer cleaner

      switch (controler) {
        case 1:
          System.out.print("Book title: ");
          String title = input.nextLine();
          System.out.print("Author: ");
          String author = input.nextLine();
          System.out.print("Status: ");
          String statusInput = input.nextLine().toUpperCase().replace(" ", "_");
          try {
            BookStatus status = BookStatus.valueOf(statusInput);
            Book book = new Book(title, author, status);
            user.addBook(book);
            System.out.println("book added successfully !");
          } catch (IllegalArgumentException e) {
            System.out.println("Invalid Status! Try again using: READ, READING, WANT_TO_READ.");
          }

          break;

        case 2:
          System.out.println("Enter the title of the book you want to remove");
          String titleToRemove = input.nextLine();
          Book foundBook = null;

          for (Book b : user.getList()) {
            if (b.getTitle().equalsIgnoreCase(titleToRemove)) {
              foundBook = b;
              break;
            }
          }
          if (foundBook != null) {
            user.removeBook(foundBook);
            System.out.println("Book removed");
          } else {
            System.out.println("Book not found");
          }
          break;

        case 3:
          System.out.print("Wich book do you want do edit the status ? ");
          String editBook = input.nextLine();
          if (user.hasThisBook(editBook)) {
            Book toEdit = user.getBookByTitle(editBook);

            System.out.println("Corrent status: " + toEdit.getStatus());
            System.out.println("Select a new status: (READ, WANT TO READ, READING)");
            String newStatusStr = input.nextLine().toUpperCase().replace(" ", "_");

            try {
              BookStatus newStatus = BookStatus.valueOf(newStatusStr);
              toEdit.setStatus(newStatus);
              System.out.println("Status updated successfully!");
            } catch (IllegalArgumentException e) {
              System.out.println("Invalid status entered. Try again with READ, UNREAD or READING.");
            }
          } else {
            System.out.println("Book not found");
          }
          break;
        case 4:
          System.out.println("enter a book name: ");
          String bookSearch = input.nextLine();
          Book foundedBook;
          if (user.hasThisBook(bookSearch)) {
            foundedBook = user.getBookByTitle(bookSearch);
            System.out.println(foundedBook.toString());
          } else {
            System.out.println("Book not found");
          }
          break;
        case 5:
          System.out.println("Your Books:");
          user.listBooks();
          break;

        case 6:
          System.out.println("Select a status (READ, READING, WAIT_TO_READ): ");
          String bookStatus = input.nextLine().toUpperCase().replace(" ", "_");

          if (bookStatus.equals("READ")) {
            user.listByStatus(BookStatus.READ);
          } else if (bookStatus.equals("READING")) {
            user.listByStatus(BookStatus.READING);
          } else if (bookStatus.equals("WANT_TO_READ")) {
            user.listByStatus(BookStatus.WANT_TO_READ);
          } else {
            System.out.println("Invalid Status");
          }
          break;

        case 7:
          user.collectionStatus();
          break;

        case 8:
          System.out.println("Closing...");
          break;
        default:
          System.out.println("Invalid option");
      }

    } while (controler != 8);
  }
}