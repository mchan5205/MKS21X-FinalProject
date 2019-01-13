public class Tile{
  private Combatable thing;
  private boolean passable;
  public Tile(Combatable thething, boolean pass){
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
  public void setTile(Combatable x){
    thing = x;
  }
  public boolean isPassable(){
    return passable;
  }
}
