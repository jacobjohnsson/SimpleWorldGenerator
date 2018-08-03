public class MapDebugger implements IMapTraverser {
  public void print(Map map) {
    traverse(map);
  }

  public void before(Map map){
    System.out.print("Degubbing: \n");
  }

  public void atEvery(Map map, int x, int y){
    System.out.print("X: " + x + " Y: " + y + '\n');
  }

  public void after(Map map){
    System.out.print("\n\tDebugging is complete!");
  }
}
