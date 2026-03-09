void main()
{
    IO.println("max: " + MathUtils.max(-1, 2, -5));
    IO.println("min: " + MathUtils.min(-1, 2, -5));

    IO.println("linear: " + MathUtils.solveLinear(3, 6));
    IO.println("quadratic: " + Arrays.toString(MathUtils.solveQuadratic(8, 3, -11)));

    IO.println("sign: " + MathUtils.getSign(15));

    IO.println("sumEvenNums: " + MathUtils.sumEvenNumbers(11));

    IO.println("factorial: " + MathUtils.factorial(6));
    IO.println("prime: " + MathUtils.isPrime(11));

    double matrix[][] = {
            {1,    2,     3,    4,     5},
            {-3,  -5,    -2,   11,     2},
            {12,   5,    -4,    3,   1.5},
            {8,    1,   0.3,    8,  -2.5},
            {100, -3, -12.2,    11,   -10}
    };

    IO.println("arithMean: " + MathUtils.arithmeticMean(matrix));
    IO.println("geomMean: " + MathUtils.geometricMean(matrix));

    IO.println("sumEvenColumn: " + MathUtils.sumEvenColumns(matrix));
    IO.println("productOddRows: " + MathUtils.productOddRows(matrix));
}


public final class MathUtils
{
    private MathUtils() {}

    public static int max(int a, int b, int c) {
        if (a > b && a > c) {
            return a;
        } else if (b > a && b > c) {
            return b;
        } else {
            return c;
        }
    }

    public static int min(int a, int b, int c) {
        if (a < b && a < c) {
            return a;
        } else if (b < a && b < c) {
            return b;
        } else {
            return c;
        }
    }

    public static double solveLinear(double a, double b) {
        return (-b) / a;
    }

    public static String getSign(int num) {
        if (num > 0) {
            return "положительное";
        } else if (num < 0) {
            return "отрицательное";
        }
        return "нулевое";
    }

    public static double[] solveQuadratic(double a, double b, double c) {
        double discr = b * b - 4 * a * c;
        double ans[] = new double[2];

        if (discr > 0) {
            ans[0] = (-b + Math.pow(discr, 0.5)) / (2 * a);
            ans[1] = (-b - Math.pow(discr, 0.5)) / (2 * a);

            return ans;
        } else if (discr == 0) {
            ans[0] = (-b) / (2 * a);
            ans[1] = ans[0];
            return ans;
        } else {
            IO.println("нет решений в поле действительных чисел\n");
            return null;
        }
    }

    public static int sumEvenNumbers(int n) {
        int sum = 0;

        for (int i = 2; i <= n; i += 2) {
            sum += i;
        }

        return sum;
    }

    public static long factorial(int n) {
        long factorial = 1;

        for (int i = 2; i <= n; i++) {
            factorial *= i;
        }

        return factorial;
    }

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.pow(num, 0.5) + 1; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static double arithmeticMean(double matrix[][]) {
        double sum = 0;
        int cnt = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                cnt++;
                sum += matrix[i][j];
            }
        }

        return sum / cnt;
    }

    public static double geometricMean(double matrix[][]) {
        double prod = 1;
        int cnt = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                cnt++;
                prod *= matrix[i][j];
            }
        }

        return Math.pow(prod, 1.0/cnt);
    }

    public static double sumEvenColumns(double matrix[][]) {
        double sum = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (j % 2 == 0)
                {
                    sum += matrix[i][j];
                }
            }
        }

        return sum;
    }

    public static double productOddRows(double matrix[][]) {
        double prod = 1;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i % 2 == 1)
                {
                    prod *= matrix[i][j];
                }
            }
        }

        return prod;
    }
}