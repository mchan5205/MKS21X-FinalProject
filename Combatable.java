public interface Combatable{
  int hP;
  int atk;
  String name;
  void attack(Combatable other);
  void changeHP(int hp);
}
