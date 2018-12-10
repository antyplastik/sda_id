import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PolishID implements Validator {

//      A    B	C	D	E	F	G	H	I	J	K	L	M	N	O	P	Q	R	S	T	U	V	W	X	Y	Z
//      10	11	12	13	14	15	16	17	18	19	20	21	22	23	24	25	26	27	28	29	30	31	32	33	34	35  Value

//    ABS 123456
//Dane:	    A	B	S	1	2	3	4	5	6
//Wartość:	10	11	28	(1)	2	3	4	5	6
//Waga:	    7	3	1	-	7	3	1	7	3
//Iloczyn:	70	33	28	-	14	9	4	35	18
//Suma:	    70 + 33 + 28 + 14 + 9 + 4 +35 +18 = 211
// 211 mod 10 = 1 czyli liczba kontrolna sie zgadza

    private String idNumber;
    String polishIdFormatRegex = "([a-zA-Z]{3})([\\s]*)([0-9]{6})";
    private Map<Character, Integer> charMap;
    private int[] charWeight = {7, 3, 1, 0, 7, 3, 1, 7, 3};

    public PolishID(String idNumber) {
        this.idNumber = idNumber;
        charMap = new HashMap<>();
        setCharMap();

        validate(idNumber);
    }

    private void setCharMap() {
//        65 - 90
        int value = 10;

        for (int i = 0; i < value; i++)
            charMap.put((char) (48 + i), i);

        for (int i = 65; i <= 90; i++) {
            charMap.put((char) i, value);
            value++;
        }
    }

    @Override
    public boolean validate(String inputString) {

        this.idNumber = inputString.toUpperCase();

        boolean length = checkLenght(idNumber);
        if (length == false)
            return false;
        else {
            boolean format = checktFormat(idNumber);
            boolean calculation = checkCalculation(idNumber);

            if (format == true && calculation == true)
                return true;
            else
                return false;
        }
    }

    private boolean checkCalculation(String inputString) {
        IntStream charStream = IntStream.range(0, 9);
        int sum = charStream
                .map(i -> {
                    int value = getValueOfSign(inputString.charAt(i));
                    int weight = charWeight[i];
                    return value * weight;
                }).sum();

        if ((sum % 10) == Integer.parseInt(inputString.charAt(3) + ""))
            return true;
        else
            return false;
    }

    private int getValueOfSign(char c) {
        int value = 0;
        value = Integer.valueOf(charMap.get(c).toString());
        return value;
    }

    private boolean checktFormat(String inputString) {
        if (Pattern.matches(polishIdFormatRegex, inputString))
            return true;
        else
            return false;
    }

    private boolean checkLenght(String inputString) {
        this.idNumber = inputString.replaceAll("\\s", "");
        int polishIdLen = idNumber.length();

        if (polishIdLen == 9)
            return true;
        else
            return false;
    }

}
