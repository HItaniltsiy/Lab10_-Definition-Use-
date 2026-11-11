package mn.edu.must.sqat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GcdTest {
    @Test
    @DisplayName("gcd(7,0): x def 13 to return use 20")
    void xDefinitionReachesReturnWithoutLoop() {
        assertEquals(7, DataFlowTargets.gcd(7, 0));
    }

    @Test
    @DisplayName("gcd(12,8): loop DU pairs across two iterations")
    void twoIterationsCoverLoopPairs() {
        assertEquals(4, DataFlowTargets.gcd(12, 8));
    }
}
