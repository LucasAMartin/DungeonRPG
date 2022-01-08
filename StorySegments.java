// Author: Lucas Martin
// Date: 11/21/21
// File: StorySegments.java
// Java file for story portions of game

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class StorySegments {
   
   Scanner keyboard = new Scanner(System.in);
   
   // begin the story and get the player's name
   public String storyIntroName() {
      System.out.println("You awaken in a dark, damp cavern with nothing but a single match and a pounding headache, "
                         + "you attempt to recall\nlast night's events. Last night's events? What was I doing last night?" 
                         + " Wait, where am I? Who am I?");
      System.out.print("\nEnter name- ");
      String playerName = keyboard.nextLine();
      return playerName;
   }
   // get the background occupation that the player chooses
   public int storyIntroOccupation(String inputPlayerName) {
      System.out.println("\nAh right, " + inputPlayerName + ". Man, I haven't felt this terrible since" 
                         + " that night at the Academy. Wait, the Academy? What was I studying again?");
      System.out.println("\n\t\tSwordsmanship- 1 \n\t\tMedicine- 2 \n\t\tThe art of being an absolue unit- 3");
      System.out.print("\nPress the corresponding number to select option- ");
      int playerOccupation = keyboard.nextInt();
      // stop player from being stupid and not choosing a correct option
      while (playerOccupation != 1 && playerOccupation != 2 && playerOccupation != 3) {
         System.out.print(" That was not an option. Choose again- ");
         playerOccupation = keyboard.nextInt();   
      }
      return playerOccupation;
   }
   // a choice the player can make with different responses based off their chosen occupation
   public void storyIntroYummyRedJuice(int playerOccupation){
      System.out.println("\nAfter a few minutes of reflection, you're able to gather your thoughts "
                         + "and finally begin to take in your surroundings.\nLighting your match,"
                         + " you look all around. On the ground, you find two vials. You're not sure what they are,\n"
                         + "but picking them up seems to lessen the ache in your head, as if they have some sort of magical properties.\n\t\t+2 Health Potions"
                         + "\nAbove you, stalagmites seem to be dripping some mysterious red liquid.");  
      switch (playerOccupation) {
         case (1):
            System.out.println("\nI am feeling a bit thirtsy.. although drinking weird dripping mystery juice"
                               + " is probably a bad Idea.");
            break;
         case (2):
            System.out.println("\nBecause of your pharamacology background, you instantly recognize it as Enavotol,"
                               + " a highly potent neurotoxin. \nYou know that one drop is enough to put a grown man"
                               + " on his knees. \nYou wouldn't possibly taste it, would you? Of course not.");
            break;
         case (3):
            System.out.println("\nOh, Cranberry juice! My mother used to make it all the time! I'm terribly"
                               + " thirsty, I should drink some.");
            break;
      }
   }
   // continuation of last method to get players choice              
   public int playerYummyLiquidChoice() {
      int drinkLiquid = 0;
      
      System.out.println("\nWhat should I do? \n\n\t\tDrink- 1 \n\t\tIgnore it- 2");
      drinkLiquid = keyboard.nextInt();
            
      while (drinkLiquid != 1 && drinkLiquid != 2) {
         System.out.println("That wasn't an option, idiot");
         System.out.println("\nWhat should I do? \n\t\tDrink- 1 \n\t\tIgnore it- 2");
         drinkLiquid = keyboard.nextInt();         
      }
      return drinkLiquid;
   }
   // intro to first combat sequence 
   public void firstCombatSegment(){
      System.out.println("\nOut of the corner of your eye, you see a projectile flying towards you." 
                         + " You just barely duck out of the way.");
   } 
    // intro to combat arena
   public void arenaStorySegment() {
      System.out.println("Before you're even able to catch your breath, you look around you to realize where" 
                         + " you have found yourself.\nYou're in the combat arena... OF DEATH!");
   }
   // allow the player to stop the game if they want
   public boolean arenaEscapeChoice() {
      System.out.println("You see a gap in the enemies.. if you make a break for it now you may be"
                         + " able to make an escape now.");
                         System.out.println("---------------------------------------------------------------------");
                         System.out.print("\t\t1. Continue Battling\n\t\t2. Escape [");
      boolean running = true;
      int choice = keyboard.nextInt();
      if (choice == 2){
         running = false;
      }
      return running;  
   }
   // runs when the player chooses to escape and prints how many dudes they killed to a file
   public void escapeSegment(String playerName, int winCount) {
      if (winCount < 4){
         System.out.println("You casually stroll your way out of the dungeon, with nothing but a scratch to show for it. Good job."
                               + " You only killed " + winCount + " enemies.\nKinda Cringe but ok. Thanks for playing I guess.");
      }
      else if (winCount >= 4 && winCount < 10) {
         System.out.println("You're able to bust through the line of enemies. Feeling exhausted, you managed to take out\n"
                              + winCount + " enemies. Not bad. Thanks for playing!");  
      }
      else if (winCount >= 10) {
         System.out.println("Bloody and beaten, you limp your way out of the dungeon. You look behind you and glance at the trail of the "
                             + winCount + " \nbodies of those unfortunate souls who dared to stand in your way. You are truly an epic gamer. Thanks for playing!");  
      }
      try {
         FileWriter outputFile = new FileWriter("winCountFile", true);
         outputFile.write("\n" + playerName + "- " + winCount);
         outputFile.close();
      }
      catch (IOException error) {
         System.out.println("An error occured while writing score to file");
      }
      
      
   }                         
}