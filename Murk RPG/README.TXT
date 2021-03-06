PROJECT TITLE: Murk RPG
PURPOSE OF PROJECT: Text-based role-playing game
VERSION or DATE: 10/26/15 - 11/30/15
HOW TO START THIS PROJECT: run "static main()" method from class Main with no arguments
AUTHORS: Anuv Gupta
USER INSTRUCTIONS: Play the game! (read outline below (#1 and #3 specifically) for further instruction and understanding)


OUTLINE
-------
1. Storyline theme
    User assumes role of minstrel (musician) in fictional medieval kingdom 
    and encounters a series of survival challenges. User has health, money, stamina.
    User uses money to buy tools with which he can glean resources from the natural
    world and find gems. User loses when he runs out of health. User wins when he finds
    all the gems he can and becomes minstrel in king's court. User starts off in a world with
    no idea what to do so he must explore on his own.
2. Class Hierarchy
    Main class: starter class, creates HQ object and runs
        HQ class: game brain class, creates world and runs world methods, manages beginning of game
        World class: all-encompassing class, contains the game map with every cell of the world, the player, and the storyline.
            Cell class: sector class, represents each sector of the map, contains properties that the world can have the player interact with
            Player class: basic user class, contains data/information of player, including name, origin, inventory, etc.
                Item class: basic item class, contains data/information for each type of item in game, including name, type, and variables/effects
            SongGame Class: contained minigame class, contains static methods for playing a "musical" (guitar hero style) minigame, builds itself to make a custom JFrame with key events
3. Storyline Pseudocode
    -user is dropped in world
    -user must explore world until he finds a gem
    -user must go to village and talk to bartender at tavern to get info
    -user must go to palace to talk to king and get more info and a map - the king has lost his gems and user must find them
    -user must go around the world using natural resources to collect items and gems
        -user must must maintain a good balance of health, stamina, and money
            (which are all manipulated by user's actions in the world)
            -user must not run out of health or he dies
            (if user wants to commit suicide, user can go and jump into the volcano)
            -user can regain health by eating food/animals user finds and drinking drinks at taverns
            -user can make money by selling the goods he retrieves from his travelling around the world
            -user must find and collect gems by:
                *cutting down trees and collecting wood in forests
                *shoot arrows and catching rabbits in meadows
                *gaining stamina from climbing mountains
                *gaining stamina from swimming in a lake
                *digging for precious shells at beaches
                *fishing for fish by the sea
                *playing "music" (the minigame) for satyrs (half man, half goat beasts) to calm them from chasing the user in the palace gardens
            -for enjoyment, user can
                *enjoy cheesy ASCII art
                *laugh at the King's terrible jokes (there are no jokes, the King just laughs at nothing)
                *talk to the ever-busy bartenders
                *chase satyrs, satyrs, angelfish, and... no, those are the only other living things in the game
                *jump into a volcano
                *get drunk on Murky Ale
    -user must collect as many gems as he/she can before returning to the king.
        Then user wins!
        
    
    
    
    