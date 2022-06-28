package ProjectCarLot;

import javax.swing.table.AbstractTableModel;

// https://stackoverflow.com/questions/2146488/converting-an-arraylist-into-a-2d-array <-- this is where I got the idea from and the general code.
// other way I was going to do this was writing functions for both car and carlot to convert them into readable 2d object arrays
public class CarLotTableModel extends AbstractTableModel {

    private CarLot lot;

    public CarLotTableModel(CarLot lot) {
        this.lot = lot;
    }

    public int getColumnCount() {
        return 8;
    }

    public int getRowCount() {
        return lot.size();
    }

    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0: return "ID";
            case 1: return "Mileage";
            case 2: return "MPG";
            case 3: return "Cost";
            case 4: return "List Price";
            case 5: return "isSold";
            case 6: return "Sold For";
            case 7: return "Profit";
            default: return null;
        }
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Car c = lot.get(rowIndex);

        switch (columnIndex) {
            case 0: return c.getId();
            case 1: return c.getMileage();
            case 2: return Math.round(c.getMpg()*100)/100.0;
            case 3: return Math.round(c.getCost()*100)/100.0;
            case 4: return Math.round(c.getSalesPrice()*100)/100.0;
            case 5: return c.isSold();
            case 6: return Math.round(c.getPriceSold()*100)/100.0;
            case 7: return Math.round(c.getProfit()*100)/100.0;
            default: return null;
        }
    }

}
