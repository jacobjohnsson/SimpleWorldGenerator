class MapInverter implements IMapTraverser {
  public void print(Map map) {
    traverse(map);
  }

  public void atEvery(Map map, int x, int y) {
    if (map.atIndex(x, y) == 1){
      System.out.print(".");
    } else {
      System.out.print("X");
    }
  }

  public void atRow(Map map, int x) {
    System.out.print('\n');
  }
}
