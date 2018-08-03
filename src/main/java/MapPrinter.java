class MapPrinter implements IMapTraverser {
  public void print(Map map){
    traverse(map);  // Template method!
  }

  public void before(Map map) {
    printLine();
  }

  public void atEvery(Map map, int x, int y) {
    if (map.atIndex(x, y) == 1){
      System.out.print("X");
    } else {
      System.out.print(".");
    }
  }

  public void atRow(Map map, int x) {
    System.out.print("\n");
  }

  public void after(Map map) {
    printLine();
  }

  private void printLine() {
    System.out.print("\n------------------------------------------------------------\n");
  }
}
