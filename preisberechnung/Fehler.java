public class Fehler {

    public static void main(String[] args) {
        // double baseprice = 100.0;
        // double specialprice = 50.0;
        // double extraprice = 5.0;
        // int extras = 0;
        // double discount = 2.0;
        // double result = calculatePrice(baseprice, specialprice, extraprice, extras, discount);
        boolean result = test_calculate_price();
        System.out.println(result);
    }

    public static double calculatePrice(double baseprice, double specialprice, double extraprice, int extras, double discount) {
        double addon_discount;
        double result;

        if (extras >= 3)
            addon_discount = 10;
        else if (extras >= 5)
            addon_discount = 15;
        else
            addon_discount = 0;

        if (discount > addon_discount)
            addon_discount = discount;

        result = baseprice/100.0 * (100-discount) + specialprice
                + extraprice/100.0 * (100-addon_discount);

        return result;
    }

    public static boolean test_calculate_price(){
        double price;
        boolean test_ok = true;

        price = calculatePrice(100, 0, 0, 0, 0);
        if (price != 100) {
            test_ok = false;
            System.out.println("Test 1 failed.");
        }

        price = calculatePrice(100, 10, 0, 0, 0);
        if (price != 110) {
            test_ok = false;
            System.out.println("Test 2 failed.");
        }

        price = calculatePrice(100, 0, 0, 0, 20);
        if (price != 80) {
            test_ok = false;
            System.out.println("Test 3 failed.");
        }

        price = calculatePrice(0, 0, 100, 2, 0);
        if (price != 100) {
            test_ok = false;
            System.out.println("Test 4 failed.");
        }

        price = calculatePrice(0, 0, 100, 3, 0);
        if (price != 90) {
            test_ok = false;
            System.out.println("Test 5 failed.");
        }

        price = calculatePrice(0, 0, 100, 4, 0);
        if (price != 90) {
            test_ok = false;
            System.out.println("Test 6 failed.");
        }

        price = calculatePrice(0, 0, 100, 5, 0);
        if (price != 85) {
            test_ok = false;
            System.out.println("Test 7 failed.");
        }

        price = calculatePrice(100, 0, 100, 3, 5);
        if (price != 185) {
            test_ok = false;
            System.out.println("Test 8 failed.");
        }

        price = calculatePrice(100, 0, 100, 3, 20);
        if (price != 160) {
            test_ok = false;
            System.out.println("Test 9 failed.");
        }

        return test_ok;
    }
}
