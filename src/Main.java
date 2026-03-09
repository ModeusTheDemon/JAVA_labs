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


public final class MathUtils {

    private MathUtils() {}

    public static int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public static int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    public static double solveLinear(double a, double b) {
        if (a == 0) {
            throw new IllegalArgumentException("Коэффициент a не может быть равен 0");
        }
        return -b / a;
    }

    public static String getSign(int num) {
        if (num > 0) {
            return "положительное";
        } else if (num < 0) {
            return "отрицательное";
        } else {
            return "нулевое";
        }
    }

    public static double[] solveQuadratic(double a, double b, double c) {
        if (a == 0) {
            throw new IllegalArgumentException("Коэффициент a не может быть равен 0 (уравнение не квадратное)");
        }

        double discriminant = b * b - 4 * a * c;
        double[] roots = new double[2];

        if (discriminant > 0) {
            double sqrtDisc = Math.sqrt(discriminant);
            roots[0] = (-b + sqrtDisc) / (2 * a);
            roots[1] = (-b - sqrtDisc) / (2 * a);
        } else if (discriminant == 0) {
            roots[0] = -b / (2 * a);
            roots[1] = roots[0];
        } else {
            IO.println("Нет решений в поле действительных чисел");
            roots[0] = 0;
            roots[1] = 0;
        }
        return roots;
    }

    public static int sumEvenNumbers(int n) {
        int sum = 0;
        for (int i = 2; i <= n; i += 2) {
            sum += i;
        }
        return sum;
    }

    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Факториал отрицательного числа не определён");
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static double arithmeticMean(double[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            throw new IllegalArgumentException("Матрица не должна быть пустой");
        }

        double sum = 0;
        int count = 0;
        for (double[] row : matrix) {
            if (row == null) continue;
            for (double val : row) {
                sum += val;
                count++;
            }
        }

        if (count == 0) {
            throw new IllegalArgumentException("Матрица не содержит элементов");
        }
        return sum / count;
    }

    public static double geometricMean(double[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            throw new IllegalArgumentException("Матрица не должна быть пустой");
        }

        double product = 1.0;
        int count = 0;
        for (double[] row : matrix) {
            if (row == null) continue;
            for (double val : row) {
                product *= val;
                count++;
            }
        }

        if (count == 0) {
            throw new IllegalArgumentException("Матрица не содержит элементов");
        }
        return Math.pow(product, 1.0 / count);
    }

    public static double sumEvenColumns(double[][] matrix) {
        double sum = 0;
        if (matrix == null) {
            return sum;
        }
        for (double[] row : matrix) {
            if (row == null) continue;
            for (int j = 0; j < row.length; j++) {
                if (j % 2 == 0) {
                    sum += row[j];
                }
            }
        }
        return sum;
    }

    public static double productOddRows(double[][] matrix) {
        double product = 1.0;
        if (matrix == null) {
            return product;
        }
        for (int i = 0; i < matrix.length; i++) {
            if (i % 2 == 1) {
                double[] row = matrix[i];
                if (row == null) continue;
                for (double val : row) {
                    product *= val;
                }
            }
        }
        return product;
    }
}