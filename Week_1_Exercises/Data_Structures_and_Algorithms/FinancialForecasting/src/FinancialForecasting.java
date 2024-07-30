public class FinancialForecasting {

    // Recursive method to calculate future value
    public double predictFutureValue(double initialValue, double growthRate, int years) {
        // Base case: if no years left, return the initial value
        if (years == 0) {
            return initialValue;
        }

        // Recursive step: calculate the future value for the current year
        return predictFutureValue(initialValue, growthRate, years - 1) * (1 + growthRate);
    }

    public static void main(String[] args) {
        FinancialForecasting forecasting = new FinancialForecasting();

        // User input for initial value, growth rate, and number of years
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        System.out.print("Enter the initial value: ");
        double initialValue = scanner.nextDouble();

        System.out.print("Enter the annual growth rate (as a decimal, e.g., 0.05 for 5%): ");
        double growthRate = scanner.nextDouble();

        System.out.print("Enter the number of years: ");
        int years = scanner.nextInt();

        // Predict the future value
        double futureValue = forecasting.predictFutureValue(initialValue, growthRate, years);

        // Display the result
        System.out.println("The predicted future value after " + years + " years is: " + futureValue);

        scanner.close();
    }
}
