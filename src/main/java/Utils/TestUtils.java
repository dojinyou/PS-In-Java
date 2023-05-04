package Utils;

import java.util.Arrays;

public class TestUtils {

	public static <O> void printResult(int idx, O expect, O result) {
		if (!expect.equals(result)) {
			System.out.printf("[%d] %s\n\texpect:%d\n\tresult:%d\n\n", idx, "FAILED", expect, result);
		}
	}

}
