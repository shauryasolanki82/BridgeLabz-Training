import com.example.Program;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;


public class JunitTest {

@Test
public void Test_Deposit_ValidAmount() {
    Program account = new Program(1000);
    account.deposit(500);
    assertEquals(1500, account.getBalance());
}

@Test
public void Test_Deposit_NegativeAmount(){
    Program account = new Program(1000);

    Exception exception = assertThrows(RuntimeException.class, () ->
    account.deposit(-500));

    assertEquals("Deposit amount cannot be negative",exception.getMessage());

}

@Test
public void Test_Withdraw_ValidAmount(){
     Program account = new Program(1000);

     Exception exception = assertThrows(RuntimeException.class, ()->
     account.withdraw(5000));

     assertEquals("Insufficient funds.", exception.getMessage());
}
}