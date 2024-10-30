public class Map {
    private final static int rows = 5; // Final means value can not be changed
    private final static int colms = 5;
    private static String[][] grid; // 2d Grid declared but not initialized with values yet assigned
    private static int playersX; // Players X and Y coordinates declared with no value
	private static int playersY;
    static Map map = new Map();
    // Default constructor with player's start position at (4, 4)
    public Map() {
        this(3, 4); // Calls the other Map constructor and gives it the default start position
    }

    public Map(int X, int Y) { // Constructor method that makes instance of class
        grid = new String[rows][colms]; // Initialises 2D grid with 5 rows and 5 columns in the index values
        initializeMap(); // Calls the function that initilizes the map
        playersX = X; // Directly setting the coordinants
        playersY = Y; 
    }

    // Getter for playerX
    public static int getPlayerX() {
        return playersX;
    }

    // Setter for playerX
    public static void setPlayerX(int X) {
        playersX = X;
    }

    // Getter for playerY
    public static int getPlayerY() {
        return playersY;
    }

    // Setter for playerY
    public static void setPlayerY(int Y) {
        playersY = Y;
    }

    // Get players current location method
    public static String getCurrentLocation() {
        return grid[playersX][playersY];
    }

    // Move the player to a new coordinate
    public static void movePlayer(int newX, int newY) {
        setPlayerX(newX);
        setPlayerY(newY);
    }

    public static void locationChange(String dir) {// This method actually contains the logic to turn the players input into actual change of character location with boundry checks
        int x = getPlayerX(); // Grab the player's x and y coordinates
        int y = getPlayerY();
        
        if (dir.equals("n") && x > 0) { // if direction equals n and the axis is not out of bounce
            x--; // Decriment the x axis by one to move up
        } else if (dir.equals("e") && y < 4) {
            y++;
        } else if (dir.equals("s") && x < 4) { // Move south if not at the bottom boundary
            x++; // Moving "south" means increasing x-coordinate
        } else if (dir.equals("w") && y > 0) {
            y--;
        } else {
            System.out.println("Cannot move in that direction! Boundary reached.");
            return;// return nothing and handle loop where fuction can be called again this is to prevent errors
                    
        }
        if (grid[x][y].equals("|      🌲     |")) {
            System.out.println("You can't move to an empty space. Try a different direction.");
            return; // Do not move player and return nothing if they are at empty space
        }
        movePlayer(x, y); // Move player to new coordinates

            System.out.print("\n\n\nTravelling...................\n\n\n");// After moving the players coordinant then print message with their new location
			System.out.println("You have arrived at: " + getCurrentLocation());

    }

    private void initializeMap() { // Initilize 2d grid with String values assigned to each location this is the heart of the map class
        grid[0][2] = "|    🌲🌲     |";
        grid[1][0] = "|Secret door  |"; // Hardcoding the formatting for the table cell to be printed each cell will be
        grid[1][1] = "|Mansion      |";// 15 characters long
        grid[1][2] = "|Backyard     |";
        grid[2][0] = "|Tunnel       |";
        grid[2][4] = "|Soldier      |";
        grid[3][0] = "|Waterfall    |";
        grid[2][1] = "|Mountain     |";
        grid[3][1] = "|CrossRoads   |";
        grid[3][2] = "|Alien slums  |";
        grid[3][3] = "|Tiny Cave    |";
        grid[3][4] = "|Start        |";
        grid[4][2] = "|Merchant     |";
        

        // Populate unpopulates parts of grid with tree emoji - meaning its empty
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colms; j++) {
                if (grid[i][j] == null) {
                    grid[i][j] = "|      🌲     |"; // Hardcoding the format to represent empty boxes using emoji
                }
            }
        }
    }

    public static void printMap() {// This is the method thats responsible for viewing the map, compass and the players location
        String[] compass = {
            "         N         ",  // Index 0 of compass
            "         |         ",
            "     W --+-- E     ",
            "         |         ",
            "         S         " // index of 4 or the 5th element of the array
        };

        for (int i = 0; i < colms; i++) { // Go through each colm of the initilised map colmns - row is a 
            for (int j = 0; j < rows; j++) { // For every colmn go through all rows within
                
                String currentLocation = getCurrentLocation(); // store players location in variable within function scope
                if (grid[i][j].equals(currentLocation)){ //if the part of grid being itirated through matches the players location
                    System.out.print("|      X      |");// then print out X -- a feature for marking the players location
                } else {
                    System.out.print(grid[i][j]); // If the player is not at that location then print the actual content of the cell
                }
            }
            if (i < compass.length) { //if the index of map being printed meaning its still being printed is less than 5 then execute code below
                System.out.print("    " + compass[i]); //prints empty space and the row of compass that matches the map column
            }
            System.out.println(); // Move to the next line after each row and its colums is printed
        }
        
        
        System.out.println("\nYou are at: " + getCurrentLocation()); // Print players current location
        System.out.println("Your location marked with X ");
    }

}
