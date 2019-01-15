import java.util.Random;
public class Grid{
  private Tile[][] tiles;
  public Grid(Player d){
    tiles = new Tile[45][27];
    for (int i = 0; i < 45; i++){
      for (int x = 0 ;x < 27; x++){
        tiles[i][x] = new Tile(new Empty(), true);
      }
    }
    for (int i = 0; i < 44; i++){
      tiles[i][3] = new Tile(new Empty(), false);
    }
    for (int i = 0; i < 44; i++){
      tiles[i][5] = new Tile(new Empty(), false);
    }
    for (int i = 0; i < 44; i++){
      tiles[i][12] = new Tile(new Empty(), false);
    }
    for (int i = 0; i < 44; i++){
      tiles[i][14] = new Tile(new Empty(), false);
    }
    for (int i = 0; i < 44; i++){
      tiles[i][21] = new Tile(new Empty(), false);
    }
    for (int i = 0; i < 44; i++){
      tiles[i][23] = new Tile(new Empty(), false);
    }
    for (int i = 0; i < 27; i++){
      tiles[6][i] = new Tile(new Empty(), false);
    }
    for (int i = 0; i < 27; i++){
      tiles[8][i] = new Tile(new Empty(), false);
    }
    for (int i = 0; i < 27; i++){
      tiles[21][i] = new Tile(new Empty(), false);
    }
    for (int i = 0; i < 27; i++){
      tiles[23][i] = new Tile(new Empty(), false);
    }
    for (int i = 0; i < 27; i++){
      tiles[34][i] = new Tile(new Empty(), false);
    }
    for (int i = 0; i < 27; i++){
      tiles[36][i] = new Tile(new Empty(), false);
    }
    Random t = new Random();
    for(int w = 7; w < 46; w = w + 15){
      for (int h = 4; h < 23; h = h + 9){
        int height;
        int width;
        height = Math.abs(t.nextInt() % 3) + 2;
        width = Math.abs(t.nextInt() % 5) + 2;
        for (int y = w - width; y<= h + height; y++){
          tiles[w + width][y] = new Tile(new Empty(), false);
          tiles[w - width][y] = new Tile(new Empty(), false);
        }
        for (int x = h - height; x <= w + width; x++){
          tiles[x][h + height] = new Tile(new Empty(), false);
          tiles[x][h + height] = new Tile(new Empty(), false);
        }
        for (int x = h - height + 1; x < h + height; x++){
          for (int y = w - width + 1; y < w + width; y++){
            tiles[y][x] = new Tile(new Empty(), true);
          }
        }
        tiles[w + width][h] = new Tile(new Empty(), true);
        tiles[w - width][h] = new Tile(new Empty(), true);
        tiles[w][h + height] = new Tile(new Empty(), true);
        tiles[w][h - height] = new Tile(new Empty(), true);
      }
    }
    tiles[22][13] = new Tile(d, true);
    for(int i = 0; i < 45; i++){
      tiles[i][0] = new Tile(new Empty(), false);
      tiles[i][26] = new Tile(new Empty(), false);
    }
    for(int i = 0; i < 27; i++){
      tiles[0][i] = new Tile(new Empty(), false);
      tiles[44][i] = new Tile(new Empty(), false);
    }
  }
  public Tile getTile(int x, int y){
    return tiles[x][y];
  }
  public void setTile(int x, int y, Tile z){
    tiles[x][y] = z;
  }
}
