package _3_ex;

public class _4_assert {
  public static void main(String[] args) {
    
    //when to use ?
    //  avoid log_err when debug

    //how to use and print msg when err ?
    
    //assert bool_expr ( : detail_msg )
    assert 1 + 1 == 0 : "HaHa";
    assert true;

    /**
     * Eclipse中开启断言(Assert),方法有二:
     * 
     * 1.Run -> Run Configurations -> Arguments页签 -> VM arguments
     *   文本框中加上断言开启的标志:-enableassertions 或者-ea 就可以了
     * 2.在myEclipse中,Windows -> Preferences ->Java ->Installed JREs ->
     *   点击正使用的JDK ->Edit ->Default VM Arguments文本框中输入:-ea
     */
  }
}
