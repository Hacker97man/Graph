import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class Mian {
	static int x=0;
	public static void main(String[] args) {
		BFSGraph graph=new BFSGraph(6);
		graph.AddNode(0,2);
		graph.AddNode(0,1);
		graph.AddNode(1,4);
		graph.AddNode(1, 3);
		graph.AddNode(1, 0);
		graph.AddNode(3, 1);
		graph.AddNode(4, 1);
		graph.AddNode(2, 5);
		graph.AddNode(2, 0);
		graph.AddNode(5, 2);
		graph.BFSExplore(0);
		
	}
	private static class Node{
		int dest;
		Node  next;
		public Node(Node next,int dest) {
			this.dest=dest;
			this.next=next;
		}
		
	}
	private static class adjList{
		Node head;
	}
	private static class BFSGraph{
		protected int size;
		protected adjList[]array;
		public BFSGraph(int size) {
		this.size=size;
		array=new adjList[this.size];
		for(int i=0;i<size;i++)
		{
			array[i]=new adjList();
			array[i].head=null;
			
		}
		}
		public void AddNode(int sec,int dest){
			Node n=new Node(null,dest);
			n.next=array[sec].head;
			array[sec].head=n;
			
		}
		public void BFSExplore(int start){
			boolean[]visited=new boolean[size];
			for(int i=0;i<size;i++)
				visited[i]=false;
			Queue<Integer>s=new LinkedList<Integer>();
			s.add(start);
			while(! s.isEmpty()){
				int n=s.poll();
				visited[n]=true;
				System.out.println("Visited : "+n);
				Node head=array[n].head;
				while(head!=null)
				{
					if(visited[head.dest]==false){
						s.add(head.dest);
						visited[head.dest]=true;
					}
					else head=head.next;
				}
			}
		}

	}


}
