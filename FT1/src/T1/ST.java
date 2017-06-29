package T1;

import java.util.ArrayList;

public class ST {
	
	//Clase base de un estado de una Maquina de Turing.
	
	String qi;
	boolean terminal = false;
	ArrayList<TR> trans;
	
	public ST(String n) {
		qi = n;
		trans = new ArrayList<TR>(0);
	}
	
	public boolean isTerminal() {
		return terminal;
	}

	public void setTerminal(boolean terminal) {
		this.terminal = terminal;
	}

	

	public void setQi(String qi) {
		this.qi = qi;
	}

	public void setTrans(ArrayList<TR> trans) {
		this.trans = trans;
	}

	public String getQi() {
		return qi;
	}

	public ArrayList<TR> getTrans() {
		return trans;
	}
	
}
