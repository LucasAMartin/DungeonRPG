// Author: Lucas Martin
// Date: 11/21/21
// File: EnemyCombat.java
// Java file to combat system

import java.util.Random;
import java.util.Scanner;

public class EnemyCombat {
   
   // define player fields
   private String [] playerAttacks = {"rush", "backhand", "do a spinning back kick at", 
                                      "perform the 1-2-3 banana split attack to",  "attack", "land a critical hit on", 
                                      "headshot", "cheap shot", "tie together the shoe laces of", "truck", "posterize", "lunge at"};
   private int healthPotions;
   private int runningWinCount;

   // define enemy fields
   private String [] enemyNames = {"maruader", "bandit", "skeleton", "spider", "sorcerer", "demon", "minotaur", 
                                 "reptillain humanoid", "ankle biter", "evil young man named Cody"};
   private String [] enemyPrefixes = {"towering", "fat", "terrifying", "swole", "dashingly handsome", 
                                     "handicapped", "moronic","midget", "suave", "drippy"};
   private String [] enemyReactions = {"enraged", "sad", "suspicously excited", "bored", 
                                      "content with their skills", "somewhat turned on", "angry","evil"};
   private String enemyName = "000";
   private String enemyPrefix = "000";
   private String enemyReaction = "000";
   private int playerCombatChoice; // which option player chooses during combat scenario
   private int enemyMaxHP = 50;
   private int enemyHP;
   private int enemyBaseDamage = 10; //max damage an enemy can do in a turn
   private int enemyDamage; //changes each turn during combat
   
   // getter methods
   public String getEnemyName() {
      return enemyName;
   }
   public String getEnemyPrefix() {
      return enemyPrefix;
   }
   public int getEnemyHP() {
      return enemyHP;
   }
   public int getEnemyBaseDamage() {
      return enemyBaseDamage;
   }
   public int getHealthPotions() {
      return healthPotions;
   }
   public int getRunningWinCount() {
      return runningWinCount;
   }
   //setter methods
   public void setHealthPotions(int inputHealthPotions) {
      healthPotions = inputHealthPotions;
   }
   public void setRunningWinCount(int winCount) {
      runningWinCount = winCount;
   }
   // method that will randomly generate an enemy recation to being hit in combat
   public String getEnemyReaction () {
      enemyReaction = enemyReactions[random.nextInt(enemyReactions.length)];
      return enemyReaction;
   }   
   // create instance of random class
   Random random = new Random();
   
   // method where most combat takes place
   public int combatScenario (int playerBaseDamage, int playerHP, int healthPotions, int healAmount ) {
      enemyName = enemyNames[random.nextInt(enemyNames.length)]; // use array to create random name and hp amount for enemy
      enemyPrefix = enemyPrefixes[random.nextInt(enemyPrefixes.length)];
      enemyHP = random.nextInt(enemyMaxHP);
      enemyBaseDamage = 10;
      boolean playerDidRun = false;
      
      Scanner keyboard = new Scanner(System.in);
      System.out.println("---------------------------------------------------------------------");
      System.out.println("A " + enemyPrefix + " " + enemyName + " with " + enemyHP 
                     + " HP has appeared! What will you do?");
      while (enemyHP > 0) {
         System.out.println("---------------------------------------------------------------------");
         //exit program if player dies
         if (playerHP <= 0) {
            System.out.println("You have died");
            System.exit(0) ;
         }
         System.out.print("1. Attack!\n2. Healing Potion\n3. Run "); 
         int playerCombatChoice = keyboard.nextInt();
         // stop player from choosing option that does not work
         while (playerCombatChoice != 1 && playerCombatChoice != 2 && playerCombatChoice != 3) {
            System.out.println("Not a correct choice bro\n");
            System.out.print("1. Attack!\n2. Healing Potion\n3. Run "); 
            playerCombatChoice = keyboard.nextInt();
         }
         // attack if player chooses attack
         switch (playerCombatChoice) {
            case (1):         
               int enemyDamage = random.nextInt(enemyBaseDamage);
               int playerDamage = random.nextInt(playerBaseDamage);
               String enemyReaction = enemyReactions[random.nextInt(enemyReactions.length)];
               String playerAttackPerformed = playerAttacks[random.nextInt(playerAttacks.length)];
               playerHP -= enemyDamage;
               enemyHP -= playerDamage;
               if (enemyHP <= 0) {
                  enemyHP = 0;
               }               
               System.out.println("\nYou " +playerAttackPerformed +  " the " + enemyName + ", doing " + playerDamage + " damage");
               System.out.println("The enemy, feeling " + enemyReaction + ", strikes back and deals " + enemyDamage + " damage");
               System.out.println("You now have " + playerHP + " HP remaining\nThe " + enemyName + " has " + enemyHP + " HP remaining");
               break;
            //check if player has health potions and heal
            case (2):
               if (healthPotions >= 1) {
                  healthPotions--;
                  System.out.println("\nYou consume a health potion. You heal for " + healAmount + "\nYou now have " + healthPotions + " remaining");
                  playerHP += healAmount;
               } 
               // if out of healh potions display a message and allow player to choose again
               else {
                  System.out.println("\nYou're out of health potions! The " + enemyName + " advances towards you");                     
               } 
               break;
            case (3):
               //escape from combat, but take a bit of damage
               enemyDamage = random.nextInt(enemyBaseDamage);
               System.out.println("You're able to escape from the battle. However, in the process you take " + enemyDamage + " damage");
               playerHP -= enemyDamage;  
               break;                   
         }
         // if player choose to run skip the next part because they do not deserve health potions >:(
         if (playerCombatChoice == 3) {
            playerDidRun = true;
            break; 
         } 
      }
      if (playerDidRun == false){
         ++runningWinCount;
         setRunningWinCount(runningWinCount);      
         System.out.println("The " + enemyName + " has been defeated!");
         //if the player has less then 2 health potions give them either 1 or 2 as an enemy drop
         if (healthPotions < 2) {
            int itemDrop = random.nextInt(2) + 1;
            healthPotions += itemDrop;
            System.out.println("The enemy has dropped something.... +" + itemDrop
                           + " health potions\nYou now have " + healthPotions 
                           + " health Potions");
         }                     
      }
      setHealthPotions(healthPotions);
      return playerHP;
   
   }
}