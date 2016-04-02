package com.java;

import javax.swing.table.AbstractTableModel;

class MyTableModel extends AbstractTableModel {
    private String[] columnNames;
    private Object[][] data = {
        { "Kathy", "Smith", "Snowboarding", new Integer(5),
            new Boolean(false) },
        { "John", "Doe", "Rowing", new Integer(3), new Boolean(true) },
        { "Sue", "Black", "Knitting", new Integer(2),
            new Boolean(false) },
        { "Jane", "White", "Speed reading", new Integer(20),
            new Boolean(true) },
        { "Joe", "Brown", "Pool", new Integer(10), new Boolean(false) } };

    public MyTableModel(String[] c,Object[][] d) {
		// TODO Auto-generated constructor stub
    	columnNames=c;
    	data=d;
	}
    
    public int getColumnCount() {
      return columnNames.length;
    }

    public int getRowCount() {
      return data.length;
    }

    public String getColumnName(int col) {
      return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
      return data[row][col];
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public Class getColumnClass(int c) {
      return getValueAt(0, c).getClass();
    }

    /*
     * Don't need to implement this method unless your table's editable.
     */
    public boolean isCellEditable(int row, int col) {
      // Note that the data/cell address is constant,
      // no matter where the cell appears onscreen.
      if (col < 2) {
        return true;
      } else {
        return true;
      }
    }
    public void setValueAt(Object value, int row, int col) {
        data[row][col] = value;
        fireTableCellUpdated(row, col);
      }

    }
