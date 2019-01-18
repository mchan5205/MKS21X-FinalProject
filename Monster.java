public class Monster implements Combatable{
  private int hP;
  private int atk;
  private String name;
  private int expReward;
  public Monster(String nam, int health, int attack){
    hP = health;
    atk = attack;
    name = nam;
  }
  public int getExp(){
    return expReward;
  }
  public String getName(){
    return name;
  }
  public int getHP(){
    return hP;
  }
  public int getAtk(){
    return atk;
  }
  public void attack(Combatable other){
    other.changeHP(-1 * this.getAtk());
  }
  public void changeHP(int hp){
    hP = hP + hp;
  }
}
