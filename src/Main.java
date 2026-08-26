import java.util.ArrayList; //allows us to store multiple students and grades.
import java.util.Scanner;  //allows our program to take input from the user

public class Main {
    public static void main(String[] args) {
        System.out.println("======================================");
        System.out.println("       STUDENT GRADE TRACKER");
        System.out.println("======================================");

        Scanner scanner = new Scanner(System.in); // created scanner to take inputs
        System.out.println(" enter the number of students:");
        int numberOfStudents = scanner.nextInt(); // reads an integer from the user
        while (numberOfStudents <= 0) {
            System.out.print("Please enter at least 1 student: ");
            numberOfStudents = scanner.nextInt();

        }
        scanner.nextLine();

        ArrayList<String> studentNames = new ArrayList<>(); // creating arraylist of type String to store the names
        ArrayList<Double> grades = new ArrayList<>(); // creating arraylist of type Double to store the marks

        for(int i = 0 ; i < numberOfStudents ; i++){ // for loop to take the inputs of different student

            System.out.println("enter the name of student " + (i+1) + ":"); //the loop runs once for each student.
            String name = scanner.nextLine(); //String type of ip

            double grade;
            while (true) {
                System.out.print("Enter the grade of student " + (i + 1) + ": "); //the loop runs once for each student.
                if(scanner.hasNextDouble()){
                    grade  = scanner.nextDouble();
                    scanner.nextLine();
                if (grade >= 0 && grade <= 100) {
                    break;
                }

                System.out.println("Invalid grade! Please enter a grade between 0 and 100.");
            }   else{
                    System.out.println("please enter the number!");
                    scanner.nextLine();
                }

            }

            studentNames.add(name);
            grades.add(grade); //puts the entered grades into our ArrayLists
        }


        double total = 0; // means we start the total from 0
        for( double grade : grades){ //Take each grade from the grades ArrayList, one by one
            total = total + grade; //calculates the total
        }

        double avg = total/ grades.size(); //grades.size() = 3 means this is just exmple of number interies we made
        double highest = grades.get(0);  //initially set the highest to the oth index
        for(double grade :grades){ //defines the  grade and store the value of grades
            if(grade>highest){  //compares and swaps in other words  compares and updates the highest grade
                highest=grade;
            }
        }
        double lowest = grades.get(0); //set the zeroth index as lowest first then compares with next element in the for loop
        for(double grade : grades){ //defines grade and stores the grades
            if(grade<lowest){  // compares and updates the highest grade
                lowest=grade;
            }
        }
        System.out.println("\n========== SUMMARY ============");
        for(int i = 0 ; i<studentNames.size() ; i++){
            System.out.printf("%-20s : %.2f%n", studentNames.get(i), grades.get(i)); //It gives the names a fixed amount of space, so your output lines up neatly
        }
        System.out.println("-------------------------------");
        System.out.printf("average grade :%.2f%n", avg);  //prints avg only upto 2 decimal places
        System.out.printf("Highest Grade : %.2f%n", highest);
        System.out.printf("lowest grade : %.2f%n", lowest);
        System.out.println("===============================");
        scanner.close();

    }
}