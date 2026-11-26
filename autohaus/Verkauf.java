
public class Verkauf {
    public static void main(String[] args) {
        boolean result = test_calculateDiscount();
        System.out.println(result);
    }

    public static double calculateDiscount(double price) {
        double discount;

        if (price < 15000) {
            discount = 0;
        } else if (price < 20000) {
            discount = 5;
        } else if (price < 25000) {
            discount = 7;
        } else {
            discount = 8.5;
        }

        return discount;
    }

    public static boolean test_calculateDiscount() {
        double discount;
        boolean test_ok = true;

        discount = calculateDiscount(10000);
        if (discount != 0) {
            System.out.println("Test 1 failed.");
            test_ok = false;
        }

        discount = calculateDiscount(15000);
        if (discount != 5) {
            System.out.println("Test 2 failed.");
            test_ok = false;
        }

        discount = calculateDiscount(20000);
        if (discount != 7) {
            System.out.println("Test 3 failed.");
            test_ok = false;
        }

        discount = calculateDiscount(25000);
        if (discount != 8.5) {
            System.out.println("Test 4 failed.");
            test_ok = false;
        }

        return test_ok;
    }
}
