public interface Combatable{ //implemented by player and monster
  void attack(Combatable other);
  void changeHP(int hp);
}
