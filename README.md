# Battleship Game

Project overview and purpose
    The Battleship Game project is a Java-based implementation of an automated Battleship player that competes against an opponent using the Battleship game framework. The program focuses on developing a strategy for ship placement and attack decisions. The project implements object-oriented programming concepts by creating a custom BattleshipStrategy class that randomly places ships, selects valid attack coordinates, and interacts with the game state to make decisions during gameplay.


Installation and setup instructions

    1. Download or clone the repository to your computer
    2. Open the project in Eclipse or another Java IDE
    3. Ensure Java is installed and configured
    4. Run the provided project runner to launch the application
    5. The Battleship game will automatically begin

How to run the program and reproduce results

    1. Open the project folder
    2. Navigate to MyBattleship.java
    3. Compile and run the project
    4. The game will display the battleship framework
    5. The strategy will automatically:
        - Place ships on the board
        - Select coordinated to attack the opponent
        - Continue making moves until the game ends

    STRATEGY FEATURES:
        - Randomly places ships on board
        - Uses both vertical and horizontal ship placement
        - Generates random attack coordinates
        - Checkes that selected attack location are valid before firing
        - Follows Battleship rules 


    RESULTS:

        - Successfully created an Battleship player
        - Places ships in different configuration each game
        - Generates legal attack moves aganist opponent
        - Use game state information to interact with opponents board
        - Demonstrated the use of ojbect-oriented design and algorithmic decision-making

Technologies or libraries used

    Java - Main programming language used to implement Battleship strategy
    Object-Oriented-Programming - Used through classes, interfaces, and game-state logic
    Battleship Framework - Provides the game enviornment, board management, ship placement, and attack functionality


Author(s) and contribution summary

    Author: Reema Kapoor

    Contributions:
        - Developed Battleship strategy using Java
        - Implemented random ship placement methods
        - Created logic for selecting attack locations
        - Tested and documented for project implementation