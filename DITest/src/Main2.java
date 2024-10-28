public class Main2 {
  public static void main(String[] args) {
    Post post = new NewPost();
    PrintPost ps = new NewPrint(post);
    ps.printPost();
    ps.printPost();
    ps.printPost();
    ps.printPost();
  }
}

interface Post {
  String getAllPosts();
}

class NewPost implements Post {

  @Override
  public String getAllPosts() {
    return "post data";
  }
}

interface PrintPost {
  void printPost();
}

class NewPrint implements PrintPost {
  // 스프링에서는 생성자 주입을 쓰는게 더 좋음
  private final Post post;
  public NewPrint(Post post) {
    this.post = post;
  }

  // final일 때는 setter 사용할 수 없음 = 불변객체니까
//  public void setPost(Post post) {
//    this.post = post;
//  }

  @Override
  public void printPost() {
    System.out.println(post.getAllPosts());
  }
}

class NoPrintLn implements PrintPost {
  private Post post;
  public NoPrintLn(Post post) {
    this.post = post;
  }
  @Override
  public void printPost() {
    System.out.print(post.getAllPosts());
  }
}
