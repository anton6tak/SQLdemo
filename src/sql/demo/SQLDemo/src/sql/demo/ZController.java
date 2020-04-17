package sql.demo;
import sql.demo.model.Body;
import sql.demo.model.Gun;
import sql.demo.model.Tank;
import sql.demo.model.Tower;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;


public class ZController {
    private ZView theView;
    private ZModel theModel;
    private StockExchangeDB stockExchangeDB;
    public int GlobalID=1;


    public ZController(ZView theView, ZModel theModel, StockExchangeDB stockExchangeDB) {
        this.theView = theView;
        this.theModel = theModel;
        this.stockExchangeDB = stockExchangeDB;

        this.theView.addPrintButtonListener(new Printlistener());
        this.theView.addAddButtonListener(new Addlistener());
        this.theView.addEditButtonListener(new Editlistener());
    }

    class Printlistener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            try {
                stockExchangeDB.PrintllTables();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }
    class Addlistener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            //for gun
            int caliber = Integer.parseInt(theView.TFGunCaliber.getText());
            int lenth = Integer.parseInt(theView.TFGunLenth.getText());
            String guntype = theView.TFGunType.getText();

            //for body
            int bodyarmor = Integer.parseInt(theView.TFBodyArmor.getText());
            int weight = Integer.parseInt(theView.TFBodyWeight.getText());
            int persons = Integer.parseInt(theView.TFBodyPersons.getText());

            //for tower
            int towerarmor = Integer.parseInt(theView.TFTowerArmor.getText());
            int speed = Integer.parseInt(theView.TFTowerSpeed.getText());
            int countofguns = Integer.parseInt(theView.TFTowerCount.getText());

            //for tank
            String tankname = theView.TFTankName.getText();
            String tankcountry = theView.TFTankCountry.getText();
            String yearofproduction = theView.TFTankYearOfProduction.getText();


            Gun gun = new Gun(GlobalID, caliber, lenth, guntype);
            Body body = new Body(GlobalID, bodyarmor, weight, persons);
            Tower tower = new Tower(GlobalID, towerarmor, speed, countofguns);
            Tank tank = new Tank(GlobalID, tankname, tankcountry,yearofproduction);
            try {
                stockExchangeDB.GUNS.AddNewItem(gun);
                stockExchangeDB.TOWERS.AddNewItem(tower);
                stockExchangeDB.BODIES.AddNewItem(body);
                stockExchangeDB.TANKS.AddNewItem(tank);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            GlobalID++;
        }

    }
    class Editlistener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            int IDforEdit = Integer.parseInt(theView.TFGeneralID.getText());


            //for gun
            int caliber = Integer.parseInt(theView.TFGunCaliber.getText());
            int lenth = Integer.parseInt(theView.TFGunLenth.getText());
            String guntype = theView.TFGunType.getText();

         //for body
            int bodyarmor = Integer.parseInt(theView.TFBodyArmor.getText());
            int weight = Integer.parseInt(theView.TFBodyWeight.getText());
            int persons = Integer.parseInt(theView.TFBodyPersons.getText());
            //for tower
            int towerarmor = Integer.parseInt(theView.TFTowerArmor.getText());
            int speed = Integer.parseInt(theView.TFTowerSpeed.getText());
            int countofguns = Integer.parseInt(theView.TFTowerCount.getText());


          //for tank
            String tankname = theView.TFTankName.getText();
            String tankcountry = theView.TFTankCountry.getText();
            String yearofproduction = theView.TFTankYearOfProduction.getText();


            Gun gun = new Gun(GlobalID, IDforEdit, caliber, lenth, guntype);
            Body body = new Body(GlobalID,IDforEdit, bodyarmor, weight, persons);
            Tower tower = new Tower(GlobalID, IDforEdit, towerarmor, speed, countofguns);
            Tank tank = new Tank(GlobalID, IDforEdit, tankname, tankcountry, yearofproduction);
            try {
                stockExchangeDB.GUNS.EditThisItem(gun);
                stockExchangeDB.TOWERS.EditThisItem(tower);
                stockExchangeDB.BODIES.EditThisItem(body);
                stockExchangeDB.TANKS.EditThisItem(tank);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            GlobalID++;
        }

    }
}
