import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
public class CalcFrame extends JFrame{
    private static final long serialVersionUID = 1L;
    private JTextField showView = null;
    private NumberBtnActionListener numberBtnActionListener;
    private LogicBtnActionListener logicBtnActionListener;
    private String logic;//记录运算符的字符串
    private String content1 = "";//记录第一个数字的字符串
    private String content2 = "";//记录第二个数字的字符串
    public CalcFrame() {
        //窗口标题
        //思考: 调用方法时没有对象来调用  怎么回事??
        setTitle("计算器");
        //窗口位置和大小
        //需要注意的是  这个坐标是相对于桌面  在桌面的哪个位置出现
        setBounds(300,150,230, 320);
        //设置窗口右上角 关闭按钮的事件
        //点击时关闭
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //不能改变大小
        setResizable(false);

        //设置窗口布局为null  不设置窗口布局
        setLayout(null);

        addView();


        addButton();
        //对象创建完成时,显示窗口
        setVisible(true);
    }

    private void addButton() {
        numberBtnActionListener = new NumberBtnActionListener();
        logicBtnActionListener = new LogicBtnActionListener();
        JButton button_7 = new JButton("7");
        button_7.setBounds(5,65,40,40);
        //设置按钮边框为 浅灰色 厚度为1
        button_7.setBorder(new LineBorder(Color.lightGray,1));
        button_7.addActionListener(numberBtnActionListener);
        add(button_7);

        JButton button_8 = new JButton("8");
        button_8.setBounds(60,65,40,40);
        button_8.setBorder(new LineBorder(Color.lightGray,1));
        button_8.addActionListener(numberBtnActionListener);
        add(button_8);

        JButton button_9 = new JButton("9");
        button_9.setBounds(115,65,40,40);
        button_9.setBorder(new LineBorder(Color.lightGray,1));
        button_9.addActionListener(numberBtnActionListener);
        add(button_9);

        JButton button_add = new JButton("+");
        button_add.setBounds(170,65,40,40);
        button_add.setBorder(new LineBorder(Color.lightGray,1));
        button_add.addActionListener(logicBtnActionListener);
        add(button_add);

        JButton button_4 = new JButton("4");
        button_4.setBounds(5,120,40,40);
        //设置按钮边框为 浅灰色 厚度为1
        button_4.setBorder(new LineBorder(Color.lightGray,1));
        button_4.addActionListener(numberBtnActionListener);
        add(button_4);

        JButton button_5 = new JButton("5");
        button_5.setBounds(60,120,40,40);
        button_5.setBorder(new LineBorder(Color.lightGray,1));
        button_5.addActionListener(numberBtnActionListener);
        add(button_5);

        JButton button_6 = new JButton("6");
        button_6.setBounds(115,120,40,40);
        button_6.setBorder(new LineBorder(Color.lightGray,1));
        button_6.addActionListener(numberBtnActionListener);
        add(button_6);

        JButton button_sub = new JButton("-");
        button_sub.setBounds(170,120,40,40);
        button_sub.setBorder(new LineBorder(Color.lightGray,1));
        button_sub.addActionListener(logicBtnActionListener);
        add(button_sub);


        JButton button_1 = new JButton("1");
        button_1.setBounds(5,175,40,40);
        //设置按钮边框为 浅灰色 厚度为1
        button_1.setBorder(new LineBorder(Color.lightGray,1));
        button_1.addActionListener(numberBtnActionListener);
        add(button_1);

        JButton button_2 = new JButton("2");
        button_2.setBounds(60,175,40,40);
        button_2.setBorder(new LineBorder(Color.lightGray,1));
        button_2.addActionListener(numberBtnActionListener);
        add(button_2);

        JButton button_3 = new JButton("3");
        button_3.setBounds(115,175,40,40);
        button_3.setBorder(new LineBorder(Color.lightGray,1));
        button_3.addActionListener(numberBtnActionListener);
        add(button_3);

        JButton button_mul = new JButton("*");
        button_mul.setBounds(170,175,40,40);
        button_mul.setBorder(new LineBorder(Color.lightGray,1));
        button_mul.addActionListener(logicBtnActionListener);
        add(button_mul);


        JButton button_0 = new JButton("0");
        button_0.setBounds(5,230,40,40);
        //设置按钮边框为 浅灰色 厚度为1
        button_0.setBorder(new LineBorder(Color.lightGray,1));
        button_0.addActionListener(numberBtnActionListener);
        add(button_0);

        JButton button_eq = new JButton("=");
        button_eq.setBounds(60,230,40,40);
        button_eq.setBorder(new LineBorder(Color.lightGray,1));
        button_eq.addActionListener(new EqBtnActionListener());
        add(button_eq);

        JButton button_c = new JButton("c");
        button_c.setBounds(115,230,40,40);
        button_c.setBorder(new LineBorder(Color.lightGray,1));
        button_c.addActionListener(new CleanBtnActionListener());
        add(button_c);

        JButton button_div = new JButton("/");
        button_div.setBounds(170,230,40,40);
        button_div.setBorder(new LineBorder(Color.lightGray,1));
        button_div.addActionListener(logicBtnActionListener);
        add(button_div);
    }

