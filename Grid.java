import java.util.Random;
public class Grid{
  private Tile[][] tiles;
  public Grid(Player d){
    tiles = new Tile[45][27];
    for (int i = 0; i < 45; i++){ //creates walls in all tiles
      for (int x = 0 ;x < 27; x++){
        tiles[i][x] = new Tile(false);
      }
    }
    for (int i = 0; i < 45; i++){ //creates hallways between rooms
      tiles[i][4] = new Tile(true);
    }
    for (int i = 0; i < 45; i++){
      tiles[i][13] = new Tile(true);
    }
    for (int i = 0; i < 45; i++){
      tiles[i][22] = new Tile(true);
    }
    for (int i = 0; i < 27; i++){
      tiles[7][i] = new Tile(true);
    }
    for (int i = 0; i < 27; i++){
      tiles[22][i] = new Tile(true);
    }
    for (int i = 0; i < 27; i++){
      tiles[37][i] = new Tile(true);
    }

    Random t = new Random();
    for(int w = 7; w < 44; w = w + 15){ //the 9 points on the grid where rooms are centered
      for (int h = 4; h < 23; h = h + 9){
        int height;
        int width;
        height = Math.abs(t.nextInt() % 3) + 2;
        width = Math.abs(t.nextInt() % 5) + 2;
        for (int y = h - height; y <= h + height; y++){//creates a room with random dimensions
          tiles[w + width][y] = new Tile(false);
          tiles[w - width][y] = new Tile(false);
        }
        for (int x = w - width; x <= w + width; x++){
          tiles[x][h + height] = new Tile(false);
          tiles[x][h - height] = new Tile(false);
        }
        for (int x = h - height + 1; x < h + height; x++){
          for (int y = w - width + 1; y < w + width; y++){
            if (t.nextInt() % 10 < 9){
              tiles[y][x] = new Tile(true);
            }
            else{
              if (t.nextInt() % 10 < 8){ //chance to spawn Monster
                tiles[y][x] = new Tile(new Monster("monster", Math.abs(t.nextInt() % 10) + d.getLevel(), Math.abs(t.nextInt() % 5 + d.getLevel()), Math.abs(t.nextInt() % 5 + d.getLevel())), true);
              }
              else{
                tiles[y][x] = new Tile(true, true);
              }
            }
          }
        }
        tiles[w + width][h] = new Tile(true);
        tiles[w - width][h] = new Tile(true);
        tiles[w][h + height] = new Tile(true);
        tiles[w][h - height] = new Tile(true); //opens up hallways in the rooms
      }
    }
    for(int i = 0; i < 45; i++){// creates a border around the grid
      tiles[i][0] = new Tile(false);
      tiles[i][26] = new Tile(false);
    }
    for(int i = 0; i < 27; i++){
      tiles[0][i] = new Tile(false);
      tiles[44][i] = new Tile(false);
    }
  }
  public Tile getTile(int x, int y){
    return tiles[x][y];
  }
  public void setTile(int x, int y, Tile z){
    tiles[x][y] = z;
  }
}
