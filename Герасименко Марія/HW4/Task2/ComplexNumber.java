public class ComplexNumber {

    /**
     * Представляет действительную часть комплексного числа
     */
    private double re;

    /**
     * Представляет мнимую часть комплексного числа
     */
    private double im;

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    /**
     * @return возвращает модуль (или абсолютное значение) числа
     */
    private double getModule() {
        return Math.sqrt(this.re * this.re + this.im * this.im);
    }

    /**
     * Позволяет получить сумму двух комплексных чисел, заданных в параметрах.
     *
     * @return возвращает новое комплексное число
     */
    public static ComplexNumber sum(ComplexNumber cn1, ComplexNumber cn2) {
        return new ComplexNumber(cn1.getRe() + cn2.getRe(), cn1.getIm() + cn2.getIm());
    }

    /**
     * Позволяет получить произведение двух комплексных чисел, заданных в параметрах.
     *
     * @return возвращает новое комплексное число
     */
    public static ComplexNumber multiply(ComplexNumber cn1, ComplexNumber cn2) {
        return new ComplexNumber(cn1.getRe() * cn2.getRe() - cn1.getIm() * cn2.getIm(), cn1.getRe() * cn2.getIm() + cn1.getIm() * cn2.getRe());
    }

    /**
     * Позволяет получить разность двух комплексных чисел, заданных в параметрах.
     *
     * @return возвращает новое комплексное число
     */
    public static ComplexNumber subtract(ComplexNumber cn1, ComplexNumber cn2) {
        return new ComplexNumber(cn1.getRe() - cn2.getRe(), cn1.getIm() - cn2.getIm());
    }

    /**
     * Позволяет получить произведение двух комплексных чисел, заданных в параметрах.
     *
     * @return возвращает новое комплексное число
     */
    public static ComplexNumber divide(ComplexNumber cn1, ComplexNumber cn2) {
        ComplexNumber temp = new ComplexNumber(cn2.getRe(), (-1) * cn2.getIm());
        temp = ComplexNumber.multiply(cn1, temp);
        double denominator = cn2.getRe() * cn2.getRe() + cn2.getIm() * cn2.getIm();
        return new ComplexNumber(temp.getRe() / denominator, temp.getIm() / denominator);
    }

    /**
     * Эта функция позволяет получить аргумент комплексного числа, чтобы представить его в тригонометрической форме.
     *
     * @return возвращает аргумент комплексного числа
     */
    private double GetArg() {
        if (this.re > 0) {
            return Math.atan(im / re);
        } else {
            if (re < 0 && im > 0) {
                return Math.PI + Math.atan(im / re);
            } else {
                return -Math.PI + Math.atan(im / re);
            }
        }
    }

    /**
     * Позволяет возвести комплексное число в указанную степень с помощью формулы де Муавра.
     *
     * @param cn    необходимое комплексное число (основание)
     * @param power показатель степени
     * @return возвращает новое комплексное число
     */
    public static ComplexNumber pow(ComplexNumber cn, int power) {
        double factor = Math.pow(cn.getModule(), power);
        return new ComplexNumber(factor * Math.cos(power * cn.GetArg()), factor * Math.sin(power * cn.GetArg()));
    }

    /**
     * Функция получения квадратных корней из комплексного числа cn
     *
     * @return вернуть массив пары квадратных корней
     */
    public static ComplexNumber[] sqrt(ComplexNumber cn) {
        double a = cn.getModule() / 2;
        ComplexNumber pos = new ComplexNumber(Math.sqrt(a + cn.getRe() / 2), Math.signum(cn.getIm()) * Math.sqrt(a - cn.getRe() / 2));
        ComplexNumber neg = new ComplexNumber((-1) * pos.getRe(), (-1) * pos.getIm());
        ComplexNumber[] answer = {pos, neg};
        return answer;
    }

    /**
     * Определяет и возвращает знак, необходимый для правильной записи числа
     *
     * @return строка возврата с соответствующим знаком
     */
    private String sign() {
        if (im > 0) return " + ";
        else return " - ";
    }

    @Override
    public String toString() {
        String string;
        if (im == 1 || im == -1) {
            if (re == 0) {
                string = sign() + "i";
            } else {
                string = Double.toString(re) + sign() + "i";
            }
        } else {
            string = Double.toString(re) + sign() + Double.toString(Math.abs(im)) + "i";
        }
        return string;
    }

    @Override
    public boolean equals(Object obj) {
        if (this.getClass() != obj.getClass() || obj == null)
            return false;
        return true;
    }

    /**
     * Показаны все операции с комплексными числами
     */
    public static void main(String[] args) {
        ComplexNumber x = new ComplexNumber(2, 3);
        ComplexNumber y = new ComplexNumber(-1, 2);
        System.out.println("z1 = " + x + ",     z2 = " + y);

        ComplexNumber z;
        z = ComplexNumber.sum(x, y);
        System.out.println("+ : " + z);

        z = ComplexNumber.subtract(x, y);
        System.out.println("- : " + z);

        z = ComplexNumber.divide(x, y);
        System.out.println("/ : " + z);

        z = ComplexNumber.multiply(x, y);
        System.out.println(" * :" + z);

        z = ComplexNumber.pow(y, 2);
        System.out.println("Pow 2 of z2 : " + z);

        ComplexNumber b = new ComplexNumber(3, 4);
        ComplexNumber[] ans = ComplexNumber.sqrt(b);
        System.out.println("Sqrt of " + b + " = " + ans[0] + ",  " + ans[1]);

    }
}