import java.util.Random;

class MapGenerator {
  int width;
  int height;
  int deathLimit = 4;
  int birthLimit = 3;
  double chanceToStartAlive = 0.35;

  public MapGenerator(int width, int height) {
    this.width = width;
    this.height = height;
  }

  public MapGenerator(int width, int height, int deathLimit, int birthLimit, int chanceToStartAlive) {
    this.width = width;
    this.height = height;
    this.deathLimit = deathLimit;
    this.birthLimit = birthLimit;
    this.chanceToStartAlive = chanceToStartAlive;
  }


  public int[][] generate(int steps) {
    int[][] array = initArray(width, height);

    for (int i = 0; i < steps; i++) {
      array = SimulationStep(array);
    }

    return array;
  }

  private int[][] initArray(int width, int height) {
    Random rand = new Random();
    int[][] array = new int[width][height];

    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        if (rand.nextDouble() < chanceToStartAlive) {
          array[x][y] = 1;
        }
      }
    }
    return array;
  }

  private int[][] SimulationStep(int[][] oldArray) {
    int[][] newArray = new int[width][height];

    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        int nbs = countAliveNeighbours(oldArray, x, y);

        if (oldArray[x][y] == 1) {
          if (nbs < deathLimit){
            newArray[x][y] = 0;
          } else {
            newArray[x][y] = 1;
          }
        }
        else {
          if (nbs > birthLimit) {
            newArray[x][y] = 1;
          } else {
            newArray[x][y] = 0;
          }
        }
      }
    }
    return newArray;
  }

  private int countAliveNeighbours(int[][] array, int x, int y) {
    int count = 0;
    for (int dx = -1; dx <= 1; dx++) {
      for (int dy = -1; dy <= 1; dy++) {
        int neighbour_x = x + dx;
        int neighbour_y = y + dy;

        if (dx == 0 && dy == 0) {

        } else if (neighbour_x < 0 ||
                  neighbour_y < 0 ||
                  neighbour_x >= width ||
                  neighbour_y >= height){
          count++;
        } else if (array[neighbour_x][neighbour_y] == 1){
          count++;
        }
      }
    }
    return count;
  }
}
