package ProjectCarLot;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;

// you can tell my naming got a bit lazy, I started using default names, given they are good for being default
public class CarLotMainUI {
    private JButton b_exit;
    private JPanel rootPanel;
    private JButton b_Load;
    private JButton b_Save;
    private JTable table1;
    private JTabbedPane tabbedPane1;
    private JTextField f_ID;
    private JTextField f_mileage;
    private JTextField f_MPG;
    private JTextField f_PriceCost;
    private JTextField f_PriceSell;
    private JButton b_Add;
    private JButton sellSelectedButton;
    private JButton editSelectedButton;
    private JButton b_gen50;
    private JLabel statHighestMilage;
    private JLabel statHighestMPG;
    private JLabel statAvgMPG;
    private JLabel statTotalProfit;
    private JButton b_unsort;
    private CarLot lot = new CarLot();

    public CarLotMainUI() {
        b_Save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JFileChooser fc = new JFileChooser();
                    fc.setFileFilter(new FileNameExtensionFilter("Comma Separated Text File (.txt)", "*.txt")); // ensure that file saved is *.txt
                    fc.showDialog(null, "Save"); // display save dialog


                    if (fc.getSelectedFile() == null)
                        System.out.println("You cancelled the choice"); // output to console for debugging
                    else {
                        File output = new File(fc.getSelectedFile().toString() + ".txt");
                        System.out.println("You saved to " + output); // same as above
                        lot.saveToDisk(output); // call the function with that file
                        updateTable();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        b_Load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser();
                fc.setFileFilter(new FileNameExtensionFilter("Comma Separated Text File (.txt)", "txt")); // ensure txt is loaded
                fc.showDialog(null, "Load"); // show load dialog


                if (fc.getSelectedFile() == null)
                    System.out.println("You cancelled the choice"); // debugging same as before
                else {
                    System.out.println("You loaded from " + fc.getSelectedFile());
                    lot.loadFromDisk(fc.getSelectedFile());
                    updateTable();
                }

            }
        });
        b_exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // not sure if this is the best way to exit, but it was the fastest thing I could think to make
            }
        });
        b_Add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    lot.addCar(f_ID.getText(),                  // add a car using all fields in the "add" tab
                            Integer.parseInt(f_mileage.getText()),
                            Double.parseDouble(f_MPG.getText()),
                            Double.parseDouble(f_PriceCost.getText()),
                            Double.parseDouble(f_PriceSell.getText()));
                    updateTable();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(
                            rootPanel,
                            "Invalid input",
                            "Illegal Action",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        b_gen50.addActionListener(new ActionListener() { // function to generate 50 random unsold cars
            @Override
            public void actionPerformed(ActionEvent e) {
                Random r = new Random();
                String uid = "";
                for(int i = 0; i < 49; i++) {
                    do {
                        uid = "c" + r.nextInt(1000); // hard limit of 1000 randomly generated cars since each ID is unique
                    } while (lot.findCarByIdentifier(uid) != null);
                    lot.addCar(uid, r.nextInt(150000), 10 + (50 - 10) * r.nextDouble(), 5000 + (100000 - 5000) * r.nextDouble(), 5000 + (100000 - 5000) * r.nextDouble());
                }
                updateTable();
            }
        });
        sellSelectedButton.addActionListener(new ActionListener() { // sell car at currently selected row
            @Override
            public void actionPerformed(ActionEvent e) {
                final String selected = (String)table1.getValueAt(table1.getSelectedRow(), 0); // display dialog prompting user for selling price
                String s = (String)JOptionPane.showInputDialog(
                        rootPanel,
                        "How much would you like to sell this car for?",
                        "Sell Car",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        null,
                        "");
                lot.sellCar(selected, Double.parseDouble(s));
                updateTable();
            }
        });
        editSelectedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(table1.getSelectedColumn() == 5 || table1.getSelectedColumn() == 6 || table1.getSelectedColumn() == 7){ // prompt user to change values, however checks beforehand to make sure values changed by selling aren't edited
                    JOptionPane.showMessageDialog(
                            rootPanel,
                            "You cannot change these values manually, please sell the car instead",
                            "Illegal Action",
                            JOptionPane.INFORMATION_MESSAGE);
                return;
                }
                final Car selected = lot.findCarByIdentifier((String)table1.getValueAt(table1.getSelectedRow(), 0));
                String s = (String)JOptionPane.showInputDialog(
                        rootPanel,
                        "What would you like to change this to?",
                        "Edit Cell",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        null,
                        table1.getValueAt(table1.getSelectedRow(),table1.getSelectedColumn()));
                try{
                    switch(table1.getSelectedColumn()){             // switch for the specific type based on row, probably a better way of making this
                        case 0:
                            selected.setId(s);
                            break;
                        case 1:
                            selected.setMileage(Integer.parseInt(s));
                            break;
                        case 2:
                            selected.setMpg(Double.parseDouble(s));
                            break;
                        case 3:
                            selected.setCost(Double.parseDouble(s));
                            break;
                        case 4:
                            selected.setSalesPrice(Double.parseDouble(s));
                            break;
                    }
                } catch (Exception e2) {
                    JOptionPane.showMessageDialog(
                            rootPanel,
                            "That is not a valid type",
                            "Illegal Action",
                            JOptionPane.ERROR_MESSAGE);
                }
                updateTable();
            }
        });
        b_unsort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                table1.getRowSorter().setSortKeys(null);
            }
        });
    }

    public JPanel getRootPanel(){
        return rootPanel;
    }
    private void updateTable() {
         table1.setModel(new CarLotTableModel(lot));
         Car mileage = lot.getCarWithHighestMileage();
         Car mpg = lot.getCarWithBestMPG();
         statHighestMilage.setText(String.format("Car with highest mileage in the lot: %s with %d miles.", mileage.getId(),mileage.getMileage()));
         statHighestMPG.setText(String.format("Car with best MPG in the lot: %s with MPG of %.2f", mpg.getId(), mpg.getMpg()));
         statAvgMPG.setText(String.format("Lot average MPG: %.2f", lot.getAverageMpg()));
         statTotalProfit.setText(String.format("Total profit: $%.2f",lot.getTotalProfit()));
    }
}
