import greenfoot.*;

/**
 * The backyard screen where the whole game is based.
 * 
 * @author PULKIT AGARWAL (2014A7PS356G)
 *         ROHAN GOEL     (2014A7PS014G)
 * @version (August 22, 2015)
 */

public class Backyard extends World
{
    //Variables Declation
    private int[] rows;
    private int[] columns;
    private Counter counter_sun = new Counter();
    private Counter counter_score = new Counter();
    private GreenfootSound backgroundMusic = new GreenfootSound("background.wav");
    
    /**
     * Constructor for objects of class backyard.
     * 
     */
    public Backyard()
    {   
        // Create a new world with 1111x602 cells with a cell size of 1x1 pixels.
        super(1111, 602, 1);
        
        setRowsCoordinates();
        setColumnsCoordinates();
        prepare();
        backgroundMusic.playLoop();        
    }
    
    /**
     * Possible Row Cordinates
     */
    private void setRowsCoordinates()
    {
        rows = new int[5];
        rows[0] = 78;
        rows[1] = 184;
        rows[2] = 306;
        rows[3] = 418;
        rows[4] = 523;
    }
    
    /**
     * Possible Column Cordinates
     */
    private void setColumnsCoordinates()
    {
        columns = new int[9];
        columns[0] = 326;
        columns[1] = 413;
        columns[2] = 500;
        columns[3] = 588;
        columns[4] = 679;
        columns[5] = 765;
        columns[6] = 857;
        columns[7] = 943;
        columns[8] = 1042;
    }
    
    /**
     * Ensures that the user can't randomly place plants in the world but only in the grid.
     */
    public int returnGridRowPosition(int y)
    {
        int row;
        
        int[] rowGrid = {0, 137, 246, 357, 462, 569};
        for(row = 0; row < 5; row += 1)
        {
            if(y > rowGrid[row] && y < rowGrid[row + 1])
            {
                return rows[row];
            }
        }
        return -1;
    }
    
    /**
     * Ensures that the user can't randomly place plants in the world but only in the grid.
     */
    public int returnGridColumnPosition(int x)
    {
        int column;
        
        int[] columnGrid = {280, 364, 449, 543, 632, 721, 812, 897, 985, 1089};
        for(column = 0; column < 9; column += 1)
        {
            if(x > columnGrid[column] && x < columnGrid[column + 1])
            {
                return columns[column];
            }
        }
        return -1;
    }
    
    /**
     * Prepares Lawnmovers which serve as an extra life
     */
    private void prepareLawnmowers()
    {
        int[] rows = {77, 183, 309, 422, 522};
        int[] columns = {242, 240, 226, 219, 214};
        for(int i = 0; i<5; i++)
        {
            addObject(new Lawnmower(), columns[i] , rows[i]);
        }
    }
    
    /**
     * Prepares the sidebar which houses all the icons
     */
    private void prepareSidebar()
    {
        addObject(new WalnutIcon(49, 140)   , 49, 140);
        addObject(new PeaShootIcon(49, 236) , 49, 236);
        addObject(new SunFlowerIcon(49, 332), 49, 332);
        addObject(new BeetRootIcon(49, 428) , 49, 428);
        
        addObject(counter_score, 49, 78);
        addObject(counter_sun, 49, 567);
        counter_sun.setValue(400);
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    
    private void prepare()
    {
        prepareSidebar();
        prepareLawnmowers();
        addObject(new Shovel(1035, 40), 1035, 40); 
    }
    
    /**
     * Adds a zombie in a specific cell
     */
    public void addZombie(Zombie zombie, int row)
    {
        addObject(zombie, columns[8] + 70, rows[row]);        
    }
    
    /**
     * Use to randomize the type of zombie being spawned (Normal OR Football)
     */
    public void randomZombie(int row)
    {
        if(Greenfoot.getRandomNumber(2) == 0)
            {
                addZombie(new NormalZombie(), row);
            }
            else
            {
                addZombie(new FootballZombie(), row);
            }
    }
    
    /**
     * Spawns a zombie in every row i.e a wave  
     */
    public void createWave()
    {
        for(int i = 0; i < 5; i += 1)
        {
            randomZombie(i);
        }
    }
    
    //Variables used for creatin a wave.
    private long lastAdded = System.currentTimeMillis();
    private int timeUnit = 1; // 1 time unit = 10 seconds
    private int numberOfWaves = 0;
    private int waveNumber = 0;
    
    /**
     *   The act method is called by the greenfoot framework to give actors a chance to perform some action.
     *   Here it keeps the record of the time and accodingly spawns zombies
     *   
     */
    public void act()
    {      
        long curTime  = System.currentTimeMillis();
        
        if (curTime >= lastAdded + 10000)
        {
            lastAdded = curTime;
            timeUnit += 1;
            produceSunFromSky();
            randomZombie(Greenfoot.getRandomNumber(5));
        }
        
        if(timeUnit % 3 == 0 && timeUnit != 3)//5000ms = 5s
        {
            if(curTime <= lastAdded + 25)
            {
                addObject(new ZombiesAreComing(), 639, 273);
                numberOfWaves = (timeUnit - 3) / 3;
                createWave();
                waveNumber = 1;
            }
            
            if((curTime > lastAdded + waveNumber * 1000) && (curTime < lastAdded + numberOfWaves * 1000))
            {
                waveNumber+=1;
                createWave();
            }
        }
     
    }
    
    /**
     * Randomly produces sun from the sky
     */
    public void  produceSunFromSky()
    {
        Sun sun = new Sun();
        addObject(sun, columns[Greenfoot.getRandomNumber(8)], 0);
        sun.letTheSunFall();
    }
    
    /**
     * Returns the sun counter
     */
    public Counter getSunCounter()
    {
        return counter_sun;
    }
    
    /**
     * Reuturns the score counter
     */
    public Counter getScoreCounter()
    {
        return counter_score;
    }
    
    /**
     * Stops the background music when the game ends
     */public void stopBackgroundMusic()
    {
       backgroundMusic.stop();
    }
}
