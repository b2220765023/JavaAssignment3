import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<AddBook> allBooks = new ArrayList<>();
    public static ArrayList<AddMember> allMembers = new ArrayList<>();
    public static void main(String[] args) throws FileNotFoundException {
        /**

         * This program reads input from a file, creates new books or members based on the input, and adds them to appropriate lists.

         * The program prints out the status of the creation process.

         * @param args an array of command-line arguments that contains the file name of the input and the file name of the output.

         * @throws FileNotFoundException if the input file is not found.
         */

        // Create a new Writer object that writes output to a file with the name specified in args[1].
        Writer myWriter = new Writer(args[1]);
        // Create a new Scanner object that reads input from a file with the name specified in args[0].
        Scanner inputFile = new Scanner(new File(args[0]));
        // Read input line by line and create new books or members based on the input.
        while (inputFile.hasNext()){
            String line = inputFile.nextLine();
            if (!line.isEmpty()){
                String parts[] = line.split("\t");

                if(line.startsWith("addBook")){
                    // Create a new AddBook object and add it to the allBooks list.
                    AddBook newBook = new AddBook(parts[1]);
                    allBooks.add(newBook);
                    // Print out the status of the creation process.
                    if(parts[1].equals("P")){
                        Writer.Print("Created new book: Printed [id: "+ allBooks.get(allBooks.size()-1).getId()+"]",true);
                        allBooks.get(allBooks.size()-1).setType("P");

                    }
                    else if (parts[1].equals("H")){
                        Writer.Print("Created new book: Handwritten [id: "+allBooks.get(allBooks.size()-1).getId()+"]",true);
                        allBooks.get(allBooks.size()-1).setType("H");
                    }
                    else
                        Writer.Print("No such book type",true);
                }
                else if (line.startsWith("addMember")){
                    // Create a new AddMember object and add it to the allMembers list.
                    AddMember newMember = new AddMember(parts[1]);
                    allMembers.add(newMember);
                    // Print out the status of the creation process.
                    if(parts[1].equals("S")){
                        Writer.Print("Created new member: Student [id: "+allMembers.get(allMembers.size()-1).getId()+"]",true);
                        allMembers.get(allMembers.size()-1).setType("S");
                    }

                    else if (parts[1].equals("A")){
                        Writer.Print("Created new member: Academic [id: "+allMembers.get(allMembers.size()-1).getId()+"]",true);
                        allMembers.get(allMembers.size()-1).setType("A");
                    }
                    else
                        Writer.Print("No such member type",true);
                }

                /**

                 * This method is used to borrow a book by a member.
                 * It takes in a string 'line' which contains the command to borrow a book and
                   its parameters.
                 * The bookId and memberId are parsed from the 'line' and checked against the existing list of books and members.
                 * If the book is available and the member is eligible to borrow the book, then the book is borrowed by the member and the
                   details of the borrowing are recorded.
                 * If the member has already reached the borrowing limit, then an appropriate message
                   is printed.
                 * If the book is not available or the member is not eligible to borrow the book, then a message is printed
                   accordingly.
                 * @param line A string containing the command to borrow a book and its parameters
                 */

                else if (line.startsWith("borrowBook")){
                    //This method handles the commands related to borrowing books in the library.
                    //Extract book ID and member ID from input string
                    int bookId = Integer.parseInt(parts[1]);
                    int memberId = Integer.parseInt(parts[2]);
                    String bookType = null;
                    String memberType = null;
                    //Loop through all books to find the book with the given ID
                    for (AddBook book : allBooks) {
                        if (book.getId() == bookId) {
                            //If the book is available, store its type and break the loop
                            if (allBooks.get(bookId-1).getIsAvailable()){
                                bookType = book.getType();
                                break;
                            //If the book is not available, print an error message and break the loop
                            }else {
                                Writer.Print("You can not read this book!",true);
                                break;
                            }
                        }
                    }
                    //If a book was found and its type was determined
                    if (bookType != null) {
                        //Loop through all members to find the member with the given ID
                        for (AddMember member : allMembers) {
                            //Store the member type
                            memberType = member.getType();
                            if (member.getId() == memberId) {
                                //Check if a student is trying to borrow a handwritten book
                                if (bookType.equals("H") && memberType.equals("S")){
                                    Writer.Print("Students can not borrow handwritten books!",true);
                                    break;
                                } //Check if an academic is trying to borrow a handwritten book
                                else if (bookType.equals("H") && memberType.equals("A")){
                                    //Check if the borrowing limit has been exceeded
                                    if(allMembers.get(memberId-1).timesBorrowed<4){
                                        //Create a BorrowBook object and print a success message
                                        BorrowBook borrowBook = new BorrowBook(parts[1],parts[2],parts[3],"A");
                                        Writer.Print("The book ["+bookId+"] was borrowed by member ["+memberId+"] at "+allBooks.get(bookId-1).getBorrowedDate(),true);

                                    }
                                    //Print an error message if the borrowing limit has been exceeded
                                    else
                                        Writer.Print("You have exceeded the borrowing limit!",true);
                                    break;

                                }//Check if a student is trying to borrow a printed book
                                else if (bookType.equals("P") && memberType.equals("S")){
                                    //Check if the borrowing limit has been exceeded
                                    if(allMembers.get(memberId-1).timesBorrowed<2){
                                        //Create a BorrowBook object and print a success message
                                        BorrowBook borrowBook = new BorrowBook(parts[1],parts[2],parts[3],"S");
                                        Writer.Print("The book ["+bookId+"] was borrowed by member ["+memberId+"] at "+allBooks.get(bookId-1).getBorrowedDate(),true);

                                    }//Print an error message if the borrowing limit has been exceeded
                                    else
                                        Writer.Print("You have exceeded the borrowing limit!",true);
                                    break;

                                }//Check if an academic is trying to borrow a printed book
                                else if (bookType.equals("P") && memberType.equals("A")) {
                                    //Check if the borrowing limit has been exceeded
                                    if (allMembers.get(memberId-1).timesBorrowed<4){
                                        //Create a BorrowBook object and print a success message
                                        BorrowBook borrowBook = new BorrowBook(parts[1],parts[2],parts[3],"A");
                                        Writer.Print("The book ["+bookId+"] was borrowed by member ["+memberId+"] at "+allBooks.get(bookId-1).getBorrowedDate(),true);
                                    }//Print an error message if the borrowing limit has been exceeded
                                    else
                                        Writer.Print("You have exceeded the borrowing limit!",true);
                                    break;
                                }

                            }
                        }
                    }
                }
                /**

                 * This method is used to read a book in the library.
                 * It takes in a string 'line' which contains the command to read a book and
                   its parameters.
                 * The bookId and memberId are parsed from the 'line' and checked against the existing list of books and members.
                 * If the book is available and the member is eligible to read the book in the library, then the book is read by the member in
                   the library and the details of the reading are recorded.
                 * If the book is not available or the member is not eligible to read
                   the book in the library, then a message is printed accordingly.
                 * @param line A string containing the command to read a book in the library and its parameters
                 */
                else if (line.startsWith("readInLibrary")){
                    // If the command is 'readInLibrary', then extract the bookId, memberId, and startTime from the input line.
                    int bookId = Integer.parseInt(parts[1]);
                    int memberId = Integer.parseInt(parts[2]);
                    // Initialize bookType and memberType as null.
                    String bookType = null;
                    String memberType = null;
                    // Loop through all books in the library to check if the book with the given bookId exists and is available.
                    for (AddBook book : allBooks) {
                        if (book.getId() == bookId) {
                            // If the book exists and is available, set bookType to the book's type and break out of the loop.
                            if (allBooks.get(bookId-1).getIsAvailable()){
                                bookType = book.getType();
                                break;
                            } // If the book is not available, print a message and break out of the loop.
                            else {
                                Writer.Print("You can not read this book!",true);
                                break;
                            }
                        }
                    }// If bookType is not null, then loop through all members in the library to check if the member with the given memberId exists.
                    if (bookType != null){
                        for (AddMember member : allMembers){
                            memberType = member.getType();
                            if (member.getId() == memberId){
                                // If the member exists, check if the member type allows them to read the book.
                                if ( bookType.equals("H") && memberType.equals("S")){
                                    // If the member type is student and the book type is handwritten, print a message and break out of the loop.
                                    Writer.Print("Students can not read handwritten books!",true);
                                    break;
                                }else{
                                    // If the member type allows them to read the book, call the ReadInLibrary.main() method with the bookId, memberId, and startTime.
                                    ReadInLibrary.main(bookId,memberId,parts[3]);
                                    break;
                                }
                            }
                        }
                    }
                }
                /**

                 * This method handles the commands related to returning books in the library.
                 * It takes in a String command line input and extracts the book ID, member ID and return date from it.
                 * It then checks if the book is already returned or not, if not it creates a new ReturnBook object
                   and updates the book's availability status and return date.
                 * If the book is already returned,
                   it prints an error message.
                 * @param line The input command line containing the returnBook command and its arguments
                 */
                else if (line.startsWith("returnBook")){
                    // If the command is 'returnBook', then extract the bookId, memberId, and returnTime from the input line.
                    int bookId = Integer.parseInt(parts[1]);
                    int memberId = Integer.parseInt(parts[2]);
                    // Initialize bookType and memberType as null.
                    String bookType = null;
                    String memberType = null;
                    // Loop through all books in the library to check if the book with the given bookId exists and is not available (i.e., it has been borrowed).
                    for (AddBook book : allBooks) {
                        if (book.getId() == bookId) {
                            // If the book exists and is not available, set bookType to the book's type and break out of the loop.
                            if (!allBooks.get(bookId-1).getIsAvailable()){
                                bookType = book.getType();
                                break;
                            }// If the book is available, print a message and break out of the loop.
                            else {
                                Writer.Print("You can not return this book!",true);
                                break;
                            }
                        }
                    }
                    // If bookType is not null, then loop through all members in the library to check if the member with the given memberId exists.
                    if (bookType != null) {
                        for (AddMember member : allMembers) {
                            memberType = member.getType();
                            if (member.getId() == memberId) {
                                // If the member exists, create a new ReturnBook object and break out of the loop.
                                ReturnBook returnBook = new ReturnBook(bookId,memberId,parts[3]);
                                break;
                            }
                        }
                    }
                }
                /**

                 * This method extends the deadline of a book borrowed by a member.
                 * @param line the command line input containing the "extendBook" command and the book ID, member ID, and new return date separated by spaces.
                 * @param allBooks the list of all books in the library.
                 * @param parts an array of strings containing the command line input separated by spaces.
                 */
                else if ( line.startsWith("extendBook")){
                    int bookId = Integer.parseInt(parts[1]);
                    int memberId = Integer.parseInt(parts[2]);
                    // Loop through all books in the library to check if the book with the given bookId exists and is not extended
                    for (AddBook book : allBooks) {
                        if (book.getId() == bookId) {
                            //Check if the book's deadline extended.
                            if (!allBooks.get(bookId-1).getIsExtended()){
                                //If it is not extended, create a new extendBook object.
                                ExtendDeadLine extendBook = new ExtendDeadLine(parts[3],bookId,memberId);
                            }//If deadline already extended, write the correct error.
                            else {
                                Writer.Print("You cannot extend the deadline!",true);
                            }
                        }
                    }
                }
                /**
                 * This method prints the history of all the books borrowed from the library.
                 */
                else if (line.startsWith("getTheHistory")){
                    GetTheHistory.main();
                }
            }
        }
        Writer.Print("",false);
    }
}