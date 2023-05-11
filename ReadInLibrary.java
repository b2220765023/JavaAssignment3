import java.time.LocalDate;

/**

 * The ReadInLibrary class contains a static method that updates the status of a book to indicate that it was read in the library by a member on a specific date.
 */
public class ReadInLibrary {
    /**

     * Updates the status of a book to indicate that it was read in the library by a member on a specific date.
     * Also updates the member's list of books they have read in the library.
     * @param bookId the ID of the book that was read in the library
     * @param memberId the ID of the member who read the book in the library
     * @param date the date the book was read in the library
     */
    public static void main(int bookId,int memberId,String date) {
        // Prints a message indicating that the book was read in the library by the member on the specified date
        Writer.Print("The book ["+bookId+"] was read in library by member ["+memberId+"]"+" at " +date,true);
        // Sets the availability of the book to false, indicating that it is not available to be borrowed
        Main.allBooks.get(bookId-1).setIsAvailable(false);
        // Sets the borrowed date of the book to the specified date
        Main.allBooks.get(bookId-1).setBorrowedDate(date);
        // Sets the extended date of the book to one year from the borrowed date
        Main.allBooks.get(bookId-1).setExtendedDate(String.valueOf(LocalDate.parse(date).plusDays(365)));
        // Sets the read in library status of the book to true
        Main.allBooks.get(bookId-1).setReadInLibrary(true);
        // Adds the book to the member's list of books they have read in the library
        Main.allMembers.get(memberId-1).HasReadInLibraryBookIDs.add(Integer.valueOf(bookId));
    }
}
