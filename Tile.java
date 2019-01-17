public class Tile{
  private Monster enemy;
  private boolean passable;
  public Tile(Monster thing, boolean pass){
    enemy = thing;
    passable = pass;
  }
  public Tile(boolean pass){
    passable = pass;
  }
  public boolean isMonster(){
    return enemy instanceof Monster;
  }
  public Monster getMonster(){
    return enemy;
  }
  public boolean isPassable(){
    return passable;
  }
}
