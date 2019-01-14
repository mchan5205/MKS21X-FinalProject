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
    for(int w = 4; w < 23; w = w + 9){
      for (int h = 4; h < 23; h = h + 9){
        int height;
        int width;
        height = Math.abs(t.nextInt() % 3) + 2;
        width = Math.abs(t.nextInt() % 3) + 2;
        System.out.println(height);
        System.out.println(width);
        for (int y = w - width; y <= w + width; y++){
          tiles[h + height][y] = new Tile(new Empty(), false);
          tiles[h - height][y] = new Tile(new Empty(), false);
        }
        for (int x = h - height; x <= h + height; x++){
          tiles[x][w + width] = new Tile(new Empty(), false);
          tiles[x][w - width] = new Tile(new Empty(), false);
        }
        for (int x = h - height + 1; x < h + height; x++){
          for (int y = w - width + 1; y < w + width; y++){
            tiles[x][y] = new Tile(new Empty(), true);
          }
        }
        tiles[h + height][w] = new Tile(new Empty(), true);
        tiles[h - height][w] = new Tile(new Empty(), true);
        tiles[h][w + width] = new Tile(new Empty(), true);
        tiles[h][w - width] = new Tile(new Empty(), true);
      }
    }
    tiles[13][13] = new Tile(d, true);
  }
  public Tile getTile(int x, int y){
    return tiles[x][y];
  }
  public void setTile(int x, int y, Tile z){
    tiles[x][y] = z;
  }
}
