/*
  Author: Alexander Zetterström
  Id: m11p1163
  Study program: MPP (Valbar kurs)
*/
import java.util.Scanner;
public class Assignment1{
  static Scanner input = new Scanner(System.in);
  // an array to use for testing, replace as needed to test your code
  static String[][] guestList = {{"Adam Ason", "35"},
                                 {"Berta Bson", "70"},
                                 {"Ceasar Cson", "12"},
                                 {"",""},
                                 {"",""},
                                 {"",""},
                                 {"",""},
                                 {"",""},
                                 {"Eomer David","13"},
                                 {"Maximilian Stones","12"},
                               };



  public static void printGuestList(){
      System.out.println("");
    for(int i = 0; i < guestList.length; i++){
      if(guestList[i][0] != ""){
          System.out.println(i + ". " + guestList[i][0] + " - " + guestList[i][1]);
      }
    }
            System.out.println("");
  }

  public static void printStatistics(){
    System.out.println("You chose to print statistics"); //you don't need to keep this line

    int totalGuestAmount = 0;
    int totalguestAmountAdults = 0;
    int totalguestAmountKids = 0;
    int oldestAge = 0;
    String oldestGuestName = "";
    String youngestGuestName = "";
    int youngestAge = 100;

    for(int i = 0; i < guestList.length; i++){

      if(guestList[i][1] != ""){
      int currentAge = Integer.parseInt(guestList[i][1]);

        if(guestList[i][0] != ""){
          totalGuestAmount++;
        }
        if(currentAge >= 18){
          totalguestAmountAdults++;
        }
        if(currentAge <= 13){
          totalguestAmountKids++;
        }
        if(currentAge > oldestAge){
          oldestGuestName = guestList[i][0];
          oldestAge = currentAge;
        }
        if(currentAge < youngestAge){
          youngestGuestName = guestList[i][0];
          youngestAge = currentAge;
        }
      }
    }



System.out.println("");
System.out.println("Total amount of guests: " + totalGuestAmount);
System.out.println("Total amount of adults: " + totalguestAmountAdults);
System.out.println("Total amount of kids: " +  totalguestAmountKids);

if(totalGuestAmount > 0){
  System.out.println("Oldest guest: " + oldestGuestName + " - " + oldestAge);
  System.out.println("Youngest guest: " + youngestGuestName + " - " + youngestAge);
}

System.out.println("");
  }

  public static void addGuest(String name, String age){
    boolean foundEmptySpace = false;

    for(int i = 0; i < guestList.length; i++){
      if(guestList[i][0] == "" && !foundEmptySpace){
        foundEmptySpace = true;
        guestList[i][0] = name;
        guestList[i][1] = age;
      }
    }
  }

  public static void addGuestExternal(){
    System.out.println("You chose to add a guest"); //you don't need to keep this line

    String newGuestName;
    String newGuestAge;

    input.nextLine();
    System.out.println("Enter the name of the new guest");
    newGuestName = input.nextLine();
    System.out.println("Enter the age of the new guest");
    newGuestAge = input.nextLine();

    addGuest(newGuestName, newGuestAge);
  }

  public static void changeNamneOfGuest(int nameChangeChoice, String newName){
    for(int i = 0; i < guestList.length; i++){
      if(nameChangeChoice == i){
      guestList[i][0] = newName;
      }
    }
  }
  public static void changeNamneOfGuestExternal(){
    System.out.println("You chose to change the name of a guest"); //you don't need to keep this line
    int nameChangeChoice;
    printGuestList();

    nameChangeChoice = getArrayIndexFromUser("select which guest to change the name of");

    String newName;
    System.out.println("Enter new name");
    input.nextLine();
    newName = input.nextLine();

    changeNamneOfGuest(nameChangeChoice, newName);
  }



  public static void changeAgeOfGuest(int ageChangeChoice, String newAge){
    System.out.println("You chose to change the age of a guest"); //you don't need to keep this line

    for(int i = 0; i < guestList.length; i++){
      if(ageChangeChoice == i){
      guestList[i][1] = newAge;
      }
    }
  }

  public static void changeAgeOfGuestExternal(){
    System.out.println("You chose to change the age of a guest"); //you don't need to keep this line

    int ageChangeChoice;
    printGuestList();

    ageChangeChoice = getArrayIndexFromUser("select which guest to change the age of");

    String newAge;
    System.out.println("Enter new age");
    String filler = input.nextLine();
    newAge = input.nextLine();

    changeAgeOfGuest(ageChangeChoice, newAge);
  }

  public static void removeGuest(){
    System.out.println("You chose to remove a guest"); //you don't need to keep this line
    int removeChoice;
    printGuestList();

    removeChoice = getArrayIndexFromUser("select which guest to remove");

    for(int i = 0; i < guestList.length; i++){
      if(removeChoice == i){
        for(int j = 0; j < guestList[i].length; j++){
          guestList[i][j] = "";
        }
      }
    }
  }

  public static void changePlaces(){
    int swapChoiceOne;
    int swapChoiceTwo;
    printGuestList();

    System.out.println();
    swapChoiceOne = getArrayIndexFromUser("select which guests to swap places with");

    swapChoiceTwo = getArrayIndexFromUser("select which guests to swap places with");

    String[] temp = guestList[swapChoiceOne];
    guestList[swapChoiceOne] = guestList [swapChoiceTwo];
    guestList[swapChoiceTwo] = temp;

    System.out.println("You chose to switch places between index "+swapChoiceOne+" and "+swapChoiceTwo); //you don't need to keep this line
  }

  public static void printMenu(){
    System.out.println("Program menu"); //you don't need to keep this line
    System.out.println("Please select an option from the following list:");
      System.out.println("1. print guest list");
      System.out.println("2. add a guest.");
      System.out.println("3. change the name of a guest.");
      System.out.println("4. change the age of a guest.");
      System.out.println("5. remove a guest.");
      System.out.println("6. swap places for guests.");
      System.out.println("7. print statistics.");
      System.out.println("0. exit software");
  }

  public static int getArrayIndexFromUser(String prompt){
  boolean inputCheck = false;
  int index = 0;

    while(!inputCheck){
      System.out.println(prompt);
      index = input.nextInt();

      if(index > guestList.length){
        System.out.println("not a valid choice");
      }else{
        inputCheck = true;
      }
    }
    return index;
  }

  public static void main(String[] args) {
    int menuChoice;
     // Add you code here with the main loop that handles the user's menu choices.
     do{
      printMenu();
       System.out.println("Select an option");
       menuChoice = input.nextInt();

       if (menuChoice == 1){
         printGuestList();
       }else if(menuChoice == 2){
         addGuestExternal();
       }else if(menuChoice == 3){
         changeNamneOfGuestExternal();
       }else if(menuChoice == 4){
         changeAgeOfGuestExternal();
       }
       else if(menuChoice == 5){
         removeGuest();
       }else if(menuChoice == 6){
         changePlaces();
       }else if(menuChoice == 7){
         printStatistics();
       }else{
         System.out.println("");
         System.out.println("Not a valid choice");
         System.out.println("");
       }
     }
     while(menuChoice != 0);
     System.out.println("Exiting software.");
  }
}
