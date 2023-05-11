import java.time.LocalDate;

/**

 * A class representing the action of extending the deadline of a borrowed book by a library member.
 */
public class ExtendDeadLine {
    /**

     * Constructor method that extends the deadline of a book by 7 days from the specified date.
     * @param nonExtendedDate a String representing the original date of the deadline in the format "yyyy-MM-dd".
     * @param bookID an integer representing the ID of the book being borrowed.
     * @param memberID an integer representing the ID of the member who is borrowing the book.
     */
    public ExtendDeadLine(String nonExtendedDate,int bookID,int memberID){

        LocalDate extendedDate = LocalDate.parse(nonExtendedDate).plusDays(7);

        Main.allBooks.get(bookID-1).setExtendedDate(String.valueOf(extendedDate));
        Main.allBooks.get(bookID-1).setIsExtended(true);
        Writer.Print("The deadline of book ["+bookID+"] was extended by member ["+memberID+"] at "+nonExtendedDate,true);
        Writer.Print("New deadline of book ["+bookID+"] is "+String.valueOf(extendedDate),true);

    }
}
