import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import java.util.List;
import java.util.ArrayList;


/* 
Game Path:
The user has to fight a monster. They get to choose 3 things:
- Bow and Arrow
- Sword
- Knife

If they choose the bow, they will shoot the monster and be safe (success)
If they choose the sword, they will go to fight it (multiple attempts), but not be strong enough, requring that they go back to get a new weapon.
If they choose the knife, they will die and have to restart.

*/

public class Game {
    public static void main(String[] args) {
        // Display lore
        display("You were trapped in a labyrinth, and have nearly found your way out.");
        display("However, there is a monster covering the exit.");
        display("Luckily, you have collected a few weapons on your way out.");
        display("But, to get to the exit (and the monster), you have to slip through a thin wall.");
        display("You can only fit yourself and a single weapon through the crack.");
        
        List<String> weaponsAvailable = new ArrayList<String>() {{
            add("1) Sword");
            add("2) Bow and Arrow");
            add("3) Knife");
        }};

        // Get User input
        Scanner scanner = new Scanner(System.in);

        try {
            while (weaponsAvailable.size() > 0) {
                // Display options
                display("Which weapon will you take?");

                for (String weapon : weaponsAvailable) display(weapon);

                display("Your choice: ");
                String choice = scanner.nextLine();

                switch (choice) {
                    case "1":
                        display("You have chosen to take the Sword.");
                        display("You leave the other weapons behind and slide through the crack.");
                        display("You see the monster. You take your sword and look the creature in the eye.");
                        display("You must choose whether to swing or stab.");

                        List<String> messages = new ArrayList<String>() {{
                            add("A powerful blow! But the monster still lives.");
                            add("Another strike! It'll just take one more hit!");
                            add("You go to attack, but alas! You are swept off your feet by the monster and have lost your sword!");
                        }};

                        for (String message : messages) {
                            display("Choices:");
                            display("1) Swing");
                            display("2) Stab");
                            scanner.nextLine();
                            display(message);
                        }

                        weaponsAvailable.remove(0); // Remove the sword

                        display("Wounded, you scramble back through the crack, barely escaping with your life.");
                        display("Your sword is gone, but you still have other weapons behind left.");
                        display("You must choose a different weapon to face the monster again.");
                        break;

                    case "2":
                        display("You have chosen the Bow and Arrow.");
                        display("You leave the other weapons behind and slide through the crack.");
                        display("The monster sees you and starts charging.");
                        display("You quickly prepare your bow and shoot.");
                        display("The monster falls dead on the floor.");
                        display("-------------- VICTORY --------------");
                        display("You have defeated the monster! You walk out of the labyrinth safely with nothing but a scratch.");
                        display("As you walk out, your eyes adjust to the harsh light.");
                        System.exit(0);

                    case "3":
                        display("You have chosen the Knife.");
                        display("You leave the other weapons behind and slide through the crack.");
                        display("You look the monster in the eye and charge with conviction, emitting a loud war cry.");
                        display("You jump into the air and hold out the knife. With bravery, you come ever closer to the monster.");
                        display("Alas! The monster has heard your war cry and slapped you out of the air.");
                        display("You hit the concrete so hard that you are knocked out.");
                        display("The monster gets a much needed snack.");
                        display("-------------- DEFEAT --------------");
                        display("You were defeated by the monster.");
                        System.exit(0);
                
                    default:
                        break;
                    }
                    display("--------------------------------------");
            }
        } finally {
            scanner.close();
        }
    }

    public static void display(String message) {
        for (int i = 0; i < message.length(); i++) {
            System.out.print(message.charAt(i));
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                System.out.println("\nError: Display interrupted.");
                return;
            }
        }
        System.out.print("\n");
        try {
            TimeUnit.MILLISECONDS.sleep(400);
        } catch (InterruptedException e) {
            System.out.println("\nError: Display interrupted.");
            return;
        }
    }
}