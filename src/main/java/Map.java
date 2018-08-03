import java.util.Random;

public class Map implements IMapTraverser {
  int width;
  int height;
  Printer printer = new Printer();
  int[][] map;

  public Map(int x, int y) {
    this.width = x;
    this.height = y;
    MapGenerator mg = new MapGenerator(x, y);
    this.map = mg.generate(8);
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public int atIndex(int x, int y) {
    return map[x][y];
  }
}
