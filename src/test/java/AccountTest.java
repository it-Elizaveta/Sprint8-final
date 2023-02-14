import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;


@RunWith(Parameterized.class)
public class AccountTest {

    private final String name;
    private final Boolean isExpected;

    public AccountTest (String name, Boolean isExpected) {
        this.name=name;
        this.isExpected=isExpected;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][] {
                {"",false},
                {"p",false},
                {"po",false},
                {" ",false},
                {"TjkjkkTnmmnm",false},
                {"Thjhhhj HJhjjh Hjjkj",false},
                {"UKJHG KJKJKKJKJHGHG)",false},
                {"UKJHG KJKJKoKJKJHGHG)",false},
                {"q 0",true},
                {"qi 0",true},
                {"q77777 0www",true},
                {"UKJHG KJKJKKJKJHGHG",true}
        };

    }

    @Test
    public void checkNameToEmbossParameterizedTest() {
        Account account=new Account(name);
        boolean actual= account.checkNameToEmboss();
        assertEquals(isExpected,actual);

    }
}