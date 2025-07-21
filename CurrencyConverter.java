import java.util.Scanner;

public class CurrencyConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Display available currencies
        System.out.println("Welcome to Currency Converter!");
        System.out.println("Available currencies: INR, USD, EUR, GBP");
        
        // Input from user
        System.out.print("Enter source currency (e.g., USD): ");
        String fromCurrency = scanner.next().toUpperCase();

        System.out.print("Enter target currency (e.g., INR): ");
        String toCurrency = scanner.next().toUpperCase();

        System.out.print("Enter amount to convert: ");
        double amount = scanner.nextDouble();

        double convertedAmount = convertCurrency(fromCurrency, toCurrency, amount);
        if (convertedAmount != -1) {
            System.out.printf("%.2f %s = %.2f %s\n", amount, fromCurrency, convertedAmount, toCurrency);
        } else {
            System.out.println("Invalid currency or conversion not supported.");
        }

        scanner.close();
    }

    // Method to convert currency
    public static double convertCurrency(String from, String to, double amount) {
        // Example conversion rates (for demonstration)
        double rate = 0.0;

        switch (from) {
            case "USD":
                if (to.equals("INR")) rate = 83.0;
                else if (to.equals("EUR")) rate = 0.91;
                else if (to.equals("GBP")) rate = 0.78;
                break;

            case "INR":
                if (to.equals("USD")) rate = 0.012;
                else if (to.equals("EUR")) rate = 0.011;
                else if (to.equals("GBP")) rate = 0.0094;
                break;

            case "EUR":
                if (to.equals("USD")) rate = 1.1;
                else if (to.equals("INR")) rate = 91.0;
                else if (to.equals("GBP")) rate = 0.86;
                break;

            case "GBP":
                if (to.equals("USD")) rate = 1.28;
                else if (to.equals("INR")) rate = 106.0;
                else if (to.equals("EUR")) rate = 1.16;
                break;

            default:
                return -1; // Unsupported currency
        }

        return rate == 0.0 ? -1 : amount * rate;
    }
}
