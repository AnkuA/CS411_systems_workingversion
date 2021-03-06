package simpledb.tx.recovery;

// AA: Added this whole file

import simpledb.server.SimpleDB;
import simpledb.buffer.*;
import simpledb.file.Block;
import simpledb.log.BasicLogRecord;

class SetFloatRecord implements LogRecord {
   private int txnum, offset;
   private float val;
   private Block blk;

   /**
    * AA: Added this
    * Creates a new setint log record.
    * @param txnum the ID of the specified transaction
    * @param blk the block containing the value
    * @param offset the offset of the value in the block
    * @param val the new value
    */
   public SetFloatRecord(int txnum, Block blk, int offset, float val) {
      this.txnum = txnum;
      this.blk = blk;
      this.offset = offset;
      this.val = val;
   }

   /**
    * Creates a log record by reading five other values from the log.
    * @param rec the basic log record
    */
   public SetFloatRecord(BasicLogRecord rec) {
      txnum = rec.nextInt();
      String filename = rec.nextString();
      int blknum = rec.nextInt();
      blk = new Block(filename, blknum);
      offset = rec.nextInt();
      val = rec.nextFloat();
   }

   /**
    * Writes a setFloat record to the log.
    * This log record contains the SETFLOAT operator,
    * followed by the transaction id, the filename, number,
    * and offset of the modified block, and the previous
    * integer value at that offset.
    * @return the LSN of the last log value
    */
   public int writeToLog() {
      Object[] rec = new Object[] {SETFLOAT, txnum, blk.fileName(),
         blk.number(), offset, val};
      return logMgr.append(rec);
   }

   public int op() {
      return SETFLOAT;
   }

   public int txNumber() {
      return txnum;
   }

   public String toString() {
      return "<SETFLOAT " + txnum + " " + blk + " " + offset + " " + val + ">";
   }

   /**
    * Replaces the specified data value with the value saved in the log record.
    * The method pins a buffer to the specified block,
    * calls setInt to restore the saved value
    * (using a dummy LSN), and unpins the buffer.
    * @see simpledb.tx.recovery.LogRecord#undo(float)
    */
   public void undo(int txnum) {
      BufferMgr buffMgr = SimpleDB.bufferMgr();
      Buffer buff = buffMgr.pin(blk);
      buff.setFloat(offset, val, txnum, -1);
      buffMgr.unpin(buff);
   }
}
