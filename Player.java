public class Player implements Combatable{
  private int hP;
  private int maxHP;
  private int atk;
  private int exp;
  private int potNum;
  private String name;
  private int level;

  public Player(String nam, int health, int attack) {
    hP = health;
    maxHP = health;
    atk = attack;
    name = nam;
    exp = 0;
    potNum = 0;
    level = 1;
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
    potNum += 1;
  }
  public void losePot(){
    potNum -= 1;
  }
  public int getLevel(){
    return level;
  }
  public void gainExp(int xp){
     exp += xp;
     if (exp > 10){
       exp -= 10;
       maxHP += 1;
       hP += 1;
       level += 1;
       atk += 1;
     }
  }
  public void attack(Combatable other){ //attack monsters
    other.changeHP(-1 * this.atk);
  }
  public void changeHP(int hit){
    hP = hP + hit;
  }
  public void maxHeal(){
    hP = maxHP;
  }

}
