public class Tile{
  private Monster enemy;
  private boolean passable;
  private boolean hasMonster;
  private boolean hasPotion;
  public Tile(boolean pass, boolean pot){   //POTION GENERTATOR
    passable = pass;
    hasMonster = false;
    hasPotion = true;
  }
  public Tile(Monster thing, boolean pass){ //constructor for tiles with monsters
    enemy = thing;
    passable = pass;
    hasMonster = true;
    hasPotion = false;
  }
  public Tile(boolean pass){ //constructor for tile without monsters
    passable = pass;
    hasMonster = false;
    hasPotion = false;
  }

  public boolean isMonster(){
    return hasMonster;
  }
  public Monster getMonster(){
    return enemy;
  }
  public boolean isPassable(){
    return passable;
  }
  public boolean isPotion(){
    return hasPotion;
  }
}
