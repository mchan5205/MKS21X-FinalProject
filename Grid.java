public class Grid{
  private Tile[][] tiles;
  public Grid(Player d){
    tiles = new Tile[27][27];
    for (int i = 0; i < 27; i++){
      for (int x = 0 ;i < 27; i++){
        tiles[i][x] = new Tile(new Empty(), true);
      }
    }
    tiles[13][13] = new Tile(d, true);

  }
  public Tile getTile(int x, int y){
    return tiles[x][y];
  }
}
