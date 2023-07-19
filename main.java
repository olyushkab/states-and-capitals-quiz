import java.util.*;
public class Main {
    public static void main(String[] args) {
        //Part 1: Sorting Arrays
        //Creating two-dimensional array in order by state name for 50 States and their capitals
        String[][] statesAndCapitals = new String[][]{
                {"Alabama", "Montgomery"},
                {"Alaska", "Juneau"},
                {"Arizona", "Phoenix"},
                {"Arkansas", "Little Rock"},
                {"California", "Sacramento"},
                {"Colorado", "Denver"},
                {"Connecticut", "Hartford"},
                {"Delaware", "Dover"},
                {"Florida", "Tallahassee"},
                {"Georgia", "Atlanta"},
                {"Hawaii", "Honolulu"},
                {"Idaho", "Boise"},
                {"Illinois", "Springfield"},
                {"Indiana", "Indianapolis"},
                {"Iowa", "Des Moines"},
                {"Kansas", "Topeka"},
                {"Kentucky", "Frankfort"},
                {"Louisiana", "Baton Rouge"},
                {"Maine", "Augusta"},
                {"Maryland", "Annapolis"},
                {"Massachusetts", "Boston"},
                {"Michigan", "Lansing"},
                {"Minnesota", "St. Paul"},
                {"Mississippi", "Jackson"},
                {"Missouri", "Jefferson City"},
                {"Montana", "Helena"},
                {"Nebraska", "Lincoln"},
                {"Nevada", "Carson City"},
                {"New Hampshire", "Concord"},
                {"New Jersey", "Trenton"},
                {"New Mexico", "Santa Fe"},
                {"New York", "Albany"},
                {"North Carolina", "Raleigh"},
                {"North Dakota", "Bismarck"},
                {"Ohio", "Columbus"},
                {"Oklahoma", "Oklahoma City"},
                {"Oregon", "Salem"},
                {"Pennsylvania", "Harrisburg"},
                {"Rhode Island", "Providence"},
                {"South Carolina", "Columbia"},
                {"South Dakota", "Pierre"},
                {"Tennessee", "Nashville"},
                {"Texas", "Austin"},
                {"Utah", "Salt Lake City"},
                {"Vermont", "Montpelier"},
                {"Virginia", "Richmond"},
                {"Washington", "Olympia"},
                {"West Virginia", "Charleston"},
                {"Wisconsin", "Madison"},
                {"Wyoming", "Cheyenne"}
        };
        //Calling method to display all the states and their capitals
        System.out.println("The list off all the states and their capitals:");
        displayStatesAndCapitals(statesAndCapitals);
        //Calling method to perform bubble sort by capital
        bubbleSortByCapital(statesAndCapitals);
        //Calling method to display sorted array
        System.out.println("\nThe list off all the states and their capitals sorted by capital:");
        displayStatesAndCapitals(statesAndCapitals);
        //Calling method to start playing quiz game and assigning the final score
        int count = quizPlayer(statesAndCapitals);
        //Finally, display the final score
        System.out.println("You got "+count+" capitals correct!");


        //Part 2: Sorting & Searching HashMap
        Map<String, String> statesAndCapitalsMap = new HashMap<>();
        for (String[] stateAndCapital : statesAndCapitals) {
            statesAndCapitalsMap.put(stateAndCapital[0], stateAndCapital[1]);
        }

        //Display the content of the Map
        System.out.println("\nStates and Capitals using Map:");
        for (Map.Entry<String, String> entry : statesAndCapitalsMap.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

        //Sort the map using TreeMap (binary search tree)
        Map<String, String> sortedStatesAndCapitalsMap = new TreeMap<>(statesAndCapitalsMap);

        //Ask user to enter a state to display the capital
        Scanner scanner = new Scanner(System.in);

        //Loop to search for capitals based on user state input
        boolean exitLoop = false;
        while (!exitLoop) {
            //Prompt user to enter a state to display the capital
            System.out.print("\nEnter a state to find its capital or type 'exit' to quit: ");
            String state = scanner.nextLine().trim();

            if (state.equalsIgnoreCase("exit")) {
                exitLoop = true;
            } else {
                if (sortedStatesAndCapitalsMap.containsKey(state)) {
                    String capital = sortedStatesAndCapitalsMap.get(state);
                    System.out.println("Capital of " + state + " is " + capital);
                } else {
                    System.out.println("Sorry, this state doesn't exist.");
                }
            }
        }

        System.out.println("Exiting the program.");
    }


    
    //Part 1 continues: creating methods called in main

    //Displaying method
    public static void displayStatesAndCapitals(String[][] statesAndCapitals){
        for(String[] stateAndCapital : statesAndCapitals){
            System.out.println(stateAndCapital[0]+" - "+stateAndCapital[1]);
        }
    }
    //Bubble sort method
    public static void bubbleSortByCapital(String[][] statesAndCapitals){
        for(int i=0; i< statesAndCapitals.length-1; i++){
            for (int j = 0; j < statesAndCapitals.length - i - 1; j++) {
                if (statesAndCapitals[j][1].compareToIgnoreCase(statesAndCapitals[j + 1][1]) > 0) {
                    // Swap elements at j and j+1
                    String[] temp = statesAndCapitals[j];
                    statesAndCapitals[j] = statesAndCapitals[j + 1];
                    statesAndCapitals[j + 1] = temp;
                }
            }
        }

    }
    //Method for counting correct quiz answers
    public static int quizPlayer(String[][] statesAndCapitals){
        int count = 0;
        Scanner scn = new Scanner(System.in);

        for(String[] stateAndCapital : statesAndCapitals){
            System.out.println("\nEnter the capital of "+stateAndCapital[0]+": ");
            String answer = scn.nextLine().trim();

            if (answer.equalsIgnoreCase(stateAndCapital[1])){
                count++;
                System.out.println("This is correct answer!");
            } else {
                System.out.println("Sorry, this is incorrect answer.");
            }
        }
        return count;
    }


}

