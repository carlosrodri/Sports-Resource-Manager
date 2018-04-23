package views;

import java.awt.BorderLayout;
import javax.swing.JDialog;
import models.entities.Petition;
import structures.Queue;

public class ShowReport extends JDialog{

	private static final long serialVersionUID = 1L;
	private Table table;

	public ShowReport() {
		table = new Table();
		
		setLayout(new BorderLayout());
		setSize(400, 600);
		setTitle("Files Tree V 1.0");
		
		add(table, BorderLayout.CENTER);
	}
	
	public void setDatas(Queue<Petition> list){
		System.out.println("dialogo");
		table.refreshTable(list);
	}
}