import java.util.*;

class Example {

    public final static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            e.printStackTrace();
            // Handle any exceptions.6
        }
    }



    // Q1) Add new student
    public static void addNewStudent(String[][] dataOfStudents, int[][] marksOfStudents) {
        Scanner input = new Scanner(System.in);
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("|   	                      ADD NEW STUDENTS                             |");
        System.out.println("----------------------------------------------------------------------------");
        String yesOrNo = "Y";
        L: while (Objects.equals(yesOrNo, "Y") || Objects.equals(yesOrNo, "y")) {
            String[][] tempArray = new String[dataOfStudents.length + 1][2];
            for (int i = 0; i < dataOfStudents.length; i++) {
                tempArray[i][0] = dataOfStudents[i][0]; // i>> Student ID
                tempArray[i][1] = dataOfStudents[i][1]; // i>> Student Name
            }
            System.out.print("\nEnter Student ID   : ");
            tempArray[dataOfStudents.length][0] = input.next();
            for (int i = 0; i < dataOfStudents.length; i++) {
                if (Objects.equals(tempArray[i][0], tempArray[dataOfStudents.length][0])) {
                    System.out.println("The Student ID already exists");
                    continue L;
                }
            }

            System.out.print("Enter Student Name : ");



            tempArray[dataOfStudents.length][1] = input.next();
            dataOfStudents = tempArray;

            int[][] tempMarksArray = new int[dataOfStudents.length][2];
            for (int i = 0; i < marksOfStudents.length; i++) {
                tempMarksArray[i] = marksOfStudents[i];
            }

            tempMarksArray[tempMarksArray.length - 1][0] = -1;
            tempMarksArray[tempMarksArray.length - 1][1] = -1;

            marksOfStudents = tempMarksArray;

            System.out.print("\nStudent has been added successfully. Do you want to add a new student (Y/n): ");
            yesOrNo = input.next();
            if (Objects.equals(yesOrNo, "n") || Objects.equals(yesOrNo, "N")) {
                clearConsole();
                mainMenu(dataOfStudents, marksOfStudents);
            }
        }
    }
    //Q2) Add new student with marks
    public static void addNewStudentWithMarks(String[][] dataOfStudents, int[][] marksOfStudents) {
        Scanner input = new Scanner(System.in);
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("|   	                ADD NEW STUDENTS WITH MARKS                        |");
        System.out.println("----------------------------------------------------------------------------");
        String yesOrNo = "Y";
        L1: while (Objects.equals(yesOrNo, "Y") || Objects.equals(yesOrNo, "y")) {
            String[][] tempArray = new String[dataOfStudents.length + 1][2];
            for (int i = 0; i < dataOfStudents.length; i++) {
                tempArray[i][0] = dataOfStudents[i][0]; // Student ID
                tempArray[i][1] = dataOfStudents[i][1]; // Student Name
            }
            System.out.print("\nEnter Student ID   : ");
            tempArray[dataOfStudents.length][0] = input.next();
            for (int i = 0; i < dataOfStudents.length; i++) {
                if (Objects.equals(tempArray[i][0], tempArray[dataOfStudents.length][0])) {
                    System.out.println("The Student ID already exists");
                    continue L1;
                }
            }
            System.out.print("Enter Student Name : ");
            tempArray[dataOfStudents.length][1] = input.next();
            dataOfStudents = tempArray;

            int[][] tempMarksArray = new int[dataOfStudents.length][2];
            for (int i = 0; i < marksOfStudents.length; i++) {
                tempMarksArray[i] = marksOfStudents[i];
            }
            while (true) {
                System.out.print("\nProgramming Fundamentals Marks   : ");
                int marks = input.nextInt();
                if (marks >= 0 && marks <= 100) {
                    tempMarksArray[tempMarksArray.length - 1][0] = marks; // P F Marks
                    break;
                } else {
                    System.out.println("Invalid marks, Please enter correct marks.");
                }
            }
            while (true) {
                System.out.print("Database Management System Marks : ");
                int marks = input.nextInt();
                if (marks >= 0 && marks <= 100) {
                    tempMarksArray[tempMarksArray.length - 1][1] = marks; // D S Marks
                    break;
                } else {
                    System.out.println("Invalid marks, Please enter correct marks.\n");
                }
            }
            marksOfStudents = tempMarksArray;

            System.out.print("\nStudent has been added successfully. Do you want to add a new student (Y/n): ");
            yesOrNo = input.next();
            if (Objects.equals(yesOrNo, "n") || Objects.equals(yesOrNo, "N")) {
                clearConsole();
                mainMenu(dataOfStudents, marksOfStudents);
            }
        }
    }
    //Q3)Add marks

    public static void addMarks(String[][] dataOfStudents, int[][] marksOfStudents) {
        Scanner input = new Scanner(System.in);
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("|   	                          ADD MARKS                                |");
        System.out.println("----------------------------------------------------------------------------");
        String yesOrNo = "Y";

        while (Objects.equals(yesOrNo, "Y") || Objects.equals(yesOrNo, "y")) {
            int count1 = 0, count2 = 0;
            System.out.print("\nEnter Student ID : ");
            String id = input.next();
            for (int i = 0; i < dataOfStudents.length; i++) {
                if (Objects.equals(dataOfStudents[i][0], id)) {
                    System.out.println("Student name     : " + dataOfStudents[i][1]);
                    if (marksOfStudents[i][0] != -1) {
                        System.out.println("This student's marks have been already added.");
                        System.out.println("If you want to update the marks, Please use [5] Update Marks option.\n");
                        count2--;

                    } else {
                        while (true) {
                            System.out.print("\nProgramming Fundamentals Marks   : ");
                            int marks = input.nextInt();
                            if (marks >= 0 && marks <= 100) {
                                marksOfStudents[i][0] = marks; // P F Marks
                                break;
                            } else {
                                System.out.println("Invalid marks, Please enter correct marks.");
                            }
                        }

                        while (true) {
                            System.out.print("Database Management System Marks : ");
                            int marks = input.nextInt();
                            if (marks >= 0 && marks <= 100) {
                                marksOfStudents[i][1] = marks; // D S Marks
                                break;
                            } else {
                                System.out.println("Invalid marks, Please enter correct marks.\n");
                            }
                        }
                    }
                } else {
                    count1++;
                }
            }

            if (count1 == dataOfStudents.length) {
                System.out.print("Invalid Student ID. Do you want to search again? (Y/n) ");
                yesOrNo = input.next();
            }

            else if (count2 == -1) {
                System.out.print("Do you want to add marks for another student? (Y/n) ");
                yesOrNo = input.next();
            } else {
                System.out.print("Marks have been added. Do you want to add marks for another student? (Y/n) ");
                yesOrNo = input.next();
            }
        }

        if (Objects.equals(yesOrNo, "n") || Objects.equals(yesOrNo, "N")) {
            clearConsole();
            mainMenu(dataOfStudents, marksOfStudents);
        }
    }
    //Q4)update student details

    public static void updateStudentDetails(String[][] dataOfStudents, int[][] marksOfStudents) {
        Scanner input = new Scanner(System.in);
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("|   	                   UPDATE STUDENT DETAILS                          |");
        System.out.println("----------------------------------------------------------------------------");
        String yesOrNo = "Y";
        while (Objects.equals(yesOrNo, "Y") || Objects.equals(yesOrNo, "y")) {
            int count = 0;
            System.out.print("\nEnter Student ID : ");
            String id = input.next();
            for (int i = 0; i < dataOfStudents.length; i++) {
                if (Objects.equals(dataOfStudents[i][0], id)) {
                    System.out.println("Student name     : " + dataOfStudents[i][1]);
                    System.out.print("\nEnter the new student name : ");
                    dataOfStudents[i][1] = input.next();

                } else {
                    count++;
                }
            }
            if (count == dataOfStudents.length) {
                System.out.print("Invalid Student ID. Do you want to search again? (Y/n) ");
                yesOrNo = input.next();
            } else {
                System.out.print(
                        "\nStudent details has been updated successfully.\nDo you want to Update another student details? (Y/n) ");
                yesOrNo = input.next();
            }
        }
        if (Objects.equals(yesOrNo, "n") || Objects.equals(yesOrNo, "N")) {
            clearConsole();
            mainMenu(dataOfStudents, marksOfStudents);
        }
    }


    //Q5)update marks
    public static void updateMarks(String[][] dataOfStudents, int[][] marksOfStudents) {
        Scanner input = new Scanner(System.in);
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("|   	                        UPDATE MARKS                               |");
        System.out.println("----------------------------------------------------------------------------");
        String yesOrNo = "Y";

        while (Objects.equals(yesOrNo, "Y") || Objects.equals(yesOrNo, "y")) {
            int count1 = 0, count2 = 0;
            System.out.print("\nEnter Student ID : ");
            String id = input.next();
            for (int i = 0; i < dataOfStudents.length; i++) {
                if (Objects.equals(dataOfStudents[i][0], id)) {
                    System.out.println("Student name     : " + dataOfStudents[i][1]);
                    if (marksOfStudents[i][0] == -1) {
                        System.out.println("\nThis student's marks yet to be added.");
                        count2--;
                    } else {
                        System.out.println("\nProgramming Fundamentals Marks   : " + marksOfStudents[i][0]);
                        System.out.println("Database Management System Marks : " + marksOfStudents[i][1]);

                        while (true) {
                            System.out.print("\nEnter new Programming Fundamentals Marks   : ");
                            int marks = input.nextInt();
                            if (marks >= 0 && marks <= 100) {
                                marksOfStudents[i][0] = marks; // Programming Fundamentals
                                break;
                            } else {
                                System.out.println("Invalid marks, Please enter correct marks.");
                            }
                        }

                        while (true) {
                            System.out.print("Enter new Database Management System Marks : ");
                            int marks = input.nextInt();
                            if (marks >= 0 && marks <= 100) {
                                marksOfStudents[i][1] = marks; // Datamanagement System Marks
                                break;
                            } else {
                                System.out.println("Invalid marks, Please enter correct marks.\n");
                            }
                        }
                    }
                } else {
                    count1++;
                }
            }
            if (count1 == dataOfStudents.length) {
                System.out.print("Invalid Student ID. Do you want to search again? (Y/n) ");
                yesOrNo = input.next();
            }

            if (count2 == -1) {
                System.out.print("Do you want to add marks for another student? (Y/n) ");
                yesOrNo = input.next();
            } else {
                System.out
                        .print("Marks have been updated successfully.\nDo you want to update marks for another student? (Y/n) ");
                yesOrNo = input.next();
            }
        }

        if (Objects.equals(yesOrNo, "n") || Objects.equals(yesOrNo, "N")) {
            clearConsole();
            mainMenu(dataOfStudents, marksOfStudents);
        }
    }

    //Q6)Delete student
    public static void deleteStudent(String[][] dataOfStudents, int[][] marksOfStudents) {
        Scanner input = new Scanner(System.in);
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("|   	                       DELETE STUDENT                              |");
        System.out.println("----------------------------------------------------------------------------");

        //???????

    }
    //Q7)
    public static void printStudentDetails(String[][] dataOfStudents, int[][] marksOfStudents) {
        Scanner input = new Scanner(System.in);
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("|   	                    PRINT STUDENT DETAILS                          |");
        System.out.println("----------------------------------------------------------------------------");


    }
    //-----------------------------------------------------------------------

    //Q8
    public static void printStudentRanks(String[][] dataOfStudents, int[][] marksOfStudents) {
        Scanner input = new Scanner(System.in);
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("|   	                     PRINT STUDENT RANKS                           |");
        System.out.println("----------------------------------------------------------------------------\n\n");
        System.out.println("+-------+-------+-------------------------------+-------------+------------+");
        System.out.println("| Rank  | ID    | Name                          | Total Marks | Avg. Marks |");
        System.out.println("+-------+-------+-------------------------------+-------------+------------+");
    }

    //--------------------------------------------------------------------------------------------------------

    //Q9)
    public static void bestInProgrammingFundamentals(String[][] dataOfStudents, int[][] marksOfStudents) {
        Scanner input = new Scanner(System.in);
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("|   	              BEST IN PROGRAMMING FUNDAMENTALS                     |");
        System.out.println("----------------------------------------------------------------------------\n\n");
        System.out.println("+-------+----------------------------------+----------+------------+");
        System.out.println("| ID    | Name                             | PF Marks | DBMS Marks |");
        System.out.println("+-------+----------------------------------+----------+------------+");
    }
    //Q10)

    public static void bestInDatamanagementSystem(String[][] dataOfStudents, int[][] marksOfStudents) {
        Scanner input = new Scanner(System.in);
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("|   	              BEST IN DATABASE MANAGEMENT SYSTEM                   |");
        System.out.println("----------------------------------------------------------------------------\n\n");
        System.out.println("+-------+----------------------------------+------------+----------+");
        System.out.println("| ID    | Name                             | DBMS Marks | PF Marks |");
        System.out.println("+-------+----------------------------------+------------+----------+");
    }

    //--------------------------------------------------------------------------------------------------

    public static void mainMenu(String[][] dataOfStudents, int[][] marksOfStudents) {
        Scanner input = new Scanner(System.in);
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("|   	          WELCOME TO GDSE MARKS MANAGEMENT SYSTEM                  |");
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("\n[1] Add New Student\t\t\t[2] Add New Student With Marks");
        System.out.println("[3] Add Marks\t\t\t\t[4] Update Student Details");
        System.out.println("[5] Update Marks\t\t\t[6] Delete Student");
        System.out.println("[7] Print Student Details\t\t[8] Print Student Ranks");
        System.out.println("[9] Best in Programming Fundamentals\t[10] Best in Datamanagement System");
        System.out.print("\nEnter an option to continue > ");
        int option = input.nextInt();
        switch (option) {
            case 1:
                clearConsole();
                addNewStudent(dataOfStudents, marksOfStudents);
                break;

            case 2:
                clearConsole();
                addNewStudentWithMarks(dataOfStudents, marksOfStudents);
                break;

            case 3:
                clearConsole();
                addMarks(dataOfStudents, marksOfStudents);
                break;
            case 4:
                clearConsole();
                updateStudentDetails(dataOfStudents, marksOfStudents);
                break;

            case 5:
                clearConsole();
                updateMarks(dataOfStudents, marksOfStudents);
                break;
            case 6:
                clearConsole();
                deleteStudent(dataOfStudents, marksOfStudents);
                break;
            case 7:
                clearConsole();
                printStudentDetails(dataOfStudents, marksOfStudents);
                break;
            case 9:
                clearConsole();
                bestInProgrammingFundamentals(dataOfStudents, marksOfStudents);
                break;

            case 10:
                clearConsole();
                bestInDatamanagementSystem(dataOfStudents, marksOfStudents);
                break;



        }
    }
    public static void main(String[] args) {
        int[][] marksOfStudents = new int[0][2];
        String[][] dataOfStudents = new String[0][2];

        mainMenu(dataOfStudents, marksOfStudents);
    }
}
