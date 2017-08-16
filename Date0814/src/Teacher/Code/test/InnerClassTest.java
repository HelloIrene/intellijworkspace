package Teacher.Code.test;


import Teacher.Code.ui.DialogFrame;

public class InnerClassTest {
	public static void main(String[] args) {
		DialogFrame d = new DialogFrame();
		DialogFrame.MyClickHandler mc = d.new MyClickHandler();
		//mc...;
	}
}
