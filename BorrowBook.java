import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**

 * The BorrowBook class represents the borrowing of a book by a member.
 * It sets the borrowed date, extended date, availability and borrow status of the book.
 * It also increments the number of times the member has borrowed books and adds the borrowed book ID to the member's list of borrowed book IDs.
 */
public class BorrowBook {
    /**

     * Constructor to create a BorrowBook object and set the borrowed date, extended date, availability and borrow status of the book.
     * It also increments the number of times the member has borrowed books and adds the borrowed book ID to the member's list of borrowed book IDs.
     * @param bookID the ID of the book being borrowed
     * @param memberID the ID of the member who is borrowing the book
     * @param borrowedDate the date the book is being borrowed
     * @param memberType the type of the member borrowing the book (student or academic)
     */
    protected BorrowBook(String bookID,String memberID, String borrowedDate, String memberType){
        // Creates a DateTimeFormatter object with pattern "yyyy-MM-dd"
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Parses the borrowedDate string to LocalDate using the specified DateTimeFormatter object
        LocalDate dateBorrowed = LocalDate.parse(borrowedDate,format);
        // Sets the extension date based on the member type and the date borrowed
        LocalDate dateExtention = dateBorrowed;
        if (memberType.equals("S")) {
            dateExtention = dateExtention.plusDays(7);
        } else if (memberType.equals("A")) {
            dateExtention = dateExtention.plusDays(14);
        }
        // Formats the extension date to a string using the specified DateTimeFormatter object
        String extentionDateStr = dateExtention.format(format);

        // Sets the extended date, borrowed date, and availability status of the book based on the book ID
        Main.allBooks.get(Integer.parseInt(bookID)-1).setExtendedDate(extentionDateStr);
        Main.allBooks.get(Integer.parseInt(bookID)-1).setBorrowedDate(borrowedDate);
        Main.allBooks.get(Integer.parseInt(bookID)-1).setIsAvailable(false);
        Main.allBooks.get(Integer.parseInt(bookID)-1).isBorrowed = true;
        // Increases the timesBorrowed counter of the member based on the member ID
        Main.allMembers.get(Integer.parseInt(memberID)-1).timesBorrowed++;
        // and adds the book ID to the member's HasBookIDs list
        Main.allMembers.get(Integer.parseInt(memberID)-1).HasBookIDs.add(Integer.valueOf(Integer.parseInt(bookID)));
    }

}
