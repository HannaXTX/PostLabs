package Labs.Lab4;

public class Driver {
	public static void main(String[] args) {
		MyCursorArray<Integer> arr = new MyCursorArray<>(20);
		arr.initialization();
		int sqr2 = arr.createList();
		int sqr3 = arr.createList();
		

		arr.insertAtHead(2, sqr2);
		arr.insertLastRec(8, sqr2);
		arr.insertAtLast(4, sqr2);

		arr.insertAtHead(3, sqr3);
		arr.insertAtHead(9, sqr3);

//		arr.merge(sqr2, sqr3);
		arr.insertAtHead(1,sqr3);
		arr.insertAtHead(3,sqr3);
		arr.insertAtHead(1,sqr3);
		arr.insertAtHead(0,sqr3);


//		System.out.println("size is : "+arr.lengthItr(sqr3));
//		System.out.println(arr.lengthItr(sqr2));
//		System.out.println(arr.lengthRec(sqr2));

		arr.merge(sqr2,sqr3);
		arr.traversList(sqr2);

	arr.displayLIST();

	}
}
