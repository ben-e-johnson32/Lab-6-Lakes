package com.BenJohnson;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner numScanner = new Scanner(System.in);
    static Scanner stringScanner = new Scanner(System.in);

    public static void main(String[] args)
    {

        // Call the GetUserInput method to get a list of LakeTime objects.
        ArrayList<LakeTime> lakes = GetUserInput();

        // Display output. Loop through the list of LakeTime objects to get the name and the fastest time.
        System.out.println("Best times for each lake: ");
        for (LakeTime lt : lakes)
        {
            System.out.println(lt.getName() + ": " + lt.getFastestTime());
        }
        stringScanner.close();
        numScanner.close();
    }

    private static ArrayList<LakeTime> GetUserInput()
    {
        // An empty list for the lakes.
        ArrayList<LakeTime> lakes = new ArrayList<>();

        // While true loop allows the user to add as much data as they want.
        while (true)
        {
            // A boolean flag telling us whether or not there are already times for the lake.
            boolean lakeExists = false;
            // An int for the index of the lake if it does already have times entered.
            int lakeIndex = -1;

            // An empty object declaration.
            LakeTime lakeTime;

            // Take the name of the lake.
            System.out.print("Enter the name of the lake: ");
            String lake = stringScanner.nextLine();

            // Loop through the list of lakes to check if what the user typed is already in there.
            for (int x = 0; x < lakes.size(); x++)
            {
                if (lake.equals(lakes.get(x).getName()))
                {
                    // If the lake is in the list, set the flag to true and set the index, then break out of the loop.
                    lakeExists = true;
                    lakeIndex = x;
                    break;
                }
            }

            // If the lake doesn't exist in the list, create a new LakeTime object and add it to the list.
            if (!lakeExists) { lakeTime = new LakeTime(lake); lakes.add(lakeTime); }
            // If it does exist, set the LakeTime object to the one that's already made.
            else { lakeTime = lakes.get(lakeIndex); }

            // Get the time input from the user and add it to the LakeTime object's list of times.
            System.out.print("Enter your time for " + lakeTime.getName() + ": ");
            Double time = numScanner.nextDouble();
            lakeTime.addTime(time);

            // User decides whether to add more data or not.
            System.out.print("Enter another time? (Y/N) >>> ");
            String keepGoing = stringScanner.nextLine();
            if (keepGoing.equalsIgnoreCase("n"))
            { break; }
        }

        return lakes;
    }
}
