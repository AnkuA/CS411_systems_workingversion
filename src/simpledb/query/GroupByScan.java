package simpledb.query;

import java.util.Collection;
import java.util.HashMap;
import java.util.ArrayList;
import simpledb.record.RID;
import simpledb.record.RecordFile;

public class GroupByScan implements Scan {
    private Scan s;
    private Collection<String> group;
    private ArrayList<RecordFile> rfs;
    private HashMap<ArrayList<Constant>, ArrayList<ArrayList<RID>>> ht;
    private ArrayList<ArrayList<Constant>> rKey;
    private ArrayList<Constant> hold;
    private int rIn;
    private int rK;

    public GroupByScan(Scan s, Collection<String> group, int numtbls) {
        this.s = s;
        this.group = group;

        if(group != null){
        this.rfs = new ArrayList<RecordFile>();
        this.ht = new HashMap<ArrayList<Constant>, ArrayList<ArrayList<RID>>>();
        if(numtbls == 1){
            SelectScan tempS = (SelectScan) s;
            rfs.add(tempS.getRecordFile());
            RecordFile tempR1 =null;
            ArrayList<Constant> key =null;
            ArrayList<RID> value = new ArrayList<RID>();
            value.add(tempS.getRid());
            int n = 0;
            while(tempS.next()){
                if(value == null)
                    value = new ArrayList<RID>();
                tempR1 = tempS.getRecordFile();
                if(!rfs.contains(tempR1)){
                    rfs.add(tempR1);
                }
                n = rfs.indexOf(tempR1);
                if(value.size() <=n){
                    value.add(n, tempS.getRid());
                }else{
                    value.set(n, tempS.getRid());
                }
                if(n == numtbls-1){
                    key = new ArrayList<Constant>();

                    for(String fields:group){
                        key.add(tempS.getVal(fields));
                    }
                    if(this.ht.containsKey(key)){
                        ht.get(key).add(value);
                    }else{
                        ArrayList<ArrayList<RID>> omg = new ArrayList<ArrayList<RID>>();
                        omg.add(value);
                        this.ht.put(key, omg);
                    }
                    value = null;
                    key = null;
                }
                tempR1 = null;
            }
        }else{
            SelectScan tempS = (SelectScan)s;
            //get the first Record file
            rfs = tempS.getRecordFileL();
            ArrayList<Constant> key =null;
            ArrayList<RID> value = new ArrayList<RID>();
                while(tempS.next()){
                    value = tempS.getRidL();
                    key = new ArrayList<Constant>();
                    for(String fields:group)
                            key.add(tempS.getVal(fields));
                    if(this.ht.containsKey(key)){
                        ht.get(key).add(value);
                    }else{
                        ArrayList<ArrayList<RID>> omg = new ArrayList<ArrayList<RID>>();
                        omg.add(value);
                        this.ht.put(key, omg);
                    }
                }
            }
        }
        beforeFirst();
    }

    public HashMap<ArrayList<Constant>, ArrayList<ArrayList<RID>>> getHash(){
        return this.ht;
    }
    public ArrayList<RecordFile>  getRFS(){
        return this.rfs;
    }
    public ArrayList<ArrayList<Constant>> getKL(){
        return this.rKey;
    }
    public int getGroup(String field){
        return ((ArrayList<String>)this.group).indexOf(field);
    }
    public void beforeFirst() {
        if(group != null){
        rKey = new ArrayList<ArrayList<Constant>>();

        rKey.addAll(ht.keySet());
        rIn = 0;
        rK = 0;
        for(RecordFile r: rfs){
            r.beforeFirst();
        }
        }
        s.beforeFirst();
    }
    public ArrayList<Constant> getKey(){
        return hold;
    }
    public boolean next() {
        if(group != null){
            if(rK == rKey.size()){
                return false;
            }
            hold =  rKey.get(rK);
            ArrayList<RID> tempRID = ht.get(hold).get(rIn);
            for(int i=0; i< tempRID.size(); i++){
                rfs.get(i).moveToRid(tempRID.get(i));
            }
            if(rIn == ht.get(hold).size()-1){
                rIn=0;
                rK+=1;
            }else{
                rIn+=1;
            }
            return true;
        }else{
            return s.next();
        }
    }

    public void close() {
        s.close();
    }

    public boolean hasGroup() {
        return group != null;
    }

    public Constant getVal(String fldname) {
        return s.getVal(fldname);
    }

    public int getInt(String fldname) {
         return s.getInt(fldname);
    }

    public String getString(String fldname) {
        return s.getString(fldname);
    }

    public boolean hasField(String fldname) {
        return s.hasField(fldname);
    }

}