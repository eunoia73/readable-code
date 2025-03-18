package cleancode.studycafe.tobe.model.order;

import cleancode.studycafe.tobe.model.pass.StudyCafePassType;
import cleancode.studycafe.tobe.model.pass.StudyCafeSeatPass;
import cleancode.studycafe.tobe.model.pass.locker.StudyCafeLockerPass;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudyCafePassOrderTest {
    @DisplayName("좌석 패스를 구매한 경우 총 가격을 반환한다.")
    @Test
    public void testGetTotalPrice_SeatPass() {
        //given
        StudyCafePassType passType = StudyCafePassType.HOURLY;
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(passType, 2, 4000, 0.0);
        StudyCafePassOrder order = StudyCafePassOrder.of(seatPass, null);

        //when
        int totalPrice = order.getTotalPrice();

        //then
        assertEquals(4000, totalPrice);
    }

    @DisplayName("고정권 좌석 패스를 구매한 경우 할인된 총 가격을 반환한다.")
    @Test
    public void testGetTotalPrice_WithoutLockerPass() {
        //given
        StudyCafePassType passType = StudyCafePassType.FIXED;
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(passType, 4, 250000, 0.1);
        StudyCafePassOrder order = StudyCafePassOrder.of(seatPass, null);

        //when
        int totalPrice = order.getTotalPrice();

        //then
        assertEquals(225000, totalPrice);
    }

    @DisplayName("고정권 좌석 패스와 락커 패스를 구매한 경우 할인된 총 가격을 반환한다.")
    @Test
    public void testGetTotalPrice_WithLockerPass() {
        //given
        StudyCafePassType passType = StudyCafePassType.FIXED;
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(passType, 4, 250000, 0.1);
        StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(passType, 4, 10000);
        StudyCafePassOrder order = StudyCafePassOrder.of(seatPass, lockerPass);

        //when
        int totalPrice = order.getTotalPrice();

        //then
        assertEquals(235000, totalPrice);
    }



}
