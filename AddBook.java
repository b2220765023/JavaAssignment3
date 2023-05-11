import java.util.ArrayList;

/**
 * The AddBook class represents a book that can be added to the library system.
 */
public class AddBook {

    private int id = 0;
    private String borrowedDate;


    public boolean isReadInLibrary() {
        return isReadInLibrary;
    }

    public void setReadInLibrary(boolean readInLibrary) {
        isReadInLibrary = readInLibrary;
    }


    private boolean isExtended;
    public boolean isBorrowed;
    private boolean isReadInLibrary;

    /**

     * Returns whether the book's deadline has been extended or not.
     * @return True if the book's deadline has been extended, false otherwise.
     */
    public boolean getIsExtended() {
        return isExtended;
    }

    /**

     * Sets whether the book's deadline has been extended or not.
     * @param extended True if the book's deadline has been extended, false otherwise.
     */
    public void setIsExtended(boolean extended) {
        isExtended = extended;
    }

    /**

     * Returns the date on which the book was borrowed.
     * @return The date on which the book was borrowed.
     */
    public String getBorrowedDate() {
        return borrowedDate;
    }

    /**

     * Sets the date on which the book was borrowed.
     * @param borrowedDate The date on which the book was borrowed.
     */
    public void setBorrowedDate(String borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    /**

     * Returns the extended deadline of the book.
     * @return The extended deadline of the book.
     */
    public String getExtendedDate() {
        return extendedDate;
    }

    public void setExtendedDate(String extendedDate) {
        this.extendedDate = extendedDate;
    }

    private String extendedDate;
    private static ArrayList<Integer> IDs = new ArrayList<>();
    private boolean isAvailable;

    private String type;

    /**
     * Creates a new instance of the AddBook class.
     * @param type The type of book to be added to the library system.
     */
    public AddBook(String type) {

        this.id = IDs.size()+1;
        this.type = type;
        this.isAvailable = true;
        IDs.add(this.id);
        isExtended = false;
        isReadInLibrary = false;
        isBorrowed = false;
    }

    /**

     * Returns the ID of the book.
     * @return The ID of the book.
     */
    public int getId() {
        return id;
    }

    /**

     * Returns whether the book is available for borrowing or not.
     * @return True if the book is available for borrowing, false otherwise.
     */
    public boolean getIsAvailable() {
        return isAvailable;
    }

    /**

     * Sets the availability of the book for borrowing.
     * @param isAvailable True if the book is available for borrowing, false otherwise.
     */
    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    /**

     * Returns the type of the book.
     * @return The type of the book.
     */
    public String getType() {
        return type;
    }

    /**

     * Sets the type of the book.
     * @param type The type of the book.
     */
    public void setType(String type) {
        this.type = type;
    }
}