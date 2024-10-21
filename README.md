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


Difficulties of Nikki:
I wanted the combat mechanics to have 3 functions, attack, sneak, and use item. I originally intended for special attacks, however I was unsure of where it would fit into the story, so I scrapped it. So it left me with this skeleton code structure:
if player picks 1:
fight sequence happens, player damages enemy
if player picks 2:
1/3 chance of sneaking away
if player picks 3:
choose from an inventory of items (if possible) to use
it becomes enemy's turn and vice versa

Attack Mechanism Issues:
I wanted to allow for certain aliens to have different attack times, to spice up the gameplay a bit. I originally branched off and added a seperate attackTime variable  within the Alien subclass, however, since the combat mechanism used the parent class Character as a parameter, I figured it would be easier to derive the attackTime variable from setting it to turnsToAttack in the initial stage. I fiddled around before settling that the AttackTime should be declared in the combat code, before any fight sequence has happened to ensure that the variable does not change. 

Debugging issues:
I wanted to ensure that anyone who tried to input something other than the numbers specified would still be able to run the combat sequence, in case of a mistype. So I surrounded by code with try: catch. However, I found that the while loop did not work as intended, as I originally had the while loop inside the try sequence. I was able to fix it by putting the while loop first. 

Sneak Chance challenges:
I wanted to introduce a certain random percentage that activates when you try to use the sneak function. So I thought of using the random number generator to achieve this. The random number generator picks a number from 1-3, and if that number lands on 1, then you have successfully snuck away.

Main function challenges:
It was mainly hard to figure out the right pacing for the game, although I don't believe it is perfect. I think it is playable with this text pacing. I wanted the text to slowly print out characters, like the ones you see in actual story games. So I figured out a way to slowly print out characters by writing the DPO function, which takes in the string input and outputs it by the specified amount of milliseconds in the function. I accomplished this by utilising the sleep function in Java. I also used that same function to provide spacing between dialogues.

As I was writing my code, I noticed that I was using the text box too often, so I figured i might as well write a function for it. This was not too hard to do, as I didn't really think about the logic behind it, more so got the result through trial and error. But essentially I got the function to return a framed word through slowly constructing the String with for loops. 

The rest of the code, mainly consisting of dialogue and descriptions, wasn't that hard to implement. I added the dialogue options and little comments of where my groupmates should add in their functions after a certain dialogue is pressed (such as 1 - climb mountain). So it mainly consisted of copying and pasting the text that we agreed upon in one of our group meetings. 
