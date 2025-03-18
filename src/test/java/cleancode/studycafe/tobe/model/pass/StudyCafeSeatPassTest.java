package cleancode.studycafe.tobe.model.pass;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StudyCafeSeatPassTest {

    private StudyCafeSeatPass hourlyPass;
    private StudyCafeSeatPass weeklyPass;
    private StudyCafeSeatPass fixedPass;

    @BeforeEach
    void setUp() {
        // given
        hourlyPass = StudyCafeSeatPass.of(StudyCafePassType.HOURLY, 60, 1000, 0.1);
        weeklyPass = StudyCafeSeatPass.of(StudyCafePassType.WEEKLY, 420, 5000, 0.2);
        fixedPass = StudyCafeSeatPass.of(StudyCafePassType.FIXED, 1440, 15000, 0.3);
    }

    @Test
    @DisplayName("isSamePassType()은 동일한 passType에 대해 true를 반환해야 한다.")
    void testIsSamePassType_SameType() {
        // when
        boolean isHourlySame = hourlyPass.isSamePassType(StudyCafePassType.HOURLY);
        boolean isWeeklySame = weeklyPass.isSamePassType(StudyCafePassType.WEEKLY);
        boolean isFixedSame = fixedPass.isSamePassType(StudyCafePassType.FIXED);

        // then
        assertThat(isHourlySame).isTrue();
        assertThat(isWeeklySame).isTrue();
        assertThat(isFixedSame).isTrue();
    }

    @Test
    @DisplayName("isSamePassType()은 다른 passType에 대해 false를 반환해야 한다.")
    void testIsSamePassType_DifferentType() {
        // when
        boolean isHourlyDifferent = hourlyPass.isSamePassType(StudyCafePassType.WEEKLY);
        boolean isWeeklyDifferent = weeklyPass.isSamePassType(StudyCafePassType.FIXED);
        boolean isFixedDifferent = fixedPass.isSamePassType(StudyCafePassType.HOURLY);

        // then
        assertThat(isHourlyDifferent).isFalse();
        assertThat(isWeeklyDifferent).isFalse();
        assertThat(isFixedDifferent).isFalse();
    }

    @Test
    @DisplayName("getDiscountPrice()는 할인된 가격을 계산해야 한다.")
    void testGetDiscountPrice() {
        // when
        int hourlyDiscountPrice = hourlyPass.getDiscountPrice();
        int weeklyDiscountPrice = weeklyPass.getDiscountPrice();
        int fixedDiscountPrice = fixedPass.getDiscountPrice();

        // then
        assertThat(hourlyDiscountPrice).isEqualTo(100);
        assertThat(weeklyDiscountPrice).isEqualTo(1000);
        assertThat(fixedDiscountPrice).isEqualTo(4500);
    }


}
