import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

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

    public PolishID(String idNumber) {
        this.idNumber = idNumber;
        charMap = new HashMap<>();
        setCharMap();

        validate(idNumber);
    }

    private void setCharMap() {
//        65 - 90
        int value = 10;
        for (int i = 65; i <= 90; i++) {
            charMap.put((char) i, value);
            value++;
        }
    }

    @Override
    public boolean validate(String inputString) {
        boolean length = checkLenght(inputString);
        boolean format = checktFormat(inputString);
        boolean calculation = checkCalculation(inputString);

        if (length == true && format == true)
            return true;
        else
            return false;
    }

    private boolean checkCalculation(String inputString) {
        
        return false;
    }

    public boolean checktFormat(String inputString) {
        if (Pattern.matches(polishIdFormatRegex, inputString))
            return true;
        else
            return false;
    }

    public boolean checkLenght(String inputString) {
        int polishIdLen = inputString.length();
        inputString = inputString.replaceAll("\\s", "");

        if (polishIdLen == 9)
            return true;
        else
            return false;
    }

}
