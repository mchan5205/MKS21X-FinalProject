public class Tile{
  private Monster enemy;
  private boolean passable;
  private boolean hasMonster;
  public Tile(Monster thing, boolean pass){
    enemy = thing;
    passable = pass;
    hasMonster = true;
  }
  public Tile(boolean pass){
    passable = pass;
    hasMonster = false;
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
}
