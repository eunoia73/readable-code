package cleancode.studycafe.tobe.io;

import cleancode.studycafe.tobe.exception.AppException;
import cleancode.studycafe.tobe.model.pass.StudyCafePassType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.*;

class InputHandlerTest {

    @Test
    @DisplayName("사용자가 잘못된 값을 입력하면 예외가 발생한다.")
    void testGetPassTypeSelectingUserAction_InvalidInput() {
        // given
        System.setIn(new ByteArrayInputStream("4\n".getBytes()));
        InputHandler inputHandler = new InputHandler();

        // when & then
        assertThatThrownBy(() -> inputHandler.getPassTypeSelectingUserAction())
            .isInstanceOf(AppException.class)
            .hasMessage("잘못된 입력입니다.");

    }

}
