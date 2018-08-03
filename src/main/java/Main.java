public class Main {
  public static void main(String[] args) {
    Printer printer = new Printer();
    MapPrinter mapPrinter = new MapPrinter();
    MapInverter inverter = new MapInverter();
    Map map = new Map(80, 45);

    //mapPrinter.print(map);
    inverter.print(map);

  }
}
