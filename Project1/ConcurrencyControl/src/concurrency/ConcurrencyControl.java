package concurrency;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import concurrency.*;

public class ConcurrencyControl {
	
	public static HashMap<Integer, Transaction> TransMap = new HashMap<Integer, Transaction>();    
	public static HashMap<Character, LockObj> LockMap = new HashMap<Character, LockObj>();
	// contain list of active transaction which were waiting to be executed
	public static ArrayList<Integer> ActiveTransaction = new ArrayList<Integer>();
	
	public static void operationAction(String readLine)
	{
		int transid,pos;
        char obj;
        Transaction t;
        LockObj lockobj;
		if(readLine.charAt(0) == 'b')
        {
        	transid = Integer.parseInt(String.valueOf(readLine.charAt(1)));
        	t = new Transaction(transid,"ACTIVE");
        	TransMap.put(transid, t);
        	System.out.println(readLine+ " - Operation is Successful => Transaction "+transid+" has started");
//        	System.out.println(t.toString());
        }
        else if(readLine.charAt(0) == 'r')
        {
        	transid = Integer.parseInt(String.valueOf(readLine.charAt(1)));
        	pos = readLine.indexOf("(");
        	obj = readLine.charAt(pos+1);
        	t = TransMap.get(transid);
        	
        	//Create new object or use existing object
        	if(LockMap.containsKey(obj))
        		lockobj = LockMap.get(obj);
    		else
    			lockobj = new LockObj(obj);
        	
        	//action based on transaction state
        	if(t.TransactionState.equalsIgnoreCase("BLOCKED"))
        	{
        		t.appendOperation(readLine); //"r"+t.TransId+"("+obj+")"
        		System.out.println(readLine+ " - Operation is Successful => Operation added to Operation list");
//        		System.out.println(t.toString());
        	}
        	else if(t.TransactionState.equalsIgnoreCase("ABORTED"))
        	{
        		//Ignore opeartion as transaction has been aborted
        		System.out.println(readLine+ " - Operation is Ignored");
        	}
        	else
        	{
        		if(lockobj.LockMode.equalsIgnoreCase("NL"))
        		{
        			lockobj.LockMode = "RL";
        			lockobj.addHoldTransaction(t.TransId);
        			t.addHoldObject(lockobj.ItemName);
        			LockMap.put(lockobj.ItemName, lockobj);
        			System.out.println(readLine+ " - Operation is successful => "+lockobj.ItemName+" is locked by "+t.TransId);
//        			System.out.println(t.toString());
//        			System.out.println(lockobj.toString());
        			
        		}
        		else if(lockobj.LockMode.equalsIgnoreCase("RL"))
        		{
        			lockobj.addHoldTransaction(t.TransId);
        			t.addHoldObject(lockobj.ItemName);
        			LockMap.put(lockobj.ItemName, lockobj);
        			System.out.println(readLine+ " - Operation is successful => "+lockobj.ItemName+" is locked by "+t.TransId);
//        			System.out.println(t.toString());
//        			System.out.println(lockobj.toString());
        		}
        		else
        		{
        			//Read an object which already WL by same transaction
        			if(lockobj.LockMode.equalsIgnoreCase("WL") && lockobj.LockedBy.contains(t.TransId) && (lockobj.LockedBy.size() == 1))
            		{
            			System.out.println(readLine+ " - Operation is Successful => Lock on "+lockobj.ItemName+" is already Write-Lock by "+t.TransId);
//            			System.out.println(t.toString());
//            			System.out.println(lockobj.toString());
            		}
        			else
        			{
        				int i = 0;
        				while(TransMap.get(lockobj.LockedBy.get(i)).TransId == t.TransId)
        				{
        					i++;
        				}
        				Transaction anotherTrans = TransMap.get(lockobj.LockedBy.get(i));
        				if(t.TimeStamp.before(anotherTrans.TimeStamp))
        				{
//        					t.appendWaitList(lockobj.ItemName);
        					lockobj.addWaitList(t.TransId);
        					t.appendOperation(readLine);
        					t.TransactionState = "BLOCKED";
        					LockMap.put(lockobj.ItemName, lockobj);
        					System.out.println(readLine+ " - Operation is Unsuccessful => Transaction "+t.TransId+" is Blocked");
//        					System.out.println(t.toString());
//                			System.out.println(lockobj.toString());
        				}
        				else
        				{
        					t.TransactionState = "ABORTED";
        					Iterator<Character> it = t.ItemsLocked.iterator();
                        	while(it.hasNext())
                        	{
                        		char name = it.next();
                        		lockobj = LockMap.get(name);
                        		if(lockobj.LockedBy.size() == 1)
                        		{
                        			lockobj.LockMode = "NL";
                        		}
                        		lockobj.LockedBy.remove(t.TransId);
                        		Iterator jt = lockobj.WaitList.iterator();
                        		while(jt.hasNext())
                        		{
                        			int j = ((Integer)jt.next()).intValue();
                        			if(!ActiveTransaction.contains(j))
                        				ActiveTransaction.add(j);
                        			
                        		}
                        		lockobj.WaitList.clear();
                        		LockMap.put(lockobj.ItemName, lockobj);
//                    			System.out.println(lockobj.toString());
                        	}
                        	t.ItemsLocked.clear();
                        	System.out.println(readLine+ " - Operation is Unsuccessful => Transaction "+t.TransId+" is Aborted");
//                    		System.out.println(t.toString());
                    		
                    		
        				}
        			}
        		}
        	}
        	TransMap.put(t.TransId, t);
        }
        else if(readLine.charAt(0) == 'w')
        {
        	transid = Integer.parseInt(String.valueOf(readLine.charAt(1)));
        	pos = readLine.indexOf("(");
        	obj = readLine.charAt(pos+1);
        	t = TransMap.get(transid);
        	
        	//Create new object or use existing object
        	if(LockMap.containsKey(obj))
        		lockobj = LockMap.get(obj);
    		else
    			lockobj = new LockObj(obj);
        	
        	//action based on transaction state
        	if(t.TransactionState.equalsIgnoreCase("BLOCKED"))
        	{
        		t.appendOperation(readLine);//"w"+t.TransId+"("+obj+")"
        		System.out.println(readLine+ " - Operation is Successful => Operation added to Operation list");
//        		System.out.println(t.toString());
        	}
        	else if(t.TransactionState.equalsIgnoreCase("ABORTED"))
        	{
        		//Ignore opeartion as transaction has been aborted
        		System.out.println(readLine+ " - Operation is Ignored");
        	}
        	else
        	{
        		if(lockobj.LockedBy.contains(t.TransId) && (lockobj.LockedBy.size() == 1))
        		{
        			lockobj.LockMode = "WL";
        			LockMap.put(lockobj.ItemName, lockobj);
        			System.out.println(readLine+ " - Operation is Successful => Lock on "+lockobj.ItemName+" by "+t.TransId+" upgraded to Write-Lock");
//        			System.out.println(t.toString());
//        			System.out.println(lockobj.toString());
        		}
        		else if(lockobj.LockMode.equalsIgnoreCase("NL"))
        		{
        			lockobj.LockMode = "RL";
        			lockobj.addHoldTransaction(t.TransId);
        			t.addHoldObject(lockobj.ItemName);
        			LockMap.put(lockobj.ItemName, lockobj);
        			System.out.println(readLine+ " - Operation is successful => "+lockobj.ItemName+" is locked by "+t.TransId);
//        			System.out.println(t.toString());
//        			System.out.println(lockobj.toString());
        		}
        		else
        		{
        			int i = 0;
    				while(TransMap.get(lockobj.LockedBy.get(i)).TransId == t.TransId)
    				{
    					i++;
    				}
    				Transaction anotherTrans = TransMap.get(lockobj.LockedBy.get(i));
    				if(t.TimeStamp.before(anotherTrans.TimeStamp))
    				{
//    					t.appendWaitList(lockobj.ItemName);
    					lockobj.addWaitList(t.TransId);
    					t.appendOperation(readLine);
    					t.TransactionState = "BLOCKED";
    					LockMap.put(lockobj.ItemName, lockobj);
    					System.out.println(readLine+ " - Operation is Unsuccessful => Transaction "+t.TransId+" is Blocked");
//    					System.out.println(t.toString());
//            			System.out.println(lockobj.toString());
    				}
    				else
    				{
    					t.TransactionState = "ABORTED";
    					Iterator<Character> it = t.ItemsLocked.iterator();
                    	while(it.hasNext())
                    	{
                    		char name = it.next();
                    		lockobj = LockMap.get(name);
                    		if(lockobj.LockedBy.size() == 1)
                    		{
                    			lockobj.LockMode = "NL";
                    		}
                    		lockobj.LockedBy.remove(t.TransId);
                    		Iterator jt = lockobj.WaitList.iterator();
                    		while(jt.hasNext())
                    		{
                    			int j = ((Integer)jt.next()).intValue();
                    			if(!ActiveTransaction.contains(j))
                    				ActiveTransaction.add(j);
                    			
                    		}
                    		lockobj.WaitList.clear();
                    		LockMap.put(lockobj.ItemName, lockobj);
//                    		System.out.println(lockobj.toString());
                    	}
                    	t.ItemsLocked.clear();
                    	System.out.println(readLine+ " - Operation is Unsuccessful => Transaction "+t.TransId+" is Aborted");
//                    	System.out.println(t.toString());
    				}
        		}
        	}
        	TransMap.put(t.TransId, t);
        }
        else if(readLine.charAt(0) == 'e')
        {
        	transid = Integer.parseInt(String.valueOf(readLine.charAt(1)));
        	t = TransMap.get(transid);
        	if(t.TransactionState.equalsIgnoreCase("BLOCKED"))
        	{
        		t.appendOperation(readLine);
        		System.out.println(readLine+ " - Operation is Successful => Operation added to Operation list");
//        		System.out.println(t.toString());
        	}
        	else if(t.TransactionState.equalsIgnoreCase("ABORTED"))
        	{
        		//Ignore opeartion as transaction has been aborted
        		System.out.println(readLine+ " - Operation is Ignored");
        	}
        	else
        	{
        		t.TransactionState = "COMMITTED";
            	Iterator<Character> it = t.ItemsLocked.iterator();
            	StringBuffer sb = new StringBuffer();
            	while(it.hasNext())
            	{
            		char name = it.next();
            		lockobj = LockMap.get(name);
            		if(lockobj.LockedBy.size() == 1)
            		{
            			lockobj.LockMode = "NL";
            		}
//            		System.out.println("ID:"+t.TransId);
            		lockobj.LockedBy.remove(t.TransId);
            		Iterator jt = lockobj.WaitList.iterator();
            		while(jt.hasNext())
            		{
            			int j = ((Integer)jt.next()).intValue();
            			if(!ActiveTransaction.contains(j))
            				ActiveTransaction.add(j);
            			
            		}
            		lockobj.WaitList.clear();
            		LockMap.put(lockobj.ItemName, lockobj);
//            		System.out.println(lockobj.toString());
            	}
            	t.ItemsLocked.clear();
            	TransMap.put(t.TransId, t);
        		System.out.println(readLine+ " - Operation is Successful => Transaction "+transid+" has Committed");
//        		System.out.println(t.toString());
        	}
        	
        }
        else
        {
        	System.out.println("Invalid Operation");
        }
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
//			System.out.println(args[0]);
            File f = new File(args[0]);
            BufferedReader b = new BufferedReader(new FileReader(f));
            String readLine = "";
            Transaction trans;
            while ((readLine = b.readLine()) != null) {
            	
            	
            	//Call operationAction from Input file
            	operationAction(readLine);
            	
            	//Call operationAction from awaken transaction
            	int k = 0;
            	int transid;
            	ArrayList<Integer> arlst = (ArrayList<Integer>) ActiveTransaction.clone();
            	while(arlst.size()!=0){
            		System.out.println("Inside ActiveTransaction List");
            		transid = arlst.get(k);
            		trans = TransMap.get(transid);
            		trans.TransactionState = "ACTIVE";
            		TransMap.put(transid, trans);
            		Iterator it = trans.OperationList.iterator();
            		while(it.hasNext())
            		{
            			operationAction((String) it.next());
            		}
            		trans.OperationList.clear();
            		arlst.remove(k);
            		k++;
            		TransMap.put(transid, trans);
            	}
            	ActiveTransaction.clear();
            	               	
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

		
	}

}
