package mn.edu.must.sqat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GcdTest {
    @Test
    @DisplayName("gcd(7,0): x 13->20 c-use; y 13->15 p-use F")
    void xDefinitionReachesReturnWithoutLoop() {
        assertEquals(7, DataFlowTargets.gcd(7, 0));
    }

    @Test
    @DisplayName("gcd(12,8): x 13->16, 17->16/20; y 13/18->15/16; tmp 16->18")
    void twoIterationsCoverLoopPairs() {
        assertEquals(4, DataFlowTargets.gcd(12, 8));
    }
}

