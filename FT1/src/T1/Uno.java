package T1;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

public class Uno {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		sc.close();
		
		System.out.println(a);
		
		TM m = CreateTM();
		displayTM(m);
		
		m.states.get(m.states.size()-1).setTerminal(true);
		int i = 0;
		while(m.states.get(i).isTerminal()){
			
			
			
		}
		
		
		
	}
	
	private static void displayTM (TM m) {
		
		for (int i = 0; i < m.states.size() ; i++) {
			System.out.println("Estado: q"+m.states.get(i).qi);
			for (int j = 0; j < m.states.get(i).trans.size() ; j++) {
				System.out.print("si: "+m.states.get(i).trans.get(j).si+ " ");
				System.out.print("qj: "+m.states.get(i).trans.get(j).qj+ " ");
				System.out.print("sj: "+m.states.get(i).trans.get(j).sj+ " ");
				System.out.print("mov: "+m.states.get(i).trans.get(j).movimiento);
				System.out.println();
			}
			System.out.println();
		}
		
	}

	private static TM CreateTM() {
		
		SAXBuilder builder = new SAXBuilder();
		TM m = new TM();
		
		try{
			
			Document doc = builder.build(new File("C:\\Users\\Gonzalo\\Desktop\\FT1\\transiciones.xml"));
			List<Element> n = doc.getRootElement().getChildren();
			
			ArrayList<String> memory = new ArrayList<String>(0);
			for (int i = 0; i < n.size() ; i++) {//Se recorren las transiciones del xml
				if(!memory.contains(n.get(i).getChild("qi").getValue())){  //consulta si el estado ya fue ingresado
					m.states.add(new ST(n.get(i).getChild("qi").getValue()));  // crea el estado con el valor de qi
					memory.add(n.get(i).getChild("qi").getValue()); //asegura que no se repitan los estados
				}
			}
			memory.clear();
			
			for (int i = 0; i < m.states.size(); i++) {
				for(int j = 0 ; j < n.size() ; j++){
					if((m.states.get(i).qi).equals(n.get(j).getChild("qi").getValue())){
						TR tr = new TR(n.get(j).getChild("si").getValue(),n.get(j).getChild("qj").getValue(),
								n.get(j).getChild("sj").getValue(),n.get(j).getChild("movimiento").getValue());
						
						m.states.get(i).trans.add(tr);
						
					}
				}
			}
		}
		
		catch (Exception ex){
			ex.printStackTrace();
		}

		return m;
	}
	
}
