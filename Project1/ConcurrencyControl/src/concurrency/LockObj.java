package concurrency;

import java.util.ArrayList;
import java.util.Iterator;

import concurrency.Transaction;

public class LockObj {
	char ItemName;
	String LockMode;
//	public enum Mode{
//		RL,WL,NL
//	}
//	Mode LockNode;
	ArrayList<Integer> LockedBy;
	ArrayList<Integer> WaitList;
	
	public LockObj(char ItemName)
	{
		this.ItemName = ItemName;
		this.LockMode = "NL";
		this.LockedBy = new ArrayList<Integer>();
		this.WaitList = new ArrayList<Integer>();
	}
	

	public void addHoldTransaction(Integer transId) {
		// TODO Auto-generated method stub
		this.LockedBy.add(transId);
		
	}

	public void addWaitList(Integer transId) {
		// TODO Auto-generated method stub
		this.WaitList.add(transId);
	}
	
	public String toString()
	{
		StringBuffer obj = new StringBuffer();
		obj.append("{");
		obj.append("ItemName:"+this.ItemName);
		obj.append("LockMode:"+this.LockMode);
		obj.append("LockedBy:");
		Iterator it = this.LockedBy.iterator();
		while(it.hasNext())
		{
			obj.append(it.next());
			obj.append(",");
		}
		obj.append("WaitList:");
		Iterator jt = this.WaitList.iterator();
		while(jt.hasNext())
		{
			obj.append(jt.next());
			obj.append(",");
		}
		obj.append("}");
		return obj.toString();
	}
	
//	public void lock(String LockMode, Transaction Trans)
//	{
//		if(LockMode.equalsIgnoreCase("RL"))
//		{
//			if((!this.LockMode.equalsIgnoreCase("WL")) && (this.LockMode.equalsIgnoreCase("NL") || this.LockMode.equalsIgnoreCase("RL")))
//			{
//				this.LockMode = LockMode;
//				this.LockedBy.add(Trans.TransId);
//			}
//			else if(this.LockMode.equalsIgnoreCase("WL") && ((this.LockedBy.size() == 1) && (this.LockedBy.contains(Trans.TransId))))
//			{
//				//Already hold WL lock, Not action to perform
//			}
//			else
//			{
//				//
//				Iterator it = this.LockedBy.iterator();
//				while(it.hasNext())
//				{
//					Transaction tid = it.next();
//					
//					
//				}
//			}
//		}
//		else if(LockMode.equalsIgnoreCase("WL"))
//		{
//			if((!this.LockMode.equalsIgnoreCase("RL")) && (!this.LockMode.equalsIgnoreCase("WL")) && (this.LockMode.equalsIgnoreCase("NL")))
//			{
//				this.LockMode = LockMode;
//				this.LockedBy.add(Trans.TransId);
//			}
//			else if(this.LockMode.equalsIgnoreCase("RL") && ((this.LockedBy.size() == 1) && (this.LockedBy.contains(Trans.TransId))))
//			{
//				//Upgrade Lock from Read to Write
//				this.LockMode = LockMode;
//			}
//			else
//			{
//				//
//			}
//		}
//		else
//		{
//			//Invalid lock
//		}
//	}
//	
//	public void unlock(Transaction Trans)
//	{
//		this.LockMode = "NL";
//		this.LockedBy.remove(Trans.TransId);
//	}
	
}
