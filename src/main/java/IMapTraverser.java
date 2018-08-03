public interface IMapTraverser {

  default public void traverse(Map map) {
    before(map);
    for (int y = 0; y < map.getHeight(); y++) {
      for (int x = 0; x < map.getWidth(); x++) {
        atEvery(map, x, y);
      }
      atRow(map, y);
    }
    after(map);
  }

  default public void before(Map map){}

  default public void atEvery(Map map, int x, int y){}

  default public void atRow(Map map, int x){}

  default public void after(Map map){}
}
