import helloworldcicd.Greeter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

class GreeterTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream, true, StandardCharsets.UTF_8));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void testGreetOutputsCorrectMessage() {
        String name = "Сергей";
        Greeter.greet(name);

        String expected = "Приветствуем Вас, " + name + ", на нашем сервере! Добро пожаловать!";
        String actual = outputStream.toString(StandardCharsets.UTF_8);

        assertTrue(actual.contains(expected));
    }

    @Test
    void testMainWithInput() throws Exception {
        String inputName = "Светлана";
        ByteArrayInputStream in = new ByteArrayInputStream((inputName + "\n").getBytes(StandardCharsets.UTF_8));
        System.setIn(in);

        Greeter.main(new String[]{});

        String output = outputStream.toString(StandardCharsets.UTF_8);

        assertTrue(output.contains("Пожалуйста, введите Ваше имя"));
        assertTrue(output.contains("Приветствуем Вас, " + inputName));
    }
}