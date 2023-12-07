import java.util.function.*;


class Operator {

    public static LongBinaryOperator binaryOperator = (long left, long right) -> {
        long product = left;
        if (left == right){
            return left;
        }
        for (long i = left + 1; i <= right; i++) {
            product *= i;
        } return product;
    };
}
