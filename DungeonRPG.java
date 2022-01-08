// Author: Lucas Martin
// Date: 11/21/21
// File: DungeonRPG.java
// A choose your own adventure style RPG

import java.util.Scanner;
import java.util.Random;

public class DungeonRPG {

    public static void main(String args[]) {
        // create object from class that contains story segments
        StorySegments segment = new StorySegments();

        // begin story and get player name and occupation choice
        String playerName = segment.storyIntroName();
        int playerOccupation = segment.storyIntroOccupation(playerName);

        //create player object from PlayerCharacter class and assign them
        // bonus stats based off the choice made earlier
        PlayerCharacter player = new PlayerCharacter(playerName, playerOccupation);
        player.bonusStats(playerOccupation);

        // story method about drinking yummy red stuff
        segment.storyIntroYummyRedJuice(playerOccupation);
        int drinkLiquid = segment.playerYummyLiquidChoice();
        //Different paths based off player background and choice
        player.playerYummyLiquidResult(playerOccupation, drinkLiquid);

        // introduction for first combat sequence
        segment.firstCombatSegment();

        //first combat sequence
        EnemyCombat enemy = new EnemyCombat();
        int baseDamage = player.getBaseDamage();
        int playerHP = player.getPlayerHP();
        int healthPotions = player.getHealthPotions();
        int healAmount = player.getHealAmount();
        playerHP = enemy.combatScenario(baseDamage, playerHP, healthPotions, healAmount);
        healthPotions = enemy.getHealthPotions();
        player.setHealthPotions(healthPotions);
        player.setPlayerHP(playerHP);

        // combat arena of death
        segment.arenaStorySegment();
        boolean running = true;
        while (running == true) {
            playerHP = player.getPlayerHP();
            playerHP = enemy.combatScenario(baseDamage, playerHP, healthPotions, healAmount);
            healthPotions = enemy.getHealthPotions();
            player.setHealthPotions(healthPotions);
            player.setPlayerHP(playerHP);
            running = segment.arenaEscapeChoice();
        }
        // part where the player escapes
        int runningWinCount = enemy.getRunningWinCount();
        segment.escapeSegment(playerName, runningWinCount);
    }
}

 
   
