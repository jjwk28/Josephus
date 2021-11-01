import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DoubleLinkedList<Integer> queue = new DoubleLinkedList<>(); // 원을 이루며 앉아있는 사람들
		DoubleLinkedList<Integer> queue2 = new DoubleLinkedList<>(); // 제거된 사람들
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		// queue에 1번부터 n번까지 입력
		for(int i = 1; i <= n; i++) { 
			queue.add(i);
		}
		
		int idx = 0; // 삭제할 위치의 인덱스
		
		// k씩 증가시키며 해당 위치의 데이터를 삭제
		while(!queue.IsEmpty()) {
			idx = (idx + (k-1)) % queue.size(); // size를 초과할경우 size로 나눈 나머지 값만큼 증가
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
