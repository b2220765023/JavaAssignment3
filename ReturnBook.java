import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**

 * The ReturnBook class represents the process of returning a borrowed book by a member.

 * It updates the book and member records in the library system.
 */
public class ReturnBook {
    /**

     * Constructs a ReturnBook object with the given book ID, member ID, and return date.

     * It calculates the late fee if the book is returned after the extended date.

     * It updates the book and member records accordingly.

     * @param bookID the ID of the book being returned

     * @param memberID the ID of the member who is returning the book

     * @param returnDate the date on which the book is being returned
     */
    protected ReturnBook(int bookID, int memberID,String returnDate){

        // Parses the extended date of the book to check if it is returned after the extended date
        LocalDate dateExtention = LocalDate.parse(Main.allBooks.get(bookID-1).getExtendedDate());
        int fee = 0;
        if (((int) ChronoUnit.DAYS.between(dateExtention,LocalDate.parse(returnDate)))> 0){
            fee = (int) ChronoUnit.DAYS.between(dateExtention,LocalDate.parse(returnDate));
        }
        // Prints a message indicating the book has been returned and any applicable late fee
        Writer.Print("The book ["+bookID+"] was returned by member ["+memberID+"] at "+returnDate+" Fee: "+fee,true);
        // Updates the book and member records in the library system
        Main.allBooks.get(bookID-1).setIsAvailable(true);
        Main.allBooks.get(bookID-1).setReadInLibrary(false);
        Main.allBooks.get(bookID-1).isBorrowed = false;
        Main.allMembers.get(memberID-1).timesBorrowed--;
        Main.allMembers.get(memberID-1).HasBookIDs.remove(Integer.valueOf(bookID));
        Main.allMembers.get(memberID-1).HasReadInLibraryBookIDs.remove(Integer.valueOf(bookID));
    }
}
