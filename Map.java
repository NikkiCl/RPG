public class Map {
    private final int rows = 5; // Final means value can not be changed
    private final int colms = 5;
    private String[][] grid; // 2d Grid declared but not initialized with values yet assigned
    private int playersX, playersY; // Players X and Y coordinates declared with no value

    // Default constructor with player's start position at (4, 4)
    public Map() {
        this(4, 4); // Calls the other Map constructor and gives it the default start position
    }

    public Map(int X, int Y) { // Constructor method that makes instance of class
        grid = new String[rows][colms]; // Initialises 2D grid with 5 rows and 5 columns in the index values
        initializeMap(); // Calls the function that initilizes the map
        setPlayerX(X);
        setPlayerY(Y);
    }

    // Getter for playerX
    public int getPlayerX() {
        return playersX;
    }

    // Setter for playerX
    public void setPlayerX(int X) {
        this.playersX = X;
    }

    // Getter for playerY
    public int getPlayerY() {
        return playersY;
    }

    // Setter for playerY
    public void setPlayerY(int Y) {
        this.playersY = Y;
    }

    // Get players current location method
    public String getCurrentLocation() {
        return grid[playersX][playersY];
    }

    // Move the player to a new coordinate
    public void movePlayer(int newX, int newY) {
        setPlayerX(newX);
        setPlayerY(newY);
    }

    public void locationChange(String dir) {
        dir = dir.toLowerCase(); // Input is no longer case sensetive
        int x = getPlayerX(); // Grab the player's x and y coordinates
        int y = getPlayerY();

        // Store valid directions in an array
        String[] directions = { "n", "e", "s", "w" };

        // Variable to track if input is valid
        boolean isValid = false;

        // Iterate through the directions array to check for a match
        for (String direction : directions) { //For every direction in directions Array
            if (dir.equals(direction)) {
                isValid = true;
                break; // If it is valid then stop the itiration
            }
        }

        if (!isValid) {
            System.out.println("Wrong input. Choose between: n, e, w, s.");
        } else if (dir.equals("n") && x > 0) { // if direction equals n and the axis is not out of bounce
            x--; // Decriment the x axis by one to move up
        } else if (dir.equals("e") && y < 4) {
            y++;
        } else if (dir.equals("s") && x < 4) { // Move south if not at the bottom boundary
            x++; // Moving "south" means increasing x-coordinate
        } else if (dir.equals("w") && y > 0) {
            y--;
        } else {
            System.out.println("Cannot move in that direction! Boundary reached.");
            return; // Stop and return nothing --- Later on we will have to return another function
                    // to enable movement again
        }

        if (grid[x][y].equals("|      🌲     |")) {
            System.out.println("You can't move to an empty space. Try a different direction.");
            return; // Do not move player and return nothing if they are at empty space
        }

        movePlayer(x, y); // Move player to new coordinates
    }

    private void initializeMap() { // Initilize 2d grid with String values assigned to each location
        grid[0][3] = "|Crowning     |";
        grid[0][1] = "|Evil Lord    |";
        grid[1][0] = "|Secret door  |"; // Hardcoding the formatting for the table cell to be printed each cell will be
        grid[1][1] = "|Mansion      |";// 15 characters long
        grid[1][2] = "|Bird         |";
        grid[2][0] = "|Tunnel       |";
        grid[2][4] = "|Solder       |";
        grid[3][0] = "|Waterfall    |";
        grid[3][1] = "|Mountain     |";
        grid[3][2] = "|Alien slums  |";
        grid[3][3] = "|Angry bear   |";
        grid[3][4] = "|Strange man  |";
        grid[4][2] = "|Merchant     |";
        grid[4][4] = "|Start        |";

        // Populate unpopulates parts of grid with - meaning its empty
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colms; j++) {
                if (grid[i][j] == null) {
                    grid[i][j] = "|      🌲     |"; // Hardcoding the format to represent empty boxes using emoji
                }
            }
        }
    }

    public void printMap() {
        String[] compass = {
            "         N         ",  // Index 0 of compass
            "         |         ",
            "     W --+-- E     ",
            "         |         ",
            "         S         " // index of 4 or the 5th element of the array
        };

        for (int i = 0; i < rows; i++) { // Go through each row
            for (int j = 0; j < colms; j++) { // For every row go through all columns
                
                String currentLocation = getCurrentLocation(); // store players location in variable within function scope
                if (grid[i][j].equals(currentLocation)){ //if the part of grid being itirated through matches the players location
                    System.out.print("|      X      |");// then print out X -- a feature for marking the players location
                } else {
                    System.out.print(grid[i][j]); // If the player is not at that location then print the actual content of the cell
                }
            }
            if (i < compass.length) { //if the index of map being printed meaning its still being printed is less than 5 then execute code below
                System.out.print("    " + compass[i]); //prints empty space and the row of compass that matches the map
            }
            System.out.println(); // Move to the next line after each row and its colums is printed
        }
        
        
        System.out.println("\nYou are at: " + getCurrentLocation()); // Print players current location
        System.out.println("Your location marked with X ");
    }

}