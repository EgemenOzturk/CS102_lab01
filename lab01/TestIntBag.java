package lab01;

import java.util.Scanner;

public class TestIntBag {

    public static void main (String [] args) {

        Scanner scan = new Scanner(System.in);

        int singleValue = 0;
        IntBag testIntBag = null;
        int selection;


        //Menu
        do {
            System.out.println("1. Create a new empty collection with capacity of 4 (any previous values are lost!)");
            System.out.println("2. Read a set of positive values into the collection (use zero to indicate all the values have been entered.)");
            System.out.println("3. Print the collection of values.");
            System.out.println("4. Add a value to the collection of values at a specified location");
            System.out.println("5. Remove the value at a specified location from the collection of values");
            System.out.println("6. Read a single test value and remove it from the bag.");
            System.out.println("7. Quit the program.");
            System.out.println();
            System.out.print("Please choose one of these option: ");
            selection = scan.nextInt();

            // create the IntBag with specified size
            if( selection == 1) {

                testIntBag = new IntBag(4);

                System.out.println( "The 4 membered empty collection has been created!");
            }
            // Input new values from the user
            else if(selection == 2){
                int newValue = scan.nextInt();

                while (newValue != 0) {
                    if (newValue < 0){
                        System.out.println("Please enter positive values");
                        newValue = 0;
                    }
                    else {
                        testIntBag.add(newValue);
                        newValue = scan.nextInt();
                    }
                }
            }
            // print the collection
            else if(selection == 3) {
                // We have toString() method to print this array directly3
                System.out.println(testIntBag);
            }
            //add a value to a specific location of values
            else if(selection == 4){

                System.out.print("value: ");
                int value = scan.nextInt();

                if (value < 0 )
                    System.out.println("Please enter positive values");

                else{
                    System.out.print("index: ");

                    int index = scan.nextInt();

                    testIntBag.add(value,index);

                    System.out.println(testIntBag);
                }
            }
            // remove element
            else if(selection == 5) {

                System.out.print("Index: ");
                int index = scan.nextInt();

                testIntBag.remove(index);

                System.out.println(testIntBag);
            }
            //read a single test value and remove it from the bag.
            else if(selection == 6) {

                System.out.println("Please enter the value which you want to find and delete: ");
                singleValue = scan.nextInt();
        }

                testIntBag.removeAll( singleValue );

                System.out.println(testIntBag);

            //Loop Exit
        } while(selection != 7);
        System.out.println("See You!");
    }
}


