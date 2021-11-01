import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DoubleLinkedList<Integer> queue = new DoubleLinkedList<>(); // ���� �̷�� �ɾ��ִ� �����
		DoubleLinkedList<Integer> queue2 = new DoubleLinkedList<>(); // ���ŵ� �����
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		// queue�� 1������ n������ �Է�
		for(int i = 1; i <= n; i++) { 
			queue.add(i);
		}
		
		int idx = 0; // ������ ��ġ�� �ε���
		
		// k�� ������Ű�� �ش� ��ġ�� �����͸� ����
		while(!queue.IsEmpty()) {
			idx = (idx + (k-1)) % queue.size(); // size�� �ʰ��Ұ�� size�� ���� ������ ����ŭ ����
			int a = queue.remove(idx);
			queue2.add(a);
		}
		
		System.out.print("<");
		while(!queue2.IsEmpty()) {
			System.out.print(queue2.remove());
			if(queue2.IsEmpty()) {
				break;
			}
			System.out.print(", ");
		}
		System.out.print(">");
		
		sc.close();
	}

}
