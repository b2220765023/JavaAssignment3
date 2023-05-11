import java.util.ArrayList;

/**

 * This class represents a library member and their information.
 */
public class AddMember {
    /**

     * The type of the member, such as student or academic.
     */
    private String type;
    /**
     * The number of times the member has borrowed a book.
     * The borrowing limit is 2 for student, 4 for academic
     */
    public int timesBorrowed ;
    /**

     * Returns the type of the member.
     * @return The type of the member.
     */
    public String getType() {
        return type;
    }

    /**

     * Sets the type of the member.
     * @param type The type of the member.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**

     * An array list of the IDs of books currently borrowed by the member.
     */
    public ArrayList<Integer> HasBookIDs = new ArrayList<Integer>();

    /**

     * An array list of the IDs of books read by the member in the library.
     */
    public ArrayList<Integer> HasReadInLibraryBookIDs = new ArrayList<Integer>();

    /**

     * An array list of all member IDs.
     */
    public static ArrayList<Integer> IDs = new ArrayList<Integer>();
    /**

     * The unique ID of the member.
     */
    private int id = 0;



    public ArrayList<Integer> getIDs() {
        return IDs;
    }

    protected int getId() {
        return id;
    }

    /**

     * Creates a new member object with the given type.
     * @param type The type of the member, such as student or faculty.
     */
    protected AddMember(String type) {
        this.id = IDs.size() +1;
        this.type = type;
        IDs.add(getId());
        timesBorrowed = 0;

    }
}
