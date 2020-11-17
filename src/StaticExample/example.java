package StaticExample;

public class example {

    public static void main(String[] args) {
        TeslaModelS car = new TeslaModelS("jerry", 999);
        car.displayWelcome();// nonstatic method 要用实例去调用
        car.displayVin();
        TeslaModelS.displayManufacturer();// static method can only access static variable，所以只能用constructor.static method
//        TeslaModelS.displayVin();
        TeslaModelS car2 = new TeslaModelS("gab", 666);
        car2.displayWelcome();
    }

}
    class TeslaModelS {
        // constructor
        public TeslaModelS(String o, int v) {
            owner = o;
            vin = v;
        }

        private static int numWheels = 4;
        private int vin;
        private String owner;
        private static String manufacturer = "Tesla, CA";

        public void displayWelcome() {
            System.out.println("Welcom," + owner);
        }

        public static void displayManufacturer() {
            System.out.println("Made by" + manufacturer + numWheels);
        }

        public void displayVin(){
            System.out.println("VIN is" + vin);
        }

    }



