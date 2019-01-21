============
Instructions
============
How to compile + run
- full screen terminal
- javac -cp lanterna.jar:. thing.java
- java -cp lanterna.jar:. thing

Legend
- yellow O = player
- red x = enemy
- green space = stairs
- blue P = potion

How to use
- arrow keys move player
- potions
  - walk into a potion to pick it up
  - your number of potions will show up on the bottom of the screen
  - press Backspace to use a potion
    - potions get you to full health
- combat
  - walk into an enemy
  - your health will go down on the bottom of the screen
    - the amount of attack and health of enemies are random
  - everytime you get past 10 exp, you level up
    - leveling up increases player's maxHp and attack
  - when your health goes to zero or less than zero, you die
    - press any buttom to get out
- stairs
  - walk into stairs to generate a new level
  

=======
Dev Log
=======
1/21/19
- added button to use potions

1/20/19
- added stairs to new rooms
- changed glyphs
- added potions constructor and random generation

1/18/19
- add random monster generation to rooms
- added combat between mosnters and players
- remaking stairs

1/16/19
- grid size increased

1/15/19
- started increasing grid size
- started stairs

1/14/19
- changed wall color

1/13/19
- added user interface
- added walking
- added random room generation
- added boolean to Tile to indicate whetehr it is a wall or not
- added Empty class

1/10/19
- created Monster.java
- added to Combatable.java
- finished player.java
- started user interface

1/9/19
- created Grid.java
- started Combatable interface

1/8/19
- created Tile.java
- started player.java

1/7/19
- Learned git branching
- Studied lanterna java documentation
