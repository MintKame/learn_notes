package _7_io._1_file;
import java.io.File;
import java.io.IOException;

public class _1_file {
  public static void main(String[] args) throws IOException {
//what is File cls ? 
//  wrapper cls for file / dir name(a string)
    
//what can do using the cls ?
//  get msg(not content), op(what ?)
    
//what can be use to show path ? 
//  use \\ or /

//how to create cls File (2-ways) ?
    java.io.File d1 = new File("src/../src/_7_io/test"); //relative(to project) path (recommand) 
    File f1 = new File("src/_7_io/test", "1_a.text");  //use dir & file name  
    File f2 = new File(d1, "1_b.text");
    File f3 = new File("src/_7_io/test/1_c.text");
    //(n't create f/d )
    
//1.obtain properties of dir / file   
    //ret: bool
    System.out.println("f1 exists:\t" + f1.exists());
    System.out.println("  canRead:\t" + f1.canRead());   //canWrite/Execute
    System.out.println("  isAbsolute:\t" + f1.isAbsolute());
    System.out.println("  isHidden:\t" + f1.isHidden());  //unix: begin(.)
    System.out.println("  isFile:\t" + f1.isFile());
    //some msg
    System.out.println("d1 abs:\t\t" + d1.getAbsolutePath());
    System.out.println("   abs:\t\t" + d1.getCanonicalPath() + "\t(noRedundant)");
    System.out.println("   lastMod:\t" + new java.util.Date(d1.lastModified()));
    System.out.println("   length:\t" + d1.length());
    System.out.println("   listFile:\t" + java.util.Arrays.toString(d1.listFiles()));
    
//2.delete, rename dir / file
    //    f3.delete();
    System.out.println("f3 exists:\t" + f3.exists());
    //    f2.renameTo(new File(d1,"newName"));
    System.out.println("f2 exists:\t" + f2.exists());    
    
//3.create:
    //  Creates dir
    File dir1 = new File("bbb\\newDir");
    if (!dir1.exists()) {
      if (dir1.mkdirs()) {      // 创建多级dir  (include nonexistent parent dir
//      file1.mkdir();        // 创建一级dir
        System.out.println("bbb\\newDir 成功");
      }
    }
    //  Creates file
    File file1 = new File(dir1, "fff");
    if (!file1.exists()){
      if (file1.createNewFile()) {
        System.out.println("fff 成功");
      }
    }
  }
}
