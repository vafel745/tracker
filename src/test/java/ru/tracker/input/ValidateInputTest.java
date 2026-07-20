package ru.tracker.input;

import org.junit.jupiter.api.Test;
import ru.tracker.output.MockOutput;
import ru.tracker.output.Output;

import static org.assertj.core.api.Assertions.assertThat;

class ValidateInputTest {

    @Test
    void whenInvalidInput() {
        Output output = new MockOutput();
        Input in = new MockInput(
                new String[]{"one", "1"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    void whenValidInput() {
        Output output = new MockOutput();
        Input in = new MockInput(
                new String[]{"0", "1", "2", "19", "103"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selectedZero = input.askInt("Enter menu:");
        assertThat(selectedZero).isEqualTo(0);
        int selectedOne = input.askInt("Enter menu:");
        assertThat(selectedOne).isEqualTo(1);
        int selectedTwo = input.askInt("Enter menu:");
        assertThat(selectedTwo).isEqualTo(2);
        int selectedNineteen = input.askInt("Enter menu:");
        assertThat(selectedNineteen).isEqualTo(19);
        int selectedOneHundredAndThree = input.askInt("Enter menu:");
        assertThat(selectedOneHundredAndThree).isEqualTo(103);
    }

    @Test
    void whenNumberIsNegative() {
        Output output = new MockOutput();
        Input in = new MockInput(
                new String[]{"-3"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selectedZero = input.askInt("Enter menu:");
        assertThat(selectedZero).isEqualTo(-3);
    }
}
