import java.util.List;
import java.util.ArrayList;
public class Promotion{

	public static int winPrize(List<List<String>> codeList, List<String> shoppingCart) {
		if (codeList == null || codeList.size() == 0) {
			return 1;
		}
		if (shoppingCart == null || shoppingCart.size() == 0) {
			return 0;
		}
		int i = 0, j = 0;
		while (i < codeList.size() && j + codeList.get(i).size() <= shoppingCart.size()) {
			boolean match = true;
			for (int k = 0; k < codeList.get(i).size(); k++) {
				if (!codeList.get(i).get(k).equals("anything")
						&& !shoppingCart.get(j + k).equals(codeList.get(i).get(k))) {
					match = false;
					break;
				}
			}
			if (match) {
				j += codeList.get(i).size();
				i++;
			} else {
				j++;
			}
		}
		return (i == codeList.size()) ? 1 : 0;
	}

	public static void main(String[] args) {
		List<List<String>> secretList = new ArrayList<List<String>>();
		List<String> secret1 = new ArrayList<String>();
		secret1.add("a");
		secret1.add("a");
		secretList.add(secret1);
		List<String> secret2 = new ArrayList<String>();
		secret2.add("b");
		secret2.add("anything");
		secret2.add("b");
		List<String> cart = new ArrayList<String>();
		cart.add("a");
		cart.add("a");
		cart.add("b");
		cart.add("o");
		cart.add("b");

		System.out.println(winPrize(secretList, cart));

	}
}