package mn.edu.must.sqat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BonusTest {
    @Test @DisplayName("all-defs: threshold met after streak reset")
    void B1() { assertEquals(8, DataFlowTargets.bonus(new int[]{1, 0, 1, 1, 1, 1, 1}, 6)); }

    @Test @DisplayName("all-defs: threshold missed, score initial definition reaches addition")
    void B2() { assertEquals(3, DataFlowTargets.bonus(new int[]{1, 0, 1, 1, 1, 1, 1}, 7)); }

    @Test @DisplayName("all-DU-pairs: empty array, threshold zero")
    void B3() { assertEquals(5, DataFlowTargets.bonus(new int[]{}, 0)); }

    @Test @DisplayName("all-DU-pairs: short streak and threshold missed")
    void B4() { assertEquals(0, DataFlowTargets.bonus(new int[]{1, 0, 1}, 3)); }

    @Test @DisplayName("all-DU-pairs: long streak starts after an absence")
    void B5() { assertEquals(3, DataFlowTargets.bonus(new int[]{0, 1, 1, 1, 1, 1}, 7)); }

    @Test @DisplayName("all-DU-pairs: null attendance is rejected")
    void B6() { assertThrows(IllegalArgumentException.class, () -> DataFlowTargets.bonus(null, 0)); }

    @Test @DisplayName("all-DU-pairs: negative threshold is rejected")
    void B7() { assertThrows(IllegalArgumentException.class, () -> DataFlowTargets.bonus(new int[]{1}, -1)); }

    @Test @DisplayName("all-DU-pairs: all absences preserve initial present definition")
    void B8() { assertEquals(0, DataFlowTargets.bonus(new int[]{0, 0}, 1)); }

    @Test
    @DisplayName("M2 kill: present grows across reset before a shorter streak")
    void B9() {
        assertEquals(0, DataFlowTargets.bonus(new int[]{1, 0, 1, 1, 1, 1}, 6));
    }
}
