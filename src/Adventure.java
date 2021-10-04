import java.util.Scanner;
public class Adventure {
    static Scanner input = new Scanner (System.in);
    static Player player = new Player();
    static String gameDescription = "This is an adventure game where you can explore a haunted house.\nUse command help to view commands you can use.";
    static String gameCommands = "Commands:\nhelp - See the different commands\ngo [direction] - go in the desired direction\nlook - Prints the description of the current room";

    public static void main(String[] args) {
        initialize();
        game();
    }

    public static void initialize() {
        //Vi opretter et rum-objekt for hvert rum med et navn og en beskrivelse.
        Room room1 = new Room("The foyer", "The light is dim and the room is covered is cobwebs and dust");
        Room room2 = new Room("The office", "There's an old wooden desk with a worn out leather chair in front of it");
        Room room3 = new Room("The library", "Books cover the walls, most of them look like they'd fall apart if opened");
        Room room4 = new Room("The kitchen", "There's old gas stoves. Copper pans and pots litter this place");
        Room room5 = new Room("The basement", "As you go down the ladder it breaks and you find yourself trapped alongside cages with bones and skulls in them");
        Room room6 = new Room("The depot", "There's shelves with weird devices, as well as glass jars with what looks like organs");
        Room room7 = new Room("The attic", "Up here there's old propaganda posters");
        Room room8 = new Room("The bedroom", "There's a bed with perfect bedding that hasn't been touched for a very long time. Looking around you see a hatch in the north of the room");
        Room room9 = new Room("The lab", "There's an operating table with dried blood all over");

        //Vi mapper rummenes forbindelser | Rummene forbinder ikke med hinanden automatisk, da man ikke skal kunne gå igennem room 5 begge veje i vores version af spillet
        room1.setEast(room2);
        room1.setSouth(room4);
        room2.setWest(room1);
        room2.setEast(room3);
        room3.setEast(room2);
        room3.setSouth(room6);
        room4.setNorth(room1);
        room4.setSouth(room7);
        /*
        Vi har fjernet udgangen for rum 5 for at man bliver fanget
        room5.setSouth(room8);
         */
        room6.setNorth(room3);
        room6.setSouth(room9);
        room7.setNorth(room4);
        room7.setEast(room8);
        room8.setWest(room7);
        room8.setNorth(room5);
        room8.setEast(room9);
        room9.setNorth(room6);
        room9.setWest(room8);

        //Vi opretter et navn til spilleren og sætter start rummet
        player.setPlayerName("Johannes");
        player.setRoom(room1);
    }

    public static void game() {
        //Vi giver spilleren en kort introduktion
        System.out.println("Hi " + player.getPlayerName());
        System.out.println(gameDescription + "\n");
        System.out.println("- GAME START -");
        printCurrentRoom();

        //Vi gentager denne while så længe at brugeren vil spille
        while(true) {
            System.out.println("Where do you want to go?");
            inputAction();
        }

    }

    public static void inputAction() {
        //inputAction tjekker for bruger input og handler derefter
        String userInput = input.nextLine();
        String wrongRoom = "There's no room this way. Try another direction.";
        System.out.println();

        if (userInput.equalsIgnoreCase("go north") || userInput.equalsIgnoreCase("north")) {
            if(player.goNorth()) {
                printCurrentRoom();
            } else {
                System.out.println(wrongRoom);
            }
        } else if (userInput.equalsIgnoreCase("go east") || userInput.equalsIgnoreCase("east")) {
            if(player.goEast()) {
                printCurrentRoom();
            } else {
                System.out.println(wrongRoom);
            }
        } else if (userInput.equalsIgnoreCase("go south") || userInput.equalsIgnoreCase("south")) {
            if(player.goSouth()) {
                printCurrentRoom();
            } else {
                System.out.println(wrongRoom);
            }
        } else if (userInput.equalsIgnoreCase("go west") || userInput.equalsIgnoreCase("west")) {
            if(player.goWest()) {
                printCurrentRoom();
            } else {
                System.out.println(wrongRoom);
            }
        } else if (userInput.equalsIgnoreCase("exit")) {
            System.out.println("Quitting game...");
            System.exit(0);
        } else if (userInput.equalsIgnoreCase("help")) {
            System.out.println(gameCommands + "\n");
        } else if (userInput.equalsIgnoreCase("look")) {
            System.out.println(player.getRoom().getName());
            System.out.println(player.getRoom().getDescription() + "\n");
        } else {
            //Bruger input er forkert. Vi behøver ikke at fortælle brugeren dette.
        }
    }

    public static void printCurrentRoom () {
        System.out.println("You're now in " + player.getRoom().getName());
        System.out.println(player.getRoom().getDescription());
        System.out.println();
    }

}
