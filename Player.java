public class Player implements Combatable{
  private int hP;
  private int atk;
  private int exp;
  private int potNum;
  private String name;

  public Player(String nam, int health, int attack) {
    hP = health;
    atk = attack;
    name = nam;
    exp = 0;
    potNum = 0;
  }

  public String getName() {
     return name;
  }
  public int getExp() {
     return exp;
  }
  public int getHP() {
     return hP;
  }
  public int getAtk() {
     return atk;
  }
  public int getPots(){
    return potNum;
  }
  public void gainPot(){
    potNum += potNum;
  }
  public void gainExp(int xp){
     exp += xp;
  }
  public void attack(Combatable other){
    other.changeHP(-1 * this.atk);
  }
  public void changeHP(int hit){
    hP = hP - hit;
  }

}
