
public class driver {

	public static void main(String[] args) {

		LinkedBag<Integer> list = new LinkedBag<>();
		list.add(5);
		list.add(15);
		list.add(20);
		
		Object[] arr = list.toArray();
		
		System.out.println(arr);

	}

}
