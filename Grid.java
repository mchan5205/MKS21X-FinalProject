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
    /**/
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
      tiles[3][i] = new Tile(new Empty(), false);
    }
    for (int i = 0; i < 27; i++){
      tiles[5][i] = new Tile(new Empty(), false);
    }
    for (int i = 0; i < 27; i++){
      tiles[12][i] = new Tile(new Empty(), false);
    }
    for (int i = 0; i < 27; i++){
      tiles[14][i] = new Tile(new Empty(), false);
    }
    for (int i = 0; i < 27; i++){
      tiles[21][i] = new Tile(new Empty(), false);
    }
    for (int i = 0; i < 27; i++){
      tiles[23][i] = new Tile(new Empty(), false);
    }
    /**/
    Random t = new Random();
    
    int height;
    int width;
    height = Math.abs(t.nextInt() % 3) + 2;
    width = Math.abs(t.nextInt() % 3) + 2;
    System.out.println(height);
    System.out.println(width);
    for (int y = 4 - width; y <= 4 + width; y++){
      tiles[4 + height][y] = new Tile(new Empty(), false);
      tiles[4 - height][y] = new Tile(new Empty(), false);
    }
    for (int x = 4 - height; x <= 4 + height; x++){
      tiles[x][4 + width] = new Tile(new Empty(), false);
      tiles[x][4 - width] = new Tile(new Empty(), false);
    }
    for (int x = 4 - height + 1; x < 4 + height; x++){
      for (int y = 4 - width + 1; y < 4 + width; y++){
        tiles[x][y] = new Tile(new Empty(), true);
      }
    }
    tiles[4 + height][4] = new Tile(new Empty(), true);
    tiles[4 - height][4] = new Tile(new Empty(), true);
    tiles[4][4 + width] = new Tile(new Empty(), true);
    tiles[4][4 - width] = new Tile(new Empty(), true);
    tiles[13][13] = new Tile(d, true);
    tiles[13][13] = new Tile(d, false);
  }
  public Tile getTile(int x, int y){
    return tiles[x][y];
  }
  public void setTile(int x, int y, Tile z){
    tiles[x][y] = z;
  }
}
