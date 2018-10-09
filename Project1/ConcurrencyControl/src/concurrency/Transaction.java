package concurrency;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import concurrency.LockObj;

public class Transaction {
	Integer TransId;
	Date TimeStamp;
	String TransactionState;
	ArrayList<Character> ItemsLocked;
	ArrayList<String> OperationList;
	
	public Transaction(Integer TransId,String TransactionState)
	{
		this.TransId = TransId;
		this.TimeStamp = new Date();
		this.TransactionState = TransactionState;
		this.ItemsLocked = new ArrayList<Character>();
		this.OperationList = new ArrayList<String>();
	}
	
	public void appendOperation(String string) {
		// TODO Auto-generated method stub
		this.OperationList.add(string);
	}
	public void addHoldObject(char itemName) {
		// TODO Auto-generated method stub
		this.ItemsLocked.add(itemName);
		
	}
	
	public String toString()
	{
		StringBuffer obj = new StringBuffer();
		obj.append("{");
		obj.append("TransId:"+this.TransId);
		obj.append("TimeStamp:"+this.TimeStamp);
		obj.append("TransactionState:"+this.TransactionState);
		obj.append("ItemsLocked:");
		Iterator it = this.ItemsLocked.iterator();
		while(it.hasNext())
		{
			obj.append(it.next());
			obj.append(",");
		}
		obj.append("OperationList:");
		Iterator jt = this.OperationList.iterator();
		while(jt.hasNext())
		{
			obj.append(jt.next());
			obj.append(",");
		}
		obj.append("}");
		return obj.toString();
	}
	
//	public void read(LockObj obj)
//	{
//		if(this.TransactionState == "BLOCKED")
//		{
//			//add operation to waitlist
//			this.OperationList.add("R("+obj.ItemName+")");
//		}
//		else if(this.TransactionState == "ABORTED")
//		{
//			//Ignore Operation
//		}
//		else
//		{
//			obj.lock("RL", this);
//		}
//		
//	}
//	public void write(LockObj obj)
//	{
//		if(this.TransactionState == "BLOCKED")
//		{
//			//add operation to waitlist
//			this.OperationList.add("W("+obj.ItemName+")");
//		}
//		else if(this.TransactionState == "ABORTED")
//		{
//			//Ignore Operation
//		}
//		else
//		{
//			obj.lock("WL", this);
//		}
//	}
//	public void commited()
//	{
//		this.TransactionState = "COMMITTED";
////		//loop thorough all items in ItemLocked
////		Iterator it = this.ItemsLocked.iterator();
////		while(it.hasNext())
////		{
////			String str = (String)it.next();
////			str
////		}
//		
//	}
	
	
}
