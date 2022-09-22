package _1_1_mutual;

//solve 2: synchronized_blocks
public class _2_syn_block extends _0_problem {

  //what should pass to synchronized() ?
  //    non-static:
  //      obj's ref (this / other obj[not used])
  //
  //    static:
  //      cls / other obj[not used]
  //          _2_syn_block.class (XX is cls name)
  //          getClass()

  @Override
  public void inc() {
    synchronized(this) {
      super.inc();
    }
  }

  @Override
  public void dec() {
    synchronized(this) {
      super.dec();
    }
  }

  //what's locked ?
  //non-static: obj's all syn_block, should pass same obj (here is "this")

  //what's benefit VS sync-method  ?
  //    inc concurrency by dec critical section's field

  public static void main(String[] args) {
    new _2_syn_block().method();
  }

}
