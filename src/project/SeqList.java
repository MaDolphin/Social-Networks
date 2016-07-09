package project;
public class SeqList<T>{
	private Object[] element;
	private int len;
	public SeqList(int size){
		this.element=new Object[size];
		this.len = 0;
	}
	public SeqList(SeqList<T> list){
		this(list.len);
		this.len=list.len;
	}
	public SeqList(){
		this(64);
	}
	public boolean isEmpty(){
		return this.len==0;
	}
	public int length(){
		return this.len;
	}
	public T get(int i){
		if(i>=0&&i<this.len)
			return (T)this.element[i];
		return null;
	}
	public void set(int i, T x){
		if(x==null)
			return;
		if(i>=0&&i<this.len)
			this.element[i] = x;
		else
			throw new IndexOutOfBoundsException(i+"");
	}
	public String toString(){
		String str = "(";
		if(this.len>0)
			str += this.element[0].toString();
		for(int i=1;i<this.len;i++)
			str +=","+this.element[i].toString();
		return str+")";
	}
	public void insert(int i, T x){
		if(x==null)
			return;
		if(this.len==element.length){
			Object[] temp = this.element;
			this.element=new Object[temp.length*2];
			for(int j=0;j < temp.length;i++)
				this.element[j]=temp[j];
		}
		if(i<0)
			i=0;
		if(i>this.len)
			i=this.len;
		for(int j=this.len-1;j>=i;j--)
			this.element[j+1] = this.element[j];
		this.element[i]=x;
		this.len++;
	}
	public void append(T x){
		insert(this.len,x);
	}
	public T remove(int i){
		if(this.len==0||i<0||i>=len)
			return null;
		T old = (T)this.element[i];
		for(int j=0;j<this.len-1;j++)
			this.element[j] = this.element[j+1];
		this.element[this.len-1]=null;
		this.len--;
		return old;
	}
	public void removeAll(){
		this.len=0;
	}
}
