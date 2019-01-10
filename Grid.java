public class Grid{
  private Tile[][] tiles;
  public Grid(Player d){
    tiles = new Object[44][44];
    Tile[22][22] = d;
  }
  public Tile getTile(int x, int y){
    return tiles[x][y];
  }
}
