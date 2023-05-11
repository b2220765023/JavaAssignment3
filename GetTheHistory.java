
/**

 * A class that provides the history of the library.
 */
public class GetTheHistory {
    /**

     * Provides the history of the library.
     * Prints the number of students, academics, printed books, handwritten books, borrowed books, and books read in the library.
     * Prints the details of each category such as the IDs of students and academics and the IDs of borrowed and read in library books.
     */
    public static void main() {
        Writer.Print("History of library:",true);
        Writer.Print("",true);
        System.out.println();
        // Count the number of students and print their IDs to the output file
        int numOfStudent = 0;
        // Count the number of academics and print their IDs to the output file
        int numOfAcademic = 0;
        // Count the number of printed books and print their IDs to the output file
        int numOfPrintedBook = 0;
        // Count the number of handwritten books and print their IDs to the output file
        int numOfHandWrittenBook = 0;
        // Count the number of borrowed books and print their details to the output file
        int numOfBorrowedBook = 0;
        // Count the number of books read in library and print their details to the output file
        int numOfReadInLibraryBook = 0;

        for(int i = 0; i < Main.allMembers.size(); i++){
            if (Main.allMembers.get(i).getType().equals("S"))
                numOfStudent++;
        }
        Writer.Print("Number of students: "+numOfStudent,true);
        for(int i = 0; i < Main.allMembers.size(); i++){
            if (Main.allMembers.get(i).getType().equals("S"))
                Writer.Print("Student [id: "+ Main.allMembers.get(i).getId()+"]",true);
        }


        for(int i = 0; i < Main.allMembers.size(); i++){
            if (Main.allMembers.get(i).getType().equals("A"))
                numOfAcademic++;
        }
        Writer.Print("",true);
        Writer.Print("Number of academics: "+numOfAcademic,true);
        for(int i = 0; i < Main.allMembers.size(); i++){
            if (Main.allMembers.get(i).getType().equals("A"))
                Writer.Print("Academic [id: "+ Main.allMembers.get(i).getId()+"]",true);
        }


        for(int i = 0; i < Main.allBooks.size(); i++){
            if (Main.allBooks.get(i).getType().equals("P"))
                numOfPrintedBook++;
        }
        Writer.Print("",true);
        Writer.Print("Number of printed books: "+numOfPrintedBook,true);
        for(int i = 0; i < Main.allBooks.size(); i++){
            if (Main.allBooks.get(i).getType().equals("P")){
                Writer.Print("Printed [id: "+ Main.allBooks.get(i).getId()+"]",true);
            }
        }


        for(int i = 0; i < Main.allBooks.size(); i++){
            if (Main.allBooks.get(i).getType().equals("H"))
                numOfHandWrittenBook++;
        }
        Writer.Print("",true);
        Writer.Print("Number of handwritten books: "+numOfHandWrittenBook,true);
        for(int i = 0; i < Main.allBooks.size(); i++){
            if (Main.allBooks.get(i).getType().equals("H"))
                Writer.Print("Handwritten [id: "+ Main.allBooks.get(i).getId()+"]",true);
        }


        for(int i = 0; i < Main.allBooks.size(); i++){
            if (Main.allBooks.get(i).isBorrowed==true)
                numOfBorrowedBook++;
        }
        Writer.Print("",true);
        Writer.Print("Number of borrowed books: "+numOfBorrowedBook,true);
        for(int i = 0; i < Main.allBooks.size() ; i++){
            if (Main.allBooks.get(i).isBorrowed ==true){
                for (int j = 0; j < Main.allMembers.size() ; j++){
                    if(Main.allMembers.get(j).HasBookIDs.contains(i+1)){
                        Writer.Print("The book ["+ Main.allBooks.get(i).getId()+"] was borrowed by member ["+ Main.allMembers.get(j).getId()+"] at "+ Main.allBooks.get(i).getBorrowedDate(),true);
                    }

                }
            }
        }


        for(int i = 0; i < Main.allBooks.size(); i++){
            if (Main.allBooks.get(i).isReadInLibrary())
                numOfReadInLibraryBook++;
        }
        Writer.Print("",true);
        Writer.Print("Number of books read in library: "+numOfReadInLibraryBook,true);
        for(int i = 0; i < Main.allBooks.size() ; i++){
            if (Main.allBooks.get(i).isReadInLibrary() == true){
                for (int j = 0; j < Main.allMembers.size() ; j++){
                    if(Main.allMembers.get(j).HasReadInLibraryBookIDs.contains(i+1)){
                        Writer.Print("The book ["+ Main.allBooks.get(i).getId()+"] was read in library by member ["+ Main.allMembers.get(j).getId()+"] at "+ Main.allBooks.get(i).getBorrowedDate(),true);
                    }

                }
            }
        }

    }


}
