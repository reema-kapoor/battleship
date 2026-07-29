import student.micro.battleship.*;
import student.util.Random;
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Reema Kapoor (reemak@vt.edu)
//-------------------------------------------------------------------------
/**
 *  This class is created to play the battleship game by
 *  hitting the opponents ships.
 *
 *  @author Reema Kapoor (reemak@vt.edu)
 *  @version (2024.10.15)
 */
public class MyBattleship
    implements BattleshipStrategy
{
    //~ Fields ................................................................
    private Random generator;
    private Board enemy;
    private int x;
    private int y;
    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created MyBattleship object.
     */
    public MyBattleship()
    {
        super();
        this.generator = new Random();
    }

    //~ Methods ...............................................................
    /**
     * Places the ships at random vertically
     * @param queen is the object for shipPlacementMove
     */
    public void placeVertical(ShipPlacementMove queen)
    {
        y = generator.nextInt(3);
        queen.placeShip(ShipType.CARRIER, 4, y + 1, true);
        queen.placeShip(ShipType.BATTLESHIP, 2, y + 2, true);
        queen.placeShip(ShipType.DESTROYER, 5, y + 3, true);
        queen.placeShip(ShipType.SUBMARINE, 7, y + 4, true);
        queen.placeShip(ShipType.PATROL, 8, y + 5, true);
    }
    
    /**
     * Places the ships at random horizontally
     * @param queen is the object for shipPlacementMove
     */
    public void placeHorizontal(ShipPlacementMove queen)
    {
        x = generator.nextInt(2);
        queen.placeShip(ShipType.CARRIER, x + 1, 1, true);
        queen.placeShip(ShipType.BATTLESHIP, x + 2, 2, true);
        queen.placeShip(ShipType.DESTROYER, x + 3, 4, true);
        queen.placeShip(ShipType.SUBMARINE, x + 4, 5, true);
        queen.placeShip(ShipType.PATROL, x + 5, 6, true);
    }
    
    /**
     * Places the 5 sips in a random spot every time
     * @return ShipPlacementMove object that places 5 ships
     * @param currentGameState The current state of the game
     */
    public ShipPlacementMove 
        placeShips(GameState currentGameState)
    {
        ShipPlacementMove queen = new
            ShipPlacementMove(currentGameState);
        boolean layout = generator.nextBoolean();
        if (layout)
        {
            placeVertical(queen);
        }
        else
        {
            placeHorizontal(queen);
        }
        return queen;
    }
    
    /**
     * Calls the shooting move on the enemies board
     * @return CallShotMove representing the (x,y) of the shot
     * @param currentGameState The current state of the game
     */
    public CallShotMove 
        callNextShot(GameState currentGameState)
    {
        this.enemy = currentGameState.getOpponentsBoard();
        this.findPoint();
        return (new CallShotMove(x, y));
    }
    
    /**
     * Finds when the shooting point during game
     */
    public void findPoint()
    {
        x = generator.nextInt(10);
        y = generator.nextInt(10);
        for (int i = 0; i < 10; i++)
        {
            while (!enemy.canFireAt(x , y))
            {
                x = generator.nextInt(10);
                y = generator.nextInt(10);
            }
        }
    }
    
    /**
     * Returns false since my strategy follows the rules
     * @return false, indicating that it follows the rules
     */
    public boolean canPlayDeviously()
    {
        return false;
    }
    
    /**
     * Initalizing the name that will be shown when my 
     * strategy is being played
     * @return string representing the name when playing
     */
    public String getName()
    {
        return "Reemak"; 
    }
    
    /**
     * Initalizes the strategy to play a new game
     */
    public void newGame()
    {
        //Empty method to play a new game
    }
}
