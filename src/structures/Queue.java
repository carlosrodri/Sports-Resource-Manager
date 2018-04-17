package structures;

import java.util.Comparator;

public class Queue <T>{

	private Node<T> head;
	private Node<T> last;
	private Comparator<T> comparator;

	public Queue(Comparator<T> comparator) {
		this.comparator = comparator;
	}

	public void enqueue(Node<T> node){
		if (head != null) {
			Node<T> actual = head;
			while (actual.getNext() != null) {
				actual = actual.getNext();
			}
			actual.setNext(node);
		}else{
			head = node;
		}
	}

	public Node<T> getLast() {
		return last;
	}
	
	public void strainBefore(T info, Node<T> node) {
		Node<T> reference ;
		Node<T> current = head;
		if(head != null) {
			if(info.equals(head.getInformation())) {
				node.setNext(head);
				head = node;
			}else {
				while (current.getNext().getInformation() != info) {
					current = current.getNext();
				}
				reference = current.getNext();
				current.setNext(node);
				node.setNext(reference);

			}
		}else {
			head = node;
		}
	}

	public boolean isEmpty() {
		if(head != null) {
			return false;
		}else {
			return true;
		}
	}
	
	public void strainAfter(T info, Node<T> node) {
		Node<T> reference ;
		Node<T> current = head;
		if(head != null) {
			if(info.equals(head.getInformation())) {
				reference = head;
				node.setNext(head.getNext());
				reference.setNext(node);
				head = reference;
			}else {
				while (current.getInformation() != info) {
					current = current.getNext();
				}
				reference = current.getNext();
				current.setNext(node);
				node.setNext(reference);
			}
		}else {
			head = node;
		}
	}

//	public Node<T> getMaxElement(){
//		Node<T> actual = head;
//		Node<T> max = head;
//		while (actual.getNext() != null) {
//			if (comparator.compare(max.getInformation(), actual.getInformation()) < 0) {
//				max = actual;
//			}
//			actual = actual.getNext();
//		}
//		return max;
//	}

	public Node<T> getHead() {
		return head;
	}

	public Node<T> dequeue(){
		Node<T> reference = head;
		head = reference.getNext();
		reference.setNext(null);
		return reference;
	}

//	private void print() {
//		Node<T> current = head;
//		System.out.println("print");
//		while (current != null) {
//			System.out.println(current.getInformation());
//			current = current.getNext();
//		}
//	}

	public void priorityQueue(Node<T> node) {
		System.out.println("agregaaaaaaa");
		Node<T> current = head;
		if(head != null) {
//			comparator.compare(node.getInformation(), current.getInformation());
//			if(Integer.parseInt(node.getInformation().toString()) > priorityMax) {
			if(comparator.compare(node.getInformation(), current.getInformation()) > 0) {
				node.setNext(head);
				head = node;
			}else {
				while (comparator.compare(node.getInformation(), current.getInformation()) < 0) {
					current = current.getNext();
				}
				strainBefore(current.getInformation(), node);
			}
		}else {
			head = node;
		}
	}
	
	public void priorityQueueDate(Node<T> node) {
		Node<T> current = head;
		if(head != null) {
//			comparator.compare(node.getInformation(), current.getInformation());
//			if(Integer.parseInt(node.getInformation().toString()) > priorityMax) {
			if(comparator.compare(node.getInformation(), current.getInformation()) > 0) {
				node.setNext(head);
				head = node;
			}else {
				while (comparator.compare(node.getInformation(), current.getInformation()) < 0) {
					current = current.getNext();
				}
				strainBefore(current.getInformation(), node);
			}
		}else {
			head = node;
		}
	}
	
	
	public void push(Node<T> node) {
		if(head != null) {
			node.setNext(head);
			head = node;
		}else {
			head = node;
		}
	}

//	public Node<T> pop() {
//		Node<T> popNode = head;
//		head = head.getNext();
//		popNode.setNext(null);
//		return popNode;
//	}
	
	public Node<T> pop() throws Exception {
	if(head != null) {
		Node<T> popNode = head;
		head = head.getNext();
		popNode.setNext(null);
		return popNode;
		}else {
			throw new Exception("no hay mas elementos en la lista");
		}
	}
	
	public void enqueueCircle(Node<T> node) {
		if(head != null) {
			System.out.println(node.getInformation());
			last.setNext(node);
			node.setNext(head);
			last = node;
		}else {
			head = node;
			last = head;
		}
	}
}