public class Tile{
  private Object thing;
  private boolean passable;
  public Tile(Object thething, boolean pass){
    thing = thething;
    passable = pass;
  }
  public Tile(boolean pass){
    passable = pass;
  }
  public boolean isMonster(){
    return thing instanceof Monster;
  }
  public boolean isPlayer(){
    return thing instanceof Player;
  }

  public boolean isStairs(){
    return thing instanceof Stairs;
  }

  public void setTile(Object x){
    thing = x;
  }
  public boolean isPassable(){
    return passable;
  }
}
