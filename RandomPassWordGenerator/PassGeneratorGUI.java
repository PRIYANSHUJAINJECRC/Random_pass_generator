import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PassGeneratorGUI extends JFrame {
    private passwrodgenerstorLogic generator;

    public PassGeneratorGUI(){
        super("PassWordGenerator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        generator=new passwrodgenerstorLogic();
        setSize(540,570);
        setLocationRelativeTo(null);
        addcomponent();
    }
    private void addcomponent(){
        JLabel password=new JLabel("Password Generator");
        password.setFont(new Font("Dialog",Font.BOLD,35));
        password.setBounds(0,10,540,39);
        password.setHorizontalAlignment(SwingConstants.CENTER);
        add(password);


        JTextArea output=new JTextArea();
        output.setEditable(false);
        output.setFont(new Font("Dialog",Font.BOLD,35));

        JScrollPane outputScroll=new JScrollPane(output);
        outputScroll.setBounds(25,97,479,70);
        outputScroll.setBorder(BorderFactory.createLineBorder(Color.BLACK ));
        add(outputScroll);
        JLabel passwordLength=new JLabel("Password Length:");
        passwordLength.setFont(new Font("Dailog",Font.PLAIN,32));
        passwordLength.setBounds(25,215,272,39);
        add(passwordLength);

        JTextArea length=new JTextArea();
        length.setEditable(true);
        length.setFont(new Font("Dialog",Font.PLAIN,30));
        length.setBounds(300,215,200,39);
        length.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(length);

        JCheckBox upper=new JCheckBox("Upper");
        upper.setFont(new Font("Dailog",Font.PLAIN,25));
        upper.setBounds(20,290,240,79);
        add(upper);
        JCheckBox lower=new JCheckBox("Lower");
        lower.setFont(new Font("Dailog",Font.PLAIN,25));
        lower.setBounds(265,290,240,79);
        add(lower);
        JCheckBox Symbol=new JCheckBox("Symbols");
        Symbol.setFont(new Font("Dailog",Font.PLAIN,25));
        Symbol.setBounds(265,390,240,79);
        add(Symbol);
        JCheckBox numbers=new JCheckBox("numbers");
        numbers.setFont(new Font("Dailog",Font.PLAIN,25));
        numbers.setBounds(20,390,240,79);
        add(numbers);

        JButton generate=new JButton("Generate");
        generate.setFont(new Font("Dailog",Font.PLAIN,25));
        generate.setBounds(150,472,240,50);
        generate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(length.getText().length()<=0){
                    return;
                }
                boolean toggle=upper.isSelected()||lower.isSelected()||Symbol.isSelected()||numbers.isSelected();
                int passwordlength=Integer.parseInt(length.getText());
                if(toggle){
                    String ans=generator.generatepass(passwordlength,lower.isSelected(),upper.isSelected(),numbers.isSelected(),Symbol.isSelected());
                    output.setText(ans);
                }
            }
        });
        add(generate);


    }
}
