import java.util.Stack;

public class Mian {
	static int x=0;
	public static void main(String[] args) {
		DFSGraph graph=new DFSGraph(4);
		graph.AddNode(0,1);
		graph.AddNode(0,2);
		graph.AddNode(3, 0);
		graph.AddNode(2, 3);
		graph.DFSExplore(0);
		
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
	private static class DFSGraph{
		protected int size;
		protected adjList[]array;
		public DFSGraph(int size) {
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
		public void DFSExplore(int start){
			boolean[]visited=new boolean[size];
			for(int i=0;i<size;i++)
				visited[i]=false;
			Stack<Integer>s=new Stack<Integer>();
			s.push(start);
			while(! s.isEmpty()){
				int n=s.pop();
				s.push(n);
				visited[n]=true;
				Node head=array[n].head;
				Boolean isDone=true;
				while(head!=null)
				{
					if(visited[head.dest]==false){
						s.push(head.dest);
						visited[head.dest]=true;
						isDone=false;
						break;
					}
					else head=head.next;
				}
				if(isDone==true){
					int out=s.pop();
					System.out.println(out);
				}
			}
		}
	}
		}
