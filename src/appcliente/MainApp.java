
package appcliente;

import clientews.WSClienteServicoCEP;
import entity.Endereco;
import java.util.Scanner;


public class MainApp {
    
    public static void main(String[] args) throws Exception {
        
        System.out.println("Informe um CEP: ");
        String cep = new Scanner(System.in).nextLine();
        
        Endereco endereco = WSClienteServicoCEP.pesquisar(cep);
        
        System.out.println(endereco.getDados());
        
    }
    
}
