
package clientews;

import com.google.gson.Gson;
import entity.Endereco;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import util.UtilJSON;

public class WSClienteServicoCEP {
    
    static String webService = "http://viacep.com.br/ws/";
    static int codigoSucesso = 200;
    
    public static Endereco pesquisar(String cep) throws IOException, Exception{
        String urlRequisicao = webService + cep + "/json";
        //viacep.com.br/ws/01001000/json/ 
        try{
           URL url = new URL(urlRequisicao);
           HttpURLConnection conexao = (HttpURLConnection)url.openConnection();
           
           if(conexao.getResponseCode() != codigoSucesso){
               throw new RuntimeException("HTTP Error Code: " + conexao.getResponseCode());
           }
           
           BufferedReader resposta = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
           
           String jsonEmString = UtilJSON.jsonToString(resposta);
           
           Gson gson = new Gson();
           Endereco endereco = gson.fromJson(jsonEmString, Endereco.class);
           
           return endereco;
        }
        catch(Exception ex){
            throw new Exception("Erro: " + ex);
        }
    }
    
}
