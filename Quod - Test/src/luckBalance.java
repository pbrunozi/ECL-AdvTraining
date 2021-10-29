import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

public class luckBalance {
	public static void main(String[] args) {
		String caminho = "C:/temp/INPUT.txt";
		int Sortemax = 0; // RESULTADO : Saldo de Sorte da Lena
		int i;
		int Timportance; // Ti : importancia do concurso [0,1] 0=não imoportante, (1 ou !=0)=importante
		try {BufferedReader br = new BufferedReader(new FileReader(caminho));
		  String linha = br.readLine();
		  // Leitura do cabeçalho : valores "n" e "k"
		  String[] header = linha.split(" ");
		  //System.out.println(linha);
		  Integer n = Integer.parseInt(header[0]);
		  Integer k = Integer.parseInt(header[1]); 
		  System.out.println("Total de concursos: "+n+"\nNumero concursos que pode falhar: "+k);
		  Integer Contests[] = new Integer[n];
		  for (i = 0; i < n; i++)
			  Contests[i] = 0;
		  // Leitura dos valors Li (Contests) Ti (importance) para n concursos (contests)
		  linha = br.readLine();
		  i = 0;
		  while (linha != null) {
			  //System.out.println(linha);
			  String[] vect = linha.split(" ");
			  Timportance = Integer.parseInt(vect[1]);
			  if (Timportance != 1) {
				  // Somatoria de Li para concursos sem importancia
				  Sortemax += Integer.parseInt(vect[0]);
			  } else {
				  // Criando array de Li para os concursos importantes
				  Contests[i] = Integer.parseInt(vect[0]);
				  i++;
			  }
			  linha = br.readLine();
		  }
		  System.out.println("Saldo parcial da sorte para concurso sem importancia: "+Sortemax);
		  int nimport;
		  nimport = i;
		  System.out.println("Numero de concursos importantes: "+nimport);
		  System.out.println("Valores de Contests[i] (sorte) dos concursos importantes");
		  for (i = 0; i < nimport; i++)
			  System.out.print(Contests[i]+" ");
		  System.out.println("\nSorted");
		  //Aplicar função SORT no array Contests em ordem crescente, para concursos importantes
		  Arrays.sort(Contests,Collections.reverseOrder());
		  //Somatoria de Li para os k´esimos primeiro concursos  e subtração do resto (i >= k) concursos menos importantes
		  for(i = 0; i < nimport; i++){
			  System.out.print(Contests[i]+" ");
		      if(i < k) {
		          Sortemax += Contests[i]; 
		          //System.out.println(Contests[i]+"soma"+"\n");
		      }
		      else {
		          Sortemax -= Contests[i]; 
		          //System.out.println(Contests[i]+"subtrai"+"\n");
		      }
		  }
		  System.out.println("\n\nRESULTADO DO SALDO DE SORTE DE LENA ===> "+Sortemax);
		}
		catch (IOException e) {
			System.out.println("Error: "+e.getMessage());
		}
	    }
}
