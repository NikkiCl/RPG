# RPG

https://emojipedia.org/evergreen-tree 
https://www.educative.io/answers/how-to-generate-random-numbers-in-java 

Difficulties of Arvin:
Of course, I had a rough idea of what my code needed for the mapping system in this game. The challenges really started after I had written the basic class code with its getters and setters. I was aiming for something functional at first that I could build on later. But I did run into a few issues, and here's what they were and how overcame them:

Indexing Issues: I initially set the player's starting position at (0, 0), which landed them in the top-left corner—far from the actual starting point of the game. To fix it, I set the default starting position to (4, 4) so the player starts in the bottom-right corner where "Start" was planned to be.

Movement Challenges: The movement mechanics were tricky. At first, I had a hard time keeping the player from moving out of bounds or into empty spaces. I solved it by adding two checks: one to make sure the input was a valid direction, and another to ensure the player stays within the grid and doesn't walk into obstacles.

Marking Player's Position: Initially, the only way the player knew their position was from a printout of the location's name, and it wasn't clear enough. So, I added a condition to mark their position with an "X", ensuring it wouldn’t mess up the rest of the grid display.

Filling Empty Spaces: I started by using a simple "-" to represent empty spaces, but it didn’t look right to me. After some quick research, I remembered I could use emojis in code, so I went with the tree emoji 🌲 to make it visually clear which areas were unwalkable.

Compass Alignment: Aligning the compass with the map rows took a bit of trial and error. I eventually figured it out by integrating the compass printing into the iteration method that prints the map line by line.

Search for a Random Number Generator: At one point, I needed a good way to generate random numbers for sneak attempts. I decided to search for "java random number generator" and found a method called ThreadLocalRandom which I saw my coding partners using. I learned more about it and I decided to intergrate it within my code as it seemed like the best option as well to avoid complications. Then the next issue was trying to see what odds i should give the player and i decided that 1 out of three will be perfect with a %33.33 chance to sneak and %66.66 chance of failing to sneak because after all he is mentioned to be a "Dork". 