public class Tile{
  private Object thing;
  public Tile(Object thething){
    thing = thething;
  }
  public boolean isMonster(){
    return thing instanceof Monster;
  }
  public boolean isPlayer(){
    return thing instanceof Player;
  }
  public boolean isLoot(){
    return thing instanceof Loot;
  }
  public void setTile(Object x){
    thing = x;
  }
}
