public class Main {
  public static void main(String[] args) {
    // has a 관계 -> 컴퓨터 -> 마우스 -> 버튼
    Button button = new Button(2);

    // 생성자 주입
    Mouse mouse = new Mouse(button);
    // setter 주입
    //    mouse.setButton(button);

    Computer computer = new Computer();
    computer.setMouse(mouse);
    System.out.println(computer); // 출력: Computer{ mouse=Mouse{ button=Button{ b=2}}}

  }
}

class Button {
  private int b;

  Button(){}

  Button(int b) {
    this.b = b;
  }

  public void setB(int b) {
    this.b = b;
  }

  @Override
  public String toString() {
    return "Button{ b=" + b + '}';
  }
}

class Mouse {
  private Button button;

  public Mouse() {}

  public Mouse(Button button) {
    this.button = button;
  }

  public void setButton(Button button) {
    this.button = button;
  }

  @Override
  public String toString() {
    return "Mouse{ button=" + button + '}';
  }
}

class Computer {
  private Mouse mouse;

  public Computer() {}

  public Computer(Mouse mouse) {
    this.mouse = mouse;
  }

  public void setMouse(Mouse mouse) {
    this.mouse = mouse;
  }

  @Override
  public String toString() {
    return "Computer{ mouse=" + mouse + '}';
  }
}
