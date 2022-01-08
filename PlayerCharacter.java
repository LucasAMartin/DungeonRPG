// Author: Lucas Martin
// Date: 11/21/21
// File: PLayerCharacter.java
// Java file to create player object

// class to create the player object with the given traits/occupation
public class PlayerCharacter {
   
   // fields
   private String playerName; 
   private int playerOccupation;         
   private int playerHP;
   private int playerBaseDamage ; //max damage a player can do in a turn
   private int healthPotions;
   private int healAmount; //how much each health potion heals the player
   
   // setter methods
   public void setPlayerName(String inputPlayerName) {   
      playerName = inputPlayerName; 
   }   
   public void setPlayerHP(int inputHP) {
      playerHP = inputHP; 
   }
   public void setBaseDamage(int inputBaseDamage) {
      playerBaseDamage = inputBaseDamage; 
   }
   public void setHealthPotions(int inputHealthPotions) {
      healthPotions = inputHealthPotions; 
   }
   public void setHealAmount(int inputHealAmount) {
      healAmount = inputHealAmount; 
   }
   public void setPlayerOccupation(int inputPlayerOccupation) {
      playerOccupation = inputPlayerOccupation; 
   }
   
   // methods to change player base stats
   public int changePlayerHP(int playerHP, int inputHealthChange){
      playerHP += inputHealthChange;
      return playerHP;
   }
   public int changeBaseDamage(int playerBaseDamage, int inputDamageChange){
      playerBaseDamage += inputDamageChange;
      return playerBaseDamage;
   }
   public int changeHealAmount(int playerHealAmount, int inputHealingChange){
      playerHealAmount += inputHealingChange;
      return playerHealAmount;
   }   
   
   // getter methods
   public String getPlayerName() {
      return playerName;
   }
   public int getPlayerHP() {
      return playerHP;
   }   
   public int getBaseDamage() {
      return playerBaseDamage;
   }   
   public int getHealthPotions() {
      return healthPotions;
   }   
   public int getHealAmount() {
      return healAmount;
   }   
   public int getPlayerOccupation() {
      return playerOccupation;
   }
   
   // constructor that sets default stats
   public PlayerCharacter (String inputPlayerName, int inputPlayerOccupation) {
      playerHP = 100;
      playerBaseDamage = 20;
      healthPotions = 2;
      healAmount = 10;
      inputPlayerOccupation = playerOccupation;
      inputPlayerName = playerName;   
   }
   // method which distributes bonus stats based on what occupation the player chose
   public void bonusStats(int inputPlayerOccupation) {
      switch (inputPlayerOccupation) {
         case (1):
            playerBaseDamage = changeBaseDamage(playerBaseDamage, 10);
            System.out.println("\nOf course, I was top of my class in the art of the sword!\n\t\t+10 Attack Damage");
            break;
         case (2):
            healAmount = changeHealAmount(healAmount, 10);
            System.out.println("\nOf course, I was top of my class in herbal pharmacology! Mandrake root? Fisstech? I know it all!\n\t\t+10 Potion Effectiveness");
            break;
         case (3):
            playerHP = changePlayerHP(playerHP, 30);
            System.out.println("\nOf course, being an absolue unit is quite easy when I'm 7 feet tall \nand walk around at 280 of pure mass!"
                               +" Now that I think about it, \nit's really the only thing I'm good at...\n\t\t+30 HP");
            break;    
      }
   }
   // result of liquid drinking story segment, player either lose, gain, or see no change in health based on choice
   public void playerYummyLiquidResult(int playerOccupation, int drinkLiquid) {
      switch (playerOccupation) {
         case (1):
            if (drinkLiquid == 1){               
               playerHP += -30;
               System.out.println("\nYou take a nice big swig from a pool on the ground, and nearly instantaneously" 
                                 + " feel a shock of pain \nthrough your extremities. Your left thumb falls clean off."
                                 +" Ouch. That was a bad idea.\n\t\t-30 HP\nNonetheless, undeterred by your lacking digit, you venture on.");
            }
            if (drinkLiquid == 2){
               System.out.println("\nUsing your inturition gained from years of having more than two brain cells"
                                 +" you decide not to drink random liquids. You venture on."); 
            }
            break;
      }
      switch (playerOccupation) {
         case (2):
            if (drinkLiquid == 1){               
               playerHP += -30;
               System.out.println("\nYou take a nice big swig from a pool on the ground, and nearly instantaneously" 
                                 + " feel a shock of pain \nthrough your extremities. Your left thumb falls clean off."
                                 +" Ouch. That was a bad idea.\n\t\t-30 HP\nNonetheless, undeterred by your lacking digit, you venture on.");
            }
            if (drinkLiquid == 2){
               System.out.println("\nUsing your inturition gained from years of rigourous course work and studying"
                                 +" you decide not to drink random liquids. You venture on."); 
            }
            break;
      }
      switch (playerOccupation) {
         case (3):
            if (drinkLiquid == 1){               
               playerHP += 30;
               System.out.println("\nYou take a nice big swig from a pool on the ground, and nearly instantaneously" 
                                 + " feel a shot of energy \ncourse through your veins. You feel great!"
                                 +"\n\t\t+30 HP\nRejuvinated and excited you venture on.");
            }
            if (drinkLiquid == 2){
               System.out.println("\nMama always told you not to trust cranberry juice from strangers."
                                 +" You decide not to drink. You venture on."); 
            }
            break;
      }
     
   }
}