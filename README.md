# murk
Text/console-based fantasy mini-RPG in Java  
*Console gaming project for my Computer Programming class*

## idea
Guilty pleasure: I enjoy fantasy-themed media and so-called medieval literature. So one day I read too much, and imagined a fictional land similar to the epic worlds of Tolkien's Middle Earth, or the Elder Scrolls universe, or Game of Thrones, what have you. Full of kingdoms, magic, creatures, gods, and lore. So naturally, when asked to make a console game, I had to make a text-based RPG about the land of Murk. Read the outline below for storyline and gameplay details.

## instructions
 1. Install [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
 2. Clone/download [this](https://github.com/anuvgupta/murk) repository
 3. Use command line Java (recommended) or BlueJ
    - Command Line
        - Open a terminal or command prompt
        - Navigate to *this_repository/*`Murk RPG/`
        - Run the following command: `java Main`
    - BlueJ IDE
        - Download and install [BlueJ IDE](http://www.bluej.org/)
        - Open BlueJ and select Project->Open Project from the menu
        - Navigate to *this_repository/* and open the folder `Murk RPG` (as a BlueJ project)
        - Right click on class `Main` and run the static `main()` method with no arguments
 4. Play Murk!

## outline/gameplay
This is the outline included in the original readme with which I turned in the project; it details the storyline and gameplay basics.  

OUTLINE  
1. Storyline theme  
    User assumes role of minstrel (musician) in fictional medieval kingdom
    and encounters a series of survival challenges. User has health, money, stamina.
    User uses money to buy tools with which he can glean resources from the natural
    world and find gems. User loses when he runs out of health. User wins when he finds
    all the gems he can and becomes minstrel in king's court. User starts off in a world with
    no idea what to do so he must explore on his own.  
2. Class Hierarchy  
    1. Main class: starter class, creates HQ object and runs  
        1. HQ class: game brain class, creates world and runs world methods, manages beginning of game  
        2. World class: all-encompassing class, contains the game map with every cell of the world, the player, and the storyline.  
            1. Cell class: sector class, represents each sector of the map, contains properties that the world can have the player interact with  
            2. Player class: basic user class, contains data/information of player, including name, origin, inventory, etc.  
                1. Item class: basic item class, contains data/information for each type of item in game, including name, type, and variables/effects  
            3. SongGame Class: contained minigame class, contains static methods for playing a "musical" (guitar hero style) minigame, builds itself to make a custom JFrame with key events  
3. Storyline Pseudocode  
    1. user is dropped in world  
    2. user must explore world until he finds a gem  
    3. user must go to village and talk to bartender at tavern to get info  
    4. user must go to palace to talk to king and get more info and a map - the king has lost his gems and user must find them  
    5. user must go around the world using natural resources to collect items and gems  
        1. user must must maintain a good balance of health, stamina, and money (which are all manipulated by user's actions in the world)  
            1. user must not run out of health or he dies (if user wants to commit suicide, user can go and jump into the volcano)  
            2. user can regain health by eating food/animals user finds and drinking drinks at taverns  
            3. user can make money by selling the goods he retrieves from his travelling around the world  
            4. user must find and collect gems by:  
                1. cutting down trees and collecting wood in forests  
                2. shoot arrows and catching rabbits in meadows  
                3. gaining stamina from climbing mountains  
                4. gaining stamina from swimming in a lake  
                5. digging for precious shells at beaches  
                6. fishing for fish by the sea  
                7. playing "music" (the minigame) for satyrs (half man, half goat beasts) to calm them from chasing the user in the palace gardens  
            5. for enjoyment, user can  
                1. enjoy cheesy ASCII art  
                2. laugh at the King's terrible jokes (there are no jokes, the King just laughs at nothing)  
                3. talk to the ever-busy bartenders  
                4. chase satyrs, satyrs, angelfish, and... no, those are the only other living things in the game  
                5. jump into a volcano  
                6. get drunk on Murky Ale  
    6. user must collect as many gems as he/she can before returning to the king. Then user wins!  
