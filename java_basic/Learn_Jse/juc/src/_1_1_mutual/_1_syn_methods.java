package _1_1_mutual;
//solve 1: synchronized_methods

//where to use ?
//  to make: thread-safe cls
//  add to the ADT cls which is not thread-safe (not the thread !)
public class _1_syn_methods extends _0_problem {
    @Override
    public synchronized void inc() {
        super.inc();
    }

    @Override
    public synchronized void dec() {
        super.dec();
    }

    // what's locked ?
    //      this obj's (all non-static syn_method

    // if op are static, what's locked?
    //      cls  (all syn_method (all objs)
    //      note: static & non-static not share lock.

    //how to synchronize static with non-static ?
    //  use syn block / lock
    //  all synchronized on cls, not on obj;

    public static void main(String[] args) {
        _1_syn_methods a = new _1_syn_methods();
        a.method();
        //result: 0 (success)
  }
}
