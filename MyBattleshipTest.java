import student.micro.*;
import static org.assertj.core.api.Assertions.*;
import student.micro.battleship.*;
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Reema Kapoor (reemak@vt.edu)
// -------------------------------------------------------------------------
/**
 *  This test class is created to test the methods of each battleship strategy
 *
 *  @author Reema Kapoor(reemak@vt.edu)
 *  @version (2024.10.16)
 */
public class MyBattleshipTest
    extends TestCase
{
    //~ Fields ................................................................
    private TestableGameState gameState;
    private TestableBoard opponentsBoard;
    private MyBattleship myBattleship;
    
    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new MyBattleshipTest test object.
     */
    public MyBattleshipTest()
    {
        // The constructor is usually empty in unit tests, since it runs
        // once for the whole class, not once for each test method.
        // Per-test initialization should be placed in setUp() instead.
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    public void setUp()
    {
        this.gameState = new TestableGameState();
        this.opponentsBoard = new TestableBoard();
        this.myBattleship = new MyBattleship();        
    }


    // ----------------------------------------------------------
    /*# Insert your own test methods here */
    /**
     * Tests to see that the shots are fired at the enemy ships.
     */
    public void testCallNextShot()
    {
        opponentsBoard.firePattern(
                    "**********",
                    "**********",
                    "**********",
                    "******.***",
                    "**********",
                    "**********",
                    "**********",
                    "**********",
                    "**********",
                    "**********");
        
        CallShotMove fired = myBattleship.callNextShot(gameState);
        assertThat(fired).isNotNull();
    }
    
    /**
     * Tests the playHorizontal method
     */
    public void testPlayHorizontal()
    {
        ShipPlacementMove placeHori = myBattleship.placeShips(gameState);
        
        // Call method
        myBattleship.placeHorizontal(placeHori);
        
        // Assumption
        assertThat(placeHori.isValid()).isTrue();
    }
    
    /** 
     * Tests the playVertical method
     */
    public void testPlayVertical()
    {
        ShipPlacementMove placeVert = myBattleship.placeShips(gameState);
        
        // Call method
        myBattleship.placeVertical(placeVert);
        
        // Assumption
        assertThat(placeVert.isValid()).isTrue();
    }
    
    /**
     * Checks is the ships ever overlap
     */
    public void testPlaceShips()
    {
        ShipPlacementMove placement = myBattleship.placeShips(gameState);
        
        // Assumption
        assertThat(placement.isValid()).isTrue();
    }
    
    /**
     * Tests the getName method
     */
    public void testGetName()
    {
        String name = myBattleship.getName();
        myBattleship.newGame();
        
        assertThat(name).isEqualTo("Reemak");
    }
    
    /**
     * Tests the newGame method
     */
    public void testNewGame()
    {
        String name = myBattleship.getName();
        boolean cheater = myBattleship.canPlayDeviously();
        
        assertThat(name).isEqualTo("Reemak");
        assertThat(cheater).isFalse();
    }
    
    /**
     * Tests the canPlayDeviously method
     */
    public void testcanPlayDeviously()
    {
        boolean devious = myBattleship.canPlayDeviously();
        assertThat(devious).isFalse();
    }
}
