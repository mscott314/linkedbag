
public class bag {
	public static void main(String[] args) {
		
		list list = new list();
		
		System.out.println(list.add(5));
		System.out.println(list.add(10));
		
		
		
	}

	
	

	
	static class list {
		Node head;
		int numEntries = 0;
		
		list() {
			head = null;
		}
		
		int add(int data) {
			Node newNode = new Node(data);
			head = newNode;
			numEntries++;
		return data;
		}
	}
	
	static class Node {
		
		Node next;
		int data;
		
		Node (int data) {
			this.data = data;
		}
		
	} // end node
} // end bag
