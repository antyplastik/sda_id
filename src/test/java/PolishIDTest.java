import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(JUnitParamsRunner.class)
public class PolishIDTest {

    Validator validator;

    @Test
    @Parameters(method = "somePolishIdNumbers")
    public void testCheckIfIdNumberIsCorrect(String inputId, boolean expected) {
        validator = new PolishID(inputId);
        assertThat(validator.validate(inputId), is(expected));
    }
//ABS 123456
    public Object[] somePolishIdNumbers() {
        return new Object[]{
                new Object[]{"ABS 123456", true},
                new Object[]{"ABS123456", true},
                new Object[]{"ABS 12345", false},
                new Object[]{"ABS12345", false},
                new Object[]{"AB 123456", false},
                new Object[]{"AB123456", false},
        };
    }
}
