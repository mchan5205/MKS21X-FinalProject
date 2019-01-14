import java.util.Random;
public class Grid{
  private Tile[][] tiles;
  public Grid(Player d){
    tiles = new Tile[27][27];
    for (int i = 0; i < 27; i++){
      for (int x = 0 ;x < 27; x++){
        tiles[i][x] = new Tile(new Empty(), true);
      }
    }
    for (int i = 0; i < 27; i++){
      tiles[i][3] = new Tile(new Empty(), false);
    }
    for (int i = 0; i < 27; i++){
      tiles[i][5] = new Tile(new Empty(), false);
    }
    for (int i = 0; i < 27; i++){
      tiles[i][12] = new Tile(new Empty(), false);
    }
    for (int i = 0; i < 27; i++){
      tiles[i][14] = new Tile(new Empty(), false);
    }
    for (int i = 0; i < 27; i++){
      tiles[i][21] = new Tile(new Empty(), false);
    }
    for (int i = 0; i < 27; i++){
      tiles[i][23] = new Tile(new Empty(), false);
    }
    for (int i = 0; i < 27; i++){
      tiles[3][i] = new Tile (new Empty(), false);
    }
    for (int i = 0; i < 27; i++){
      tiles[5][i] = new Tile (new Empty(), false);
    }
    for (int i = 0; i < 27; i++){
      tiles[12][i] = new Tile (new Empty(), false);
    }
    for (int i = 0; i < 27; i++){
      tiles[14][i] = new Tile (new Empty(), false);
    }
    for (int i = 0; i < 27; i++){
      tiles[21][i] = new Tile (new Empty(), false);
    }
    for (int i = 0; i < 27; i++){
      tiles[23][i] = new Tile (new Empty(), false);
    }
    tiles[13][13] = new Tile(d, true);

  }
  public Tile getTile(int x, int y){
    return tiles[x][y];
  }
}
