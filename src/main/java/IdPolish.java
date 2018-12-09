public class IdPolish implements Validator {

//      A    B	C	D	E	F	G	H	I	J	K	L	M	N	O	P	Q	R	S	T	U	V	W	X	Y	Z
//      10	11	12	13	14	15	16	17	18	19	20	21	22	23	24	25	26	27	28	29	30	31	32	33	34	35  Value

//Dane:	    A	B	S	1	2	3	4	5	6
//Wartość:	10	11	28	(1)	2	3	4	5	6
//Waga:	    7	3	1	-	7	3	1	7	3
//Iloczyn:	70	33	28	-	14	9	4	35	18
//Suma:	    70 + 33 + 28 + 14 + 9 + 4 +35 +18 = 211

// 211 mod 10 = 1 czyli liczba kontrolna sie zgadza

    @Override
    public boolean validate(String inputString) {

        return false;
    }
}