    private void addView() {
        //先添加显示框  只读编辑框  默认显示0  所以直接在构造器中 传入0  注意 传入的是字符串才能显示
        //这里使用成员变量的原因是:在按钮的事件监听器中需要使用显示框变量,所有使用成员变量来保存这个显示框,其他方法才能访问
        showView = new JTextField("0");
        //需要注意,这里的坐标是相对于窗口内部,而不再是桌面。
        showView.setBounds(5, 5, 205, 55);
        showView.setHorizontalAlignment(JTextField.RIGHT);
        //设置是否可编辑  设置只读
        showView.setEditable(false);
        //设置背景色
        showView.setBackground(new Color(192, 192, 192));
        //设置字体 粗细 大小
        showView.setFont(new Font("Cambria", Font.BOLD, 16));
        add(showView);
    }
    public static void main(String[] args) {
        new CalcFrame();
    }

    class NumberBtnActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {

            //2.获取按钮内容
            JButton btn = (JButton)e.getSource();
            String btn_text = btn.getText();
            if (logic!=null&&!"".equals(logic)) {
                //3.拼接字符串
                content2=content2+btn_text;
                //4.转换为数字
                int number = Integer.valueOf(content2);
                //5.设置到显示框
                showView.setText(number+"");
            }else {
                //3.拼接字符串
                content1=content1+btn_text;
                //4.转换为数字
                int number = Integer.valueOf(content1);
                //设置到显示框
                showView.setText(number+"");
            }
        }

    }


    class CleanBtnActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            //设置显示框内容为空
            showView.setText("0");
            //清空操作
            content1 = "";
            content2 = "";
            logic = "";
        }

    }


    class LogicBtnActionListener implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            //获取运算符内容
            JButton btn = (JButton)e.getSource();
            String logic = btn.getText();
            //保存到成员变量中  因为成员变量与这个局部变量名字相同,且this代表的是当前监听器对象,所有使用CalcFrame中this
            CalcFrame.this.logic = logic;
        }

    }

    class EqBtnActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            if (content1!=null&&!"".equals(content1)&&content2!=null&&!"".equals(content2)&&logic!=null&&!"".equals(logic)) {
                //将数字字符串1转换为数字
                Integer number1 = Integer.valueOf(content1);
                //将数字字符串2转换为数字
                Integer number2 = Integer.valueOf(content2);
                //3.判断运算符
                String content = "";
                switch (logic) {
                    case "+":
                        content = (number1+number2)+"";
                        break;
                    case "-":
                        content = (number1-number2)+"";
                        break;
                    case "*":
                        content = (number1*number2)+"";
                        break;
                    case "/":
                        content = (new Double(number1)/new Double(number2))+"";
                        break;
                    default:
                        break;
                }
                //4.显示框显示最终结果
                showView.setText(content);
                //5.清空操作
                content1 = "";
                content2 = "";
                logic = "";
            }
        }

    }
}
