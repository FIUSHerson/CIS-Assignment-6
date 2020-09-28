/*******************************************************************************************************************
* Chapter 3, Exercise 11
* Author: Alexander Anthis
* CIS 129 - Programming and Problem Solving I 
******************************************************************************************************************/

import java.util.*;

/**
 * CIS129_assignment6.1_alexanderAnthis
 */
public class CIS129_assignment6_alexanderAnthis {

    static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        final int HOT_DOG_PACK_SIZE = 10;
        final int BUN_PACK_SIZE = 8;

        displayWelcome(HOT_DOG_PACK_SIZE, BUN_PACK_SIZE);

        // Input
        int numberOfPeople = getInteger("How many people are attending? : ");
        int hotDogsPerPerson = getInteger("How many hot dogs can each person have? : ");
        printNorm("");

        // Processing
        int hotDogsRequired = getHotDogsRequired(numberOfPeople, hotDogsPerPerson);
        
        int hotDogPackagesRequired = getHotDogPackagesRequired(hotDogsRequired, HOT_DOG_PACK_SIZE);
        int extraHotDogs = getExtraHotDogCount(hotDogPackagesRequired, HOT_DOG_PACK_SIZE, hotDogsRequired);

        int bunPackagesRequired = getBunPackagesRequired(hotDogsRequired, BUN_PACK_SIZE);
        int extraBuns = getExtraBunCount(bunPackagesRequired, BUN_PACK_SIZE, hotDogsRequired);

        // Output
        displayResults(hotDogsRequired, hotDogPackagesRequired, extraHotDogs, bunPackagesRequired, extraBuns);
    }

    /**
     * Fancy print functions with useful indicators
     * @param text
     */
    public static void printNorm(String text) {
        System.out.println("[ ] " + text);
    }
    public static void printWarn(String text) {
        System.out.println("[*] " + text);
    }
    public static void printCrit(String text) {
        System.out.println("[!] " + text);
    }

    /**
     * Script to display a welcome message
     * @param HOT_DOG_PACK_SIZE
     * @param BUN_PACK_SIZE
     */
    public static void displayWelcome(final int HOT_DOG_PACK_SIZE, final int BUN_PACK_SIZE) {
        printNorm("");
        printNorm("Welcome to the Hot Dog Cookout Calculator!");
        printNorm("This program will give you the optimal amount of resources you need.");
        printNorm("");
        printNorm(String.format("By default, the hot dog pack size is %s, and the bun size is %s.", HOT_DOG_PACK_SIZE, BUN_PACK_SIZE));
        printNorm("");
        printNorm("Let's get started.");
        printNorm("");
    }

    /**
     * Returns the amount of hot dogs required
     * @param numberOfPeople
     * @param hotDogsPerPerson
     * @return hotDogsRequired
     */
    public static int getHotDogsRequired(int numberOfPeople, int hotDogsPerPerson) {
        return numberOfPeople * hotDogsPerPerson;
    }

    /**
     * Returns the amount of hot dog packages required
     * @param hotDogsRequired
     * @param HOT_DOG_PACK_SIZE
     * @return hotDogPackagesRequired
     */
    public static int getHotDogPackagesRequired(int hotDogsRequired, final int HOT_DOG_PACK_SIZE) {
        return (hotDogsRequired / HOT_DOG_PACK_SIZE) + 1;
    }

    /**
     * Returns the extra hot dog count
     * 
     * @param hotDogsRequired
     * @param HOT_DOG_PACK_SIZE
     * @param hotDogPackagesRequired
     * @return extraHotDogs
     */
    public static int getExtraHotDogCount(int hotDogPackagesRequired, int HOT_DOG_PACK_SIZE,
            final int hotDogsRequired) {
        return (hotDogPackagesRequired * HOT_DOG_PACK_SIZE) - hotDogsRequired;
    }

    /**
     * Gets the amount of hot dog bun packages required
     * @param hotDogsRequired
     * @param BUN_PACK_SIZE
     * @return bunPackagesRequired
     */
    public static int getBunPackagesRequired(int hotDogsRequired, final int BUN_PACK_SIZE) {
        return (hotDogsRequired / BUN_PACK_SIZE) + 1;
    }

    /**
     * Returns the extra bun count
     * @param hotDogsRequired
     * @param BUN_PACK_SIZE
     * @return extraBuns
     */
    public static int getExtraBunCount(int bunPackagesRequired, int BUN_PACK_SIZE,
            final int hotDogsRequired) {
        return (bunPackagesRequired * BUN_PACK_SIZE) - hotDogsRequired;
    }

    /**
     * This function displays the results of all the calculations to the user
     * @param hotDogsRequired
     * @param hotDogPackagesRequired
     * @param extraHotDogs
     * @param bunPackagesRequired
     * @param extraBuns
     */
    public static void displayResults(int hotDogsRequired, int hotDogPackagesRequired, int extraHotDogs, int bunPackagesRequired, int extraBuns) {
        printNorm("==================================================");
        printNorm("");
        printNorm("Here are the results...");
        printNorm("");
        printNorm("Number of hot dogs required: " + hotDogsRequired);
        printNorm("Number of hot dog packages required: " + hotDogPackagesRequired);
        printNorm("");
        printNorm("Number of buns required: " + hotDogsRequired);
        printNorm("Number of bun packages required: " + bunPackagesRequired);
        printNorm("");
        printNorm("Number of extra hot dogs: " + extraHotDogs);
        printNorm("Number of extra buns: " + extraBuns);
        printNorm("");
        printNorm("==================================================");
    }
    
    /**
    * Prompt the user for an integer input and return the value
    * @param msg
    * @return User input
    */
    public static int getInteger(String msg) {
        System.out.print("[?] " + msg);
        return keyboard.nextInt();
    }
}