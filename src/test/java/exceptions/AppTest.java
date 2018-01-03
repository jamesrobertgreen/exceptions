package exceptions;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import uk.co.greenjam.exceptions.CreateExceptions;
import uk.co.greenjam.exceptions.MyException;

public class AppTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void throwsMyException() throws MyException {
        exception.expect(MyException.class);
        exception.expectMessage("Default exception message used if one isn't provided.");
        CreateExceptions createExceptions = new CreateExceptions();
        createExceptions.throwUncaught();
    }
}
