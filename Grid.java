public class Grid{
  private Tile[][] tiles;
  public Grid(Player d){
    tiles = new Object[50][50];
    Tile[25][25] = d;
  }
  public Tile getTile(int x, int y){
    return tiles[x][y];
  }
}
