package sql.demo;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ZView extends JFrame{

    private JButton BPrint = new JButton("Напечатать таблицу");
    private JButton BAdd = new JButton("Добавить элемент");
   // private JButton BGet = new JButton("Получить элемент");
    private JButton BEdit = new JButton("Изменить");

    public JTextField TFGeneralID  = new JTextField(25);

    public JTextField TFGunCaliber  = new JTextField(25);
    public JTextField TFGunLenth  = new JTextField(25);
    public JTextField TFGunType  = new JTextField(25);

    public JTextField TFBodyArmor  = new JTextField(25);
    public JTextField TFBodyWeight  = new JTextField(25);
    public JTextField TFBodyPersons  = new JTextField(25);

    public JTextField TFTowerArmor  = new JTextField(25);
    public JTextField TFTowerSpeed  = new JTextField(25);
    public JTextField TFTowerCount  = new JTextField(25);

    public JTextField TFTankName  = new JTextField(25);
    public JTextField TFTankCountry  = new JTextField(25);
    public JTextField TFTankYearOfProduction  = new JTextField(25);

    private JLabel LGeneralID  = new JLabel("Глобальный ID", JLabel.CENTER);

    //Gun
    private JLabel LGCName  = new JLabel("Калибр орудия", JLabel.CENTER);
    private JLabel LGLName  = new JLabel("Длина орудия", JLabel.CENTER);
    private JLabel LGTName  = new JLabel("Тип снаряда", JLabel.CENTER);
    //Body
    private JLabel LBAName  = new JLabel("Броня корпуса", JLabel.CENTER);
    private JLabel LBWName  = new JLabel("Масса танка", JLabel.CENTER);
    private JLabel LBPName  = new JLabel("Количество человек", JLabel.CENTER);
    //TOWER
    private JLabel LTAName  = new JLabel("Броня башни", JLabel.CENTER);
    private JLabel LTSName  = new JLabel("Скорость поворота", JLabel.CENTER);
    private JLabel LTCName  = new JLabel("Количество пулеметов", JLabel.CENTER);
    //TANK
    private JLabel LTNName  = new JLabel("Название", JLabel.CENTER);
    private JLabel LTCountryName  = new JLabel("Страна", JLabel.CENTER);
    private JLabel LTYofCName  = new JLabel("Год производства", JLabel.CENTER);


    public ZView() {
        JPanel ZavodPanel = new JPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1100, 700);
        this.setResizable(false);
        ZavodPanel.setLayout(null);

        LGeneralID.setBounds(100, 280, 120, 20);
        ZavodPanel.add(LGeneralID);

        TFGeneralID.setBounds(100, 300, 120, 20);
        TFGeneralID.setText("GeneralID");
        TFGeneralID.setFocusable(true);
        ZavodPanel.add(TFGeneralID);

//GUN Labels
        { LGCName.setBounds(100, 330, 120, 20);
            ZavodPanel.add(LGCName);
            LGLName.setBounds(100, 380, 120, 20);
            ZavodPanel.add(LGLName);
            LGTName.setBounds(100, 430, 120, 20);
            ZavodPanel.add(LGTName);}
//Body Labels
        {LBAName.setBounds(230, 330, 120, 20);
            ZavodPanel.add(LBAName);
            LBWName.setBounds(230, 380, 120, 20);
            ZavodPanel.add(LBWName);
            LBPName.setBounds(230, 430, 120, 20);
            ZavodPanel.add(LBPName);}
//Tower labels
        {LTAName.setBounds(360, 330, 120, 20);
            ZavodPanel.add(LTAName);
            LTSName.setBounds(360, 380, 120, 20);
            ZavodPanel.add(LTSName);
            LTCName.setBounds(360, 430, 120, 20);
            ZavodPanel.add(LTCName);}
// Tank labels
        {LTNName.setBounds(490, 330, 120, 20);
        ZavodPanel.add(LTNName);
        LTCountryName.setBounds(490, 380, 120, 20);
        ZavodPanel.add(LTCountryName);
        LTYofCName.setBounds(490, 430, 120, 20);
        ZavodPanel.add(LTYofCName);}

//GUN TextField
        {TFGunCaliber.setBounds(100, 350, 120, 20);
            TFGunCaliber.setText("180");
            TFGunCaliber.setFocusable(true);
            ZavodPanel.add(TFGunCaliber);

            TFGunLenth.setBounds(100, 400, 120, 20);
            TFGunLenth.setText("50");
            TFGunLenth.setFocusable(true);
            ZavodPanel.add(TFGunLenth);

            TFGunType.setBounds(100, 450, 120, 20);
            TFGunType.setText("OF");
            TFGunType.setFocusable(true);
            ZavodPanel.add(TFGunType);}
//BODY TextField
        {TFBodyArmor.setBounds(230, 350, 120, 20);
            TFBodyArmor.setText("190");
            TFBodyArmor.setFocusable(true);
            ZavodPanel.add(TFBodyArmor);

            TFBodyWeight.setBounds(230, 400, 120, 20);
            TFBodyWeight.setText("26");
            TFBodyWeight.setFocusable(true);
            ZavodPanel.add(TFBodyWeight);

            TFBodyPersons.setBounds(230, 450, 120, 20);
            TFBodyPersons.setText("4");
            TFBodyPersons.setFocusable(true);
            ZavodPanel.add(TFBodyPersons);}
//Tower TextField
        {TFTowerArmor.setBounds(360, 350, 120, 20);
            TFTowerArmor.setText("80");
            TFTowerArmor.setFocusable(true);
            ZavodPanel.add(TFTowerArmor);

            TFTowerSpeed.setBounds(360, 400, 120, 20);
            TFTowerSpeed.setText("35");
            TFTowerSpeed.setFocusable(true);
            ZavodPanel.add(TFTowerSpeed);

            TFTowerCount.setBounds(360, 450, 120, 20);
            TFTowerCount.setText("2");
            TFTowerCount.setFocusable(true);
            ZavodPanel.add(TFTowerCount);}
// Tank TextField
        { TFTankName.setBounds(490, 350, 120, 20);
            TFTankName.setText("IS-7");
            TFTankName.setFocusable(true);
            ZavodPanel.add(TFTankName);

            TFTankCountry.setBounds(490, 400, 120, 20);
            TFTankCountry.setText("USSR");
            TFTankCountry.setFocusable(true);
            ZavodPanel.add(TFTankCountry);

            TFTankYearOfProduction.setBounds(490, 450, 120, 20);
            TFTankYearOfProduction.setText("1945-1947");
            TFTankYearOfProduction.setFocusable(true);
            ZavodPanel.add(TFTankYearOfProduction);}

//BUTTOMS
        BPrint.setFocusable(false);
        BPrint.setBounds(240,170,120,40);
        ZavodPanel.add(BPrint);

        BAdd.setFocusable(false);
        BAdd.setBounds(100,170,120,40);
        ZavodPanel.add(BAdd);

       /* BGet.setFocusable(false);
        BGet.setBounds(700,450,120,40);
        ZavodPanel.add(BGet);*/

        BEdit.setFocusable(false);
        BEdit.setBounds(380,170,120,40);
        ZavodPanel.add(BEdit);

        add(ZavodPanel);
    }

    void addPrintButtonListener(ActionListener listenForButton){
        BPrint.addActionListener(listenForButton);
    }
    void addAddButtonListener(ActionListener listenForButton){
        BAdd.addActionListener(listenForButton);
    }
    void addEditButtonListener(ActionListener listenForButton){
        BEdit.addActionListener(listenForButton);
    }
    public void drawIcon() {
        Graphics g = getGraphics();
        g.drawImage(img, 0, 0, null);
    }
}
