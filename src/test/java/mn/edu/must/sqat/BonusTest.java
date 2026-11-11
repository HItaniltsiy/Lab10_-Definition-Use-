package mn.edu.must.sqat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BonusTest {
    @Test
    @DisplayName("all-defs: threshold met after streak reset")
    void B1() {
        assertEquals(8, DataFlowTargets.bonus(new int[]{1, 0, 1, 1, 1, 1, 1}, 6));
    }

    @Test
    @DisplayName("all-defs: threshold missed, score initial definition reaches addition")
    void B2() {
        assertEquals(3, DataFlowTargets.bonus(new int[]{1, 0, 1, 1, 1, 1, 1}, 7));
    }
}
