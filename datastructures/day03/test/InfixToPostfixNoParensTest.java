import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InfixToPostfixNoParensTest {

    @Test
    public void infixToPostfixCaseOne() {
        assertEquals("1 2 +", Problems.infixToPostfix("1 + 2"));
    }


    @Test
    public void infixToPostfixCaseTwo() {
        assertEquals("2 3 * 1 +", Problems.infixToPostfix("2 * 3 + 1"));
    }


    @Test
    public void infixToPostfixCaseThree() {
<<<<<<< HEAD
        assertEquals("2 3 1 + * ", Problems.infixToPostfix("2 * ( 3 + 1 )"));
=======
        assertEquals("2 3 1 + *", Problems.infixToPostfix("2 * ( 3 + 1 )"));
>>>>>>> 78bf0f8575d48fe7b45feeaad5ec2af1e4147035
    }


    @Test
    public void infixToPostfixCaseFour() {
        assertEquals("2 3 * 1 +", Problems.infixToPostfix("( 2 * 3 ) + 1"));
    }


    @Test
    public void infixToPostfixCaseFive() {
        assertEquals("1 2 4 + * 3 *", Problems.infixToPostfix("1 * ( 2 + 4 ) * 3"));
    }

    @Test
    public void infixToPostfixCaseSix() {
        assertEquals("1 6 2 4 + * * 3 +", Problems.infixToPostfix("( 1 * ( 6 * ( 2 + 4 ) ) ) + 3"));
    }
}
